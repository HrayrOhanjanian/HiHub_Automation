package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverFactory;
import utils.SeleniumActions;
import utils.Waiters;

import java.util.ArrayList;

public class SignUp extends HomePage{

    public int randomInt = (int)(Math.random()*10000);

    public String emailForSignUp = "automation" + randomInt + "@mailinator.com";

    @FindBy(xpath = "//*[@name=\"phone\"]")
    public WebElement phoneNumberField;

    @FindBy(xpath = "//*[@class=\"error-msg\"]")
    public WebElement invalidPhone;

    @FindBy(xpath = "//*[@name=\"email\"]")
    public WebElement emailField;

    @FindBy(xpath = "//*[@class=\"error-msg\"]")
    public WebElement invalidEmail;

    @FindBy(xpath = "//*[@class=\"btn size-md filled primary full\"]")
    public WebElement nextBtn;

    @FindBy(xpath = "//*[@name=\"nameSurname\"]")
    public WebElement nameSurnameField;

    @FindBy(xpath = "//*[@class=\"error-msg\"]")
    public WebElement requiredNameSurname;

    @FindBy(xpath = "//*[@id=\"date-picker-inline-helper-text\"]")
    public WebElement invalidDayOfBirth;

    @FindBy(xpath = "//*[@id=\"date-picker-inline\"]")
    public WebElement dayOfBirthday;

    @FindBy(xpath = "//*[@name=\"password\"]")
    public WebElement passwordField;

    @FindBy(xpath = "/html/body//div/div[1]/div[2]/div[2]/p")
    public WebElement invalidPassword;

    @FindBy(xpath = "/html/body//div[2]/div[3]/p")
    public WebElement notMatchPass;

