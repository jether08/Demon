import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import com.kms.katalon.core.util.KeywordUtil

//Call Login custom keyword
CustomKeywords.'utility.login.jethlogin'()

WebDriver driver = DriverFactory.getWebDriver()

WebUI.delay(15)

//Click App Designer Menu
WebUI.click(findTestObject('Homepage/AppDesigner'))

WebUI.delay(5)


//Click Template Action button
WebUI.click(findTestObject('TemplatePage/Action_btn'))

WebUI.delay(3)

//Click Edit Design in Action button Option
WebUI.click(findTestObject('TemplatePage/EditDesign'))

// Switch to another tab
WebUI.switchToWindowIndex(1)


WebUI.delay(5)

//Click Name of the Template
WebUI.click(findTestObject('TemplatePage/TempName'))

WebUI.delay(5)

int firstdivs = driver.findElements(By.xpath('//*[@class="col-md-12 section-list-on-document"]/div')).size()
System.out.println(firstdivs)


WebUI.delay(5)


WebUI.dragAndDropToObject(findTestObject('TemplatePage/DragSection'), findTestObject('TemplatePage/DropContainer'))

WebUI.delay(3)

//VALIDATIONS:
//Verify that a new field is added in

int Seconddivs = driver.findElements(By.xpath('//*[@class="col-md-12 section-list-on-document"]/div')).size()

System.out.println(Seconddivs)


if(Seconddivs==(firstdivs+1)){
	
		KeywordUtil.markPassed("New Sub Section is added successfuly in Canvas Area");
}

else {
		KeywordUtil.markFailed("New Sub Section is not added in Canvas Area");
		
}

