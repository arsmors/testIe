package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {
    private BaseFunc baseFunc;
    private final By MENU_SECTIONS = By.xpath("//li[@class=\"col-12 nav-section\"]");
    private final By MENU_SUB_SECTIONS = By.xpath("//a[@role=\"menuitem\"]");
    private final By PAGE_TITLE_CHECK = By.xpath("//*[@class=\"title-center\"]");

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
        WebElement searchResultPageTitle = baseFunc.getElement(PAGE_TITLE_CHECK);
        Assert.assertTrue("Sorry, wrong page displayed", searchResultPageTitle.getText().equals(text));
    }
}
