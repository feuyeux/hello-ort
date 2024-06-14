# Hello ORT Java

## About Inference Service on ORT Demo

> [YOLO(You only look once)](https://pjreddie.com/darknet/yolo)
>
> - Paper: <https://arxiv.org/abs/1506.02640>
> - Engineering: from <https://github.com/jhgan00/java-ort-example-yolov5.git>

```sh
sudo mkdir -p /opt/hello-ort/
sudo chown -R $(whoami) /opt/hello-ort/
```

### UT

```sh
mvn clean test -Dtest=HelloOrtTests#testYolo
```

```sh
mvn clean -f pom.windows.21.xml test -Dtest=HelloOrtTests#testYoloBench
```

![Laptop and Mouse.png](src/main/resources/Laptop and Mouse.png)

```sh
detectionList:[{"label":"mouse","bbox":[198.35149,119.59349,224.45099,158.48425],"confidence":0.91583246},{"label":"laptop","bbox":[54.62196,24.271353,186.86736,121.20319],"confidence":0.6366785}]
```

![Prediction for Laptop and Mouse.png](doc/prediction-Laptop and Mouse.png)

### CLI

```sh
mvn clean package appassembler:assemble -f pom.windows.21.xml
target/hello-cli/bin/hello.sh
```

### DOCKER

- <https://hub.docker.com/r/nvidia/cuda/>
- <https://github.com/microsoft/onnxruntime/blob/main/dockerfiles/Dockerfile.cuda>
- <https://org.ngc.nvidia.com/setup/api-key>

#### prepare

```sh
docker login nvcr.io
Username: $oauthtoken
Password:
Login Succeeded

docker run -ti nvcr.io/nvidia/cuda:12.1.1-cudnn8-devel-ubuntu22.04 nvcc -V
docker run -ti nvcr.io/nvidia/cuda:12.1.1-cudnn8-runtime-ubuntu22.04 bash
```

#### build

```sh
# use jdk21
export JAVA_HOME=/usr/local/opt/openjdk/libexec/openjdk.jdk/Contents/Home
# build jar
mvn clean install -DskipTests -f pom.windows.21.xml
# build with jdk21
docker build -t onnxruntime-cuda-21 -f Dockerfile.cuda.21 .
```

```sh
# use jdk8
export JAVA_HOME=/Library/Java/JavaVirtualMachines/openjdk-8.jdk/Contents/Home
mvn clean install -DskipTests -f pom.windows.8.xml
# build with jdk8
docker build -t onnxruntime-cuda-8 -f Dockerfile.cuda.8 .
```

#### run

```sh
docker run -ti onnxruntime-cuda-21 java -version
docker run -ti onnxruntime-cuda-21 ./bin/hello.sh -f dog.jpg -v v5
```
