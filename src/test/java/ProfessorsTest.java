import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProfessorsTest extends BaseTest {

    @Test
    public void searchForExistingProfessorByCourseName(){
        String email = getRandomEmail();
        signUpPage.registrAsStudent(email);
        homePage.clickOnHPImage();
        homePage.clickOnProfessorsButton();
        professorsPage.enterTextInSearchBar("Computer Science");
        assertEquals("Computer Science", professorsPage.checkCourseName());
        deleteUserTest.deleteExistingUser(email);
    }
}
