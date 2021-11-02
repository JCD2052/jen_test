package Pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class GamePage extends Form {

    private final String NEXT_BUTTON_BASE_LOCATOR = "[contains(@class, 'button') and contains(text(), 'Next')]";

    private final IComboBox CALL_DOMAIN_DROPDOWN_BUTTON = getElementFactory()
            .getComboBox(By.xpath("//div[contains(@class, 'dropdown') and contains(@class, 'header')]"),
                    "Call Domain Dropdown Button");

    private final ITextBox UPLOAD_FIELD = getElementFactory()
            .getTextBox(By.xpath("//a[contains(@class, 'upload') and contains(@class, 'button')]"),
                    "Upload Field");

    private final ILink NEXT_TO_STEP_TWO = getElementFactory()
            .getLink(By.xpath("//a".concat(NEXT_BUTTON_BASE_LOCATOR)),
                    "Next to Step 2 Link");

    private final IButton NEXT_TO_STEP_THREE = getElementFactory()
            .getButton(By.xpath("//button".concat(NEXT_BUTTON_BASE_LOCATOR)),
                    "Next to Step 3 Button");

    private final IButton ACCEPT_COOKIES_BUTTON = getElementFactory()
            .getButton(By.xpath("//div[contains(@class, 'cookies')]//button[contains(text(), 'no')]"),
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
            .getTextBox(By.xpath("//input[contains(@placeholder, 'Domain')]"),
                    "Domain Input Field");

    private final ICheckBox ACCEPT_TERMS_CHECKBOX = getElementFactory()
            .getCheckBox(By.xpath("//span[contains(@class, 'icon') and contains(@class, 'checkbox')]"),
                    "Accept Terms Checkbox");

    private final ITextBox TIMER_FILED = getElementFactory()
            .getTextBox(By.xpath("//div[contains(@class, 'timer')]"),
                    "Timer Field");

    private final String INTEREST_CHECKBOXES_LOCATOR =
            "//div[contains(@class, 'interests') and contains(@class, 'list') and contains(@class, 'item')]";

    private final String DOMAIN_SELECTOR_LOCATOR =
            "//div[contains(@class, 'dropdown') and contains(@class, 'list') and contains(@class, 'item')]";


    public GamePage() {
        super(By.xpath(
                        "//div[contains(@class, 'password')" +
                                " and contains(@class, 'check') " +
                                "and not (contains(@class, '_'))]"),
                "Game Page");
    }


    public void acceptCookies() {
        ACCEPT_COOKIES_BUTTON.state().waitForExist();
        ACCEPT_COOKIES_BUTTON.click();
    }

    public void clickHelpButton() {
        HELP_LINK.click();
    }

    public String getCurrentTimerValue() {
        return TIMER_FILED.getText();
    }

    //Can be boolean. Need to add rules for entered password.
    public void enterPassword(String password) {
        PASSWORD_INPUT_FIELD.clearAndType(password);
    }

    public void uploadFile(String filePath) {
        UPLOAD_FIELD.type(filePath);
    }


    //Can be boolean. Need to add rules for entered email.
    public void enterEmail(String email) {
        EMAIL_INPUT_FIELD.clearAndType(email);
    }

    //Can be boolean. Need to add rules for entered boolean.
    public void enterDomain(String domain) {
        DOMAIN_INPUT_FIELD.clearAndType(domain);
    }

    public void selectDomain(int domainPosition) {
        CALL_DOMAIN_DROPDOWN_BUTTON.click();
        List<ILabel> domainList = getElementFactory()
                .findElements(By.xpath(DOMAIN_SELECTOR_LOCATOR), ElementType.LABEL);
        int dropdownSize = domainList.size();
        domainList.get(domainPosition).click();
    }

    public void acceptTerms() {
        System.out.println(ACCEPT_TERMS_CHECKBOX.isChecked());
        if (!ACCEPT_TERMS_CHECKBOX.isChecked()) {
            ACCEPT_TERMS_CHECKBOX.check();
        }
    }

    public void goToStepTwo() {
        NEXT_TO_STEP_TWO.click();
    }

    public void goToStepThree() {
        NEXT_TO_STEP_THREE.click();
    }


}
