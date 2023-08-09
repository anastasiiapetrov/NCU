import dto.DeleteUser;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class DeleteUserTest {

    public void deleteExistingUser(String email){

   /*  DeleteUser delete = RestAssured.delete("/user/" + email, 200)
                .body().jsonPath().getObject("", DeleteUser.class);*/
       BaseTest.deleteRequest(BaseTest.deleteURI+email, 200);



    }
}
