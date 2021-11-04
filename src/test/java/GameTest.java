import Utils.RandomValue;
import Utils.ReadTestData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class GameTest extends BaseTest {

    @Test
    public void gamePageTest() {
        File uploadFile = new File(
                ReadTestData.readTestDataFile()
                        .getValue("/upload_file_path").toString());
        gamePage.enterPassword(RandomValue
                .getRandomPassword(RandomValue.getRandomIntInRange(10, 20)));
        gamePage.enterEmail(RandomValue
                .getRandomPassword(RandomValue.getRandomIntInRange(10, 20)));
        gamePage.enterDomain(RandomValue
                .getRandomPassword(RandomValue.getRandomIntInRange(10, 20)));

        gamePage.clickDomainDropdownMenu();
        gamePage.selectDomain(RandomValue
                .getRandomIntInRange(1, gamePage.getDomainsCount() - 1));
        gamePage.acceptTerms();
        gamePage.goToStepTwo();
        Assert.assertTrue(gamePage.isStepTwoLoaded(),
                "Step 2 is not loaded.");
        gamePage.uploadFile(uploadFile.getAbsolutePath());
        Assert.assertTrue(gamePage.isImageLoaded(),
                "Image is not loaded.");
        gamePage.unselectAllInterestsCheckBoxes();
        int count = gamePage.getInterestsCount();
        for (int step : RandomValue.getRandomIntRangeList(0, count,
                (int) ReadTestData.readTestDataFile()
                        .getValue("/count_of_selected_checkboxes"))) {
            gamePage.checkInterestCheckBox(step);
        }
        gamePage.goToStepThree();
        Assert.assertTrue(gamePage.isStepThreeLoaded(),
                "Step 3 is not Loaded");


    }
}
