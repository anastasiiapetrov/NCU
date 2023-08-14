import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;

import java.util.Random;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;

public class BaseTest {
    public static final String BASE_URL = "https://erich416.softr.app/sign-in";
    final static String deleteURI = "users/";
    final static String BASE_URI = "https://studio-api.softr.io/v1/api/";

    final static String APP_ID_VALUE = "khIbAyJIU5CIuh1oDuBRx1s49";
    final static String DOMAIN = "erich416.softr.app";

    static RequestSpecification specification = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setUrlEncodingEnabled(false)
            .setContentType(ContentType.JSON)
            .addHeader("Softr-Api-Key", APP_ID_VALUE)
            .addHeader("Softr-Domain",DOMAIN )
            .build();

    public static Response deleteRequest(String endPoint, Integer responseCode){
        Response response = given()
                .spec(specification)
                .when()
                .log().all()
                .delete(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }
    public static String getRandomEmail() {
        String SALTCHARS = "abcdefghijklmopqrstuwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@gmail.com";

    }




    @Before
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open(BASE_URL);
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    SignUpPage signUpPage = new SignUpPage();
    AddCoursePage addCoursePage = new AddCoursePage();
    CourseListPage courseListPage = new CourseListPage();
    UserProfilePage userProfilePage = new UserProfilePage();
    TheCoursePage theCoursePage = new TheCoursePage();
    StudentDirectoryPage studentDirectoryPage = new StudentDirectoryPage();
    ProfessorsPage professorsPage = new ProfessorsPage();
    DeleteUserTest deleteUserTest = new DeleteUserTest();





}
