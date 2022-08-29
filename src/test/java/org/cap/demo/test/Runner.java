package org.cap.demo.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/app.feature"}, publish=true,
		glue= {"org.cap.demo.test.stepdefinition"} )
public class Runner {

}
