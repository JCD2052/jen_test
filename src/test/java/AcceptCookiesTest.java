import org.testng.Assert;
import org.testng.annotations.Test;

public class AcceptCookiesTest extends BaseTest {

    @Test
    public void acceptCookiesTest() {
        gamePage.acceptCookies();
        Assert.assertTrue(gamePage.isCookieWindowClosed(),
                "Cookies Window still exists.");
    }
}
