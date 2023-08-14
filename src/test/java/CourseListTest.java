import org.junit.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CourseListTest extends BaseTest{

    @Test
    public void searchForExistingCourse(){
        String email = getRandomEmail();
        signUpPage.registrAsTeacher(email);
        homePage.clickOnHPImage();
        homePage.clickOnCoursesButton();
        courseListPage.enterTextInSearchBar("Meta Social Media Marketing");
        assertEquals("Meta Social Media Marketing", courseListPage.checkCoursesName());
        deleteUserTest.deleteExistingUser(email);
    }

    @Test
    public void testCheckCoursesByProfessor(){
        String email = getRandomEmail();
        signUpPage.registrAsStudent(email);
        homePage.clickOnHPImage();
        homePage.clickOnCoursesButton();
        courseListPage.enterTextInSearchBar("Roxane");
        assertTrue(courseListPage.checkCoursesByProfessor());
        deleteUserTest.deleteExistingUser(email);

    }





}
