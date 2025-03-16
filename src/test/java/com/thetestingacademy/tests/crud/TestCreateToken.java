package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.BookingResponse;
import com.thetestingacademy.pojos.TokenResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {


    @Test(groups = "reg", priority = 1)
    @TmsLink("https://bugz.atlassian.net/browse/TS-1")
    @Owner("Promode")
    @Description("TC#2  - Create Token and Verify")
    public void testTokenPOST() {
        requestSpecification.basePath(APIConstants.AUTH_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.setAuthPayload())
                .post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        String token = payloadManager.getTokenFromJSON(response.asString());
        assertActions.verifyStringKeyNotNull(token);
    }







}
