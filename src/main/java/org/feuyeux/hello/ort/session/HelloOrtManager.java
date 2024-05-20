package org.feuyeux.hello.ort.session;

import ai.onnxruntime.OrtException;
import ai.onnxruntime.OrtSession;
import ai.onnxruntime.providers.CoreMLFlags;
import ai.onnxruntime.providers.OrtCUDAProviderOptions;
import lombok.extern.slf4j.Slf4j;

import java.util.EnumSet;

@Slf4j
public class HelloOrtManager {
    private static final long GB = 1024 * 1024 * 1024;

    public static OrtSession.SessionOptions getSessionOptions() throws OrtException {
        OrtSession.SessionOptions options = new OrtSession.SessionOptions();
        String osName = System.getProperty("os.name").toLowerCase();
        boolean isCudaSupported = false;
        if (osName.contains("win") || osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            try {
                // Try to load the CUDA-related library
                System.loadLibrary("cudart");
                isCudaSupported = true;
            } catch (UnsatisfiedLinkError e) {
                log.info("{}",e.getMessage());
                log.error("CUDA is not supported on this system.");
            }
        }
        if (osName.contains("mac")) {
            options.addCoreML(EnumSet.of(CoreMLFlags.ONLY_ENABLE_DEVICE_WITH_ANE));
        } else if (isCudaSupported) {
            options.addCUDA(getOrtCUDAProviderOptions(2));
        } else {
            options.addCPU(true);
        }
        options.setExecutionMode(OrtSession.SessionOptions.ExecutionMode.PARALLEL);
        options.setMemoryPatternOptimization(true);
        options.setOptimizationLevel(OrtSession.SessionOptions.OptLevel.ALL_OPT);
        return options;
    }

    public static OrtCUDAProviderOptions getOrtCUDAProviderOptions(int limit) throws OrtException {
        OrtCUDAProviderOptions cudaProviderOptions = new OrtCUDAProviderOptions();
        // https://onnxruntime.ai/docs/execution-providers/CUDA-ExecutionProvider.html#gpu_mem_limit
        cudaProviderOptions.add("gpu_mem_limit", String.valueOf(limit * GB));
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
        return cudaProviderOptions;
    }
}
