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
        waitPageTitle("Комплектующие для ПК");
        clickWebElementFromList(optionsPage.getOptionsList(), "Видеокарты");
        waitPageTitle("Видеокарты");
        searchPage.setMinPrice(2000);
        clickWebElementFromList(searchPage.getManufacturerList(), "Gigabyte");
        searchPage.checkResultsCount(searchPage.getResultsList(), 24);
        searchPage.waitUntilSearchDone();
        String s = searchPage.getTitleFromResultsList(1);
        setFieldAndSubmit(searchBar, s);
        searchPage.waitUntilSearchDone();
        searchPage.checkResultsCount(searchPage.getResultsList(), 1);
    }
}

