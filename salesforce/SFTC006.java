package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SFTC006 {
	/*
	 * Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Legal Entities from App Launcher
4. Click on the legal Entities tab 
5. Search the Legal Entity 'Salesforce Automation by Your Name'
6. Click on the Dropdown icon and Select Edit
7.Enter the Company name as 'Testleaf'.
8. Enter Description as 'SalesForce'.
9.Select Status as 'Active'
10. Click on Save and Verify Status as Active"
	 */

	public static void main(String[]args) throws InterruptedException {

			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			ChromeDriver driver= new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://login.salesforce.com/");
			driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@2024");
			driver.findElement(By.xpath("//input[@id='Login']")).click();
			Thread.sleep(3000); 
			WebElement bb=driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
			driver.executeScript("arguments[0].click();", bb);
			Thread.sleep(2000);
			WebElement yy=driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")); 
			driver.executeScript("arguments[0].click();", yy);
			Thread.sleep(2000);
			WebElement ab = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
			driver.executeScript("arguments[0].click();", ab);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Salesforce Automation by Shanmuganathan"+Keys.ENTER);
			Thread.sleep(3000);
			WebElement ash = driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']"));
			driver.executeScript("arguments[0].click();", ash);
			driver.findElement(By.xpath("//a[@title='Edit']")).click(); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("Testleaf");
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforce");
			Thread.sleep(3000);
			WebElement cd=driver.findElement(By.xpath("//button[@id='combobox-button-212']")); 
			driver.executeScript("arguments[0].click();", cd);
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[@class='slds-media__body'])[2]")).click(); 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@name='SaveEdit']")).click(); 
			WebElement dd=driver.findElement(By.xpath("//a[text()='Salesforce Automation by Sabin Jone']")); 
			driver.executeScript("arguments[0].click();", dd);
			
			String status=	driver.findElement(By.xpath("(//p[@class='fieldComponent slds-text-body--regular slds-show_inline-block slds-truncate'])[2]")).getText(); 
			if(status.contains("Active"))
			{
				System.out.println("Status Verified sucessfully");
			}
			else
			{		
				System.out.println("Status Not Active");
			}

		}
}
