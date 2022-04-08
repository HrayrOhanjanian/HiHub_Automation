package utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    protected static WebDriverWait wait;

    public static void setWait(int sec){
        wait = new WebDriverWait(DriverFactory.getDriver(),sec);
    }

    public static boolean waitUntilClickable (WebElement element) {
        setWait(5);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean waitForVisibility (WebElement element) {
        setWait(5);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
