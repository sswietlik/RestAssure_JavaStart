package pl.javastart.restassured.test.pl.javastart.restassured.test.tasks;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.javastart.main.pojo.User.User;

import static io.restassured.RestAssured.*;

public class UserCreationTests {
    @BeforeClass
    public void setupConfiguration(){
        baseURI = "https://swaggerpetstore.przyklady.javastart.pl";
        basePath = "v2";

    }

    @Test
    public void givenCorrectUserDataWhenCreateUserThenUserIsCreatedTest() {
        User user = new User();
        user.setId(445);
        user.setUsername("firstuser");
        user.setFirstName("Krzysztof");
        user.setLastName("Kowalski");
        user.setEmail("krzysztof@test.com");
        user.setPassword("password");
        user.setPhone("+123456789");
        user.setUserStatus(123);


        given().contentType("application/json")
                .body(user)
                .when().post("user")
                .then()
                .assertThat().body("code", equalTo(200))
                .assertThat().body("type", equalTo("unknown"))
                .assertThat().body("message", equalTo("445"))
                .assertThat().statusCode(200);

        given().contentType("application/json")
                .pathParam("username", user.getUsername())
                .when().get("user/{username}")
                .then()
                .assertThat().body("id", equalTo(445))
                .assertThat().body("username", equalTo("firstuser"))
                .assertThat().body("firstName", equalTo("Krzysztof"))
                .assertThat().body("lastName", equalTo("Kowalski"))
                .assertThat().body("email", equalTo("krzysztof@test.com"))
                .assertThat().body("password", equalTo("password"))
                .assertThat().body("phone", equalTo("+123456789"))
                .assertThat().body("userStatus", equalTo(123))
                .assertThat().body("user",eq)
                .assertThat().statusCode(200);
    }


}





