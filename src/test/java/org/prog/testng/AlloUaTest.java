package org.prog.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.pages.AlloUaPage;
import org.prog.web.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlloUaTest {

    private final WebDriver driver = WebDriverFactory.getDriver();
    private AlloUaPage page;

    @BeforeSuite
    public void setUp() {
        page = new AlloUaPage(driver);
    }

    //TODO: add method to page object that will switch between search pages
    //TODO: methods: left, right and by page number
    //TODO: test must vefiry that searched value is present on that page
    @Test
    public void searchForPhone() {
        String phoneName = "iPhone 15";
        page.loadPage();
        page.searchForGoods(phoneName);
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was present on page");
        page.scrollToElement(page.pagination());
        page.nextPage();
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was present on the next page");

        //add next page by clicking ">"
        // add verifiation like line 29
    }

    @Test
    public void searchForPhoneByPageNumber() {
        String phoneName = "iPhone 15";
        page.loadPage();
        page.searchForGoods(phoneName);
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was presented on page");
        page.scrollToElement(page.pagination());
        page.pageByNumber(2);
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was presented on this page");
    }

    //TODO: add second test where you change page by clicking "2"

    //TODO: * - switch page "2" then click "<" then validate goods
    @Test
    public void searchForPhoneByPageNumberAndStepBack() {
        String phoneName = "iPhone 15";
        page.loadPage();
        page.searchForGoods(phoneName);
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was presented on page");
        page.scrollToElement(page.pagination());
        page.pageByNumber(3);
        page.scrollToElement(page.pagination());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        WebElement prevButton = wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pagination__prev")));
        page.previousPage();
        Assert.assertTrue(page.searchResultsContain(phoneName),
                "No phone with name '" + phoneName + "' was presented on this page");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
