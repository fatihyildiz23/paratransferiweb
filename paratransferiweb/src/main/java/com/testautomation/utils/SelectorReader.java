package com.testautomation.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;

public class SelectorReader {
    private static JsonNode selectors;
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        try {
            selectors = mapper.readTree(new File("src/test/resources/selectors/all-selectors.json"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load selectors file", e);
        }
    }

    public static By getLocator(String page, String elementName) {
        JsonNode element = selectors.get(page).get(elementName);
        String type = element.get("type").asText();
        String value = element.get("value").asText();

        switch (type.toLowerCase()) {
            case "id":
                return By.id(value);
            case "name":
                return By.name(value);
            case "css":
                return By.cssSelector(value);
            case "xpath":
                return By.xpath(value);
            case "classname":
                return By.className(value);
            case "linktext":
                return By.linkText(value);
            case "partiallinktext":
                return By.partialLinkText(value);
            case "tagname":
                return By.tagName(value);
            default:
                throw new IllegalArgumentException("Invalid selector type: " + type);
        }
    }
} 