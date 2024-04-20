package SpotifyOauth2.api;

import SpotifyOauth2.api.utils.ConfigLoader;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TokenManager {
    private static String access_token;
    private static Instant expiry_time;
    public static String getToken(){
        if(access_token==null||Instant.now().isAfter(expiry_time)) {
            try {
                System.out.println("Renewing new token");
                Response response = refreshToken();
                access_token = response.path("access_token");
                int expiryInSec = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryInSec);
            }
            catch (Exception e){
                throw new RuntimeException("get Token is failed");
            }
        }
        else {
            System.out.println("Using the old token");
        }
        return access_token;
    }
    public static Response refreshToken() {
        Map<String,String> formParams=new HashMap<>();
        formParams.put("grant_type", ConfigLoader.getInstance().getGrantTypeForToken());
        formParams.put("refresh_token",ConfigLoader.getInstance().getrefresh_token());
        Map<String,String> headers=new HashMap<>();
        headers.put("Content-Type",ConfigLoader.getInstance().getContentTypeForTokenGenration());
        headers.put("Authorization",ConfigLoader.getInstance().getAuthorizationForTokenGeneration());
        Response response=RestResource.postAccountDetails(headers,formParams);
        if(response.getStatusCode()!=200){
              throw new RuntimeException("Token generation Failed");
        }
            return response;
    }
}
