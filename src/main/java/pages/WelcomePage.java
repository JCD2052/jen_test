package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WelcomePage extends Form {

    private final ILink lnkGoToGamePage = getElementFactory().
            getLink(By.xpath("//a[contains(@class, 'start') and contains(@class, 'link')]"),
                    "Go Next Page");

    public WelcomePage() {
        super(By.xpath("//button[contains(@class, 'start')]"), "Welcome Page");
    }

    public void goToGamePage() {
        lnkGoToGamePage.click();
    }
}
