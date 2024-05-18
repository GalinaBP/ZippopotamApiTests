package ApiTests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class Test1 {
    @Test
    public void testBody90210() {
        given().
                when().
                get("http://api.zippopotam.us/us/90210").
                then().assertThat().body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void testCheckStatusCode90210() {
        given().
                when().
                get("http://api.zippopotam.us/us/90210").
                then().
                assertThat().statusCode(200);
    }

    @Test
    public void testCheckContentType90210() {
        given().
                when().
                get("http://api.zippopotam.us/us/90210").
                then().assertThat().contentType(ContentType.JSON);
    }

    @Test
    public void testLogRequestAndResponse90210() {
        given().
                log().all().
                when().
                get("http://api.zippopotam.us/us/90210").
                then().
                log().body();
    }

    @Test
    public void testPlaceNameInResponseBody90210() {
        given().
                when().
                get("http://api.zippopotam.us/us/90210").
                then().assertThat().body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void testLongitudeInResponseBody1001() {
        given().
                when().
                get("http://api.zippopotam.us/CH/1001").
                then().assertThat().body("places[2].'longitude'", equalTo("6.6303"));
    }

    @Test
    public void testLogRequestAndResponse1001() {
        given().log().all().when().get("http://api.zippopotam.us/CH/1001").then().log().body();
    }

    @Test
    public void testItemInResponseBody1001(){
        given().when().get("http://api.zippopotam.us/CH/1001").then().assertThat().body("places.'state'", hasItem("Canton de Vaud"));
    }
    
}
