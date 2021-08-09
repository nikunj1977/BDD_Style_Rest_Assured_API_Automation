package steps;

import io.restassured.http.ContentType;
import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BDDStyleMethod {

    public static void simpleGetPost(String postNumber){
        given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:3000/posts/%s",postNumber)).
                then().body("author", is("Dhruvin")).statusCode(200);

    }

    public static void performPathParameter(){
        given()
                .contentType(ContentType.JSON)
        .with()
                .pathParam("post",2).
        when()
                .get("http://localhost:3000/posts/{post}").
        then()
                .body("author",containsString("Nikunj"));

    }

    public static void performQueryParameter(){
        given()
                .contentType(ContentType.JSON)
                .queryParam("id",2).
        when()
                .get("http://localhost:3000/posts/").
        then()
                .body("author",hasItem("Nikunj"));

    }

    public static void PerformPOSTWithBodyParameter(){
        HashMap<String,String>postContent = new HashMap<String, String>();
        postContent.put("id","3");
        postContent.put("title","life of pie");
        postContent.put("author","Hetal");

        given()
                .contentType(ContentType.JSON).
        with()
                .body(postContent).
        when()
                .post("http://localhost:3000/posts").
        then()
                .body("author", Is.is("Hetal"));


    }
}
