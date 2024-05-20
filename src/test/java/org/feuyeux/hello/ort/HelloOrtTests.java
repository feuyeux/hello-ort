package org.feuyeux.hello.ort;

import lombok.extern.slf4j.Slf4j;
import org.feuyeux.hello.ort.pojo.Result;
import org.feuyeux.hello.ort.service.HelloOrtService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Slf4j
public class HelloOrtTests {
    private String[] imageNames = new String[]{"Laptop and Mouse.png", "dog.jpg", "dog.png", "kite.jpg"};
    @Test
    public void testYolo() {
        try (HelloOrtService helloOrtService = new HelloOrtService("v8")) {
            Result result = helloOrtService.inference(imageNames[0]);
            log.info("{}", result);
        } catch (IOException e) {
            log.error("", e);
        }
    }
}
