import org.junit.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class UserProfileTest extends BaseTest{

    @Test
    public void useSamePassWhileChanging(){
        String email = getRandomEmail();
        signUpPage.registrAsStudent(email);
        homePage.clickOnHPImage();
        homePage.clickOnMyProfileButton();
        userProfilePage.enterOldPass("134235467");
        userProfilePage.enterNewPass("134235467");
        userProfilePage.clickOnChangePassButton();
        //Error message about the same passwords is displayed
        deleteUserTest.deleteExistingUser(email);
    }

    @Test
    public void uploadProfilePhotoAsStudent(){
        String email = getRandomEmail();
        signUpPage.registrAsStudent(email);
        homePage.clickOnHPImage();
        homePage.clickOnMyProfileButton();
        userProfilePage.uploadPhoto();
        userProfilePage.clickOnUpdateProfile();
        //The message that profile photo updated is displayed
        deleteUserTest.deleteExistingUser(email);

    }



}
