package Day8;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class BookItAuthTest {

    @BeforeClass
    //wil run before always before method
    public void before(){
        baseURI = "https://cybertek-reservation-api-qa2.herokuapp.com";
    }

    ///token is too big so its btr to save as string n thn gv as value in header in line 2t..to authorize and aceess api
    //by automation
    String accessToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI1NyIsImF1ZCI6InN0dWRlbnQtdGVhbS1sZWFkZXIifQ.a_N9URDBPGOMcDdEVoaMHsJtk3jOnig0v0SCtSWcsGE";

    @Test
    public void getAllCampuses(){

        //v ned to give key n value of authorization from documents to here as headers jsut like in post man so v will
        // aftr given slect header and give key authorization n value is token but its too big so we saved as string and
        //then inserted here
        Response response = given().header("Authorization",accessToken).
                when().get("/api/campuses");

        response.prettyPrint();
        System.out.println(response.statusCode());

    }
}