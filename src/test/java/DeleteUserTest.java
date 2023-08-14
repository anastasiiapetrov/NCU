

public class DeleteUserTest {

    public void deleteExistingUser(String email){

       BaseTest.deleteRequest(BaseTest.deleteURI+email, 200);



    }
}
