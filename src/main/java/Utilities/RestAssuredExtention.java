package Utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class RestAssuredExtention {

    public static RequestSpecification Request;
    //Arrange
    public RestAssuredExtention() {

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec = builder.build();

        Request = RestAssured.given().spec(requestSpec);
    }
    //Act
    public void GetOpsWithPathParameter(String url, HashMap<String,String> pathParmeters) throws URISyntaxException {
        Request.pathParams(pathParmeters);
        Request.get(new URI(url));
    }

    //Act
    public ResponseOptions<Response> GetOps(String url)  {
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResponseOptions<Response> PostOpsWithBodyAndPathParams(String url, Map<String,String> pathParams,Map<String,String>body){
      Request.pathParams(pathParams);
      Request.body(body);
      return Request.post(url);

    }
}
