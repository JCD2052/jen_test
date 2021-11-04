import Utils.ReadTestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTimerTest extends BaseTest {

    @Test
    public void checkTimerTest() {
        String currentTimerValue = gamePage.getCurrentTimerValue().trim();
        Assert.assertEquals(currentTimerValue,
                ReadTestData.readTestDataFile()
                        .getValue("/expected_timer_result").toString(),
                "Timer result doesn't match.");
    }
}
