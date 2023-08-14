import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TheCourseTest extends BaseTest{

    @Test
    public void successfulUploadFileAsTeacher(){
        String email = getRandomEmail();
        signUpPage.registrAsTeacher(email);
        homePage.clickOnHPImage();
        homePage.clickOnCoursesButton();
        courseListPage.enterTextInSearchBar("Meta Social Media Marketing");
        assertEquals("Meta Social Media Marketing", courseListPage.checkCoursesName());
        courseListPage.clickOnFoundedCourse();
        theCoursePage.fillInDocField("Last lesson");
        theCoursePage.uploadFile();
        theCoursePage.clickOnUploadButton();
        deleteUserTest.deleteExistingUser(email);
    }

    @Test
    public void uploadFileAsStudent(){
        String email = getRandomEmail();
        signUpPage.registrAsStudent(email);
        homePage.clickOnHPImage();
        homePage.clickOnCoursesButton();
        courseListPage.enterTextInSearchBar("Meta Social Media Marketing");
        assertEquals("Meta Social Media Marketing", courseListPage.checkCoursesName());
        courseListPage.clickOnFoundedCourse();
        deleteUserTest.deleteExistingUser(email);
    }


}
