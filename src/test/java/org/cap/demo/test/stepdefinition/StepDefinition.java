package org.cap.demo.test.stepdefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.cap.demo.model.BookDTO;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
@SpringBootTest
@CucumberContextConfiguration
public class StepDefinition {
	
	private Response response;
	private RequestSpecification request;
	
	@Given("I want to provide data with {int},{string}")
	public void i_want_to_provide_data_with(Integer int1, String string) {
	    BookDTO Book=new BookDTO();
	    Book.setId(int1);
	    Book.setTitle(string);
	    request=given().contentType(ContentType.JSON).body(Book);
	    //throw new io.cucumber.java.PendingException();
	}

	@When("post method")
	public void post_method() {
	    response=request.when().post("http://localhost:8081/book");
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("validate {string}")
	public void validate(String string) {
	    int status=response.then().extract().statusCode();
	    System.out.println(string);
	    assertEquals(200,status);
		//throw new io.cucumber.java.PendingException();
	}
}
