package Pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class GamePage extends Form {

    private final String NEXT_BUTTON_BASE_LOCATOR = "[contains(@class, 'button') and contains(text(), 'Next')]";

    private final String COOKIE_WINDOW_LOCATOR = "//div[contains(@class, 'cookies')]";

    private final String ACCEPT_COOKIES_BUTTON_LOCATOR = "//button[contains(text(), 'no')]";

    private final ILabel HELP_WINDOW = getElementFactory()
            .getLabel(By.xpath("//div[contains(@class, 'help-form') and not (contains(@class, '_'))]"),
                    "Help Window");

    private final IButton HIDE_HELP_FORM_BUTTON = getElementFactory()
            .getButton(By.xpath("//button[contains(@class, 'send') and contains(@class, 'bottom')]"),
                    "Hide Help Form Button");

    private final ILabel COOKIE_WINDOW = getElementFactory().getLabel(By.xpath(COOKIE_WINDOW_LOCATOR),
            "Cookie Window");

    private final IButton CALL_DOMAIN_DROPDOWN_BUTTON = getElementFactory()
            .getButton(By.xpath("//div[contains(@class, 'dropdown') and contains(@class, 'header')]"),
                    "Call Domain Dropdown Button");

    private final IButton UPLOAD_FIELD = getElementFactory()
            .getButton(By.xpath("//a[contains(@class, 'upload') and contains(@class, 'button')]"),
                    "Upload Field");

    private final ILink NEXT_TO_STEP_TWO = getElementFactory()
            .getLink(By.xpath("//a".concat(NEXT_BUTTON_BASE_LOCATOR)),
                    "Next to Step 2 Link");

    private final IButton NEXT_TO_STEP_THREE = getElementFactory()
            .getButton(By.xpath("//button".concat(NEXT_BUTTON_BASE_LOCATOR)),
                    "Next to Step 3 Button");

    private final IButton ACCEPT_COOKIES_BUTTON = getElementFactory()
            .getButton(By.xpath(COOKIE_WINDOW_LOCATOR.concat(ACCEPT_COOKIES_BUTTON_LOCATOR)),
                    "Accept Cookies Button");

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

    private final ILabel TIMER_FILED = getElementFactory()
            .getLabel(By.xpath("//div[contains(@class, 'timer')]"),
                    "Timer Field");

    private final String INTEREST_CHECKBOXES_LOCATOR =
            "//span[contains(@class, 'checkbox') and contains(@class, 'icon')]";

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

    public boolean isCookieWindowClosed() {
        return !COOKIE_WINDOW.state().isExist();
    }

    public void clickHideHelpForm() {
        HIDE_HELP_FORM_BUTTON.click();
    }

    public boolean isHelpFormHidden() {
        return HELP_WINDOW.getAttribute("class").contains("hidden");
    }

    public String getCurrentTimerValue() {
        return TIMER_FILED.getText();
    }

    public void enterPassword(String password) {
        PASSWORD_INPUT_FIELD.clearAndType(password);
    }

    public void uploadFile() {
        UPLOAD_FIELD.click();
    }

    public void enterEmail(String email) {
        EMAIL_INPUT_FIELD.clearAndType(email);
    }

    public void enterDomain(String domain) {
        DOMAIN_INPUT_FIELD.clearAndType(domain);
    }

    public void clickDomainDropdownMenu() {
        CALL_DOMAIN_DROPDOWN_BUTTON.click();
    }

    public void selectDomain(int domainPosition) {
        List<ILabel> domainList = getElementFactory()
                .findElements(By.xpath(DOMAIN_SELECTOR_LOCATOR), ElementType.LABEL);
        domainList.get(domainPosition).click();
    }

    public void acceptTerms() {
        if (!ACCEPT_TERMS_CHECKBOX.isChecked()) {
            ACCEPT_TERMS_CHECKBOX.check();
        }
    }

    public int getDomainsCount() {
        List<ILabel> domainList = getElementFactory()
                .findElements(By.xpath(DOMAIN_SELECTOR_LOCATOR), ElementType.LABEL);
        return domainList.size();
    }

    public void goToStepTwo() {
        NEXT_TO_STEP_TWO.click();
    }

    public void unselectAllInterestsCheckBoxes() {
        List<ICheckBox> checkBoxes = getElementFactory()
                .findElements(By.xpath(INTEREST_CHECKBOXES_LOCATOR), ElementType.CHECKBOX);
        for (ICheckBox checkBox : checkBoxes) {
            if (checkBox.getText().contains("Unselect")) {
                if (!checkBox.isChecked()) {
                    checkBox.check();
                    break;
                }
            }
        }
    }

    public void goToStepThree() {
        NEXT_TO_STEP_THREE.click();
    }


}
