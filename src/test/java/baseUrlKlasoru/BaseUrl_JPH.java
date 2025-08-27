
package baseUrlKlasoru;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseUrl_JPH {
    protected RequestSpecification specJPH;

    @BeforeTest
    public void setup(){
        specJPH= new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com").build();
    }
}
