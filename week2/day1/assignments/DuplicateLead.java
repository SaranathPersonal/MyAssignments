package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateLead {

	static void dropdownselection(WebElement sourceEle, String value) {
		Select dropdownobj = new Select(sourceEle);
		dropdownobj.selectByVisibleText(value);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

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
		WebElement firstnamelocal = driver.findElement(By.id("createLeadForm_firstNameLocal"));
		WebElement department = driver.findElement(By.id("createLeadForm_departmentName"));
		WebElement description = driver.findElement(By.id("createLeadForm_description"));
		WebElement primaryemail = driver.findElement(By.id("createLeadForm_primaryEmail"));
		
		
		companyName.sendKeys("Testleaf");
		firstname.sendKeys("Saranath");
		lastname.sendKeys("B");
		firstnamelocal.sendKeys("Saranath");
		department.sendKeys("testing");
		description.sendKeys("Selenium course testing");
		primaryemail.sendKeys("pheonixelan@gmail.com");
		
		createLeadButton.click();

		String title = driver.getTitle();
		System.out.println(title);
		
		WebElement duplicatelead = driver.findElement(By.linkText("Duplicate Lead"));
		duplicatelead.click();
		
		 companyName = driver.findElement(By.id("createLeadForm_companyName"));
		 firstname = driver.findElement(By.id("createLeadForm_firstName"));
		 createLeadButton = driver.findElement(By.name("submitButton"));
		companyName.clear();
		companyName.sendKeys("Organization");
		firstname.clear();
		firstname.sendKeys("testing");
		createLeadButton.click();
		title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
	}

}
