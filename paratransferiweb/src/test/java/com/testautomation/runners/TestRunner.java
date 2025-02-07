package com.testautomation.runners;



import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;



@RunWith(Cucumber.class)

@CucumberOptions(

        features = {"src/test/resources/features"},

        glue = {"com.testautomation.stepdefinitions"},

        plugin = {

                "pretty",

                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",

                "json:target/cucumber-reports/CucumberTestReport.json",

                "html:target/cucumber-reports/cucumber-pretty.html",

                "junit:target/cucumber-reports/Cucumber.xml"

        },

        tags = "@smoke or @regression",

        monochrome = true

)

public class TestRunner {

}
