package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/zerobank/stepdefinitions" ,
        features = "src/test/resources/features" ,
        dryRun = false,
        tags = "@not @smoke_test",
        plugin = {"html:target/default-report-for-regression",
                "json:target/cucumber_regression.json" ,
                "rerun:target/rerun_regression.txt"
        }
)
public class RegressionRunner {
}
