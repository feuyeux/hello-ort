package org.feuyeux.hello.ort.service;

import ai.onnxruntime.OrtException;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.feuyeux.hello.ort.pojo.Detection;
import org.feuyeux.hello.ort.pojo.Result;
import org.feuyeux.hello.ort.session.HelloOrtSession;
import org.feuyeux.hello.ort.utils.ImageUtil;
import org.feuyeux.hello.ort.utils.ModelFactory;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

@Slf4j
public class HelloOrtService implements Closeable {
    private ModelFactory modelFactory = new ModelFactory();
    private Gson gson = new Gson();

    private HelloOrtSession inferenceSession;

    public HelloOrtService(String version) {
        try {
            inferenceSession = modelFactory.getModel("model_" + version + ".properties");
        } catch (Exception e) {
            log.error("", e);
            System.exit(1);
        }
    }

    public Result inference(String imageName) {
        Mat img = Imgcodecs.imread("/opt/hello-ort/" + imageName, Imgcodecs.IMREAD_COLOR);
        Result result = new Result();
        try {
            List<Detection> detections = inferenceSession.run(img);
            result.setDetections(detections);
            ImageUtil.drawPredictions(img, detections);
            log.debug("detectionList:{}", gson.toJson(detections));
            String filePath = "/tmp/prediction-" + imageName;
            Imgcodecs.imwrite(filePath, img);
            result.setImagePath(filePath);
        } catch (Exception e) {
            log.error("", e);
        }
        return result;
    }

    @Override
    public void close() throws IOException {
        inferenceSession.close();
    }
}
