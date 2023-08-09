import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private SelenideElement emailField = $(byId("sw-form-capture-email-input"));

    private SelenideElement passwordField = $(byId("sw-form-password-input"));

    private SelenideElement signInButton = $(byId("sw-sign-in-submit-btn"));
    private SelenideElement loginError = $(byClassName("login-error"));
    private SelenideElement forgotPasswordLink = $x("//a[@href='/forgot-password']");
    private SelenideElement emailInputField = $(byId("forgot-password-email--1161217580"));


    public void enterEmail(String emailValue){
        emailField.shouldBe(visible, Duration.ofSeconds(10));
        emailField.setValue(emailValue);
    }

    public void enterPassword(String passwordValue){
        passwordField.shouldBe(visible, Duration.ofSeconds(10));
        passwordField.setValue(passwordValue);
        }

    public void clickOnSignInButton() {
         signInButton.shouldBe(enabled);
         signInButton.click();
        }

    public void loginErrorIsVisible(){
        loginError.shouldBe(visible, Duration.ofSeconds(10));
    }

    public void clickOnForgotPasswordLink(){
        forgotPasswordLink.click();
    }

    public void emailInputFieldIsVisible(){
        emailField.shouldBe(visible, Duration.ofSeconds(10));
    }

    public void loginAsTeacher(){
        enterEmail("roxanne@example.com");
        enterPassword("123456");
        clickOnSignInButton();
    }

    public void loginAsStudent(){
        enterEmail("malik@example.com");
        enterPassword("123456");
        clickOnSignInButton();
    }


}
