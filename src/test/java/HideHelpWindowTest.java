import org.testng.Assert;
import org.testng.annotations.Test;

public class HideHelpWindowTest extends BaseTest{

    @Test
    public void hideHelpWindowTest(){
        gamePage.clickHideHelpWindow();
        Assert.assertTrue(gamePage.isHelpWindowHidden(),
                "Help Window is not hidden.");
    }
}
