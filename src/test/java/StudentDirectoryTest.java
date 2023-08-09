import org.junit.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertEquals;

public class StudentDirectoryTest extends BaseTest {

    @Test
    public void searchForExistingStudentAsTeacher(){
        String email = getRandomEmail();
        signUpPage.registrAsTeacher(email);
        sleep(5000);
        homePage.clickOnHPImage();
        homePage.clickOnStudDirectoryButton();
        studentDirectoryPage.enterTextInSearchBar("Martin Slepanek");
        sleep(5000);
        assertEquals("Martin Slepanek", studentDirectoryPage.checkStudentName());
        deleteUserTest.deleteExistingUser(email);
    }

    @Test
    public void searchForExistingStudentAsStudent(){
        String email = getRandomEmail();
        signUpPage.registrAsStudent(email);
        sleep(5000);
        homePage.clickOnHPImage();
        homePage.clickOnStudDirectoryButton();
        studentDirectoryPage.enterTextInSearchBar("Martin Slepanek");
        sleep(5000);
        assertEquals("Martin Slepanek", studentDirectoryPage.checkStudentName());
        deleteUserTest.deleteExistingUser(email);
    }

}
