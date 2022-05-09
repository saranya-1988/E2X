package productCheckout

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class productCheckout {
	//@Product_Checkout
	def Product_selection_Checkout() {
		WebUI.click(findTestObject('HomePage_elements/Product_Landing/Shopall_Link'))

		WebUI.scrollToElement(findTestObject('HomePage_elements/Product_Landing/Product_Selection'), 0)

		WebUI.click(findTestObject('HomePage_elements/Product_Landing/Product_Selection'))

		WebUI.click(findTestObject('Common_Elements/Product_Page/Add_to_cart'))

		WebUI.click(findTestObject('Common_Elements/Product_Page/a_Proceed to checkout'))

		WebUI.delay(2)
	}
}
