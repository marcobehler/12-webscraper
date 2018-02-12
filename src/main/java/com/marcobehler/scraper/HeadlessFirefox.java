package com.marcobehler.scraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
public class HeadlessFirefox {

    public static void main(String[] args) {
        FirefoxDriver driver = createFirefoxDriver();
        driver.get("https://www.reddit.com/r/java/");

        WebElement nextLink = driver.findElement(By.linkText("next ›"));
        nextLink.click();

        List<WebElement> titles = driver.findElements(By.cssSelector("a.title"));
        titles.stream().map(WebElement::getText).sorted().forEach(System.out::println);

    }


    private static FirefoxDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "c:\\dev\\gecko\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        return new FirefoxDriver(options);
    }
}
