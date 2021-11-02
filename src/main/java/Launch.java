import Pages.WelcomePage;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;

public class Launch {
    public static void main(String[] args) throws InterruptedException {
        Browser browser = AqualityServices.getBrowser();
        browser.goTo("https://userinyerface.com/game.html%20target=");
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.goToGamePage();
        Thread.sleep(5000);
        browser.quit();
    }
}
