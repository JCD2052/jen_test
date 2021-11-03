import Pages.GamePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HideHelpWindowTest extends BaseTest{

    @Test
    public void hideHelpWindowTest(){
        GamePage gamePage = new GamePage();
        gamePage.state().waitForDisplayed();
        gamePage.clickHideHelpForm();
        Assert.assertTrue(gamePage.isHelpFormHidden(), "Help Form is not hidden.");
    }
}
