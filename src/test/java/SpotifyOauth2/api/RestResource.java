package SpotifyOauth2.api;

import SpotifyOauth2.POJO.Playlist;
import io.restassured.response.Response;

import java.util.Map;

import static SpotifyOauth2.api.Route.API;
import static SpotifyOauth2.api.Route.TOKEN;
import static SpotifyOauth2.api.Specbuilder.*;
import static io.restassured.RestAssured.given;

public class RestResource {
    public static Response post(Playlist requestPlaylist,String path,String accesstoken){
        return given(getRequestSpecification())
                .auth()
                .oauth2(accesstoken)
                .body(requestPlaylist)
                .when()
                .post(path)
                .then()
                .spec(getResponseSpecification())
                .extract()
                .response();
    }
    public static Response postAccountDetails(Map<String,String> headers,Map<String,String> formParams){
        return given(getRequestSpecificationForAccount())
                .headers(headers)
                .formParams(formParams)
                .when()
                .post(API+TOKEN)
                .then()
                .extract()
                .response();
    }
    public static Response get(String path,String accesstoken){
        return given(getRequestSpecification())
                .auth()
                .oauth2(accesstoken)
                .when()
                .get(path)
                .then()
                .spec(getResponseSpecification())
                .extract()
                .response();
    }
    public static Response update(Playlist requestPlaylist,String path,String accesstoken){
        return given(getRequestSpecification())
                .auth()
                .oauth2(accesstoken)
                .body(requestPlaylist)
                .when()
                .put(path)
                .then()
                .spec(getResponseSpecification())
                .extract().response();
    }
}
