import Pages.GamePage;
import Pages.WelcomePage;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;

public class Launch {
    public static void main(String[] args) throws InterruptedException {
        Browser browser = AqualityServices.getBrowser();
        browser.goTo("https://userinyerface.com/game.html%20target=");
        browser.maximize();
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.goToGamePage();
        GamePage gamePage = new GamePage();
        gamePage.acceptCookies();
        gamePage.clickHelpButton();
        gamePage.enterPassword("XzVZXloV1d");
        gamePage.enterEmail("Zma");
        gamePage.enterDomain("mail");
        gamePage.selectDomain(4);
        gamePage.acceptTerms();
        gamePage.goToStepTwo();
        Thread.sleep(3000);
        gamePage.goToStepThree();
        Thread.sleep(3000);
        browser.quit();
    }
}
