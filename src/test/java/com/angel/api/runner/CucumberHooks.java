package com.angel.api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.angel.api"},
        features = {"src/test/resources/api/features"},
        plugin = {
                "pretty",
                "html:reports/test-report-api.html",
                "json:reports/test-report-api.json"
        },
        monochrome = true
)
public class CucumberHooks {}
