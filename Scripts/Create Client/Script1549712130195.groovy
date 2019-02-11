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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.util.KeywordUtil

//Call Login custom keyword
CustomKeywords.'utility.login.jethlogin'()

WebDriver driver = DriverFactory.getWebDriver()

WebUI.delay(15)

//Click Side Menu Client
WebUI.click(findTestObject('Homepage/ClientMenu'))

WebUI.delay(5)


//Click Add new Client button
WebUI.click(findTestObject('ClientPage/AddClient_btn'))

//Enter ClientName
WebUI.setText(findTestObject('ClientPage/Name'), GlobalVariable.ClientName)

//Enter Address
WebUI.setText(findTestObject('ClientPage/Address_1'), GlobalVariable.ClientAddress)

//Enter Suburb
WebUI.setText(findTestObject('ClientPage/Suburb'), GlobalVariable.ClientSuburb)

//Enter State
WebUI.setText(findTestObject('ClientPage/State'), GlobalVariable.ClientState)

//Enter Postcode
WebUI.setText(findTestObject('ClientPage/Postcode'), GlobalVariable.ClientPost)

//Click Save Client Buttion 
WebUI.click(findTestObject('ClientPage/ClientSave_btn'))


WebUI.delay(10)

//Loop all rows and column to compare text inside

String ExpectedValue = GlobalVariable.ClientName;

System.out.println(ExpectedValue);

WebElement Table = driver.findElement(By.xpath("//*[@id='table-client_wrapper']"))

List < WebElement > rows_table = Table.findElements(By.tagName('tr'))

int rows_count = rows_table.size()

System.out.println(rows_count);

Loop:

for (int row = 1; row < rows_count; row++) {

	List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName('td'))

	int columns_count = Columns_row.size()
	
	System.out.println(columns_count);

	String celltext = Columns_row.get(0).getText()
	
	System.out.println(celltext);
	
// Assert text comparison
	
	if (celltext == '  ' + ExpectedValue) {

	System.out.println("New Client has been successfully Added and visible in Client listing page");	 	
		 	
 break Loop;
	  
   }

	else {
		KeywordUtil.markFailed("New Client is not successfully added and not visible in Client listing page");
		}
   
}


	
	  	








