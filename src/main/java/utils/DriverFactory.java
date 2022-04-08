package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static void initDriver () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver (){
        return driver;

    }

    public static void downDriver () {
        driver.quit();
    }

    public static WebDriver driverForAdmin;

    public static void initDriverForAdmin() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriverForAdmin () {
        return driverForAdmin;
    }

    public static void downDriverForAdmin() {
        driverForAdmin.quit();
    }
}
