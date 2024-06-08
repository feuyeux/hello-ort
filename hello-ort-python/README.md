# Hello ORT Python

- <https://github.com/THU-MIG/yolov10/blob/main/examples/YOLOv8-ONNXRuntime>

```sh
python -m venv ort_env

source ort_env/Scripts/activate
.\ort_env\Scripts\Activate.ps1

python -m pip install --upgrade pip
pip install ultralytics
pip install onnxruntime-gpu --extra-index-url https://aiinfra.pkgs.visualstudio.com/PublicPackages/_packaging/onnxruntime-cuda-12/pypi/simple/
```

```sh
source ort_env/Scripts/activate

export model_path=../hello-ort-java/src/main/resources/yolov8s.onnx
export source_path=../hello-ort-java/src/main/resources/dog.jpg
python main.py --model ${model_path} --img ${source_path} --conf-thres 0.5 --iou-thres 0.5

$model_path = "../hello-ort-java/src/main/resources/yolov8s.onnx"
$source_path = "../hello-ort-java/src/main/resources/dog.jpg"
python main.py --model $model_path --img $source_path --conf-thres 0.5 --iou-thres 0.5
```
