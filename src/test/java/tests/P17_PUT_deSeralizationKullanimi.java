package tests;

import baseUrlKlasoru.BaseUrl_JPH;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.JPH_datas;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class P17_PUT_deSeralizationKullanimi extends BaseUrl_JPH {

    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body'e sahip bir PUT request yolladigimizda
        donen response'in response body'sinin
        asagida verilen ile ayni oldugunu test ediniz
        Request Body
        {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
        }

        Expected Data :
        {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
        }

 */

    @Test
    public void test01(){

        //1- Endpoint ve gerekirse (3P) request body hazirlanir
        specJPH.pathParams("pp1","70","pp2","posts");
        Map<String, Object> reqMapBody = JPH_datas.MAPdataOlustur("Ahmet","Merhaba",10.0,70.0);

        //2- ExpData olusturulur
        Map<String,Object> expMapBody=JPH_datas.MAPdataOlustur("Ahmet","Merhaba",10.0,70.0);

        //3- Response bir obje icine kaydedilir
        Response response=given().contentType(ContentType.JSON).spec(specJPH).when().body(reqMapBody).put("/{pp2}/{pp1}");
        // put("/{pp2}/{pp1}") icine yazilan degerler soruda verilen endpoint' deki siraya gore isimden bagimsiz olarak yazilir

        // Assertion islemleri yapilir
        Map<String,Object> resMAP=response.as(HashMap.class);

        Assert.assertEquals(resMAP.get("title"),expMapBody.get("title"));
        Assert.assertEquals(resMAP.get("body"),expMapBody.get("body"));
        Assert.assertEquals(resMAP.get("userId"),expMapBody.get("userId"));
        Assert.assertEquals(resMAP.get("id"),expMapBody.get("id"));

        System.out.println("All tests PASSED");

    }

}
