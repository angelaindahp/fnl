package com.angel.web.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.angel.web"},
        features = {"src/test/resources/webfeatures"},
        plugin = {
                "pretty",
                "html:reports/test-report-web.html",
                "json:reports/test-report-web.json"
        },
        monochrome = true
)
public class CucumberWEBTest {}