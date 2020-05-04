Test interview project to test availability of some products on the different ecommerce websites

REQUIREMENTS
------------
JDK 14
Selenium Java 3.12.0
Maven Plugins 3.8.1
testng 6.14.3


SETUP
------------
- Test "SearchGoods" is located by the following path "Interview_project/src/test/java/testsTest/SearchGoods.java"

- Set the path to the Chrome(or any other browser) driver in the variable "driverPath" inside the TestData.java module,
  find it by the path: "Interview_project/src/test/java/config_parameters/TestData.java"

- To change values of products which should be found, please open the TestData.java module and specify values
  in the "test_data" variable

- To change website url address which should be tested, please open the TestData.java module
  and specify test url address

- By default code tests the "rozetka" website, if you want to change tested website, please change locators values on appropriate  (path with locators -  "Interview_project/src/test/java/locators/")


