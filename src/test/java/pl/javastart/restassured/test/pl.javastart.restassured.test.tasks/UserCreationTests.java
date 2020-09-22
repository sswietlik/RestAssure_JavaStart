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

//        String user =
//                "{  \n" +
//                        "   \"id\": 445,\n" +
//                        "   \"username\": \"firstuser\",\n" +
//                        "   \"firstName\": \"Krzysztof\",\n" +
//                        "   \"lastName\": \"Kowalski\",\n" +
//                        "   \"email\": \"krzysztof@test.com\",\n" +
//                        "   \"password\": \"password\",\n" +
//                        "   \"phone\": \"+123456789\",\n" +
//                        "   \"userStatus\": 123\n" +
//                 "}";

        given().log().all().contentType("application/json")
                .body(user)
                .when().post("user")
                .then().log().all().statusCode(200);

        given().log().all().contentType("application/json")
                .pathParam("username", user.getUsername())
                .when().get("user/{username}")
                .then().log().all().statusCode(200);

    }


}





