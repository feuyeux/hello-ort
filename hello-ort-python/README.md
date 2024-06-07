# Hello ORT Python

- <https://github.com/THU-MIG/yolov10/blob/main/examples/YOLOv8-ONNXRuntime>

```sh
python -m venv ort_env
source ort_env/Scripts/activate
python -m pip install --upgrade pip
pip install ultralytics onnxruntime-gpu

export model_path=../hello-ort-java/src/main/resources/yolov8s.onnx
export source_path=../hello-ort-java/src/main/resources/dog.jpg
python main.py --model ${model_path} --img ${source_path} --conf-thres 0.5 --iou-thres 0.5
```
