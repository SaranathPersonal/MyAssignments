package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	static void dropdownselection(WebElement sourceEle, String value){
		Select dropdownobj = new Select(sourceEle);
		dropdownobj.selectByVisibleText(value);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");

		WebElement userName = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));

//Login		
		userName.sendKeys("demoSalesManager");
		password.sendKeys("crmsfa");
		loginButton.click();

		WebElement cRMSFALink = driver.findElement(By.linkText("CRM/SFA"));
		cRMSFALink.click();

		// Home page-Lead Creation Elements
		
	
		WebElement leadsLink = driver.findElement(By.linkText("Leads"));
		leadsLink.click();
		WebElement createLead = driver.findElement(By.linkText("Create Lead"));
		createLead.click();
		
		
		WebElement companyName = driver.findElement(By.id("createLeadForm_companyName"));
		WebElement firstname = driver.findElement(By.id("createLeadForm_firstName"));
		WebElement lastname = driver.findElement(By.id("createLeadForm_lastName"));
		WebElement sourceEle = driver.findElement(By.id("createLeadForm_dataSourceId"));
		WebElement marketingcampaignEle = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		WebElement ownershipEle = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		WebElement countryEle = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		WebElement createLeadButton = driver.findElement(By.name("submitButton"));

		
		companyName.sendKeys("Testleaf");
		firstname.sendKeys("Saranath");
		lastname.sendKeys("B");
		
		
		dropdownselection(sourceEle,"Employee");
		dropdownselection(marketingcampaignEle,"Pay Per Click Advertising");
		dropdownselection(ownershipEle,"Corporation");
		dropdownselection(countryEle,"India");

	/*	Select sourcedropdown = new Select(sourceEle);
		sourcedropdown.selectByVisibleText("Employee");

		Select marketingcampaigndropdown = new Select(marketingcampaignEle);
		marketingcampaigndropdown.selectByVisibleText("Pay Per Click Advertising");

		Select ownershidropdown = new Select(ownershipEle);
		ownershidropdown.selectByVisibleText("Corporation");

		Select countryDropdown = new Select(countryEle);
		countryDropdown.selectByVisibleText("India");*/

		createLeadButton.click();

		String title = driver.getTitle();
		System.out.println(title);

	}

}
