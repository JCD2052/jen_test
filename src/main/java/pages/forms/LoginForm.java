package pages.forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.RandomUtil;

import java.util.List;

public class LoginForm extends Form {
    private static final String DOMAIN_SELECTOR_LOCATOR =
            "//div[contains(@class, 'dropdown') and contains(@class, 'list') and contains(@class, 'item')]";
    private final ITextBox txtPasswordInputField = getElementFactory()
            .getTextBox(By.xpath("//input[contains(@placeholder, 'Password')]"),
                    "Password Input Field");
    private final ITextBox txtEmailInputField = getElementFactory()
            .getTextBox(By.xpath("//input[contains(@placeholder, 'email')]"),
                    "Email Input Field");
    private final ITextBox txtDomainInputField = getElementFactory()
            .getTextBox(By.xpath("//input[contains(@placeholder, 'Domain')]"),
                    "Domain Input Field");
    private final ICheckBox chbAcceptTerms = getElementFactory()
            .getCheckBox(By.xpath("//span[contains(@class, 'icon') and contains(@class, 'checkbox')]"),
                    "Accept Terms");
    private final IButton btnCallDomainDropdown = getElementFactory()
            .getButton(By.xpath("//div[contains(@class, 'dropdown') and contains(@class, 'header')]"),
                    "Call Domain Dropdown");
    private final ILink lnkNextToStepTwo = getElementFactory()
            .getLink(By.xpath("//a[contains(@class, 'button') and contains(text(), 'Next')]"),
                    "Next to Step 2");

    public LoginForm() {
        super(By.xpath(DOMAIN_SELECTOR_LOCATOR), "Login Form");
    }

    public void fillForm(String password, String domain, String username) {
        enterPassword(password);
        enterUsername(username);
        enterDomain(domain);
        clickDomainDropdownMenu();
        selectDomain();
    }

    private void enterUsername(String email) {
        txtEmailInputField.clearAndType(email);
    }

    private void enterDomain(String domain) {
        txtDomainInputField.clearAndType(domain);
    }

    private void clickDomainDropdownMenu() {
        btnCallDomainDropdown.click();
    }

    private void enterPassword(String password) {
        txtPasswordInputField.clearAndType(password);
    }

    private void selectDomain() {
        List<ILabel> domainList = getElementFactory()
                .findElements(By.xpath(DOMAIN_SELECTOR_LOCATOR), ElementType.LABEL);
        domainList.get(RandomUtil.getRandomIntInRange(1, getDomainsCount() - 1)).click();
    }

    public void acceptTerms() {
        if (!chbAcceptTerms.isChecked()) {
            chbAcceptTerms.check();
        }
    }

    private int getDomainsCount() {
        return getElementFactory()
                .findElements(By.xpath(DOMAIN_SELECTOR_LOCATOR), ElementType.LABEL).size();
    }

    public void goToStepTwo() {
        lnkNextToStepTwo.click();
    }
}
