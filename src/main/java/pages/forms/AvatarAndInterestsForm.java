package pages.forms;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.RandomUtil;
import utils.RobotUtil;

import java.util.List;
import java.util.stream.Collectors;


public class AvatarAndInterestsForm extends Form {
    private List<ICheckBox> interests;
    private final static String INTEREST_CHECKBOXES_LOCATOR =
            "//label[contains(@class, 'checkbox') and contains(@class, 'label')]";
    private final ILabel lblAvatarPicture = getElementFactory()
            .getLabel(By.xpath("//div[contains(@class, 'image') and contains(@class, 'avatar')]"),
                    "Profile Avatar");
    private final ICheckBox chbUnselectAll = getElementFactory()
            .getCheckBox(By.xpath(INTEREST_CHECKBOXES_LOCATOR
                            .concat("//ancestor::div//span[contains(text(), 'Unselect')]//preceding-sibling::span")
                            .concat(INTEREST_CHECKBOXES_LOCATOR)),
                    "Unselect All");
    private final IButton btnUploadField = getElementFactory()
            .getButton(By.xpath("//a[contains(@class, 'upload') and contains(@class, 'button')]"),
                    "Upload Field");
    private final IButton lnkNextToStepThree = getElementFactory()
            .getButton(By.xpath("//button[contains(@class, 'button') and contains(text(), 'Next')]"),
                    "Next to Step 3");

    public AvatarAndInterestsForm() {
        super(By.xpath(INTEREST_CHECKBOXES_LOCATOR), "Fill Profile Form");
    }

    public boolean isImageLoaded() {
        return lblAvatarPicture.state().waitForExist();
    }

    public void checkInterestCheckBox(int position) {
        getAllCheckBoxes().get(position).check();
    }

    public void uploadFile(String absoluteFilePath) {
        btnUploadField.click();
        RobotUtil.insertFilePath(absoluteFilePath);
    }

    private int getInterestsQuantity() {
        return getAllCheckBoxes().size();
    }

    private List<ICheckBox> getAllCheckBoxes() {
        if (interests == null) {
            interests = getElementFactory().
                    findElements(By.xpath(INTEREST_CHECKBOXES_LOCATOR),
                            ICheckBox.class, ElementState.EXISTS_IN_ANY_STATE)
                    .stream().filter(checkBox -> !checkBox.getAttribute("for").toLowerCase().contains("select"))
                    .collect(Collectors.toList());
        }
        return interests;
    }

    public void unselectAllInterestsCheckBoxes() {
        if (!chbUnselectAll.isChecked()) {
            chbUnselectAll.check();
        }
    }

    public void checkInterests(int quantity) {
        for (int step : RandomUtil.getRandomIntRangeList(0, getInterestsQuantity(), quantity)) {
            checkInterestCheckBox(step);
        }
    }

    public void goToStepThree() {
        lnkNextToStepThree.click();
    }
}
