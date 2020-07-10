package regression;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.abh_restaurant.*;
import testUtils.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogInFailedWithWrongPassword extends TestBase {
    private static final String HEADER_TEXT = "Make a free reservation";
    private static final String PASSWORD_RIGHT = "1234";
    private static final String PASSWORD_WRONG = "1237";
    private static final String EMAIL = "main@gmail.com";
    private static final String ERROR_TEXT = "Bad username and/or password.";

    /*private static final String FIRST_NAME = "Alice";
    private static final String LAST_NAME = "Lopez";

    private static final String PHONE_NUMBER = "12345";
    private static final String ADDRESS = "Pijacna 118";

    */


    @Test(priority = 0)
    public void openRestaurantsHomePage() {
        new HomePage(driver)
                .clickLoginButton(2);
    }

    @Test(priority = 1)
    public void loginToRestaurantsPageWrongPassword() {
        new LoginPage(driver)
                .loginToRestaurants(EMAIL, PASSWORD_WRONG);
    }
    
    @Test(priority = 2)
    public void checkForError() {
        Assert.assertTrue(new LoginPage(driver)
                .checkForError(ERROR_TEXT));
    }

    @Test(priority = 3)
    public void clearFields() {
        new LoginPage(driver)
                .deleteInput();
    }
    @Test(priority = 3)
    public void loginToRestaurantsPageRightPassword() {
        new LoginPage(driver)
                .loginToRestaurants(EMAIL, PASSWORD_RIGHT);
    }

    @Test(priority = 4)
    public void checkUserLoginIsSuccessful(){
        Assert.assertTrue(new HomePage(driver)
                .checkMainText(HEADER_TEXT));
    }
}