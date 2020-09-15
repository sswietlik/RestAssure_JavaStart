package pl.javastart.restassured.test.parameters;

import org.testng.annotations.Test;
import pl.javastart.main.pojo.Category;
import pl.javastart.main.pojo.Pet;
import pl.javastart.main.pojo.Tag;

import java.util.Collections;

import static io.restassured.RestAssured.given;

public class QueryParamsTests {

//    Stwórz test, którego zadaniem będzie:
//
//    Stworzenie jednego zwierzęcia o wartościach:
//    status = sold
//            id = 777
//    Następnie listujemy wszystkie zwierzątka ze statusem sold za pomocą endpointu /pet/findByStatus. Deserializujemy je do tablicy.
//    Test powinien kończyć się asercją która sprawdza, że w tablicy znajduje się przynajmniej jeden element ze statusem sold.
//
//    Inne wymagania:
//
//    Nazwa klasy testowej: QueryParamsTests
//    Nazwa metody testowej: givenExistingPetWithStatusSoldWhenGetPetWithSoldStatusThenPetWithStatusIsReturnedTest
//    Nazwa pakietu, w którym ma się znaleźć klasa: pl.javastart.restassured.test.parameters


    @Test
    public void givenExistingPetWithStatusSoldWhenGetPetWithSoldStatusThenPetWithStatusIsReturnedTest(){

        Category category = new Category();
        category.setId(777);
        category.setName("dogs");

        Tag tag = new Tag();
        tag.setId(1);
        tag.setName("dogs-category");

        Pet pet = new Pet();
        pet.setId(123);
        pet.setCategory(category);
        pet.setPhotoUrls(Collections.singletonList("http://photos.com/dog1.jpg"));
        pet.setTags(Collections.singletonList(tag));
        pet.setStatus("sold");


        given().log().all()
                        .body(pet)
                        .contentType("applicatiob/json")
                .when().post("https://swaggerpetstore.przyklady.javastart.pl/v2/pet")
                .then().log().all().statusCode(200);

        Pet[] pets = new 




    }


}
