package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P19_QueryParametresiKullanimi extends BaseUrl.RestFullBaseUrl {

    /*

    https://restful-booker.herokuapp.com/booking endpointine
    gerekli Query parametrelerini yazarak
    "firstname" degeri "Eric" olan rezervasyon oldugunu test edecek
    bir GET request gonderdigimizde, donen response'un status code'unun
    200 oldugunu ve "Eric" ismine sahip en az bir booking oldugunu test edin

 */

    @Test
    public void test01(){

        specJPH.pathParam("pp1","booking").queryParam("firstname","Josh");
                        //Query parametresi eger birden fazla ise queryParams() methodu kullanilir

        //https://restful-booker.herokuapp.com/booking?firstname=Eric
        //response kaydedilirken Response class' i query parametrelerinin
        //get/post/put gibi methodlarin icine yazilmasini gerekli kilmamistir.

        Response response=given().spec(specJPH).when().get("/{pp1}");
        response.then().assertThat().statusCode(200).body("size()", Matchers.greaterThanOrEqualTo(1));
    }



}
