package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFTC003 {
	/*Test Steps:
		1. Login to https://login.salesforce.com
		2. Click on the toggle menu button from the left corner
		3. Click View All and click Work Type Groups from App Launcher
		4. Click on the Dropdown icon in the Work Type Groups tab
		5. Click on New Work Type Group
		6. Enter Work Type Group Name as 'Salesforce Automation by Your Name'
		7.Click save and verify Work Type Group Name"
		*/

	
		public static void main(String[] args) throws InterruptedException {
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--disable-notifications");
			ChromeDriver driver = new ChromeDriver(options);
			driver.get("https://login.salesforce.com/");
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("leaf@2024");
			driver.findElement(By.id("Login")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			Thread.sleep(2000);
			WebElement ele = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
			driver.executeScript("arguments[0].click();", ele);
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[@data-key='chevrondown'])[15]")).click();
			
			Thread.sleep(3000);
			WebElement ele1 = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
			driver.executeScript("arguments[0].click();", ele1);
			Thread.sleep(3000);	
			driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow']/input")).sendKeys("Sales force Automation by Shanmuganathan");
			driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
			Thread.sleep(3000);	
			String verify = driver.findElement(By.xpath("//div[contains(@class,'entityNameTitle')]")).getText();
			if (verify.contains("Shanmuganathan")) {
				System.out.println("Work Type Name Verified Sceecessfully");
			}
			else
				System.out.println("Work Type Name Not Verified");

			}
		

	
}
