package SpotifyOauth2.api.utils;

import java.util.Properties;

public class DataLoader {
    private final Properties properties;
    private static DataLoader dataLoader;
    private DataLoader(){
        properties=PropertyUtils.propertyLoader("src/main/resources/data.properties");
    }
    public static DataLoader getInstance(){
        if (dataLoader==null){
            dataLoader=new DataLoader();
        }
        return dataLoader;
    }
    public String getgetplaylistid(){
        String prop=properties.getProperty("getplaylistid");
        if (prop==null){
            throw new RuntimeException("no getplaylistid");
        }
        return prop;
    }
    public String getupdateplaylistid(){
        String prop=properties.getProperty("updateplaylistid");
        if (prop==null){
            throw new RuntimeException("no updateplaylistid");
        }
        return prop;
    }
}
