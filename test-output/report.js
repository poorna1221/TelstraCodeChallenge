$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AddItemstoCart.feature");
formatter.feature({
  "line": 1,
  "name": "Amazon mobile application automation feature",
  "description": "",
  "id": "amazon-mobile-application-automation-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 16442098700,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Verify the adding items to cart functionality in Amazon mobile app",
  "description": "",
  "id": "amazon-mobile-application-automation-feature;verify-the-adding-items-to-cart-functionality-in-amazon-mobile-app",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User logged into Amazon mobile application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User Search for item and add items to cart and purchase",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "compare the products information between product search screen and checkout screen",
  "keyword": "Then "
});
formatter.match({
  "location": "AmazonAppAddItemsToCart.user_logged_into_Amazon_mobile_application()"
});
formatter.result({
  "duration": 16962876000,
  "status": "passed"
});
formatter.match({
  "location": "AmazonAppAddItemsToCart.user_Search_for_item_and_add_items_to_cart_and_purchase()"
});
