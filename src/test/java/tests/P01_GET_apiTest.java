package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P01_GET_apiTest {
    /*
   https://restful-booker.herokuapp.com/booking/10 url'ine
  bir GET request gonderdigimizde donen Response'un,
    status code'unun 200,
ve content type'inin application/json; charset=utf-8,
ve Server isimli Header'in degerinin Heroku,
ve status Line'in HTTP/1.1 200 OK
ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.

    */

    /*
            Tum API testlerinde 4 asamada islem yapacagiz
                1- Endpoint ve gerekiyorsa requestData hazirlanir
                2- Eger verilmis ise ExpectedData hazirlanir
                3- Donen response kullanilmak icin bir obje icine kaydedilir
                4- Assertion islemleri yapilir
     */

    @Test
    public void test01(){
        //1- Endpoint ve gerekiyorsa (3P) requestData hazirlanir
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2- Eger verilmis ise ExpectedData hazirlanir
            //soruda verilmemis

        //3- Donen response kullanilmak icin bir obje icine kaydedilir
        Response response=given().when().get(url);
        //ya da
        //Response response=RestAssured().get(url);

        //response.prettyPrint();
        response.prettyPeek();

        System.out.println("Status Code:" + response.getStatusCode());
        System.out.println("Content-Type:" + response.getContentType());
        System.out.println("Server Header: " + response.getHeader("Server"));
        System.out.println("Status Line:" + response.statusLine());
        System.out.println("Process Time:" + response.getTime());



    }

}
