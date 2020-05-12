package com.zerobank.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private  static Properties configFile;

    static {
        try{
            String path=System.getProperty("user.dir")+"/configuration.properties";
            FileInputStream inputStream= new FileInputStream(path);
            configFile=new Properties();
            configFile.load(inputStream);
            inputStream.close();
        }catch(Exception e){
            e.printStackTrace();
            throw  new RuntimeException("Failed to load properties file!");
        }
    }
    public static String getProperty (String keyName){
        return configFile.getProperty(keyName);
    }
}
