package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import pages.ProductListPage;
import pages.MainPageClass;
import config_parameters.TestData;
import config_parameters.DataproviderClass;


/*
@Author - Mykola Sokolovskyi
@Date - 05/02/2020

@TestCase description:
    TC#0001: Verify that at least one product is present on the ecommerce site among given 3 items

    Pre-conditions:
    1. Test data set is given from 3 items.

    Steps to reproduce:
    1. Open any ecommerce website in any browser.
    2. Fill out first item name in the Search field.
    3. Press the Search button.
    4. Check search results.
    5. Repeat 2-4 steps twice to coverage full test data set.

    Expected result:
    At least one item should be found among the given test data set.
*/

public class TestSearchGoods {
    String driverPath = TestData.driverPath;
    String website_url = TestData.website_url;
    MainPageClass homepage_obj;
    ProductListPage products_list_page_obj;
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chromedriver.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(website_url);
    }

    @Test(dataProvider="SearchProvider", dataProviderClass = DataproviderClass.class)
    public void test_TC0001(String[] set_of_queries)
    {
        homepage_obj = new MainPageClass(driver);
        products_list_page_obj= new ProductListPage(driver);
        int number_of_search_results = 0;
        /*
        Perform search for each keyword in the test data set,
        if at least one item is found - test passes, otherwise - test fails
         */
        for (int i = 0; i < set_of_queries.length; i++)
        {
            if (i == 0)
            {
                homepage_obj.perform_search(set_of_queries[i]);
            }
            else {
                products_list_page_obj.clear_search_text();
                products_list_page_obj.perform_search(set_of_queries[i]);
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            if (products_list_page_obj.num_of_found_items() > 0)
            {
                number_of_search_results += 1;
                break;
            }
            products_list_page_obj.clear_search_text();
        }
        Assert.assertTrue(number_of_search_results != 0,
                String.format("Not results were found among following items: %s, %s, %s .",
                        set_of_queries[0],
                        set_of_queries[1],
                        set_of_queries[2])
        );
    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}