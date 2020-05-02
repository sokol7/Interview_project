package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import locators.HomePageLocators;


//Basic class which describes common functionality for other pages classes
public class MainPageClass {
    WebDriver driver;
    By search_field = By.name(HomePageLocators.searh_field);

    public MainPageClass(WebDriver driver)
    {
        this.driver = driver;
    }

    //Perform search by the selected query
    public void perform_search(String search_query)
    {
        driver.findElement(search_field).sendKeys(search_query + Keys.ENTER);
    }

    //Erase text from the Search field
    public void clear_search_text()
    {
        driver.findElement(search_field).clear();
    }
}
