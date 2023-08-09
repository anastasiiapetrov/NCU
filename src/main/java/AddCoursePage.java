import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AddCoursePage {
    private SelenideElement headerAddCourse = $(byTagName("h2"));
    private SelenideElement courseNameField = $(byId("course-documents-form-CourseName--1078269106"));
    private SelenideElement facultyField = $(byId("course-documents-form-Faculty-1389247778"));
    private SelenideElement exactFaculty = $x("//li[@data-value='Engineering']");
    private SelenideElement courseDescriptionField = $(byId("course-documents-form-Description-1634506682"));
    private SelenideElement startDateField = $(byId("course-documents-form-Startdate-831849774"));
    private SelenideElement exactStartDate = $x("//button[@class='rdrDay'][1]");
    private SelenideElement endDateField = $(byId("course-documents-form-Enddate-1271684309"));
    private SelenideElement exactEndDate = $x("//button[@class='rdrDay'][18]");
    private SelenideElement addButton = $x("//button[@type='submit']");
    private SelenideElement errorMessageCourseName = $("[class='form-error-text']");

    public void fillInCourseNameField(String textValue){
        courseNameField.shouldBe(visible).setValue(textValue);
    }
    public void selectFacultyField(){
        facultyField.click();
        exactFaculty.shouldBe(visible).click();
    }
    public void fillInCourseDescriptionField(String textValue){
        courseDescriptionField.setValue(textValue);
    }
    public void selectStartDate(){
        startDateField.click();
        exactStartDate.shouldBe(visible).click();
    }
    public void selectEndDate(){
        endDateField.click();
        exactEndDate.shouldBe(visible).click();
    }
    public void selectWrongStartDate(){
        startDateField.click();
        exactEndDate.shouldBe(visible).click();
    }
    public void selectWrongEndDate(){
        endDateField.click();
        exactStartDate.shouldBe(visible).click();
    }

    public void clickOnAddButton(){
        addButton.click();
    }
    public void checkErrorMessageCourseName(String errorTextValue){
        errorMessageCourseName.shouldBe(visible);
        errorMessageCourseName.shouldHave(text(errorTextValue));
    }
}
