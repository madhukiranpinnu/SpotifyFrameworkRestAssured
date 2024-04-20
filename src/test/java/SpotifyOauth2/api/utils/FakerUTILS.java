package SpotifyOauth2.api.utils;

import com.github.javafaker.Faker;

public class FakerUTILS {
    public static String generateName(){
       Faker faker=new Faker();
       return "Playlist"+faker.regexify("[0-9a-zA-Z.,-_]{20}");
    }
    public static String generateDescription(){
        Faker faker=new Faker();
        return "Playlist"+faker.regexify("[0-9a-zA-Z!@#$%_]{30}");
    }
}
