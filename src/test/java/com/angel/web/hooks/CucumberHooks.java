package com.angel.web.hooks;

import com.angel.web.helper.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.Objects;

import static com.angel.web.helper.Utility.driver;
import static com.angel.web.helper.Utility.getDriver;

public class CucumberHooks {
    String tagsRunning = null;
    @Before
    public void berforeTest(Scenario scenario){
        System.out.println("Before test each scenario");
        String[] tags = scenario.getSourceTagNames().toArray(new String[0]);
        tagsRunning = tags[0];
        if (Objects.equals(tagsRunning, "@web")) {
            Utility.startDriver();
        }
    }

    @After
    public void afterTest(Scenario scenario) throws InterruptedException{
        System.out.println("After test each scenario");
        if (Objects.equals(tagsRunning, "@web")) {
            Utility.quitDriver();
        }
    }
}
