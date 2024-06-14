package org.feuyeux.hello.ort;

import lombok.extern.slf4j.Slf4j;
import org.feuyeux.hello.ort.cli.HelloOrgEnv;
import org.feuyeux.hello.ort.pojo.Result;
import org.feuyeux.hello.ort.service.HelloOrtService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Slf4j
public class HelloOrtTests {
    private static final String[] imageNames = new String[]{"Laptop and Mouse.png", "dog.jpg", "dog.png", "kite.jpg"};
    private static final int times = 60;

    @Test
    public void testYolo() {
        try (HelloOrtService helloOrtService = new HelloOrtService(HelloOrgEnv.getModelPath(), "v8")) {
            Result result;
            for (int i = 0; i < 100; i++) {
                result = helloOrtService.inference(HelloOrgEnv.getModelPath(), imageNames[0]);
                log.info("{}", result);
                TimeUnit.MICROSECONDS.sleep(300);
            }
        } catch (Exception e) {
            log.error("", e);
        }
    }

    @Test
    public void testYoloBench() {
        int loop = times;
        try (HelloOrtService helloOrtService = new HelloOrtService(HelloOrgEnv.getModelPath(), "v8")) {
            while (loop > 0) {
                int i = times - loop;
                if (i % 10 == 0) {
                    log.info("==== ==== {} ==== ====", i);
                } else {
                    log.debug("==== ==== {} ==== ====", i);
                }
                Arrays.stream(imageNames).parallel().forEach(imageName -> {
                    Result result = helloOrtService.inference(HelloOrgEnv.getModelPath(), imageName);
                    log.debug("{}", result);
                });
                TimeUnit.MICROSECONDS.sleep(50);
                loop--;
            }
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
