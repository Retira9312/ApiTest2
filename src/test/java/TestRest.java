package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.core.IsEqual.equalTo;


public class TestRest {

    @Test(description = "API GET REQUEST TEST")
    public <string> void getRequestExampleTest() throws JSONException {
         RequestSpecification httpRequest = given();
         Response response = httpRequest.get("https://api.vk.com/method/users.get?user_id=20723173&access_token=a4f28633b93b1e64f0bc6dac52fd46289812f1a766dcaaa22bdf8f09b75aff92cc8ef6bdbae653410dd31&v=5.92");
         response.prettyPrint();

         Response responseF = httpRequest.get("https://api.vk.com/method/friends.get?user_id=20723173&access_token=a4f28633b93b1e64f0bc6dac52fd46289812f1a766dcaaa22bdf8f09b75aff92cc8ef6bdbae653410dd31&v=5.92");
         responseF.prettyPrint();


         Response responseS = httpRequest.get("https://api.vk.com/method/status.set?group_id=117179357&text='text'&access_token=39bad999230de9ed0e203e93c260db123f9b7fc5bfaca8baf2d360ae603f74af4f60a6d3a01b5ff41dcb0&v=5.92");
         responseS.prettyPrint();



    }
}

