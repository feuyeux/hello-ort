package org.feuyeux.hello.ort.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detection {
    private String label;
    private float[] bbox;
    private float confidence;
}
