package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="src\\test\\resources\\Adactin\\feature.feature",
		glue="org.steps" , 
		dryRun=false
)
public class RunnerFile {

}
