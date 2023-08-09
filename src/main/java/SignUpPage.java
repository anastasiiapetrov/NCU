import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;


public class SignUpPage {
    private SelenideElement roleDropdown = $(byClassName("bootstrap-select"));
    private SelenideElement optionTeacher = $("[value='teacher']");
    private SelenideElement optionStudent = $("[value='student']");
    private SelenideElement fullNameInputField = $(byId("sw-form-capture-full_name-input"));
    private SelenideElement emailInputField = $(byId("sw-form-capture-email-input"));
    private SelenideElement passwordInputField = $(byId("sw-form-password-input"));
    private SelenideElement checkmarkTerms = $(byClassName("checkmark"));
    private SelenideElement signUpButton = $(byId("sw-sign-up-submit-btn"));
    private SelenideElement errorMessageShortPassword = $(byClassName("validation-message"));
    private SelenideElement errorMessageSignUp = $(byClassName("required-errors"));
    private SelenideElement errorMessageExistingUser = $(byClassName("signup-error"));
    private SelenideElement goToSignUpPage = $(byId("sw-go-to-sign-up-btn"));


    public void selectTeacherRole(){
        roleDropdown.click();
        optionTeacher.shouldBe(visible, Duration.ofSeconds(10));
        optionTeacher.click();
    }

    public void selectStudentRole(){
        roleDropdown.click();
        optionStudent.shouldBe(visible,Duration.ofSeconds(10));
        optionStudent.click();
    }
    public void inputFullName(String fullNameValue){
        fullNameInputField.shouldBe(visible, Duration.ofSeconds(10));
        fullNameInputField.setValue(fullNameValue);
    }
    public void inputEmail(String emailValue){
        emailInputField.shouldBe(visible, Duration.ofSeconds(10));
        emailInputField.setValue(emailValue);
    }
    public void inputPassword(String passwordValue){
        passwordInputField.shouldBe(visible, Duration.ofSeconds(10));
        passwordInputField.setValue(passwordValue);
    }

    public void clickOnCheckmarkTerms(){
        checkmarkTerms.click();
    }

    public void clickOnSignUpButton(){
        signUpButton.click();
    }

    public void checkErrorMessageShortPassword(String errorTextValue){
        errorMessageShortPassword.shouldBe(visible);
        errorMessageShortPassword.shouldHave(text(errorTextValue));
    }

    public void checkErrorMessageSignUp(String errorTextValue){
        errorMessageSignUp.shouldBe(visible);
        errorMessageSignUp.shouldHave(text(errorTextValue));
    }
    public void checkErrorMessageExistingUser(String errorTextValue){
        errorMessageExistingUser.shouldBe(visible);
        errorMessageExistingUser.shouldHave(text(errorTextValue));
    }

    public void goToSignUpPage (){
        goToSignUpPage.click();
    }

    public static String getRandomEmail() {
        String SALTCHARS = "abcdefghijklmopqrstuwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@gmail.com";

    }

    public void registrAsStudent(String email){
       goToSignUpPage();
       selectStudentRole();
       inputFullName("Martin Slepanek");
       inputEmail(email);
       inputPassword("34rt35t5464");
       clickOnCheckmarkTerms();
        clickOnSignUpButton();
    }

    public void registrAsTeacher(String email){
        goToSignUpPage();
        selectTeacherRole();
        inputFullName("Martin Slepanek");
        inputEmail(email);
        inputPassword("34rt35t5464");
        clickOnCheckmarkTerms();
        clickOnSignUpButton();
    }







}
