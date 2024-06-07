# Hello ORT Python

- <https://github.com/THU-MIG/yolov10/blob/main/examples/YOLOv8-ONNXRuntime>

```sh
virtualenv ort_env --python=python3.9
source ort_env/bin/activate
python -m pip install --upgrade pip

pip install ultralytics onnxruntime
# pip install onnxruntime-gpu

export model_path=../hello-ort-java/src/main/resources/yolov8s.onnx
export source_path=../hello-ort-java/src/main/resources/dog.jpg

python main.py --model ${model_path} --img ${source_path} --conf-thres 0.5 --iou-thres 0.5
```
