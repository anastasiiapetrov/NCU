import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UserProfilePage {
    private SelenideElement oldPassField = $x("//input[@name='password']");
    private SelenideElement newPassField = $(byId("sw-new-password-input"));
    private SelenideElement changePassButton = $(byId("sw-change-password-btn"));
    private SelenideElement uploadPhotoField = $x("//input[@type='file']");
    private SelenideElement updateProfileButton = $(byId("sw-update-profile-btn"));

    public void enterOldPass (String password){
        oldPassField.setValue(password);
    }

    public void enterNewPass (String password){
        newPassField.setValue(password);
    }

    public void clickOnChangePassButton(){
        changePassButton.click();
    }
    public void uploadPhoto(){
        uploadPhotoField.uploadFile(new File("src/main/data/professor_photo.jpeg"));
    }
    public void clickOnUpdateProfile(){
        updateProfileButton.click();
    }


}
