import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;


public class HomePageTest extends BaseTest{


    @BeforeMethod
    void openPage() {
        navigateToURI(" ");
    }


    @Test
    void productsPopUpAppears() {
        HomePage homePage = new HomePage();

        // Category pop up appears
        homePage.clickCategoryPopUp();
        Assert.assertTrue(homePage.isCategoryPopUpAppears(),"Categories Pop up isn't opened");

        // Subcategory pop up appears
        homePage.clickCategoryBtn();
        Assert.assertTrue(homePage.isSubcategoryPopUpAppears(),"Subcategories pop up doesn't appear ");
    }

    @Test
    void promotionsPageIsOpened() {
        HomePage homePage = new HomePage();

        // Promotions Page opened
        homePage.clickPromotionsBtn();
        Assert.assertTrue(homePage.isPromotionsPageOpened(),"There is issue with promotions page: ");
    }

    @Test
    // Language Popup open
    void languagePopupIsOpened() {
        HomePage homePage = new HomePage();

        homePage.clickLanguageBtn();
        Assert.assertTrue(homePage.isLanguagePopUpOpened(),"There is issue with language pop up");
    }

    @Test
    // Change app language to Russian
    void changeLanguageToRussian()  {
        HomePage homePage = new HomePage();

        homePage.changingLanguageToRussian();
        Assert.assertTrue(homePage.isLanguageChangedToRussian(),"There is issue when user changes language to russian");
    }
    // Change app language to English
    @Test
    void changeLanguageToEnglish() {
        HomePage homePage = new HomePage();

        homePage.changingLanguageToEnglish();
        Assert.assertTrue(homePage.isLanguageChangedToEnglish(),"There is issue when user changes language to english");
    }

    // Change app Language to Armenian
    @Test
    void changeLanguageToArmenian() {
        HomePage homePage = new HomePage();

        homePage.changingLanguageToArmenian();
        Assert.assertTrue(homePage.isLanguageChangedToArmenian(),"There is issue when user changes language to Armenian ");
    }

    // When user clicks on the header phone numbers
    @Test
    void clickOnTheHeaderPhoneNumbers() {
        HomePage homePage = new HomePage();

        homePage.clickPhoneNumbers();
        Assert.assertTrue(homePage.isPhoneNumbersClickable(),"There is issue when user clicks on the Phone numbers ");
    }

    // Click on the Sign in button
    @Test
    void clickSignInBtn() {
        HomePage homePage = new HomePage();

        homePage.clickSignInBtn();
        Assert.assertTrue(homePage.isSignInPopUpOpened(),"There is issue when user opens Sign in pop up");
    }

    // Sign up Popup
    @Test
    void clickSignupBtn() {
        HomePage homePage = new HomePage();

        homePage.clickSignUpBtn();
        Assert.assertTrue(homePage.isSignUpPopUpOpened(),"There is issue when user clicks on the sign up pop up");
    }

    // Shopping Cart pop up
    @Test
    void clickOnShoppingCartBtn(){
        HomePage homePage  = new HomePage();

        Assert.assertTrue(homePage.isShoppingCartPopUpOpened(), "There is issue when user clicks on the shopping cart pop up ");
    }

    @Test
    // Logo redirects to home page
    void clickOnLogo(){
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.isLogoRedirectsHomePage());
    }

    // Search result check with link
    @Test
    void searchResult() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.isSearchReturnsCorrectProducts(),"There is issue with search result link  ");
    }

    // Search by id
    @Test
    void searchById() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.isSearchByIdReturnsCorrect(), "There is iss when user wants to search by id");
    }

    // After search is bar appears
    @Test
    void filterAppear() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.isFilterBarAppear(), "Filter bar is missing when user search anything");
    }

    // Click on the Download app button
    @Test
    void downloadAppPopUp(){
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.isScanToDownLoadAppear(), "There is issue when user opens Download app pop up");
    }

    //Click on the support pop up
    @Test
    void supportPopUpAppear() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.isSupportPopUpAppear());
    }

    // Click Terms and condition Button
    @Test
    void clickTermsAndConditionBtn(){
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.isUserRedirectTermsPage(), "There is issue when user clicks on the Terms and condition button");
    }

    // Click Why HiHub Button
    @Test
    void clickWhyHiHubBtn() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.isUserRedirectsWhyHiHubPage(), "There is issue when user clicks on the Why HiHub button");
    }

    // Click About us Button
    @Test
    void clickAboutUsBtn() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.isUserRedirectsAboutUsPage(), "There is issue when user clicks on the about us Button");
    }

    // Click Blog Btn
    @Test
    void clickBlogBtn() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.isUserRedirectsBlogPage(), "There is issue when user clicks on the Blog Button ");
    }

    // Click contact us page
    @Test
    void clickContactUsBtn() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.isUserRedirectsContactUsPage(), "There is issue when user clicks on the contact us Button");
    }

    // Click site map button
    @Test
    void clickSiteAMpBtn() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isUserRedirectsSiteMapPage(), "There is issue when user clicks on the site map Btn ");
    }

}

