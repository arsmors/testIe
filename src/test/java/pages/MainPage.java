package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {
    private BaseFunc baseFunc;
    private final By MENU_SECTIONS = By.xpath("//li[@class=\"col-12 nav-section\"]");
    private final By MENU_SUB_SECTIONS = By.xpath("//a[@role=\"menuitem\"]");
    private final By PAGE_TITLE_CHECK = By.xpath("//*[@class=\"title-center\"]");
    private final By SEARCH_BOX = By.xpath("//*[@id=\"site-search-query\"]");
    private final By SEARCH_RESULTS = By.xpath("//div[@class=\"result-details\"]");


    public MainPage(BaseFunc basefunc) {
        this.baseFunc = basefunc;
    }

    public void selectMenuSection(String sectionName) {
        List<WebElement> menuSections = baseFunc.getElements(MENU_SECTIONS);
        for (WebElement section : menuSections) {
            if (section.getText().contains(sectionName)) {
                section.click();
                break;
            }
        }
    }

    public void selectSubMenuSection(String sectionName) {
        List<WebElement> menuSections = baseFunc.getElements(MENU_SUB_SECTIONS);
        for (WebElement section : menuSections) {
            if (section.getText().contains(sectionName)) {
                section.click();
                break;
            }
        }
    }

    public void searchResultsCheck(String text) {
        WebElement aa = baseFunc.getElement(PAGE_TITLE_CHECK);
        Assert.assertTrue("Sorry, wrong page displayed", aa.getText().equals(text));
    }

    public void enterSearchDetails(String search) {
        baseFunc.getElement(SEARCH_BOX).click();
        baseFunc.getElement(SEARCH_BOX).sendKeys(search);
        baseFunc.getElement(SEARCH_BOX).sendKeys(Keys.RETURN);
    }

    public void searchResults2(String search) {
        WebElement searchResult = baseFunc.getElement(SEARCH_RESULTS);
        Assert.assertTrue("Displayed message is not correct", searchResult.getText().contains(search));
    }
}
