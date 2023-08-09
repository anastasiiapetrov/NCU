import org.junit.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertEquals;

public class ProfessorsTest extends BaseTest {

    @Test
    public void searchForExistingProfessorByCourseName(){
        String email = getRandomEmail();
        signUpPage.registrAsStudent(email);
        sleep(5000);
        homePage.clickOnHPImage();
        homePage.clickOnProfessorsButton();
        professorsPage.enterTextInSearchBar("Computer Science");
        sleep(10000);
        assertEquals("Computer Science", professorsPage.checkCourseName());
        deleteUserTest.deleteExistingUser(email);
    }
}
