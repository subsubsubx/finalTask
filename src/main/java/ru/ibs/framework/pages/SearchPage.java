package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//span[text()='Цена']//ancestor::section//input[contains(@name, 'min')]")
    private WebElement minPrice;

    public List<WebElement> getManufacturerList() {
        return manufacturerList;
    }

    @FindBy(xpath = "//span[text()='Производитель']//ancestor::section //div[contains(@class, 'Checkbox')]")
    private List<WebElement> manufacturerList;


    public boolean checkResultsCount(List<WebElement> list, int num) {
        if (list.size() <= num) {
            return true;
        } else
            Assert.fail("Количество элементов массива больше заданного числа: " + num);
        return false;
    }

    public List<WebElement> getResultsList() {
        return driverManager.getDriver().findElements(By
                .xpath("//div[contains(@class, 'ListingRenderer_row')]/div"));
    }

    public String getTitleFromResultsList(int num){
        return getResultsList().get(num  - 1).findElement(By.xpath(".//h6")).getText();
    }

    public void setMinPrice(int num) {
        waitClickability(minPrice);
        setField(minPrice, num);
        Assert.assertEquals(Integer.parseInt(minPrice.getAttribute("value")), num);
    }

    public void waitUntilSearchDone() {
        wait.until(ExpectedConditions
                .invisibilityOf(driverManager.getDriver().findElement(By
                        .xpath("//span[contains(@class, 'PageTitle_countSkeleton')]"))));
    }
}


