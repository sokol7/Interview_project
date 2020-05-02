package config_parameters;

import org.testng.annotations.DataProvider;


// DataproviderClass provides data set for tests
public class DataproviderClass {
    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
        return new Object[][]
                {
                        {TestData.test_data},
                };
    }
}
