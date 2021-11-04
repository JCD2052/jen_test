import pages.GamePage;
import pages.WelcomePage;
import utils.TestDataReader;
import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected GamePage gamePage;

    @BeforeMethod
    protected void setup() {
        AqualityServices.getBrowser().goTo(TestDataReader.readTestDataFile()
                .getValue("/enter_url").toString());
        WelcomePage welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().waitForDisplayed(),
                "Welcome Page is not open.");
        welcomePage.goToGamePage();
        gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().waitForDisplayed(),
                "Game page is not open");
    }

    @AfterMethod
    protected void teardown() {
        AqualityServices.getBrowser().quit();
    }
}
