package org.feuyeux.hello.ort.utils;

import java.net.URL;

public class ResourceLoader {
    public String getResourcePath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return resource.getPath();
        }
    }
}