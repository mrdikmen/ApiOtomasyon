package tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class P03_jSonObjeCreate {

     /*
     Asagidaki JSON Objesini olusturup konsolda yazdirin.
               {
               "title":"Ahmet",
               "body":"Merhaba",
               "userId":1
               }
*/

    @Test
    public void JsonDataCreate(){

        JSONObject jSonData=new JSONObject();

        jSonData.put("title","Ahmet");
        jSonData.put("body","Merhaba");
        jSonData.put("userId",1);

        System.out.println(jSonData.toString(2));







    }
}
