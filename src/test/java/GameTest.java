import utils.RandomUtil;
import utils.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class GameTest extends BaseTest {

    @Test
    public void gamePageTest() {
        File uploadFile = new File(
                TestDataReader.readTestDataFile()
                        .getValue("/upload_file_path").toString());
        String randomPassword = RandomUtil.getRandomString(15);
        String randomUsername = RandomUtil.getRandomString(15);
        String randomDomain = RandomUtil.getRandomString(15);
        gamePage.loginForm.fillForm(randomPassword, randomUsername, randomDomain);
        gamePage.loginForm.acceptTerms();
        gamePage.loginForm.goToStepTwo();
        Assert.assertTrue(gamePage.avatarAndInterestsForm.state().waitForDisplayed(),
                "Step 2 is not loaded.");
        gamePage.avatarAndInterestsForm.uploadFile(uploadFile.getAbsolutePath());
        Assert.assertTrue(gamePage.avatarAndInterestsForm.isImageLoaded(),
                "Image is not loaded.");
        gamePage.avatarAndInterestsForm.unselectAllInterestsCheckBoxes();
        gamePage.avatarAndInterestsForm.checkInterests(3);
        gamePage.avatarAndInterestsForm.goToStepThree();
        Assert.assertTrue(gamePage.isStepThreeLoaded(),
                "Step 3 is not Loaded");
    }

    @Test
    public void acceptCookiesTest() {
        gamePage.cookiesForm.acceptCookies();
        Assert.assertTrue(gamePage.cookiesForm.isCookieWindowClosed(),
                "Cookies Window still exists.");
    }

    @Test
    public void hideHelpWindowTest() {
        gamePage.helpForm.clickHideHelpWindow();
        Assert.assertTrue(gamePage.helpForm.isHelpWindowHidden(),
                "Help Window is not hidden.");
    }

    @Test
    public void checkTimerTest() {
        String currentTimerValue = gamePage.getCurrentTimerValue().trim();
        Assert.assertEquals(currentTimerValue,
                TestDataReader.readTestDataFile()
                        .getValue("/expected_timer_result").toString(),
                "Timer result doesn't match.");
    }
}
