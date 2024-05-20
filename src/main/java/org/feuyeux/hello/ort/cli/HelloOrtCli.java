package org.feuyeux.hello.ort.cli;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;
import org.feuyeux.hello.ort.pojo.Result;
import org.feuyeux.hello.ort.service.HelloOrtService;

import java.io.IOException;

@Slf4j
public class HelloOrtCli {
    public static void main(String[] args) throws ParseException {
        Gson gson = new Gson();
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption(getVersionOption()).addOption(getImageOption());
        CommandLine commandLine = parser.parse(options, args);
        String fileName = commandLine.getOptionValue("fileName", "dog.jpg");
        String version = commandLine.getOptionValue("version", "v5");
        try (HelloOrtService helloOrtService = new HelloOrtService(version)) {
            Result result = helloOrtService.inference(fileName);
            log.info("fileName:{},version:{},detectionImage:{},detections:{}",
                    fileName, version, result.getImagePath(), gson.toJson(result.getDetections()));
        } catch (IOException e) {
            log.debug("", e);
            System.exit(1);
        }
    }

    private static Option getImageOption() {
        return Option.builder("f").desc("image path").longOpt("fileName").hasArg().build();
    }

    private static Option getVersionOption() {
        return Option.builder("v").desc("yolo version").longOpt("version").hasArg().build();
    }
}
