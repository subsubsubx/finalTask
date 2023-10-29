package ru.ibs;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.pages.OptionsPage;
import ru.ibs.framework.pages.SearchPage;

import java.util.List;

public class NewTest extends BaseTest {
    DriverManager driverManager = DriverManager.getDriverManager();

    SearchPage searchPage = new SearchPage();
    OptionsPage optionsPage = new OptionsPage();

    @Test
    public void test() {
        catalogueButton.click();
        clickWebElementFromList(menuOptionsList, "Комплектующие для ПК");
        checkOpenPage("Комплектующие для ПК");
        clickWebElementFromList(optionsPage.getOptionsList(), "Видеокарты");
        checkOpenPage("Видеокарты");
        searchPage.setMinPrice(2000);
        clickWebElementFromList(searchPage.getManufacturerList(), "Gigabyte");
        searchPage.checkResultsCount(searchPage.getResultsList(), 24);
        searchPage.waitUntilSearchDone();
        String first = searchPage.getResultsList().get(0).findElement(By.xpath(".//h6")).getText();
     /*   clickWebElementFromList(manufacturerList, "Gigabyte");
        pageManager.getSearchPage().checkResultsCount(pageManager.getSearchPage().getResultsList(), 24);
        pageManager.getSearchPage().waitUntilSearchDone();
        String first = pageManager.getSearchPage().getResultsList().get(0)
                .findElement(By.xpath(".//h6")).getText();*/
    setFieldAndSubmit(searchBar, first);
    //    pageManager.getSearchPage().waitUntilSearchDone();
/*        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        searchPage.waitUntilSearchDone();
        searchPage.checkResultsCount(searchPage.getResultsList(), 1);
 //       pageManager.getSearchPage().checkResultsCount(pageManager.getSearchPage().getResultsList(), 1);
    }
}

