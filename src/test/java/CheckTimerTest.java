import Pages.GamePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTimerTest extends BaseTest{

    @Test
    public void checkTimerTest(){
        GamePage gamePage = new GamePage();
        gamePage.state().waitForDisplayed();
        String currentTimerValue = gamePage.getCurrentTimerValue().trim();
        Assert.assertEquals(currentTimerValue, "00:00:00");
    }
}
