import Pages.GamePage;
import Pages.WelcomePage;
import Utils.RandomValue;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;

public class Launch {
    public static void main(String[] args) throws InterruptedException {
        Browser browser = AqualityServices.getBrowser();
        browser.goTo("https://userinyerface.com/game.html%20target=");
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.goToGamePage();
        GamePage gamePage = new GamePage();
        gamePage.state().waitForDisplayed();
        gamePage.enterPassword(RandomValue.getRandomPassword(11));
        gamePage.enterEmail(RandomValue.getRandomPassword(11));
        gamePage.enterDomain(RandomValue.getRandomPassword(11));
        gamePage.clickDomainDropdownMenu();
        gamePage.selectDomain(RandomValue.getRandomIntInRange(1, gamePage.getDomainsCount() - 1));
        gamePage.acceptTerms();
        gamePage.goToStepTwo();
        gamePage.uploadFile();
        Thread.sleep(3000);
        browser.quit();
    }
}
