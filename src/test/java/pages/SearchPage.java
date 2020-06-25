package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchPage {
    private BaseFunc baseFunc;
    private final By SEARCH_BOX = By.xpath("//*[@id=\"site-search-query\"]");
    private final By SEARCH_RESULTS = By.xpath("//div[@class=\"result-details\"]");


    public SearchPage(BaseFunc basefunc) {
        this.baseFunc = basefunc;
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
