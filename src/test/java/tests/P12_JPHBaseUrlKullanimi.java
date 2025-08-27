package tests;

import baseUrlKlasoru.BaseUrl_JPH;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P12_JPHBaseUrlKullanimi extends BaseUrl_JPH {

    /*

                https://jsonplaceholder.typicode.com/posts endpointine
                bir GET request gonderdigimizde
                donen response'un status code'unun 200 oldugunu ve
                Response'ta 100 kayit oldugunu test edin


 */



    @Test
    public void test01(){

        //1- Endpoint olusturulmasi
        specJPH.pathParams("pp1","posts");  //specJPH: https://jsonplaceholder.typicode.com pp1:posts

        //2-ExpData hazirlama

        //3-Response degeri kayit altina alinir
        Response response=given().spec(specJPH).when().get("/{pp1}");

        response.then().assertThat().statusCode(200).body("body", Matchers.hasSize(100));
        //response.prettyPrint();

        System.out.println("Test01 PASSED");
    }
    /*
2- https://jsonplaceholder.typicode.com/posts/44 endpointine
    bir GET request gonderdigimizde donen response’un
    status code’unun 200 oldugunu ve “title” degerinin
    “optio dolor molestias sit” oldugunu test edin

 */

    @Test
    public void test02(){

        specJPH.pathParams("pp1","posts","pp2","44");

        Response response=given().spec(specJPH).when().get("/{pp1}/{pp2}");

        response.then().assertThat().statusCode(200).body("title",Matchers.equalTo("optio dolor molestias sit"));

        System.out.println("Test02 PASSED");


    }

    /*
        https://jsonplaceholder.typicode.com/posts/50 endpointine
        bir DELETE request gonderdigimizde donen response'un
        status code'unun 200 oldugunu
        ve response body'sinin null oldugunu test edin
 */

    @Test
    public void test03(){

        specJPH.pathParams("pp1","posts","pp2","50");

        Response response=given().spec(specJPH).when().delete("/{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).body("title", Matchers.nullValue(),
                "userId",Matchers.nullValue(),
                "id",Matchers.nullValue(),
                "body",Matchers.nullValue());

        System.out.println("Test03 PASSED");
    }




}
