package pages;

import locators.ProductListPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


// ProductListPage class describes functionality of the Product List Page
public class ProductListPage extends MainPageClass{
    By product_item = By.xpath(ProductListPageLocators.product_item);

    public ProductListPage(WebDriver driver)
    {
        super(driver);
    }

    // Return number of founds goods
    public int num_of_found_items()
    {
        return driver.findElements(product_item).size();
    }
}
