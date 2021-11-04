package Utils;

import aquality.selenium.core.logging.Logger;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.openqa.selenium.json.JsonException;

import java.io.File;
import java.io.IOException;

public class ReadTestData {

    public static ISettingsFile readTestDataFile() {
        try {
            return new JsonSettingsFile(new File("src/test/testData/testData.json"));
        } catch (IOException e) {
            Logger.getInstance().error("Test Data is not found");
            throw new JsonException("Test Data is not found", e);
        }
    }
}
