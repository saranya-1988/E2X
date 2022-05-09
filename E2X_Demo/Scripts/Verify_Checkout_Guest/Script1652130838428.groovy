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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://cornerstone-light-demo.mybigcommerce.com/')

WebUI.click(findTestObject('Object Repository/Test/Page_Cornerstone Demo/button_Reject all'))

WebUI.click(findTestObject('Object Repository/Test/Page_Cornerstone Demo/a_Shop All'))

WebUI.click(findTestObject('Object Repository/Test/Page_Shop All - Page 1 - Cornerstone Demo/a_Smith Journal 13'))

WebUI.click(findTestObject('Object Repository/Test/Page_Smith Journal 13 - Cornerstone Demo/input_Increase Quantity of Smith Journal 13_1d79fa'))

WebUI.click(findTestObject('Object Repository/Test/Page_Smith Journal 13 - Cornerstone Demo/a_Proceed to checkout'))

WebUI.setText(findTestObject('Object Repository/Test/Page_Cornerstone Demo/input_Email Address_email'), 'test@gmail.com')

WebUI.click(findTestObject('Test/Page_Cornerstone Demo/label_Yes, I agree with the privacy policy'))

WebUI.modifyObjectProperty(findTestObject('Object Repository/Test/Page_Cornerstone Demo/label_Yes, I agree with the privacy policy'), 
    'privacyPolicy', '', 'true', false)

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Test/Page_Cornerstone Demo/button_Continue as guest'))

WebUI.click(findTestObject('Object Repository/Test/Page_Cornerstone Demo/a_Continue as guest'))

WebUI.delay(2)

WebUI.setText(findTestObject('Shipping_Address/FirstName'), 'test')

WebUI.setText(findTestObject('Shipping_Address/LastName'), 'test')

WebUI.setText(findTestObject('Shipping_Address/Address'), '34,newstreet')

WebUI.setText(findTestObject('Shipping_Address/City'), 'Testing')

WebUI.setText(findTestObject('Shipping_Address/Postal_Code'), 'TR06NP')

WebUI.setText(findTestObject('Shipping_Address/Phone_Number'), '07880679799')

WebUI.delay(2)

WebUI.click(findTestObject('Shipping_Address/Continue'))

WebUI.setText(findTestObject('Common_Elements/Payment_Details/input_Credit Card Number_ccNumber'), '4111 1111 1111 1111')

WebUI.setText(findTestObject('Common_Elements/Payment_Details/input_Expiration_ccExpiry'), '01 / 24')

WebUI.setText(findTestObject('Common_Elements/Payment_Details/input_Name on Card_ccName'), 'Saranya')

WebUI.setText(findTestObject('Common_Elements/Payment_Details/input_CVV_ccCvv'), '123')

WebUI.click(findTestObject('Login_Product_Checkout/Check_Out_Page_RegCustomer/button_Place Order'))

Order_number = WebUI.getText(findTestObject('Common_Elements/Order_Confirmation_Page/Order_Confirmation_id'))

WebUI.comment('Page title retrived ' + Order_number)

WebUI.closeBrowser()

