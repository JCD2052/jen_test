package pages;

import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import pages.forms.CookiesForm;
import pages.forms.AvatarAndInterestsForm;
import pages.forms.HelpForm;
import pages.forms.LoginForm;


public class GamePage extends Form {
    private final ILabel lblPersonalDetails = getElementFactory()
            .getLabel(By.xpath("//div[contains(@class, 'personal') and contains(@class, 'content')]"),
                    "Personal Details Content Element");
    private final ILabel lblTimerFiled = getElementFactory()
            .getLabel(By.xpath("//div[contains(@class, 'timer')]"),
                    "Timer Field");
    public final CookiesForm cookiesForm;
    public final HelpForm helpForm;
    public final LoginForm loginForm;
    public final AvatarAndInterestsForm avatarAndInterestsForm;

    public GamePage() {
        super(By.xpath("//div[contains(@class, 'password')" +
                        " and contains(@class, 'check') " +
                        "and not (contains(@class, '_'))]"),
                "Game Page");
        this.cookiesForm = new CookiesForm();
        this.avatarAndInterestsForm = new AvatarAndInterestsForm();
        this.helpForm = new HelpForm();
        this.loginForm = new LoginForm();
    }

    public boolean isStepThreeLoaded() {
        return lblPersonalDetails.state().waitForDisplayed();
    }

    public String getCurrentTimerValue() {
        return lblTimerFiled.getText();
    }
}
