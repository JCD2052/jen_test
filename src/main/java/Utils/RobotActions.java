package Utils;

import aquality.selenium.core.logging.Logger;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotActions {

    public static void insertFilePath(String absoluteFilePath) {
        try {
            Toolkit.getDefaultToolkit().getSystemClipboard()
                    .setContents(new StringSelection(absoluteFilePath), null);
            Robot robot = new Robot();
            robot.delay(200);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }catch (AWTException awtException){
            Logger.getInstance().error("Robot actions has been interrupted");
            throw new RuntimeException("Robot is interrupted", awtException);

        }

    }
}
