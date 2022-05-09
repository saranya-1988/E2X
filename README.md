# E2X
Scenario -
Given I have a product in my cart

When I complete the checkout process

Then I am presented with a purchase confirmation page for my order
In this framework Used technology 
Katalon studio IDE
Selenium
Groovy
KS Built in Object modeling.
Katalon studio - freeware - Download latest version and clone this project. we are able to do the product checkout as guest and existing user.(Have added minimum checkpoint - but scenariowise we can have more test case validation with data sheet for postive, neagtive and error handling scenarios)
-------------------------------------------------
I have a thought of creating framework as below but due to some technical giltch which need more time from my end to fix- created a base setup. I am glad to explain the approch of testing - for given scenario anyway
Given I have a product in my cart
When I complete the checkout process
Then I am presented with a purchase confirmation page for my order
Technology (PyTest, Page Object Model, HTML Reports) - 
-------------------------------------------------
But i did for basic 2 testcases
Steps:
(In mind
slenium - webUI - implemented
pytest -Python unit test - impleted
pytest-html - Reports - not yet
openpyxl - Excel sheet data upload - not yet)
1. IDE - Pycharm
2. Create a project called 'cornerstone'
3. Install required plugin (I installed - selenium and pytest)
4. Create a POM structure,
    Planned structure
        POM (Package)
        Test Cases(Package)
        Configuration(Directory)
        Tesy Data(Directory)
        Reports(Directory)
          Screenshots(Directory)
          Logs(Directory)
 5. Create a POM - and added Loginpage.py as below
import selenium

from selenium import webdriver

class LoginPage:
    signin_link_xpath ="/html/body/header/nav/ul/li[4]/a[1]"
    textbox_username_id = "login_email"
    textbox_password_id = "login_pass"
    button_login_xpath = "//*[@id=\"main-content\"]/div[1]/div/div/form/div[3]/input"
    link_logout_xpath = "/html/body/header/nav/ul/li[4]/a[2]"

    def __init__(self,driver):##Python Constructor - invoke on object creation
        self.driver=driver ##Our local driver Login
    ##Action Methods for Signin Click
    def clickSigin(self):
        self.driver.find_element_by_xpath(self.signin_link_xpath).click()
    ##Action Methods for UserID
    def setUserName(self,username):
        self.driver.find_element_by_id(self.textbox_username_id).clear()
        self.driver.find_element_by_id(self.textbox_username_id).send_keys(username)
    ##Action Method for Password
    def setPassword(self,password):
        self.driver.find_element_by_id(self.textbox_password_id).clear()
        self.driver.find_element_by_id(self.textbox_password_id).send_keys(password)
    ##Action Method for Signin
    def clickSigninButton(self):
        self.driver.find_element_by_xpath(self.button_login_xpath).click()
    ##Action Method for Sign out after Successful Login
    def clickSignout(self):
        self.driver.find_element_by_xpath(self.link_logout_xpath).click()
6.Test case login.py
import pytest
from selenium import webdriver
from pageObject.LoginPage import LoginPage


class Test_001_Login:
    ##Common variables
    baseURL = "https://cornerstone-light-demo.mybigcommerce.com"
    username = "saranya.ranganayaki@gmail.com"
    Password = "Pa55w0rd"

    ##Verify the Landing page title
    def test_landingPageTitle(self,setup):
        ##self.driver = webdriver.Chrome() will be duplicated in the test, hence we are going to keep it in config file
        self.driver = setup
        self.driver.get(self.baseURL)
        act_title = self.driver.title
        self.driver.close()
        if act_title == "Cornerstone Demo":
            assert True
        else:
            assert False
 7.Confytest.py
 
 Duplicated lines planned to be in config in this case
 self.driver = webdriver.Chrome() will be duplicated in the test, hence we are going to keep it in config file
 
 8. pythom -m pytest -v -s testCases/login.py
 9. output as below,

 1 failed, 1 passed in 12.67s 
