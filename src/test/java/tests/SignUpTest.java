package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SignUp;
import utils.DriverFactory;
import utils.SeleniumActions;
import utils.Waiters;


public class SignUpTest extends HomePageTest{

    // Check sign up popup closed in 1st step
    @Test
    void clickXBtn1st() {
        SignUp signUp = new SignUp();

        signUp.clickSignUpBtn();
        signUp.clickXBtn();
        Assert.assertFalse(signUp.isSignUpPopupClosed1st(), "There is issue when user clicks on the x button in the sign up 1st step");
    }

    // Check sign up 1st step with invalid phone
    @Test
    void invalidPhone(){
        SignUp signUp = new SignUp();
        SoftAssert softAssert = new SoftAssert();

        signUp.clickSignUpBtn();
        SeleniumActions.sendKeysOnElement(signUp.phoneNumberField,"011");
        signUp.clickNextBtn();
        softAssert.assertTrue(signUp.isInvalidPhoneAppear(), "The invalid phone is missing");
        softAssert.assertFalse(signUp.isNextBtnClickable(), "The next button is clickable when user enters invalid phone number");
        softAssert.assertAll();
    }

    // Check sign up 1st step with invalid email
    @Test
    void invalidEmail() {
        SignUp signUp = new SignUp();
        SoftAssert softAssert = new SoftAssert();

        signUp.clickSignUpBtn();
        SeleniumActions.sendKeysOnElement(signUp.emailField,"test");
      //  signUp.clickNextBtn(); There is bug with clickable Next button
        softAssert.assertTrue(signUp.isInvalidEmailAppear(), "The invalid email is missing");
        softAssert.assertFalse(signUp.isNextBtnClickable(), "The next Btn is clickable  with invalid email");
        softAssert.assertAll();
    }

    // Check when user wants to sign in with Facebook
   /* @Test
    void singInWithFacebook() {
        SignUp signUp = new SignUp();

        signUp.clickSignUpBtn();
        signUp.clickFacebookBtn();
        Assert.assertTrue(signUp.isFacebookContentAppear(), "There is issue when user clicks on the Facebook Btn ");
    }*/

    // Check when user wants to sign in with Google
   /* @Test
    void signInWithGoogle() {
        SignUp signUp = new SignUp();

        signUp.clickSignUpBtn();
        signUp.clickGoogleBtn();
        Assert.assertTrue(signUp.isGoogleContentAppear(), "There is issue when user clicks on the google Btn");
    }*/

    // Check register 2nd step pass with valid email
    @Test
    void register2ndStepEmail() {
        SignUp signUp = new SignUp();
        signUp.clickSignUpBtn();
        SeleniumActions.sendKeysOnElement(signUp.emailField, "test@mailinator.com");
        SeleniumActions.clickOnElement(signUp.nextBtn);

        Assert.assertTrue(signUp.isRegister2ndStepAppear(),"There is issue with register 2nd step when user enters valid email ");
    }

    // Check register 2nd step pass with valid phone number
    @Test
    void register2ndStepPhone() {
        SignUp signUp = new SignUp();
        signUp.clickSignUpBtn();
        SeleniumActions.sendKeysOnElement(signUp.phoneNumberField,"094874499");
        SeleniumActions.clickOnElement(signUp.nextBtn);

        Assert.assertTrue(signUp.isRegister2ndStepAppear(), "There is issue with register 2nd step when user enters valid phone number ");
    }

    // Check register 2nd step pass with valid phone number and valid email
    @Test
    void register2ndStep() {
        SignUp signUp = new SignUp();

        signUp.clickSignUpBtn();
        SeleniumActions.sendKeysOnElement(signUp.phoneNumberField, "094874499");
        SeleniumActions.sendKeysOnElement(signUp.emailField, "test@mailinator.com");
        SeleniumActions.clickOnElement(signUp.nextBtn);

        Assert.assertTrue(signUp.isRegister2ndStepAppear(), "There is issue with register 2nd step when user enters valid email and phone ");
    }

    // Check user redirects from register 2nd step to 1st
    @Test
    void backTo1stStep() {
        SignUp signUp = new SignUp();

        signUp.clickSignUpBtn();
        SeleniumActions.sendKeysOnElement(signUp.emailField, "test@mailinator.com");
        SeleniumActions.clickOnElement(signUp.nextBtn);
        signUp.clickBackBtn();

        Assert.assertTrue(signUp.isRegister1stStepAppear());
    }

    // Check if without filling DOB And name surname is next button clickable in register 2nd step
    @Test
    void emptyNextBtnReg2ndStep() {
        SignUp signUp = new SignUp();

        signUp.clickSignUpBtn();
        SeleniumActions.sendKeysOnElement(signUp.emailField,"test@mailinator.com");
        SeleniumActions.clickOnElement(signUp.nextBtn);

        Assert.assertFalse(signUp.isNextBtnClickable(),"The next button is clickable with empty fields in register 2nd step");
    }


