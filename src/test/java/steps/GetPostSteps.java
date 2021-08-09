package steps;

import Utilities.RestAssuredExtention;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.HashMap;
import java.util.List;


public class GetPostSteps {

    public static ResponseOptions<Response> response;

    @Given("I perform GET operation for {string}")
    public void i_perform_get_operation_for(String url) {

    }
    @Given("I perform Get for the post number {string}")
    public void i_perform_get_for_the_post_number(String postNumber) {
        BDDStyleMethod.simpleGetPost(postNumber);

    }
    @Then("I should see the author name as {string}")
    public void i_should_see_the_author_name_as(String string) {

    }

    //Scenario 2

    @Then("I should see verify GET Parmeter")
    public void iShouldSeeVerifyGETParmeter() {
        //BDDStyleMethod.performPathParameter(); // Path Parameters
        BDDStyleMethod.performQueryParameter(); // Query Parameters
    }

    //Scenario 3

    @Given("I perform POST operation for {string}")
    public void iPerformPOSTOperationFor(String arg0) {

        BDDStyleMethod.PerformPOSTWithBodyParameter();
    }

    //Scenario 4

    @Given("I perform POST operation for {string} with body")
    public void i_perform_post_operation_for_with_body(String url, DataTable table)throws Throwable {
        List<List<String>> data = table.cells();

        //Set body
        HashMap<String,String> body = new HashMap<String, String>();
        body.put("name",data.get(1).get(0));

        //Path params
        HashMap<String,String> pathParams = new HashMap<String, String>();
        pathParams.put("profileNo",data.get(1).get(1));

        //Perform post operation
        response = RestAssuredExtention.PostOpsWithBodyAndPathParams(url,pathParams,body);


    }
    @Then("I should see the body has name as {string}")
    public void i_should_see_the_body_has_name_as(String string) throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
