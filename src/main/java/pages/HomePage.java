package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;
import utils.SeleniumActions;
import utils.Waiters;

import java.util.ArrayList;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }

    JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();


    @FindBy(xpath = "//*[@id=\"header-shop\"]//*[@class=\"logo\"]")
    public WebElement headerLogo;

    @FindBy(xpath = "//header//*[@class=\"trigger\"]")
    public WebElement headerProducts;

    @FindBy(xpath = "//*[@id=\"__next\"]//*[@class=\"dropdown first-level left show\"]")
    public WebElement productsPopUp;

    @FindBy(xpath = "(//*[@class=\"subctgry-ctrl\"])[4]")
    public WebElement vitaminsBtn;

    @FindBy(xpath = "//*[@class=\"category-navigation\"]")
    public WebElement categoryNavigation;

    @FindBy (xpath = "//*[@id=\"__next\"]//*[@class=\"drop-inner\"]")
    public WebElement subcategoriesPopUp;

    @FindBy(xpath ="//*[@id=\"header-shop\"]//*[@style=\"font-weight: bold;\"]")
    public WebElement headerPromotions;

    @FindBy(xpath = "//*[@class=\"react-select__control css-yk16xz-control\"]")
    public WebElement sortByBtn;

    @FindBy(xpath = "//*[@class=\"chat-body  \"]")
    public WebElement chatBody;

    @FindBy(xpath = "//header//*[@class=\"phone-numbers\"]")
    public WebElement headerPhoneNumbers;

    @FindBy(xpath = "//header//*[@class=\"icon-btn size-md custom-size light trigger\"]")
    public WebElement headerLanguageBtn;

    @FindBy(xpath = "//*[@class=\"language-dropdown\"]")
    public WebElement languagePopUp;

    @FindBy(xpath = "/html[@lang]")
    public WebElement languageOfPage;

    @FindBy(xpath = "//*[@class=\"language-dropdown\"]//*[@title=\"Հայերեն\"]")
    public WebElement armenianLanguageBtn;

    @FindBy(xpath = "//*[@class=\"language-dropdown\"]//*[@title=\"Русский\"]")
    public WebElement russianLanguageBtn;

    @FindBy(xpath = "//*[@class=\"language-dropdown\"]//*[@title=\"English\"]")
    public WebElement englishLanguageBtn;

    @FindBy(xpath = "//header//*[@class=\"btn outline primary no-shadow min-86 mr-15\"]")
    public WebElement headerSignInBtn;

    @FindBy(xpath = "//*[@name=\"email\"]")
    public WebElement emailField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@name=\"Save\"]")
    public WebElement signInBtn;

    @FindBy(xpath = "//header//*[@class=\"btn filled primary no-shadow min-86\"]")
    public WebElement headerSignUpBtn;

    @FindBy(xpath = "//*[@class=\"form-side\"]")
    WebElement signInPopUp;

    @FindBy(xpath = "//*[@class=\"first-step\"]")
    public WebElement signUpPopUp;

    @FindBy(xpath = "//header//*[@class=\"cart-wrapper fly-cart\"]")
    public WebElement headerShoppingCartBtn;

    @FindBy(xpath = "//*[@class=\"btn filled primary add-to-cart\"]")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//*[@class=\"items-list\"]")
    public WebElement shoppingCartPopUp;

    @FindBy(xpath = "//header//*[@class=\"search\"]//input")
    public WebElement headerSearchInput;

    @FindBy(xpath = "//header//*[@class=\"btn filled primary radius-md btn-search\"]")
    public WebElement headerSearchBtn;

    @FindBy(xpath = "//*[@class=\"sidebar\"]")
    public WebElement searchFilterBar;

    @FindBy(xpath = "class=\"filter-box\"")
    public WebElement availabilityFiled;


    @FindBy(xpath = "//header//*[@class=\"btn filled size-md radius-md with-icon doctor-call\"]")
    public WebElement chatWithDoctorBtn;

    @FindBy(xpath = "//*[@class=\"doctors-list \"]")
    public WebElement doctorsList;

    @FindBy(xpath = "//header//*[@class=\"btn filled size-md radius-md with-icon apps\"]")
    public WebElement downloadAppBtn;

    @FindBy (xpath = "//*[@class=\"MuiDialogContent-root jss3\"]")
    public WebElement scanPopUp;

    @FindBy(xpath = "//*[@class=\"icon-doctor\"]")
    public WebElement supportBtn;

    @FindBy(xpath = "//*[@class=\"chat-nav\"]")
    public WebElement supportPopUp;

    @FindBy(xpath = "//footer//*[@href=\"/privacy\"]")
    public WebElement footerTermsAndConditionsBtn;

    @FindBy(xpath = "//*[@class=\"tos\"]")
    public WebElement termsText;

    @FindBy(xpath = "//footer//*[@href=\"/why-hihub\"]")
    public WebElement footerWhyHiHubBtn;

    @FindBy(xpath = "//*[@class=\"why-hihub\"]")
    public WebElement whyHiHUbPage;

    @FindBy(xpath = "//footer//*[@href=\"https://med.hihub.am/\"]")
    public WebElement footerBlogBtn;

    @FindBy(xpath = "//footer//*[@href=\"/about-us\"]")
    public WebElement footerAboutUsBtn;

    @FindBy(xpath = "//*[@class=\"about-us\"]")
    public WebElement aboutUsPage;

    @FindBy(xpath = "//footer//*[@href=\"/contact-us\"]")
    public WebElement footerContactUsBtn;

    @FindBy(xpath = "//*[@class=\"contact-details\"]")
    public WebElement contactsUsPage;

    @FindBy(xpath = "//footer//*[@href=\"/sitemap\"]")
    public WebElement footerSiteMapBtn;

    // Click on the production Btn in header

    public void clickCategoryPopUp() {
        SeleniumActions.clickOnElement(headerProducts);
    }

    // Check if the category pop up opened

    public boolean isCategoryPopUpAppears() {
        return productsPopUp.isDisplayed();
    }

    // Click on the Category item

    public void clickCategoryBtn () {
        SeleniumActions.clickOnElement(vitaminsBtn);
    }

    // Check if the Subcategories Popup opened

    public boolean isSubcategoryPopUpAppears() {
        return subcategoriesPopUp.isDisplayed();
    }

    // Click on the Promotions Btn

    public void clickPromotionsBtn () {
        SeleniumActions.clickOnElement(headerPromotions);
    }

    // Check Promotion page opened

    public boolean isPromotionsPageOpened() {

        Waiters.waitUntilClickable(sortByBtn);
        return DriverFactory.getDriver().getCurrentUrl().contains("filter");
    }

    // Click on the language Btn
    public void clickLanguageBtn() {
        SeleniumActions.clickOnElement(headerLanguageBtn);
    }

    // Check the Popup opened
    public boolean isLanguagePopUpOpened() {
        return languagePopUp.isDisplayed();
    }

    // Change language to Russian
    public void changingLanguageToRussian () {
        SeleniumActions.clickOnElement(headerLanguageBtn);
        SeleniumActions.clickOnElement(russianLanguageBtn);
    }

    // Check if the language is changed to Russian
    public boolean isLanguageChangedToRussian() {
        return languageOfPage.getAttribute("lang").equals("ru");
    }

    // Change language to English
    public void changingLanguageToEnglish () {
        SeleniumActions.clickOnElement(headerLanguageBtn);
        SeleniumActions.clickOnElement(englishLanguageBtn);
    }

    // Check if the language changed to English
    public boolean isLanguageChangedToEnglish() {
        return languageOfPage.getAttribute("lang").equals("en");
    }

    // Change language to Armenian
    public void changingLanguageToArmenian () {
        SeleniumActions.clickOnElement(headerLanguageBtn);
        SeleniumActions.clickOnElement(englishLanguageBtn);
        SeleniumActions.clickOnElement(headerLanguageBtn);
        SeleniumActions.clickOnElement(armenianLanguageBtn);
    }

    // Check if the language changed english than Armenian
    public boolean isLanguageChangedToArmenian() {
        return languageOfPage.getAttribute("lang").equals("hy");
    }

    // Click on the Phone numbers
    public void clickPhoneNumbers() {
        SeleniumActions.clickOnElement(headerPhoneNumbers);
    }

    // Check if phone number is clickable
    public boolean isPhoneNumbersClickable() {
        return headerPhoneNumbers.isEnabled();
    }

    // Click on the SignIn button
    public void clickSignInBtn() {
        SeleniumActions.clickOnElement(headerSignInBtn);
    }

    // Check Sign In popup opened
    public boolean isSignInPopUpOpened (){
        return signInPopUp.isDisplayed();
    }

    // Click on the Sign up button
    public void clickSignUpBtn() {
        SeleniumActions.clickOnElement(headerSignUpBtn);
    }

    // Check sign up pop
    public boolean isSignUpPopUpOpened() {
        return signUpPopUp.isDisplayed();
    }

    // Check shopping cart pop up
    public boolean isShoppingCartPopUpOpened() {
        DriverFactory.getDriver().get("https://hihub-dev.kree.dev/item/17699");
        SeleniumActions.clickOnElement(addToCartBtn);
        SeleniumActions.clickOnElement(headerShoppingCartBtn);
        Waiters.waitForVisibility(shoppingCartPopUp);
        return shoppingCartPopUp.isDisplayed();
    }

    // Check Logo redirects to home page
    public boolean isLogoRedirectsHomePage() {
        DriverFactory.getDriver().get("https://hihub-dev.kree.dev/item/17699");
        SeleniumActions.clickOnElement(headerLogo);
        Waiters.waitForVisibility(categoryNavigation);
        return categoryNavigation.isDisplayed();
    }

    // Check search result
    public boolean isSearchReturnsCorrectProducts() {
        SeleniumActions.sendKeysOnElement(headerSearchInput, "L-Thyroxin");
        SeleniumActions.clickOnElement(headerSearchBtn);
        Waiters.waitForVisibility(sortByBtn);
        return DriverFactory.getDriver().getCurrentUrl().contains("L-Thyroxin");
    }

    // Check search by id
    public boolean isSearchByIdReturnsCorrect () {
        SeleniumActions.sendKeysOnElement(headerSearchInput, "1116");
        SeleniumActions.clickOnElement(headerSearchBtn);
        Waiters.waitForVisibility(sortByBtn);
        return DriverFactory.getDriver().getCurrentUrl().contains("1116");
    }

    // Check after search filter bar appears

    public boolean isFilterBarAppear(){
        SeleniumActions.sendKeysOnElement(headerSearchInput, "L-Thyroxin");
        SeleniumActions.clickOnElement(headerSearchBtn);
        Waiters.waitForVisibility(availabilityFiled);
        return searchFilterBar.isDisplayed();
    }

    // Click on the Download app Btn
    public boolean isScanToDownLoadAppear() {
        SeleniumActions.clickOnElement(downloadAppBtn);
        Waiters.waitForVisibility(scanPopUp);
        return scanPopUp.isDisplayed();
    }

    // Check support pop up opened
    public boolean isSupportPopUpAppear() {
        SeleniumActions.clickOnElement(supportBtn);
        Waiters.waitForVisibility(scanPopUp);
        return supportPopUp.isDisplayed();
    }

    // Check terms And condition page
    public boolean isUserRedirectTermsPage () {
        js.executeScript("arguments[0].scrollIntoView();",footerTermsAndConditionsBtn);
        SeleniumActions.clickOnElement(footerTermsAndConditionsBtn);
        Waiters.waitForVisibility(termsText);
        return termsText.isDisplayed();
    }

    // Check Why HiHub page
    public boolean isUserRedirectsWhyHiHubPage(){
        js.executeScript("arguments[0].scrollIntoView();",footerWhyHiHubBtn);
        SeleniumActions.clickOnElement(footerWhyHiHubBtn);
        Waiters.waitForVisibility(whyHiHUbPage);
        return whyHiHUbPage.isDisplayed();
    }

    // Check About us page
    public boolean isUserRedirectsAboutUsPage() {
        js.executeScript("arguments[0].scrollIntoView();",footerAboutUsBtn);
        SeleniumActions.clickOnElement(footerAboutUsBtn);
        Waiters.waitForVisibility(aboutUsPage);
        return aboutUsPage.isDisplayed();
    }

    // Check blog page
    public boolean isUserRedirectsBlogPage() {
        js.executeScript("arguments[0].scrollIntoView();",footerBlogBtn);
        SeleniumActions.clickOnElement(footerBlogBtn);
        return DriverFactory.getDriver().getCurrentUrl().contains("https://med.hihub.am/");
    }

    // Check contact us page
    public boolean isUserRedirectsContactUsPage() {
        js.executeScript("arguments[0].scrollIntoView();",footerContactUsBtn);
        SeleniumActions.clickOnElement(footerContactUsBtn);
        Waiters.waitForVisibility(contactsUsPage);
        return contactsUsPage.isDisplayed();
    }

    // Check Site map button
    public boolean isUserRedirectsSiteMapPage() {
        js.executeScript("arguments[0].scrollIntoView();",footerSiteMapBtn);
        SeleniumActions.clickOnElement(footerSiteMapBtn);
        return DriverFactory.getDriver().getCurrentUrl().contains("sitemap");
    }

    // Check chat with doctor button for unregistered user
    public boolean isUserRedirectsChatPage() {
        SeleniumActions.clickOnElement(chatWithDoctorBtn);
        ArrayList<String> chatTab = new ArrayList<> (DriverFactory.getDriver().getWindowHandles());
        DriverFactory.getDriver().switchTo().window(chatTab.get(1));
        Waiters.waitForVisibility(chatBody);
        return chatBody.isDisplayed();
    }

    // Check chat with doctor button for registered user
    public boolean isRegUserRedirectsChatPage() {
        SeleniumActions.clickOnElement(headerSignInBtn);
        SeleniumActions.sendKeysOnElement(emailField, "testkjl@mailinator.com");
        SeleniumActions.sendKeysOnElement(passwordField,"123456");
        SeleniumActions.clickOnElement(signInBtn);
        DriverFactory.getDriver().navigate().refresh();

        Waiters.waitUntilClickable(categoryNavigation);

        SeleniumActions.clickOnElement(chatWithDoctorBtn);
        ArrayList<String> chatTab = new ArrayList<> (DriverFactory.getDriver().getWindowHandles());
        DriverFactory.getDriver().switchTo().window(chatTab.get(1));
        Waiters.waitForVisibility(doctorsList);
        return doctorsList.isDisplayed();

    }


}
