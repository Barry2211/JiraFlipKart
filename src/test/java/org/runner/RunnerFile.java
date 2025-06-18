package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\Eclipse\\eclipse\\bin\\cucumberProjects\\src\\test\\resources\\feature.feature",
glue="org.steps" , dryRun=false
)
public class RunnerFile {

}
