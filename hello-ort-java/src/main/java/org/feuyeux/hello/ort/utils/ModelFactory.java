package org.feuyeux.hello.ort.utils;

import ai.onnxruntime.OrtException;
import org.feuyeux.hello.ort.exception.NotImplementedException;
import org.feuyeux.hello.ort.session.HelloOrtSession;
import org.feuyeux.hello.ort.session.HelloOrtSessionV5;
import org.feuyeux.hello.ort.session.HelloOrtSessionV8;

import java.io.IOException;
import java.util.Properties;

public class ModelFactory {
    public HelloOrtSession getModel(String path, String propertiesFilePath) throws IOException, OrtException, NotImplementedException {

        ConfigReader configReader = new ConfigReader();
        Properties properties = configReader.readProperties(propertiesFilePath);
        String modelName = properties.getProperty("modelName");
        String modelPath = path + properties.getProperty("modelPath");
        String labelPath = path + "coco.names";
        float confThreshold = Float.parseFloat(properties.getProperty("confThreshold"));
        float nmsThreshold = Float.parseFloat(properties.getProperty("nmsThreshold"));

        if ("yolov5".equalsIgnoreCase(modelName)) {
            return new HelloOrtSessionV5(modelPath, labelPath, confThreshold, nmsThreshold);
        } else if ("yolov8".equalsIgnoreCase(modelName)) {
            return new HelloOrtSessionV8(modelPath, labelPath, confThreshold, nmsThreshold);
        } else {
            throw new NotImplementedException();
        }
    }
}