    // Check if required name surname appear when user enters name and cleans
    @Test
    void requiredName() {
        SignUp signUp = new SignUp();
        SoftAssert softAssert = new SoftAssert();

        signUp.clickSignUpBtn();
        SeleniumActions.sendKeysOnElement(signUp.emailField, "test@mailinator.com");
        SeleniumActions.clickOnElement(signUp.nextBtn);
        SeleniumActions.sendKeysOnElement(signUp.nameSurnameField, "david");
        SeleniumActions.cleanTextFromElement(signUp.nameSurnameField);
        SeleniumActions.clickOnElement(signUp.dayOfBirthday);
        Waiters.waitForVisibility(signUp.requiredNameSurname);

        softAssert.assertTrue(signUp.isRequiredNameAppear(),"Required name is missing in the register 2nd step");
        softAssert.assertFalse(signUp.isNextBtnClickable(), "With empty name next button is clickable in the Register 2nd step ");
        softAssert.assertAll();
    }

    // Check if invalid DOB appears when user enters invalid DOB
    @Test
    void invalidDayOfBirth() {
        SignUp signUp = new SignUp();
        SoftAssert softAssert = new SoftAssert();

        signUp.clickSignUpBtn();
        SeleniumActions.sendKeysOnElement(signUp.emailField,"test@mailinator.com");
        SeleniumActions.clickOnElement(signUp.nextBtn);
        SeleniumActions.sendKeysOnElement(signUp.dayOfBirthday,"00000000");
        softAssert.assertTrue(signUp.isInvalidDayOfBirthAppear(), "Invalid error message for DOB is missing when user enters full incorrect DOB");

        SeleniumActions.cleanTextFromElement(signUp.dayOfBirthday);
        SeleniumActions.sendKeysOnElement(signUp.dayOfBirthday,"40011998");
        softAssert.assertTrue(signUp.isInvalidDayOfBirthAppear(), "invalid error message is missing when user enters invalid day in DOB field");

        SeleniumActions.cleanTextFromElement(signUp.dayOfBirthday);
        SeleniumActions.sendKeysOnElement(signUp.dayOfBirthday, "01132000");
        softAssert.assertTrue(signUp.isInvalidDayOfBirthAppear(), "Invalid error message is missing when user enters incorrect mount");

        SeleniumActions.cleanTextFromElement(signUp.dayOfBirthday);
        SeleniumActions.sendKeysOnElement(signUp.dayOfBirthday, "01011899");
        softAssert.assertTrue(signUp.isInvalidDayOfBirthAppear(),"invalid error message is missing when user enters invalid year");

        softAssert.assertAll();
    }

    // Check is user redirects to sign  up 3rd
    @Test
    void redirect3stepRegister() {
        SignUp signUp = new SignUp();

        signUp.redirectPasswordsStep("Test@mailinator.com", "David", "23021998");
        Assert.assertTrue(signUp.isRegister3ndStepAppear(), "There is issue when user redirects to register 3rd step ");

    }

    // Check is user redirects to 2nd step of register when clicks on the back btn in the register 3rd step
    @Test
    void backBtn3step() {
        SignUp signUp = new SignUp();
        signUp.redirectPasswordsStep("Test@mailinator.com", "David", "23021998");
        signUp.clickBackBtn();

        Assert.assertTrue(signUp.isRegister2ndStepAppear());
    }

    // Check is invalid password error message appear and confirm btn is not clickable with invalid pass
    @Test
    void invalidPass() {
        SignUp signUp = new SignUp();
        SoftAssert softAssert = new SoftAssert();

        signUp.redirectPasswordsStep("Test@mailinator.com", "David", "23021998");

        SeleniumActions.sendKeysOnElement(signUp.passwordField,"1");
        softAssert.assertTrue(signUp.isInvalidPassAppear(), "There is issue when user enters 1 symbol in the password field");
        softAssert.assertFalse(signUp.isConfirmBtnClickable(), "confirm Btn is clickable with invalid pass");

        SeleniumActions.cleanTextFromElement(signUp.passwordField);
        SeleniumActions.sendKeysOnElement(signUp.passwordField,"123");
        softAssert.assertTrue(signUp.isInvalidPassAppear(), "There is issue when user enters 3 symbol in the password field");
        softAssert.assertFalse(signUp.isConfirmBtnClickable(), "confirm Btn is clickable with invalid pass");

        SeleniumActions.cleanTextFromElement(signUp.passwordField);
        SeleniumActions.sendKeysOnElement(signUp.passwordField,"12345");
        softAssert.assertTrue(signUp.isInvalidPassAppear(), "There is issue when user enters 5 symbol in the password field");
        softAssert.assertFalse(signUp.isConfirmBtnClickable(), "confirm Btn is clickable with invalid pass");

        softAssert.assertAll();
    }

