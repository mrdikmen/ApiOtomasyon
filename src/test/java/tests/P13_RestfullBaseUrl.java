package tests;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class P13_RestfullBaseUrl extends BaseUrl.RestFullBaseUrl {


    /*

      https://restful-booker.herokuapp.com/booking endpointine
      bir GET request gonderdigimizde donen response'un
      status code'unun 200 oldugunu ve
      Response'ta 12 booking oldugunu test edin

 */

    @Test
    public void test01(){

        specJPH.pathParams("ilk","booking");

        Response response=given().spec(specJPH).when().get("/{ilk}");

        List<Integer> bookingIdList=response.jsonPath().getList("bookingid");
        int size=bookingIdList.size();
        response.then().assertThat().statusCode(200);

        Assert.assertTrue(size>=12);
        //response.prettyPrint();

        System.out.println("Dogrulama islemi gerceklestirildi");

    }


}
