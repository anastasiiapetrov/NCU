import org.junit.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertEquals;

public class TheCourseTest extends BaseTest{

    @Test
    public void successfulUploadFileAsTeacher(){
        String email = getRandomEmail();
        signUpPage.registrAsTeacher(email);
        sleep(5000);
        homePage.clickOnHPImage();
        homePage.clickOnCoursesButton();
        courseListPage.enterTextInSearchBar("Meta Social Media Marketing");
        sleep(5000);
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
        sleep(5000);
        homePage.clickOnHPImage();
        homePage.clickOnCoursesButton();
        courseListPage.enterTextInSearchBar("Meta Social Media Marketing");
        sleep(5000);
        assertEquals("Meta Social Media Marketing", courseListPage.checkCoursesName());
        courseListPage.clickOnFoundedCourse();
       /* theCoursePage.fillInDocField("Last lesson");
        theCoursePage.uploadFile();
        theCoursePage.clickOnUploadButton();
        error "Students cannot upload materials"*/
        deleteUserTest.deleteExistingUser(email);
    }


}
