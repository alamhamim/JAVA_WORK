package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Helper {

    public static Properties readProperty(String path) throws IOException {
        FileInputStream file = new FileInputStream(new File(path));
        Properties properties = new Properties();
        properties.load(file);
        return properties;
    }

}
