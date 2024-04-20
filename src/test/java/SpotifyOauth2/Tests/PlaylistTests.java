package SpotifyOauth2.Tests;

import SpotifyOauth2.POJO.Error;
import SpotifyOauth2.POJO.Playlist;
import  SpotifyOauth2.api.ApplicationAPI.PlaylistAPI;
import SpotifyOauth2.api.StatusCode;
import SpotifyOauth2.api.utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static SpotifyOauth2.api.utils.FakerUTILS.generateDescription;
import static SpotifyOauth2.api.utils.FakerUTILS.generateName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
@Epic("Epic 1")
@Feature("Feature 1")
public class PlaylistTests extends BaseTest{

    @Test(description = "Create a playlist in spotify")
    @Description("Create playlist description from allure annotation")
    @Issue("https://google.com")
    @Link("https://Link")
    @TmsLink("https://Tms.com")
    @Story("Story 1")
    public void CreatePlaylist(){
        Playlist requestPlaylist=playlistCreator(generateName(),generateDescription(),false);
        Response response= PlaylistAPI.post(requestPlaylist);
        assertStatuscode(response.statusCode(), StatusCode.Code_201.getCode());
        Playlist responsePlaylist=response.as(Playlist.class);
        assertPlaylistDetails(responsePlaylist,requestPlaylist);
    }

    @Test
    @Story("Story re")
    public void getPlaylist(){
         Response response=PlaylistAPI.get(DataLoader.getInstance().getgetplaylistid());
        assertStatuscode(response.statusCode(),StatusCode.Code_200.getCode());

    }

    @Test
    @Story("Story 3")
    public void Updateplaylist(){
        Playlist requestPlaylist=playlistCreator(generateName(),generateDescription(),false);
       Response response=PlaylistAPI.update(requestPlaylist,DataLoader.getInstance().getupdateplaylistid());
        assertStatuscode(response.statusCode(),StatusCode.Code_200.getCode());

    }
    @Test
    @Story("Story 4")
    public void NegetiveScenarioForCreatePlaylistWhenNoNameSpecified() {
        Playlist requestPlaylist = playlistCreator("", generateDescription(), false);
        Response response = PlaylistAPI.post(requestPlaylist);
        assertStatuscode(response.statusCode(), StatusCode.Code_400.getCode());
        ErrorValidation(response, StatusCode.Code_400.getCmessage(), StatusCode.Code_400.getCode());
    }
    @Test
    @Story("Story 5")
    public void NegetiveScenarioForCreatePlaylistWhenAccesstokenexpired(){
        Playlist requestPlaylist=playlistCreator(generateName(),generateDescription(),false);
        String invalidToken="122333";
        Response response=PlaylistAPI.post(requestPlaylist,invalidToken);
        assertStatuscode(response.statusCode(),StatusCode.Code_401.getCode());
        ErrorValidation(response,StatusCode.Code_401.getCmessage(), StatusCode.Code_401.getCode());
    }
    @Step
    public Playlist playlistCreator(String playlistName,String description,Boolean publicScope){
        return  Playlist.builder()
        .name(playlistName)
        .description(description)
                ._public(publicScope).build();

    }
    @Step
    public void assertStatuscode(int expectedStatuscode,int actualstatuscode){
        Assert.assertEquals(expectedStatuscode,actualstatuscode,"The statuscodes are different");
    }
    @Step
    public void ErrorValidation(Response response,String errormessage,int statuscode){
        Error error=response.as(Error.class);
        assertThat(error.getError().getMessage(),equalTo(errormessage));
        assertThat(error.getError().getStatus(),equalTo(statuscode));
    }
    @Step
    public void assertPlaylistDetails(Playlist responsePlaylist,Playlist requestPlaylist){
        assertThat(responsePlaylist.getName(),equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(),equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.get_public(),equalTo(requestPlaylist.get_public()));
    }
}
