package org.prog.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//TODO: go to rozetka
//TODO: search for any goods (iPhone 15)
//TODO: print that goods name ( Мобильный телефон Apple iPhone 15 Pro Max 256GB Black Titanium (MU773RX/A) )

public class SeleniumDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        try {
//            driver.get("https://google.com/");
//            //accept cookies if they are present
//            //find all buttons in cookies form
//            List<WebElement> cookieButtons =
//                    driver.findElements(By.xpath(
//                            "//a[contains(@href,'https://policies.google.com/technologies/cookies')]/../../../..//button"));
//            if (!cookieButtons.isEmpty()) {
//                //click button with index 3 (this button accepts all cookies)
//                cookieButtons.get(3).click();
//            }
//            //TODO: sreach for ben Affleck
//            //Step 1: set search form value to Ben Affleck
//            WebElement searchInput = driver.findElement(By.name("q"));
//            searchInput.sendKeys("Ben Affleck");
//            //Step 2: press enter while in search form
//            searchInput.sendKeys(Keys.ENTER);
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
//            List<WebElement> searchHeaders =
//                    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("h3"), 5));
//
//            System.out.println(">>>>> " + searchHeaders.size());
//
//            int afflecksFound = 0;
//            for (WebElement element : searchHeaders) {
//                if (element.getText().contains("Ben Affleck")) {
//                    afflecksFound++;
//                }
//            }
//            if (afflecksFound >= 3) {
//                System.out.println("Ben found!");
//            } else {
//                System.out.println("Ben not found :(");
//            }
//        } finally {
//            driver.quit();
//        }
//    }
        try {
            driver.get("https://allo.ua/");

            WebElement searchInput = driver.findElement(By.name("search"));
            searchInput.sendKeys("iPhone 15");
            searchInput.sendKeys(Keys.ENTER);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3L));
            WebElement firstGridItem = wait.until(ExpectedConditions.
                    visibilityOfElementLocated
                            (By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[2]/div/div[2]/div[2]/div[1]/div/div[3]/a")));

            String productTitle = firstGridItem.getAttribute("title");
            System.out.println(productTitle);

        } finally {
            driver.quit();
        }


    }
}