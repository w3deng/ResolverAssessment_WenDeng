This repo is just for the assessment for Resolver
I've include the testing html file QE-nde.html in the repo

Based on the QE-guide.html,
I've create this repo to do the whole testing.
Using TestNg as the testing framework to run the tests
Using log4j2 as the log helper

The actual test script is located in /src/test/java/com/resolver/ui_tests/Assessment_Test/
Inside the /src/main/java/com/resolver/, it has serverl helper classes in oder to acheive better OOP and improve the overall code reusability, readability and easier maintenance


pages/  stores all the page elements/methods needed for the testing page
test_base/  build the BaseTest to use for other testing
utilities/  store some utilities need to use, like logger for this assement

ActionHelper  general methods that can be reused for others as well
WebDriverHelper  to better handle the webdriver although it's not really needed for this assement
