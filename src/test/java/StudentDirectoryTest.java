import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentDirectoryTest extends BaseTest {

    @Test
    public void searchForExistingStudentAsTeacher(){
        String email = getRandomEmail();
        signUpPage.registrAsTeacher(email);
        homePage.clickOnHPImage();
        homePage.clickOnStudDirectoryButton();
        studentDirectoryPage.enterTextInSearchBar("Martin Slepanek");
        assertEquals("Martin Slepanek", studentDirectoryPage.checkStudentName());
        deleteUserTest.deleteExistingUser(email);
    }

    @Test
    public void searchForExistingStudentAsStudent(){
        String email = getRandomEmail();
        signUpPage.registrAsStudent(email);
        homePage.clickOnHPImage();
        homePage.clickOnStudDirectoryButton();
        studentDirectoryPage.enterTextInSearchBar("Martin Slepanek");
        assertEquals("Martin Slepanek", studentDirectoryPage.checkStudentName());
        deleteUserTest.deleteExistingUser(email);
    }

}
