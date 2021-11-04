package pages.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookiesForm extends Form {
    private final static String COOKIE_WINDOW_LOCATOR = "//div[contains(@class, 'cookies')]";
    private final String acceptCookiesButtonLocator = "//button[contains(text(), 'no')]";
    private final IButton btnAcceptCookies = getElementFactory()
            .getButton(By.xpath(COOKIE_WINDOW_LOCATOR.concat(acceptCookiesButtonLocator)),
                    "Accept Cookies Button");
    private final ILabel lblCookieWindow = getElementFactory()
            .getLabel(By.xpath(COOKIE_WINDOW_LOCATOR),
                    "Cookie Window");

    public CookiesForm() {
        super(By.xpath(COOKIE_WINDOW_LOCATOR), "Alert Form");
    }

    public void acceptCookies() {
        btnAcceptCookies.state().waitForExist();
        btnAcceptCookies.click();
    }

    public boolean isCookieWindowClosed() {
        return !lblCookieWindow.state().isExist();
    }
}
