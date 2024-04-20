package SpotifyOauth2.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;

public class BaseTest {
    @BeforeMethod
    public void BT(Method m){
        System.out.println(m.getName());
        System.out.println(Thread.currentThread().getId());
    }
}
