package org.store.pet.test;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
        retryCount = 3,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        jsonUsageReport = "target/cucumber-usage.json",
        outputFolder = "target")
@CucumberOptions(features = "src/test/resources/features",glue = "org.store.pet.stepDef",plugin = { "html:target/cucumber-html-report",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json" })
public class TestRunner {

}
