import Pages.GamePage;
import Utils.RandomValue;
import org.testng.annotations.Test;

public class GameTest extends BaseTest{


    @Test
    public void gamePageTest(){
        GamePage gamePage = new GamePage();
        gamePage.state().waitForDisplayed();
        gamePage.enterPassword(RandomValue.getRandomPassword(11));
        gamePage.enterEmail(RandomValue.getRandomPassword(11));
        gamePage.enterDomain(RandomValue.getRandomPassword(11));
        gamePage.clickDomainDropdownMenu();
        gamePage.selectDomain(RandomValue.getRandomIntInRange(1, gamePage.getDomainsCount() - 1));
        gamePage.acceptTerms();
        gamePage.goToStepTwo();
    }
}
