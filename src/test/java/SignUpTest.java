import org.junit.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class SignUpTest extends BaseTest{


    @Test
    public void successRegistrationAsTeacher(){
        String email = getRandomEmail();
        signUpPage.goToSignUpPage();
        signUpPage.selectTeacherRole();
        signUpPage.inputFullName("Alex Mack");
        signUpPage.inputEmail(email);
        signUpPage.inputPassword("12432534657");
        signUpPage.clickOnCheckmarkTerms();
        signUpPage.clickOnSignUpButton();
        homePage.clickOnAddCourseButton();
        deleteUserTest.deleteExistingUser(email);
    }

    @Test
    public void successRegistrationAsStudent(){
        String email = getRandomEmail();
        System.out.println(email);
        signUpPage.goToSignUpPage();
        signUpPage.selectStudentRole();
        signUpPage.inputFullName("Martin Slepanek");
        signUpPage.inputEmail(getRandomEmail());
        signUpPage.inputPassword("34rt35t5464");
        signUpPage.clickOnCheckmarkTerms();
        signUpPage.clickOnSignUpButton();
        sleep(5000);
     //   homePage.clickOnStudDirectoryButton();

       deleteUserTest.deleteExistingUser(email);
    }

    @Test
    public void registerWithShortPassword(){
        String email = getRandomEmail();
        signUpPage.goToSignUpPage();
        signUpPage.selectStudentRole();
        signUpPage.inputFullName("Alex Mack");
        signUpPage.inputEmail(email);
        signUpPage.inputPassword("123");
        signUpPage.clickOnCheckmarkTerms();
        signUpPage.clickOnSignUpButton();
        signUpPage.checkErrorMessageShortPassword("Password must contain at least 6 characters");
    }

    @Test
    public void registerWithUncheckedCheckbox(){
        String email = getRandomEmail();
        signUpPage.goToSignUpPage();
        signUpPage.selectStudentRole();
        signUpPage.inputFullName("Alex Mack");
        signUpPage.inputEmail(email);
        signUpPage.inputPassword("123");
        signUpPage.clickOnSignUpButton();
        signUpPage.checkErrorMessageSignUp("Please make sure there are no empty required fields");
    }

    @Test
    public void registerWithExistingUser(){
        signUpPage.goToSignUpPage();
        signUpPage.selectTeacherRole();
        signUpPage.inputFullName("Alex Mack");
        signUpPage.inputEmail("roxanne@example.com");
        signUpPage.inputPassword("12432534657");
        signUpPage.clickOnCheckmarkTerms();
        signUpPage.clickOnSignUpButton();
        signUpPage.checkErrorMessageExistingUser("User by given email already exists.");
    }

}
