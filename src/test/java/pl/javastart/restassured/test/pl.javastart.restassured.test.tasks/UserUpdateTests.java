package pl.javastart.restassured.test.pl.javastart.restassured.test.tasks;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.javastart.main.pojo.User.User;

import static io.restassured.RestAssured.*;

public class UserUpdateTests {
    @BeforeClass
    public void setupConfiguration(){
        baseURI = "https://swaggerpetstore.przyklady.javastart.pl";
        basePath = "v2";
    }

    @Test
    public void givenCorrectUserDataWhenFirstNameLastNameAreUpdatedThenUserDataIsUpdatedTest(){
        User user = new User();
        user.setId(445);
        user.setUsername("firstuser");
        user.setFirstName("Krzysztof");
        user.setLastName("Kowalski");
        user.setEmail("krzysztof@test.com");
        user.setPassword("password");
        user.setPhone("+123456789");
        user.setUserStatus(123);

System.out.println("__________________________");

        given()
                .contentType("application/json")
                .body(user)
                .when().post("user")
                .then().log().all();
        user.setFirstName("Lucyfer");
        user.setLastName("Szatański");


System.out.println("__________________________");

        given()
                    .contentType("application/json")
                    .pathParam("username",user.getUsername())
                    .body(user)
                .when().get("user/{username}")
                .then().log().all().statusCode(200);

System.out.println("__________________________");

        given()
                    .contentType("application/json")
                    .pathParam("username",user.getUsername())
                .body(user)
                .when().get("user/{username}")
                .then().log().all().statusCode(200);

System.out.println("__________________________");

    }
}