    // Check is passwords doesn't match error message appear and confirm Btn is not clickable
    @Test
    void notMatchPasses() {
        SignUp signUp = new SignUp();
        SoftAssert softAssert = new SoftAssert();

        signUp.redirectPasswordsStep("Test@mailinator.com", "David", "23021998");

        SeleniumActions.sendKeysOnElement(signUp.passwordField, "123456");

        SeleniumActions.sendKeysOnElement(signUp.confirmPasswordField, "1");
        softAssert.assertTrue(signUp.isNotMatchPassesAppear(), "password isn't match is missing when user enters valid pass and 1 symbol confirm pass");
        softAssert.assertFalse(signUp.isConfirmBtnClickable(), "When there is doesn't match error message, confirm Btn is clickable ");

        SeleniumActions.sendKeysOnElement(signUp.confirmPasswordField, "23");
        softAssert.assertTrue(signUp.isNotMatchPassesAppear(), "password isn't match is missing when user enters valid pass and 3 symbol confirm pass");
        softAssert.assertFalse(signUp.isConfirmBtnClickable(), "When there is doesn't match error message, confirm Btn is clickable ");

        SeleniumActions.sendKeysOnElement(signUp.confirmPasswordField, "45");
        softAssert.assertTrue(signUp.isNotMatchPassesAppear(), "password isn't match is missing when user enters valid pass and 5 symbol confirm pass");
        softAssert.assertFalse(signUp.isConfirmBtnClickable(), "When there is doesn't match error message, confirm Btn is clickable ");
        softAssert.assertAll();

    }

    // Check show Password Btn Functionality
    @Test
    void checkShowPassBtn() {
        SignUp signUp = new SignUp();
        SoftAssert softAssert = new SoftAssert();

        signUp.redirectPasswordsStep("Test@mailinator.com", "David", "23021998");
        SeleniumActions.sendKeysOnElement(signUp.passwordField, "123456");
        SeleniumActions.sendKeysOnElement(signUp.confirmPasswordField, "123456");

        signUp.clickShowPassBtn(signUp.showPassword);
        softAssert.assertTrue(signUp.isPasswordVisible(), "There is issue when user clicks on the show password Btn");

        signUp.clickShowPassBtn(signUp.showConfirmPass);
        softAssert.assertTrue(signUp.isConfirmPassVisible(), "There is issue when user clicks on the show confirm pass Btn");

        // check password isn't visible when user clicks on the hide passwordBtn

        signUp.clickShowPassBtn(signUp.hidePassword);
        softAssert.assertFalse(signUp.isPasswordVisible(),"There is issue when user clicks on the hide password Btn");

        signUp.clickShowPassBtn(signUp.hidePassword);
        softAssert.assertFalse(signUp.isConfirmPassVisible(), "there is issue when user clicks on the hide confirm pass Btn");

        softAssert.assertAll();
    }

    // Sign Up

    @Test
    void signUp() {
        SignUp signUp = new SignUp();
        SoftAssert softAssert = new SoftAssert();

        signUp.redirectPasswordsStep(signUp.emailForSignUp, "David", "23021998");
        SeleniumActions.sendKeysOnElement(signUp.passwordField, "123456");
        SeleniumActions.sendKeysOnElement(signUp.confirmPasswordField,"123456");
        SeleniumActions.clickOnElement(signUp.confirmBtn);

        softAssert.assertTrue(signUp.isSuccessPopUpAppear(), "There is issue with success pop up when user registers");

        // Check sign up without confirmation
        SeleniumActions.clickOnElement(signUp.registerSuccessCloseBtn);
        signUp.clickSignInBtn();
        SeleniumActions.sendKeysOnElement(signUp.signInEmailField, signUp.emailForSignUp);
        SeleniumActions.sendKeysOnElement(signUp.signInPasswordField, "123456");
        SeleniumActions.clickOnElement(signUp.signInBtn);
        softAssert.assertTrue(signUp.isNoConfirmErrorNotificationAppear(), "There is issue when user want to sign in without confirmation ");



        // Check Sign in with confirmation
        signUp.openMailinator();
        SeleniumActions.sendKeysOnElement(signUp.mailinatorSearch, signUp.emailForSignUp);
        SeleniumActions.clickOnElement(signUp.mailinatorGoBtn);
        SeleniumActions.clickOnElement(signUp.confirmLink);
        DriverFactory.getDriver().switchTo().frame("html_msg_body");
        SeleniumActions.clickOnElement(signUp.confirmRegisterBtn);
        signUp.switchToNewTab();
        SeleniumActions.clickOnElement(signUp.headerSignInBtn);
        SeleniumActions.sendKeysOnElement(signUp.signInEmailField, signUp.emailForSignUp);
        SeleniumActions.sendKeysOnElement(signUp.signInPasswordField, "123456");
        SeleniumActions.clickOnElement(signUp.signInBtn);
        softAssert.assertTrue(signUp.isProfileIconAppear(), "There is issue when user has registered and confirmed link and wants to sign in  ");

        // Check when user want to register with already registered email
        SeleniumActions.clickOnElement(signUp.profileIcon);
        SeleniumActions.clickOnElement(signUp.logoutBtn);
        signUp.redirectPasswordsStep(signUp.emailForSignUp, "David", "23021998");
        SeleniumActions.sendKeysOnElement(signUp.passwordField, "123456");
        SeleniumActions.sendKeysOnElement(signUp.confirmPasswordField, "123456");
        SeleniumActions.clickOnElement(signUp.confirmBtn);
        softAssert.assertTrue(signUp.isNoConfirmErrorNotificationAppear(), "There is issue when user want to register with already used email");

        softAssert.assertAll();
    }
}
