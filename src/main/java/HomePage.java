import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private SelenideElement avatar = $x("//img[contains(@class,'MuiAvatar-img')]");
    private SelenideElement addCourseButton = $x("//a[@href='/add-course']");
    private SelenideElement coursesButton = $x("//a[@role='button']");
    private SelenideElement courseListButton = $x("//a[@role='menuitem']");
    private SelenideElement myProfileButton = $x("(//button)[1]");
    private SelenideElement myProfileDropdown = $x("//a[@href='/user-profile']");
    private SelenideElement signOutButton = $x("//a[@href='#']");
    private SelenideElement studDirectoryButton = $x("//a[@href='/student-directory']");
    private SelenideElement professorsButton = $("[href='#teacher-spotlight-heading']");
    private SelenideElement homePageImage = $(By.className("navbar-brand"));







    public void homePageIsOpen(){
        avatar.shouldBe(visible, Duration.ofSeconds(10));
    }
    public void clickOnAddCourseButton(){
        addCourseButton.shouldBe(visible).click();
    }
    public void clickOnCoursesButton(){
        coursesButton.click();
        courseListButton.shouldBe(visible).click();
    }
    public void clickOnMyProfileButton (){
        myProfileButton.shouldBe(visible).click();
        myProfileDropdown.shouldBe(visible).click();
    }
    public void clickOnStudDirectoryButton(){
        studDirectoryButton.click();
    }

    public void clickOnSignOutButton(){
        myProfileButton.click();
        signOutButton.shouldBe(visible).click();
    }
    public void clickOnProfessorsButton(){
        professorsButton.click();
    }

    public void clickOnHPImage (){
        sleep(1000);
        homePageImage.shouldBe(visible).click();
    }







}
