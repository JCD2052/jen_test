import Pages.GamePage;
import org.testng.Assert;

public class CheckTimerTest extends BaseTest{

    public void checkTimerTest(){
        GamePage gamePage = new GamePage();
        gamePage.state().waitForDisplayed();
        String currentTimerValue = gamePage.getCurrentTimerValue().trim();
        Assert.assertEquals(currentTimerValue, "00:00:00");
    }
}
