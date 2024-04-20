package SpotifyOauth2.api.ApplicationAPI;

import SpotifyOauth2.POJO.Playlist;
import SpotifyOauth2.api.RestResource;
import SpotifyOauth2.api.utils.ConfigLoader;
import io.restassured.response.Response;

import static SpotifyOauth2.api.Route.PLAYLISTS;
import static SpotifyOauth2.api.Route.USERS;
import static SpotifyOauth2.api.TokenManager.getToken;

public class PlaylistAPI {
    public static Response post(Playlist requestPlaylist){
        return RestResource
                .post(requestPlaylist,USERS+"/"+ ConfigLoader.getInstance().getUserId()+PLAYLISTS, getToken());
     }
    public static Response post(Playlist requestPlaylist, String token){
        return RestResource
                .post(requestPlaylist,USERS+"/"+ConfigLoader.getInstance().getUserId()+PLAYLISTS,token);
    }
     public static Response get(String playlistId){
        return RestResource
                .get(PLAYLISTS+"/"+playlistId, getToken());
     }
     public static Response update(Playlist requestPlaylist,String playlistid){
        return RestResource.update(requestPlaylist,PLAYLISTS+"/"+playlistid, getToken());
     }
}
