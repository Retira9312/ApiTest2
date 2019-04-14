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
import static org.testng.Assert.fail;




public class TestRest {


    @Test(description = "API GET REQUEST TEST")

    public <string> void getRequestExampleTest() throws JSONException {


        String CONEXT_PATH = "https://api.vk.com/method";
        Response response = given()
                .accept(JSON)
                .queryParam("user_id", "20723173")
                .queryParam("access_token", "1cfd05e145ee99f82b20ebf796cc07f247accb38e2a79c10baf60f8851cb27ea2a351cb739b4ab3e5c725")
                .queryParam("v", "5.92")
                .when()
                .get(CONEXT_PATH + "/users.get")
                .then()
                .statusCode(200)
                .contentType(JSON)
                .extract()
                .response();

        String jsonBody = response.getBody().asString();
        System.out.println(jsonBody);



        try {
            JSONArray usersArray = new JSONArray(jsonBody);
            assertNotNull(usersArray);
            assertTrue(usersArray.length() > 0);
            assertTrue(usersArray.);
        } catch (Exception ex) {

            System.out.println(ex.getLocalizedMessage());

        }
        //System.out.println(usersArray);
        //.body(containsString("response"));
        // System.out.println(response);


    }
}



