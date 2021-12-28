package Day8;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpartanBasicAuth {

    @Test
    public void test1(){
        given()
                .accept(ContentType.JSON)
                .and()
                .auth().basic("admin","admin")
                .when()
                .get("http://54.160.250.226:8000/api/spartans")//i m using my own ip adress so it will not ask me
                //any authorization
                .then().log().all()
                .statusCode(200);
    }


}