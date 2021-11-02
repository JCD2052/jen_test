package Pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class GamePage extends Form {


    private final IButton ACCEPT_COOKIES_BUTTON = getElementFactory()
            .getButton(By.xpath("//div[contains(@class, 'cookies')]//button[contains(text(), 'Yes')]"),
                    "Accept Cookies Button");

    private final ILink HELP_LINK = getElementFactory()
            .getLink(By.xpath("//a[contains(@class, 'help') and contains(@class, 'button')]"),
                    "Help Button");

    private final ITextBox PASSWORD_INPUT_FIELD = getElementFactory()
            .getTextBox(By.xpath("//input[contains(@placeholder, 'Password')]"),
                    "Password Input Field");

    private final ITextBox EMAIL_INPUT_FIELD = getElementFactory()
            .getTextBox(By.xpath("//input[contains(@placeholder, 'email')]"),
                    "Email Input Field");

    private final ITextBox DOMAIN_INPUT_FIELD = getElementFactory()
            .getTextBox(By.xpath("//input[contains(@placeholder, 'domain')]"),
                    "Domain Input Field");

    private final ICheckBox ACCEPT_TERMS_CHECKBOX = getElementFactory().
            getCheckBox(By.xpath("//input[contains(@id, 'accept') and contains(@id, 'terms')]"),
                    "Accept Terms Checkbox");

    private final ITextBox TIMER_FILED = getElementFactory()
            .getTextBox(By.xpath("//div[contains(@class, 'timer')]"),
                    "Timer Field");


    public GamePage() {
        super(By.xpath(
                        "//div[contains(@class, 'password')" +
                                " and contains(@class, 'check') " +
                                "and not (contains(@class, '_'))]"),
                "Game Page");
    }


    public void acceptCookies() {
        ACCEPT_COOKIES_BUTTON.click();
    }

    public void clickHelpButton() {
        HELP_LINK.click();
    }

    public String getCurrentTimerValue() {
        return TIMER_FILED.getValue();
    }

    //Can be boolean. Need to add rules for entered password.
    public void enterPassword(String password) {
        PASSWORD_INPUT_FIELD.clearAndType(password);
    }

    public void enterEmail(String email) {
        EMAIL_INPUT_FIELD.clearAndType(email);
    }


    public void enterDomain(String domain) {
        DOMAIN_INPUT_FIELD.clearAndType(domain);
    }

    public void acceptTerms() {
        if (ACCEPT_TERMS_CHECKBOX.isChecked()) {
            ACCEPT_TERMS_CHECKBOX.uncheck();
        }
    }


}
