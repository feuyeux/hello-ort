# CUDA EP

## Difference between CUDA EP and TensorRT EP

<https://developer.nvidia.com/blog/end-to-end-ai-for-nvidia-based-pcs-cuda-and-tensorrt-execution-providers-in-onnx-runtime/>

- [CUDA EP](https://onnxruntime.ai/docs/execution-providers/CUDA-ExecutionProvider.html) uses the **cuDNN** inference library, which is based on granular operation blocks for neural networks.
- [TensorRT EP](https://onnxruntime.ai/docs/execution-providers/TensorRT-ExecutionProvider.html) evaluates the whole graph and collects all possible paths to execute the graph.

**cuDNN** only evaluates its own kernels while NVIDIA **TensorRT** strategies span multiple libraries including cuDNN. The workspace memory that TensorRT can allocate for intermediate buffers inside the network.

### nvidia inference stack

![nvidia-inference-stack](https://developer-blogs.nvidia.com/wp-content/uploads/2023/01/nvidia-inference-stack.png)

TensorRT 高性能推理引擎 https://developer.nvidia.com/tensorrt

- cuDNN (CUDA Deep Neural Network) https://docs.nvidia.com/cudnn 高性能深度学习库
- cuBLAS (CUDA Basic Linear Algebra Subroutines) https://docs.nvidia.com/cuda/cublas 基础线性代数库

## ONNX CUDA EP practice

### 镜像版本 21.09

logan-base-python:nvidia-21.09-py3-092501

### CUDA版本 11.4

```Bash
xpmotorsexp-ngc-ap-boot-os51-6567c5544-crm2c:~/1ocal$ nvcc -V
nvcc: NVIDIA (R) Cuda compiler driver
Copyright (c) 2005-2021 NVIDIA Corporation
Built on Sun_Aug_15_21:14:11_PDT_2021
Cuda compilation tools, release 11.4, V11.4120
Build cuda_11.4.r11.4/compiler.30300941_0
```

### onnx对应CUDA的版本 1.12

<https://onnxruntime.ai/docs/execution-providers/CUDA-ExecutionProvider.html#requirements>

| ONNX Runtime  | CUDA |
| :------------ | :--- |
| 1.12<br/>1.11 | 11.4 |

### 工程依赖

```XML
<properties>
    <!-- https://mvnrepository.com/artifact/com.microsoft.onnxruntime/onnxruntime_gpu -->
    <onnxruntime.version>1.12.1</onnxruntime.version>
</properties>

<dependencies>
    <dependency>
        <groupId>com.microsoft.onnxruntime</groupId>
        <artifactId>onnxruntime_gpu</artifactId>
        <version>${onnxruntime.version}</version>
</dependency>
```

### Performance Tuning

#### CUDA参数优化

<https://onnxruntime.ai/docs/execution-providers/CUDA-ExecutionProvider.html#configuration-options>

```java
private OrtSession.SessionOptions buildOrtSession() throws OrtException {
    OrtSession.SessionOptions options = new OrtSession.SessionOptions();
    if (Boolean.TRUE.equals(local)) {
        options.addCPU(true);
    } else {
        // https://onnxruntime.ai/docs/api/c/struct_ort_c_u_d_a_provider_options.html
        cudaProviderOptions =new OrtCUDAProviderOptions();
        // https://onnxruntime.ai/docs/execution-providers/CUDA-ExecutionProvider.html#gpu_mem_limit
        cudaProviderOptions.add("gpu_mem_limit", GPU_MEM_LIMIT);
        // https://onnxruntime.ai/docs/execution-providers/CUDA-ExecutionProvider.html#arena_extend_strategy
        cudaProviderOptions.add("arena_extend_strategy", "kNextPowerOfTwo");
        // cudaProviderOptions.add("arena_extend_strategy", "kSameAsRequested");
        // https://onnxruntime.ai/docs/execution-providers/CUDA-ExecutionProvider.html#do_copy_in_default_stream
        cudaProviderOptions.add("cudnn_conv_algo_search", "DEFAULT");
        // https://onnxruntime.ai/docs/execution-providers/CUDA-ExecutionProvider.html#do_copy_in_default_stream
        cudaProviderOptions.add("do_copy_in_default_stream", "1");
        // https://onnxruntime.ai/docs/execution-providers/CUDA-ExecutionProvider.html#cudnn_conv_use_max_workspace
        cudaProviderOptions.add("cudnn_conv_use_max_workspace", "1");
        // https://onnxruntime.ai/docs/execution-providers/CUDA-ExecutionProvider.html#cudnn_conv1d_pad_to_nc1d
        cudaProviderOptions.add("cudnn_conv1d_pad_to_nc1d", "1");
        options.addCUDA(cudaProviderOptions);
        options.setExecutionMode(OrtSession.SessionOptions.ExecutionMode.PARALLEL);
    }
    return options;
}
```

#### 显式释放Closable资源

```java
@PreDestroy
public void destroy() throws OrtException {
    try {
        session.close();
        cudaProviderOptions.close();
        options.close();
        if (env != null) {
            env.close();
        }
    } catch (Exception e) {
        log.error("fail to close OrtSession", e);
    }
}
```
