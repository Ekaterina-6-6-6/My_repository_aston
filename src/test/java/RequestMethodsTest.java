import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

class RequestMethodsTest {

    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    void getRequestTest() {

        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get(BASE_URL + "/get");

        assertEquals(200, response.statusCode());

        assertEquals("bar1", response.jsonPath().getString("args.foo1"));
        assertEquals("bar2", response.jsonPath().getString("args.foo2"));
        assertEquals(
                "https://postman-echo.com/get?foo1=bar1&foo2=bar2",
                response.jsonPath().getString("url")
        );
    }

    @Test
    void postRawTextTest() {

        String requestBody =
                "This is expected to be sent back as part of response body.";

        Response response = given()
                .body(requestBody)
                .when()
                .post(BASE_URL + "/post");

        assertEquals(200, response.statusCode());

        assertEquals(requestBody, response.jsonPath().getString("data"));
        assertEquals("https://postman-echo.com/post",
                response.jsonPath().getString("url"));
        assertTrue(response.jsonPath().getMap("args").isEmpty());
        assertTrue(response.jsonPath().getMap("form").isEmpty());
        assertTrue(response.jsonPath().getMap("files").isEmpty());
        assertNull(response.jsonPath().get("json"));
    }

    @Test
    void postFormDataTest() {

        String requestBody = "foo1=bar1&foo2=bar2";

        Response response = given()
                .log().all()
                .header("Content-Type",
                        "application/x-www-form-urlencoded; charset=UTF-8")
                .body(requestBody)
                .when()
                .post(BASE_URL + "/post");

        System.out.println("========== RESPONSE ==========");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body: " + response.asPrettyString());
        System.out.println("================================");

        assertEquals(200, response.statusCode());

        assertEquals("bar1",
                response.jsonPath().getString("form.foo1"));

        assertEquals("bar2",
                response.jsonPath().getString("form.foo2"));

        assertEquals(
                "https://postman-echo.com/post",
                response.jsonPath().getString("url")
        );
    }

    @Test
    void putRequestTest() {

        String requestBody =
                "This is expected to be sent back as part of response body.";

        Response response = given()
                .body(requestBody)
                .when()
                .put(BASE_URL + "/put");

        assertEquals(200, response.statusCode());

        assertEquals(requestBody, response.jsonPath().getString("data"));
        assertEquals("https://postman-echo.com/put",
                response.jsonPath().getString("url"));
        assertTrue(response.jsonPath().getMap("args").isEmpty());
        assertTrue(response.jsonPath().getMap("form").isEmpty());
        assertTrue(response.jsonPath().getMap("files").isEmpty());
        assertNull(response.jsonPath().get("json"));
    }

    @Test
    void patchRequestTest() {

        String requestBody =
                "This is expected to be sent back as part of response body.";

        Response response = given()
                .body(requestBody)
                .when()
                .patch(BASE_URL + "/patch");

        assertEquals(200, response.statusCode());

        assertEquals(requestBody, response.jsonPath().getString("data"));
        assertEquals("https://postman-echo.com/patch",
                response.jsonPath().getString("url"));
        assertTrue(response.jsonPath().getMap("args").isEmpty());
        assertTrue(response.jsonPath().getMap("form").isEmpty());
        assertTrue(response.jsonPath().getMap("files").isEmpty());
        assertNull(response.jsonPath().get("json"));
    }

    @Test
    void deleteRequestTest() {

        String requestBody =
                "This is expected to be sent back as part of response body.";

        Response response = given()
                .body(requestBody)
                .when()
                .delete(BASE_URL + "/delete");

        assertEquals(200, response.statusCode());

        assertEquals(requestBody, response.jsonPath().getString("data"));
        assertEquals("https://postman-echo.com/delete",
                response.jsonPath().getString("url"));
        assertTrue(response.jsonPath().getMap("args").isEmpty());
        assertTrue(response.jsonPath().getMap("form").isEmpty());
        assertTrue(response.jsonPath().getMap("files").isEmpty());
        assertNull(response.jsonPath().get("json"));
    }
}