package com.example.tests;
import io.restassured.internal.support.FileReader;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.JSONArray;
import org.json.JSONException;

import org.testng.Assert;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;

import static org.testng.Assert.assertNotNull;



class response{

}

public class TestRest {


    // String dom = "api.vk.com/method/";
    // String metod = "users.get?";

    // String id =  "user_id=20723173&";
    //  String token =  "access_token=ad330c9d89a6c54375392821838ac72047261eec0de44523cf422e8aa21202a0a69579b01f46449866c72&";
    // String ver =  "v=5.92";
    @Test(description = "API GET REQUEST TEST")

    public <string> void getRequestExampleTest() throws JSONException {
        //  RequestSpecification httpRequest = given();
        //  Response response = httpRequest.get( "https://" + dom + metod + id + token + ver + '"');
        //  response.prettyPrint();

        // Response responseF = httpRequest.get("https://api.vk.com/method/friends.get?user_id=20723173&access_token=ad330c9d89a6c54375392821838ac72047261eec0de44523cf422e8aa21202a0a69579b01f46449866c72&v=5.92");
        //responseF.prettyPrint();


        //Response responseS = httpRequest.get("https://api.vk.com/method/status.set?group_id=117179357&text='text'&access_token=39bad999230de9ed0e203e93c260db123f9b7fc5bfaca8baf2d360ae603f74af4f60a6d3a01b5ff41dcb0&v=5.92");
        // responseS.prettyPrint();

        //"https://api.vk.com/method/users.get?user_id=20723173&access_token=ad330c9d89a6c54375392821838ac72047261eec0de44523cf422e8aa21202a0a69579b01f46449866c72&v=5.92"
        //private String response ;

        String CONEXT_PATH = "https://api.vk.com/method";
        Response response = given()
                .accept(JSON)
                .queryParam("user_id", "20723173")
                .queryParam("access_token", "ad330c9d89a6c54375392821838ac72047261eec0de44523cf422e8aa21202a0a69579b01f46449866c72")
                .queryParam("v", "5.92")
                .when()
                .get(CONEXT_PATH + "/users.get")
                //.when().get("https://" + dom + metod + id + token + ver + '"').
                .then()
                .statusCode(200)
                .contentType(JSON)
                .extract()
                .response();

        String jsonBody = response.getBody().asString();

        try {
            JSONArray usersArray = new JSONArray(jsonBody);
            assertNotNull(usersArray);
            assertTrue(usersArray.length() > 0);
        } catch (JSONException ex) {
            
            Assert.fail(ex.getLocalizedMessage());

       }
        //.body(containsString("response"));
        // System.out.println(response);


    }
}



