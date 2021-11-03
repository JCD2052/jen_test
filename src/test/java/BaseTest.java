import Pages.WelcomePage;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    protected void setup() {
        Browser browser = AqualityServices.getBrowser();
        browser.goTo("https://userinyerface.com/game.html%20target=");
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.goToGamePage();
    }

    @AfterMethod
    protected void teardown() {
        AqualityServices.getBrowser().quit();
    }
}