    @FindBy(xpath = "//*[@name=\"confirmPassword\"]")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@class=\"icon-close\"]")
    public WebElement xBtn;

    @FindBy(xpath = "//*[@alt=\"facebook logo\"]")
    public WebElement facebookSignIn;

    @FindBy(xpath = "//*[@id=\"content\"]")
    public WebElement facebookContent;

    @FindBy(xpath = "//*[@alt=\"Google logo\"]")
    public WebElement googleSignIn;

    @FindBy(xpath = "//*[@jsname=\"USBQqe\"]")
    public WebElement googleContent;

    @FindBy(xpath = "//*[@class=\"login-bg\"]")
    public WebElement rightSidePic;

    @FindBy(xpath = "//*[@class=\"second-step\"]")
    public WebElement register2ndStep;

    @FindBy(xpath = "//*[@class=\"third-step\"]")
    public WebElement register3rdStep;

    @FindBy(xpath = "//*[@class=\"back-step\"]")
    public WebElement backBtn;

    @FindBy(xpath = "//*[@class=\"btn size-md filled primary full\"]")
    public WebElement confirmBtn;

    @FindBy(xpath = "(//*[@class=\"pass-state icon-eye-show\"])[1]")
    public  WebElement showPassword;

    @FindBy(xpath = "(//*[@class=\"pass-state icon-eye-show\"])[1]")
    public WebElement showConfirmPass;

    @FindBy(xpath = "(//*[@class=\"pass-state icon-eye-hide\"])[1]")
    public WebElement hidePassword;

    @FindBy (xpath = "//*[@class=\"success-dialog\"]")
    public WebElement registerSuccessPopUp;

    @FindBy (xpath = "//*[@name=\"Close\"]")
    public WebElement registerSuccessCloseBtn;

    @FindBy(xpath = "//*[@class=\"notify-item error\"]")
    public WebElement signInWithoutConfirmNotification;

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement signInEmailField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement signInPasswordField;

    @FindBy(xpath = "//*[@name=\"Save\"]")
    public WebElement signInBtn;

    @FindBy(xpath = "//*[@id=\"search\"]")
    public WebElement mailinatorSearch;

    @FindBy(xpath = "//*[@value=\"Search for public inbox for free\"]")
    public WebElement mailinatorGoBtn;

    @FindBy(xpath = "(//*[@class=\"ng-binding\"])[1]")
    public WebElement confirmLink;

    @FindBy(xpath = "//*[@valign=\"top\"]")
    public WebElement confirmationModal;

    @FindBy(xpath = "(//*[@bgColor=\"#ffbe00\"])/a")
    public WebElement confirmRegisterBtn;

    @FindBy(xpath = "//*[@class=\"icon-user\"]")
    public WebElement profileIcon;

    @FindBy(xpath = "(//*[@class=\"dropdown first-level right show\"]//a)[4]")
    public WebElement logoutBtn;


    // Click on the x button in 1 step
    public void clickXBtn() {
        SeleniumActions.clickOnElement(xBtn);
        DriverFactory.getDriver().manage().deleteAllCookies();

    }
    // Check sign up popup closed
    public boolean isSignUpPopupClosed1st () {
        try {
            signUpPopUp.isDisplayed();
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    // Check invalid error message  is appears for phone number
    public boolean isInvalidPhoneAppear() {
        return invalidPhone.isDisplayed();
    }

    // check invalid email appear
    public boolean isInvalidEmailAppear() {
        return invalidEmail.isDisplayed();
    }

    // Check if the button is clickable
    public boolean isNextBtnClickable() {
        try {
            nextBtn.isEnabled();
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    // Click next Btn
    public void clickNextBtn() {
        SeleniumActions.clickOnElement(nextBtn);
    }

    // Click facebook sign in Button
    public void clickFacebookBtn() {
        Waiters.waitForVisibility(rightSidePic);
        SeleniumActions.clickOnElement(facebookSignIn);
    }

    // Is facebook content appear
    public boolean isFacebookContentAppear() {
        Waiters.waitForVisibility(facebookContent);
        ArrayList<String> facebookDriver = new ArrayList<> (DriverFactory.getDriver().getWindowHandles());
        DriverFactory.getDriver().switchTo().window(facebookDriver.get(1));

        return facebookContent.isDisplayed();
    }

    // click on the sing in with Google Btn
    public void clickGoogleBtn() {
        Waiters.waitForVisibility(rightSidePic);
        SeleniumActions.clickOnElement(googleSignIn);
    }

    // Click gmail sign in btn
    public boolean isGoogleContentAppear() {
        Waiters.waitForVisibility(googleContent);
        ArrayList<String> googleDriver = new ArrayList<> (DriverFactory.getDriver().getWindowHandles());
        DriverFactory.getDriver().switchTo().window(googleDriver.get(1));

        return googleContent.isDisplayed();
    }

    // Check if user redirects to first step of register
    public boolean isRegister1stStepAppear() {
        return signUpPopUp.isDisplayed();
    }

    // Check if user redirect to 2nd step of register
    public boolean isRegister2ndStepAppear() {
        Waiters.waitForVisibility(register2ndStep);
        return register2ndStep.isDisplayed();
    }

    // Click on the back Btn in the register pop up
    public void clickBackBtn() {
        SeleniumActions.clickOnElement(backBtn);
    }

    // Check if the required error message appears when user send surname and clean
    public boolean isRequiredNameAppear() {
        return requiredNameSurname.isDisplayed();
    }

    // Check if invalid DOB appear
    public boolean isInvalidDayOfBirthAppear() {
        return invalidDayOfBirth.isDisplayed();
    }

    // Check if user redirects to 3rd step of register
    public boolean isRegister3ndStepAppear() {
        return register3rdStep.isDisplayed();
    }

    // Check is invalid password appear
    public boolean isInvalidPassAppear(){
        return invalidPassword.isDisplayed();
    }

    // Check is password doesn't match error message appear
    public boolean isNotMatchPassesAppear() {
        return notMatchPass.isDisplayed();
    }

    // check is confirm btn is clickable
    public boolean isConfirmBtnClickable() {
        try {
            confirmBtn.isEnabled();
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    // Redirecting to password step
    public void redirectPasswordsStep(String email, String nameSurname, String dayOfBirth) {
        SeleniumActions.clickOnElement(headerSignUpBtn);
        SeleniumActions.sendKeysOnElement(emailField,email);
        SeleniumActions.clickOnElement(nextBtn);
        SeleniumActions.sendKeysOnElement(nameSurnameField,nameSurname);
        SeleniumActions.sendKeysOnElement(dayOfBirthday,dayOfBirth);
        SeleniumActions.clickOnElement(nextBtn);
    }

    // Click on the show password Btn
    public void clickShowPassBtn(WebElement element) {
        SeleniumActions.clickOnElement(element);
    }

    // Check is show password chang password to visible

    public boolean isPasswordVisible() {
        return passwordField.getAttribute("type").equals("text");
    }

    public boolean isConfirmPassVisible() {
        return confirmPasswordField.getAttribute("type").equals("text");
    }

    public boolean isSuccessPopUpAppear() {
        Waiters.waitForVisibility(registerSuccessPopUp);
        return registerSuccessPopUp.isDisplayed();
    }

    public boolean isNoConfirmErrorNotificationAppear() {
        Waiters.waitForVisibility(signInWithoutConfirmNotification);
        return signInWithoutConfirmNotification.isDisplayed();
    }

    public void openMailinator() {
        DriverFactory.getDriver().get("https://www.mailinator.com/");
    }

    public void switchToNewTab() {
        ArrayList<String> confirmTab = new ArrayList<> (DriverFactory.getDriver().getWindowHandles());
        DriverFactory.getDriver().switchTo().window(confirmTab.get(1));
    }

    public boolean isProfileIconAppear() {
        Waiters.waitUntilClickable(profileIcon);
        return profileIcon.isDisplayed();
    }

}
