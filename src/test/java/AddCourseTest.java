import org.junit.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class AddCourseTest extends BaseTest {

    @Test
    public void addCourseAsTeacher(){
        String email = getRandomEmail();
        signUpPage.registrAsTeacher(email);
        sleep(5000);
        homePage.clickOnHPImage();
        homePage.clickOnAddCourseButton();
        addCoursePage.fillInCourseNameField("Machine Learning");
        addCoursePage.selectFacultyField();
        addCoursePage.fillInCourseDescriptionField("Master fundamental AI concepts.");
        addCoursePage.selectStartDate();
        addCoursePage.selectEndDate();
        addCoursePage.clickOnAddButton();
        //we are on the page of the course
        deleteUserTest.deleteExistingUser(email);
    }

    @Test
    public void addCourseWithoutName(){
        loginPage.loginAsTeacher();
        homePage.homePageIsOpen();
        homePage.clickOnAddCourseButton();
        addCoursePage.selectFacultyField();
        addCoursePage.fillInCourseDescriptionField("Master fundamental AI concepts.");
        addCoursePage.selectStartDate();
        addCoursePage.selectEndDate();
        addCoursePage.clickOnAddButton();
        addCoursePage.checkErrorMessageCourseName("Course name is required");
    }
    @Test
    public void addCourseWithWrongDates(){
        loginPage.loginAsTeacher();
        homePage.homePageIsOpen();
        homePage.clickOnAddCourseButton();
        addCoursePage.fillInCourseNameField("Machine Learning");
        addCoursePage.selectFacultyField();
        addCoursePage.fillInCourseDescriptionField("Master fundamental AI concepts.");
        addCoursePage.selectWrongStartDate();
        addCoursePage.selectWrongEndDate();
        addCoursePage.clickOnAddButton();
       //error message about wrong dates
    }




}
