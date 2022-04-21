package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActions {
    static ThreadLocal<Actions> actions = new ThreadLocal<>();

    public static void setActions() {
        actions.set(new Actions(DriverFactory.getDriver()));
    }

    public static Actions getActions() {
        return actions.get();
    }

    public static void removeActions(){
        actions.remove();
    }

    public static void clickOnElement(WebElement element) {
        Waiters.waitUntilClickable(element);
        getActions().click(element).build().perform();
    }

    public static void sendKeysOnElement(WebElement element, String text) {
        Waiters.waitForVisibility(element);
        getActions().sendKeys(element, text).build().perform();
    }

    public static void cleanTextFromElement(WebElement element) {
        String inputValue = element.getAttribute("value");
        if(inputValue!= null) {
            for (int i = 0; i < inputValue.length(); i++) {
                element.sendKeys(Keys.BACK_SPACE);

            }
        }
    }

}
