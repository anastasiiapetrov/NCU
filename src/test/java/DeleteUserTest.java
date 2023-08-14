import dto.DeleteUser;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class DeleteUserTest {

    public void deleteExistingUser(String email){

       BaseTest.deleteRequest(BaseTest.deleteURI+email, 200);



    }
}
