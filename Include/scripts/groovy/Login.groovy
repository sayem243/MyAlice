import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Login {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Open the application")
	def Open_the_application() {
		WebUI.openBrowser("")
		WebUI.navigateToUrl("https://myalice-automation-test.netlify.app/")
		WebUI.maximizeWindow()
	}

	@When("Verify that the login page is displayed")
	def I_check_for_the_value_in_step() {
		
		def actual_title = WebUI.getWindowTitle()
		def expected_title= "React App"
    	WebUI.verifyEqual(actual_title, "React App")
		
	}
	

	@Then("Enter valid login credentials")
	def I_verify_the_status_in_step() {
		WebUI.setText(findTestObject('Object Repository/Myalice_Login/text_username'), 'testuser')
		WebUI.setText(findTestObject('Object Repository/Myalice_Login/text_password'), 'password')
	}
	
	@And("Click the 'Login' button")
	def Click_the_Login_button() {
		WebUI.click(findTestObject('Object Repository/Myalice_Login/btn_login'))
	}	
	
	
	@Then("Verify that the user is redirected to the manga search page")
	def  Then_Verify_that_the_user_is_redirected_to_the_manga_search_page() {
		
		WebUI.verifyTextPresent("Manga You Should Read", false)
		WebUI.delay(1)
//		WebUI.closeBrowser()
	}
	
	
	@Given("Ensure the user is on the manga search page")
	def Ensure_the_user_is_on_the_manga_search_page() {
		Then_Verify_that_the_user_is_redirected_to_the_manga_search_page()
	}
	
	@And("Enter the search term 'Naruto' into the search box")
	def Enter_the_search_term_Naruto_into_the_search_box() {
		WebUI.click(findTestObject('Object Repository/Myalice_search/text_search_'))
		WebUI.setText(findTestObject("Object Repository/Myalice_search/text_search_"), "Naruto")
	}
	
	@When("Click the 'Search' button")
	def Click_the_Search_button() {
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Myalice_search/btn_search'))
	}
	
	@Then("Verify that manga cards with the name 'Naruto' are displayed")
	def Verify_that_manga_cards_with_the_name_Naruto_are_displayed() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Myalice_item/item_naruto'), 1)
		WebUI.delay(1)
		WebUI.verifyTextPresent("A young ninja strives to become the strongest in his village and earn the title of Hokage.", false, FailureHandling.STOP_ON_FAILURE)
	}
	
	@And("Enter the search term 'One Piece' into the search box")
	def Enter_the_search_term_One_Piece_into_the_search_box() {

		
		WebUI.clearText(findTestObject('Object Repository/Myalice_search/text_search_'))
		WebUI.deleteAllCookies()
		WebUI.setText(findTestObject("Object Repository/Myalice_search/text_search_"), "")
		WebUI.click(findTestObject('Object Repository/Myalice_Login/btn_search_2'))		
		WebUI.setText(findTestObject("Object Repository/Myalice_search/text_search_"), "One Piece")
	}
	
	@And("Verify that manga cards with the name 'One Piece' are displayed")
	def Verify_that_manga_cards_with_the_name_One_Piece_are_displayed() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Myalice_item/item_oneP'), 1)
		WebUI.delay(1)
		WebUI.verifyTextPresent("A pirate named Monkey D. Luffy embarks on a quest to find the legendary treasure One Piece.", false, FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(1)
		WebUI.verifyTextPresent("One Piece", false)
		
	}
	
	@And("Enter the search term 'Seven Deadly Sins' into the search box")
	def Enter_the_search_term_Seven_Deadly_Sins_into_the_search_box() {
		
	}
	
	@And("Enter a search term that returns no results  'No manga found'")
	def Enter_a_search_term_that_returns_no_results_No_manga_found() {
		WebUI.clearText(findTestObject('Object Repository/Myalice_search/text_search_'))
		WebUI.setText(findTestObject("Object Repository/Myalice_search/text_search_"), "No manga found")
	}
	
	@Then("Verify that a 'No manga found' message is displayed")
	def Verify_that_a_No_manga_found_message_is_displayed() {
		WebUI.verifyTextPresent("No manga found", false, FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(1)
		WebUI.closeBrowser()
	}
	
	@When("Click the 'Details' link on a manga card")
	def Click_the_Details_link_on_a_manga_card() {
		WebUI.click(findTestObject('Object Repository/Myalice_item/details_item_one'))
	}
	
	@And("Verify that the modal appears and displays the correct manga information")
	def Verify_that_the_modal_appears_and_displays_the_correct_manga_information() {
		

		def attribute = WebUI.getAttribute(findTestObject('Object Repository/Myalice_item/Page_React App/img_Details_w-full h-48 object-cover rounded-lg mb-4'), 'src')
		WebUI.verifyMatch(attribute, 'https://res.cloudinary.com/emerging-it/image/upload/v1724240584/mangaImage/lyj3i7qwtp3f2qz59so1.jpg', false)
		WebUI.delay(1)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Myalice_item/Page_React App/h3_Attack on Titan'), 1)
		WebUI.verifyTextPresent("Humanity fights for survival against giant humanoid Titans that have brought civilization to the brink of extinction.", false, FailureHandling.STOP_ON_FAILURE)
		
	}
	
	@And("Click the 'Close' button on the modal")
	def Click_the_Close_button_on_the_modal() {
		WebUI.click(findTestObject('Object Repository/Myalice_item/btn_close'))
	}
	
	@Then("Verify that the modal is closed and no longer visible")
	def Verify_that_the_modal_is_closed_and_no_longer_visible() {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Myalice_item/btn_close'), 20)
	}
	
	
	
}