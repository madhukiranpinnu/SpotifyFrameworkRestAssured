package SpotifyOauth2.api;

public enum StatusCode {

    Code_200(200,""),
    Code_201(201,""),
    Code_400(400,"Missing required field: name"),
    Code_401(401,"Invalid access token");
    private final int code;
    private final String cmessage;
    StatusCode(int code,String message){
        this.code=code;
        this.cmessage =message;
    }
    public int getCode(){
        return code;
    }
    public String getCmessage(){
        return cmessage;
    }
}
