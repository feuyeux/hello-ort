package org.feuyeux.hello.ort.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String imagePath;
    private List<Detection> detections;
}
