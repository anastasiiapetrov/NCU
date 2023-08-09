import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginAsTeacher(){
        loginPage.enterEmail("roxanne@example.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnSignInButton();
        homePage.homePageIsOpen();
    }

    @Test
    public void loginWithInvalidPassword(){
        loginPage.enterEmail("roxanne@example.com");
        loginPage.enterPassword("12345678");
        loginPage.clickOnSignInButton();
        loginPage.loginErrorIsVisible();
    }

    @Test
    public void loginWithInvalidEmail(){
        loginPage.enterEmail("983ruskfd93@example.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnSignInButton();
        loginPage.loginErrorIsVisible();
    }

    @Test
    public void resetPassword(){
        loginPage.clickOnForgotPasswordLink();
        loginPage.emailInputFieldIsVisible();
    }

    @Test
    public void loginWithShortPassword(){
        loginPage.enterEmail("roxanne@example.com");
        loginPage.enterPassword("123");
        loginPage.clickOnSignInButton();
        loginPage.loginErrorIsVisible();
    }

    @Test
    public void logoutAsStudent(){
        loginPage.loginAsStudent();
        homePage.clickOnSignOutButton();
        loginPage.emailInputFieldIsVisible();
    }








}
