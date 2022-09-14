package com.petstore.io.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SpecialMethods {

    public static Properties properties;

    public static void configProperties(){
        properties = new Properties();
        try {
            properties.load(new FileReader("dataToApplication.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void waitFor(int segundos) throws InterruptedException {
        Thread.sleep(segundos*1000);
    }
}
