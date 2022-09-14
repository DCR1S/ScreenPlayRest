package com.petstore.io.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/petStore.feature",
        glue = "com.petstore.io.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags="@service"
)
public class ServiceRunner {
}
