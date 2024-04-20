package SpotifyOauth2.api.utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static  ConfigLoader configloader;
    private ConfigLoader(){
        properties=PropertyUtils.propertyLoader("src/main/resources/config.properties");
    }
    public static ConfigLoader getInstance(){
        if(configloader ==null){
            configloader=new ConfigLoader();
        }
        return configloader;
    }
    public String getUserId(){
        String prop=properties.getProperty("userid");
        if(prop !=null){
            return prop;
        }
        else {
            throw new RuntimeException("userid not found");
        }
    }
    public String getGrantTypeForToken(){
        String prop=properties.getProperty("grant_typeforTokenGenration");
        if(prop !=null){
            return prop;
        }
        else {
            throw new RuntimeException("userid not found");
        }
    }
    public String getrefresh_token(){
        String prop=properties.getProperty("refresh_token");
        if(prop !=null){
            return prop;
        }
        else {
            throw new RuntimeException("userid not found");
        }
    }
    public String getContentTypeForTokenGenration(){
        String prop=properties.getProperty("Content_TypeForTokenGenration");
        if(prop !=null){
            return prop;
        }
        else {
            throw new RuntimeException("userid not found");
        }
    }
    public String getAuthorizationForTokenGeneration(){
        String prop=properties.getProperty("AuthorizationForTokenGeneration");
        if(prop !=null){
            return prop;
        }
        else {
            throw new RuntimeException("userid not found");
        }
    }
}
