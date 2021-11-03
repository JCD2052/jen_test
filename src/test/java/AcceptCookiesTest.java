import Pages.GamePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AcceptCookiesTest extends BaseTest {

    @Test
    public void acceptCookiesTest() {
        GamePage gamePage = new GamePage();
        gamePage.state().waitForDisplayed();
        gamePage.acceptCookies();
        Assert.assertTrue(gamePage.isCookieWindowClosed(),
                "Cookies Window still exist.");
    }
}
