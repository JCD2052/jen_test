package Pages;

import Utils.RobotActions;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.List;
import java.util.stream.Collectors;

public class GamePage extends Form {
    private List<ICheckBox> checkBoxesList;

    private final ILabel PERSONAL_DETAILS_CONTENT = getElementFactory()
            .getLabel(By.xpath("//div[contains(@class, 'personal') and contains(@class, 'content')]"),
                    "Personal Details Content Element");

    private final String NEXT_BUTTON_BASE_LOCATOR = "[contains(@class, 'button') and contains(text(), 'Next')]";

    private final String INTEREST_CHECKBOXES_LOCATOR =
            "//label[contains(@class, 'checkbox') and contains(@class, 'label')]";

    private final String COOKIE_WINDOW_LOCATOR = "//div[contains(@class, 'cookies')]";

    private final String ACCEPT_COOKIES_BUTTON_LOCATOR = "//button[contains(text(), 'no')]";

    private final String DOMAIN_SELECTOR_LOCATOR =
            "//div[contains(@class, 'dropdown') and contains(@class, 'list') and contains(@class, 'item')]";

    private final ILabel HELP_WINDOW = getElementFactory()
            .getLabel(By.xpath("//div[contains(@class, 'help-form') and not (contains(@class, '_'))]"),
                    "Help Window");

    private final IButton HIDE_HELP_WINDOW_BUTTON = getElementFactory()
            .getButton(By.xpath("//button[contains(@class, 'send') and contains(@class, 'bottom')]"),
                    "Hide Help Form Button");

    private final ILabel COOKIE_WINDOW = getElementFactory()
            .getLabel(By.xpath(COOKIE_WINDOW_LOCATOR),
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

    private final ILabel AVATAR_PICTURE = getElementFactory()
            .getLabel(By.xpath("//div[contains(@class, 'image') and contains(@class, 'avatar')]"),
                    "Profile Avatar Picture");


    private final ICheckBox UNSELECT_ALL_CHECKBOX = getElementFactory()
            .getCheckBox(By.xpath(INTEREST_CHECKBOXES_LOCATOR
                            .concat("//ancestor::div//span[contains(text(), 'Unselect')]//preceding-sibling::span")
                            .concat(INTEREST_CHECKBOXES_LOCATOR)),
                    "Unselect All CheckBox");


    public GamePage() {
        super(By.xpath(
                        "//div[contains(@class, 'password')" +
                                " and contains(@class, 'check') " +
                                "and not (contains(@class, '_'))]"),
                "Game Page");
    }

    public boolean isImageLoaded() {
        return AVATAR_PICTURE.state().waitForExist();
    }

    public boolean isStepTwoLoaded() {
        return UPLOAD_FIELD.state().waitForDisplayed();
    }

    public boolean isStepThreeLoaded() {
        return PERSONAL_DETAILS_CONTENT.state().waitForDisplayed();
    }

    public void checkInterestCheckBox(int position) {
        getAllCheckBoxes().get(position).check();
    }

    public void acceptCookies() {
        ACCEPT_COOKIES_BUTTON.state().waitForExist();
        ACCEPT_COOKIES_BUTTON.click();
    }

    public boolean isCookieWindowClosed() {
        return !COOKIE_WINDOW.state().isExist();
    }

    public void clickHideHelpWindow() {
        HIDE_HELP_WINDOW_BUTTON.click();
    }

    public boolean isHelpWindowHidden() {
        return HELP_WINDOW.getAttribute("class").contains("hidden");
    }

    public String getCurrentTimerValue() {
        return TIMER_FILED.getText();
    }

    public void enterPassword(String password) {
        PASSWORD_INPUT_FIELD.clearAndType(password);
    }

    public void uploadFile(String absoluteFilePath) {
        UPLOAD_FIELD.click();
        RobotActions.insertFilePath(absoluteFilePath);
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
        return getElementFactory()
                .findElements(By.xpath(DOMAIN_SELECTOR_LOCATOR), ElementType.LABEL).size();
    }

    public int getInterestsCount() {
        return getAllCheckBoxes().size();
    }

    private List<ICheckBox> getAllCheckBoxes() {
        if (checkBoxesList == null) {
            checkBoxesList = getElementFactory().
                    findElements(By.xpath(INTEREST_CHECKBOXES_LOCATOR),
                            ICheckBox.class, ElementState.EXISTS_IN_ANY_STATE)
                    .stream().filter(checkBox -> !checkBox.getAttribute("for").toLowerCase().contains("select"))
                    .collect(Collectors.toList());
        }
        return checkBoxesList;
    }

    public void goToStepTwo() {
        NEXT_TO_STEP_TWO.click();
    }

    public void unselectAllInterestsCheckBoxes() {
        if (!UNSELECT_ALL_CHECKBOX.isChecked()) {
            UNSELECT_ALL_CHECKBOX.check();
        }
    }

    public void goToStepThree() {
        NEXT_TO_STEP_THREE.click();
    }

}
