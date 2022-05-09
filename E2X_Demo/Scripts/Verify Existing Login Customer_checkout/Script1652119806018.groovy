import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Base_Test/BaseUrlAccess'), [:], FailureHandling.STOP_ON_FAILURE)

//Verify the Page Title
act_title = WebUI.getWindowTitle()

if (act_title == 'Cornerstone Demo') {
    assert true
} else {
    assert false
}

WebUI.comment('Page title retrived ' + act_title)

//Verify the Signin Functionality
signIn()

WebUI.maximizeWindow()

Sign_in_Landing_title = WebUI.getWindowTitle()

if (Sign_in_Landing_title == 'Cornerstone Demo - Order Status') {
    assert true
} else {
    assert false
}

WebUI.comment('Page title retrived ' + Sign_in_Landing_title)

product_select_Checkout()

customer_Payment()

confirmation_Page()

sign_out()

WebUI.closeBrowser()

def signIn() {
    WebUI.click(findTestObject('Login_Product_Checkout/Page_Cornerstone Demo - Sign in/a_Sign in'))

    WebUI.setText(findTestObject('Login_Product_Checkout/Page_Cornerstone Demo - Sign in/Email_Id'), 'saranya.ranganayaki@gmail.com')

    WebUI.setText(findTestObject('Login_Product_Checkout/Page_Cornerstone Demo - Sign in/Password'), 'Pa55w0rd')

    WebUI.click(findTestObject('Login_Product_Checkout/Page_Cornerstone Demo - Sign in/Sign_in_Button'))
}

def product_select_Checkout() {
    WebUI.click(findTestObject('HomePage_elements/Product_Landing/Shopall_Link'))

    WebUI.scrollToElement(findTestObject('HomePage_elements/Product_Landing/Product_Selection'), 0)

    WebUI.click(findTestObject('HomePage_elements/Product_Landing/Product_Selection'))

    WebUI.click(findTestObject('Common_Elements/Product_Page/Add_to_cart'))

    WebUI.click(findTestObject('Common_Elements/Product_Page/a_Proceed to checkout'))
}

def customer_Payment() {
    WebUI.click(findTestObject('Login_Product_Checkout/Check_Out_Page_RegCustomer/button_Continue'))

    WebUI.setText(findTestObject('Common_Elements/Payment_Details/input_Credit Card Number_ccNumber'), '4111 1111 1111 1111')

    WebUI.setText(findTestObject('Common_Elements/Payment_Details/input_Expiration_ccExpiry'), '01 / 24')

    WebUI.setText(findTestObject('Common_Elements/Payment_Details/input_Name on Card_ccName'), 'Saranya')

    WebUI.setText(findTestObject('Common_Elements/Payment_Details/input_CVV_ccCvv'), '123')

    WebUI.click(findTestObject('Login_Product_Checkout/Check_Out_Page_RegCustomer/button_Place Order'))
}

def confirmation_Page() {
    Order_number = WebUI.getText(findTestObject('Common_Elements/Order_Confirmation_Page/Order_Confirmation_id'))

    WebUI.comment('Page title retrived ' + Order_number)
}

def sign_out() {
    WebUI.click(findTestObject('Login_Product_Checkout/Check_Out_Page_RegCustomer/button_Continue Shopping'))

    WebUI.click(findTestObject('Login_Product_Checkout/Check_Out_Page_RegCustomer/a_Sign out'))
}

