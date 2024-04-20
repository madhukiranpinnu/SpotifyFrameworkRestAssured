package SpotifyOauth2.api.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static Properties propertyLoader(String filepath){
        Properties properties=new Properties();
        BufferedReader bufferedReader;
        try{
            bufferedReader=new BufferedReader(new FileReader(filepath));
            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
