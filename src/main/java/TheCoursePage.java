import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TheCoursePage {

    private SelenideElement docNameField = $(byId("upload-course-material-form-DocumentName--1971305433"));
    private SelenideElement uploadField= $(byId("upload-course-material-form-Document-1880928548"));
    private SelenideElement uploadButton = $x("//button[@type='submit']");

    public void fillInDocField(String fileName){
        docNameField.setValue(fileName);
    }
    public void uploadFile(){
        uploadField.uploadFile(new File("src/main/data/Sample.docx"));
    }

    public void clickOnUploadButton(){
        uploadButton.click();
    }

}
