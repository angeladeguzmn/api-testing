package trainingxyz;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;

public class ExecuteTest {

    String endpoint = APIVariables.baseURI;

    @Test
    @Description("Test Description : Validate that the category element has a Name key with the value \"Home & garden\" ")
    public void getCategoryName(){
       var response = given().when().get(endpoint).then().assertThat().
                body("CategoryId",equalTo(APIVariables.categoryID)).
                body("Name",equalTo(APIVariables.categoryName));
        response.log().status();
    }

    @Test
    @Description("Test Description : Validate that the category element has a CanReList key with the value \"true\" ")
    public void getReListBoolean(){
        var response = given().when().get(endpoint).then().assertThat().
                body("CategoryId",equalTo(APIVariables.categoryID)).
                body("CanRelist",equalTo(true));
        response.log().status();
    }

    @Test
    @Description("Test Description : Validate that  Promotions element with Name = \"Feature\" has a Description that contains the text \"Better position in category\" ")
    public void getFeaturePromotionDescription(){
        var response = given().when().get(endpoint).then().assertThat().
                body("Promotions[2]",hasEntry("Name",APIVariables.promotionName)).
                body("Promotions[2]",hasEntry("Description",APIVariables.promotionDescription));
        response.log().status();
    }
}
