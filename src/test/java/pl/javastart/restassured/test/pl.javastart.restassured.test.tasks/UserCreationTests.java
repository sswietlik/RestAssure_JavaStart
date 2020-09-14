package pl.javastart.restassured.test.pl.javastart.restassured.test.tasks;

import org.testng.annotations.Test;
import pl.javastart.main.pojo.User.User;

import static io.restassured.RestAssured.given;

public class UserCreationTests {

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
                .when().post("https://swaggerpetstore.przyklady.javastart.pl/v2/user")
                .then().log().all().statusCode(200);

        given().log().all().contentType("application/json")
                .pathParam("username", user.getUsername())
                .when().get("https://swaggerpetstore.przyklady.javastart.pl/v2/user/{username}")
                .then().log().all().statusCode(200);

    }


}





