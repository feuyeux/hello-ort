package org.feuyeux.hello.ort.cli;

public class HelloOrgEnv {
    private static final String modelPathMac = "/Users/hanl5/coding/feuyeux/hello-ort/src/main/resources/";
    private static final String modelPathWin = "D:\\coding\\hello-ort\\src\\main\\resources\\";

    public static String getModelPath() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            return modelPathMac;
        }
        return modelPathWin;
    }
}
