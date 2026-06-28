import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RequestMethodsTest {

    @BeforeClass
    public void setup() {
        // Базовый URL вынесен сюда, чтобы не дублировать его в каждом тесте
        RestAssured.baseURI = "https://postman-echo.com";
    }

    // Проверка GET-запроса с query-параметрами foo1 и foo2
    @Test
    public void testGetRequest() {
        given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    // POST Raw Text - тело запроса возвращается в поле data как строка
    @Test
    public void testPostRawText() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("args", notNullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    // POST Form Data - поля формы возвращаются в объектах form и json
    @Test
    public void testPostFormData() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    // PUT - тело запроса возвращается в поле data как строка, json = null
    @Test
    public void testPutRequest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("args", notNullValue())
                .body("form", notNullValue())
                .body("json", nullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    // PATCH - аналогичная структура ответа
    @Test
    public void testPatchRequest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("args", notNullValue())
                .body("form", notNullValue())
                .body("json", nullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    // DELETE - аналогичная структура ответа
    @Test
    public void testDeleteRequest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("args", notNullValue())
                .body("form", notNullValue())
                .body("json", nullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}