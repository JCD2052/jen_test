package pages.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    private final static String HELP_WINDOW_LOCATOR =
            "//div[contains(@class, 'help-form') and not (contains(@class, '_'))]";
    private final IButton btnHelpFormButton = getElementFactory()
            .getButton(By.xpath("//button[contains(@class, 'send') and contains(@class, 'bottom')]"),
                    "Hide Help Form");

    public HelpForm() {
        super(By.xpath(HELP_WINDOW_LOCATOR), "Help Form");
    }

    public void clickHideHelpWindow() {
        btnHelpFormButton.click();
    }

    public boolean isHelpWindowHidden() {
       ILabel lblHelpWindow = getElementFactory()
                .getLabel(By.xpath(HELP_WINDOW_LOCATOR),
                        "Help Window");
        return lblHelpWindow.getAttribute("class").contains("hidden");
    }
}
