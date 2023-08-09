import org.junit.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CourseListTest extends BaseTest{

    @Test
    public void searchForExistingCourse(){
        String email = getRandomEmail();
        signUpPage.registrAsTeacher(email);
        sleep(5000);
        homePage.clickOnHPImage();
        homePage.clickOnCoursesButton();
        courseListPage.enterTextInSearchBar("Meta Social Media Marketing");
        sleep(5000);
        assertEquals("Meta Social Media Marketing", courseListPage.checkCoursesName());
        deleteUserTest.deleteExistingUser(email);
    }

    @Test
    public void testCheckCoursesByProfessor(){
        String email = getRandomEmail();
        signUpPage.registrAsStudent(email);
        sleep(5000);
        homePage.clickOnHPImage();
        homePage.clickOnCoursesButton();
        courseListPage.enterTextInSearchBar("Roxane");
        sleep(5000);
        assertTrue(courseListPage.checkCoursesByProfessor());
        deleteUserTest.deleteExistingUser(email);

    }





}
