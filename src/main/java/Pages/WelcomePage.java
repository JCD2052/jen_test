package Pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WelcomePage extends Form {

    private final ILink GO_TO_GAME_PAGE_LINK = getElementFactory().
            getLink(By.xpath("//a[contains(@class, 'start') and contains(@class, 'link')]"),
                    "Go Next Page Link");

    public WelcomePage() {
        super(By.xpath("//button[contains(@class, 'start')]"), "Welcome Page");
    }

    public void goToGamePage() {
        GO_TO_GAME_PAGE_LINK.click();
    }


}
