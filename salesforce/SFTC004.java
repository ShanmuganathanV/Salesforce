package salesforce;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SFTC004 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(chromeoption);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("leaf@2024");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(3000);
		
		Actions click = new Actions(driver);
		WebElement workTypeGroups = driver.findElement(By.xpath("//span/p[text()='Work Type Groups']"));
		click.moveToElement(workTypeGroups).click().perform();
		Thread.sleep(3000);
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']"));
		searchbox.clear();
		searchbox.sendKeys("Salesforce Automation By Shanmuganathan");
		Thread.sleep(3000);
		JavascriptExecutor Executer = (JavascriptExecutor) driver;
		WebElement table = driver.findElement(By.xpath("//table/tbody/tr/th/span/a[@title='Salesforce Automation By Shanmuganathan']"));
		String text = table.getText();
		if(text.equalsIgnoreCase("Salesforce Automation By Shanmuganathan")) {
			WebElement downicon = driver.findElement(By.xpath("//table/tbody/tr/td/span/div/a"));
			Executer.executeScript("arguments[0].click();",downicon);
		}
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).clear();
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Automation");
		driver.findElement(By.xpath("//button[@aria-label='Group Type']")).click();
		driver.findElement(By.xpath("//span[text()='Capacity']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		WebElement groupname = driver.findElement(By.xpath("//table/tbody/tr/th/span/a[@title='Salesforce Automation By Shanmuganathan']"));
		Executer.executeScript("arguments[0].click();",groupname);
		WebElement Description = driver.findElement(By.xpath("//slot/lightning-formatted-text[text()='Automation']"));
		String desctext = Description.getText();
		System.out.println(desctext);
		if(desctext.equalsIgnoreCase("Automation")) 
		{
			System.out.println("Description is verified ");
		}
		else 
		{
			System.out.println("Description is not matched");
		}
		
		driver.close();
	}

}


