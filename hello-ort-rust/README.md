# Hello ORT Rust

> <https://github.com/ultralytics/ultralytics/examples/YOLOv8-ONNXRuntime-Rust>

## Install ONNXRuntime

> <https://github.com/microsoft/onnxruntime/releases/download/v1.18.0/onnxruntime-osx-arm64-1.18.0.tgz>

```sh
export onnxruntime_path=/Users/hanl5/coding/onnxruntime-osx-arm64-1.18.0
export LD_LIBRARY_PATH=${onnxruntime_path}/lib${LD_LIBRARY_PATH:+:${LD_LIBRARY_PATH}}
```

```sh
export model_path=/Users/hanl5/coding/feuyeux/hello-ort/hello-ort-java/src/main/resources/yolov8s.onnx
export source_path=/Users/hanl5/coding/feuyeux/hello-ort/hello-ort-java/src/main/resources/dog.jpg
cargo run --release -- --model ${model_path} --source ${source_path} --task detect
```
