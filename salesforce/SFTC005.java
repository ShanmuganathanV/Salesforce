package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SFTC005 {
	/*
	 * Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Legal Entities from App Launcher
4. Click on the Dropdown icon in the legal Entities tab
5. Click on New Legal Entity
6. Enter Name as 'Salesforce Automation by Your Name'
7.Click save and verify Legal Entity Name"
	 */
	
		
		public static void main(String[] args) throws InterruptedException {

		        ChromeOptions options = new ChromeOptions();
		        options.addArguments("--disable-notifications");
				ChromeDriver driver= new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get("https://login.salesforce.com/");
				driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@2024");
				driver.findElement(By.xpath("//input[@id='Login']")).click();
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				Thread.sleep(2000);	
				driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
				Thread.sleep(2000);	
				WebElement dd=driver.findElement(By.xpath("//p[text()='Legal Entities']"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", dd);
				Thread.sleep(2000);	
				WebElement ee=driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[14]"));
				executor.executeScript("arguments[0].click();", ee);
				Thread.sleep(2000);	
				WebElement ff=driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
				executor.executeScript("arguments[0].click();", ff);
				Thread.sleep(2000);	
				driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Walter White");
				driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
				Thread.sleep(2000);	
				String verify=driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-text")).getText();
	            if(verify.contains("Salesforce Automation by Shanmuganathan"))
		     	{			
				System.out.println("Legal Entity Name verified successfully");
				}
	            else
			    {			
				System.out.println("Legal Entity Name Not Found");
			    }				
		}	
	}

