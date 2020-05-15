# Project Title

Login to Amazon app and add items to cart and compare the item price and description between item search and checkoutpage

## Tools/Frameworks used

●	Appium is used along with cucumber BDD framework to complete this task.

### Framework Details

●	I have used page object model and updated all application related objects in the java class LoginPageObjects.Java which is located inside the package com.businesscomponents. Usually i will create multiple classes one for each page, but since the task is simple I have updated all the page objects in the same class.
●	I have provided all the test data in the Config.properties file such that test data maintainence will be easy to whoever wants to modify the test data.
●	I have maintainded the scenario is the feature file using gherkin language/cucubmber framework.
●	Once the testcase is execute restults can be viewed at test-output/index.html file
●   All the dependencies are provided in the pom.xml file
●   Scenarios are mentioned in the feature file
●   Feature file implementation is provided in the com.businesscomponents package

##### Prerequisites

I assume following software's are installed on the machine where this project will be executed.

●	Java 1.8(Path and Class path configured)
●	Eclipse(Eclipse IDE for Java Developers or any eclipse to import and execute the project)
●   Amazon app should be installed & device name should be changed in the config.properties file

###### Functions
setUp-intialization setup of webdriver and load properties file
user_logged_into_Amazon_mobile_application - This funtion is used to login to the amazon application
waitForObject - This funciton wait for the objects in the page to loaded
user_Search_for_item_and_add_items_to_cart_and_purchase - search for item in home page and add it to cart.
compare_the_products_information_between_product_search_screen_and_checkout_screen - This function compares both expected and actual values of item price and description
verticalSwipeScreen - To swipe screen vertically i have used this function
tearDown - Close the driver object and stop appium server.

####### Running the tests

●	Open Eclipse->Import the downloaded Project from Github->Wait for eclipse to build the workspace

●	Navigate to src/test/java->com.testrunner package->Open RunnerTest.Java class-> Right click and run as Junit test

●	Program execution will be started and wait till the execution is completed.

●	Naviate to /test-output/index.html page to view the results.

