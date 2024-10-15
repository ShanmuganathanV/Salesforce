package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SFTC001 {

	public static void main(String[] args) throws InterruptedException {
		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			ChromeDriver driver= new ChromeDriver(options);
			driver.get("https://login.salesforce.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("dilip@testleaf.com");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@2024");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='Login']")).click();
			Thread.sleep(3000);
			// clicking on toggle menu
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			// Clicking on view all
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
			Thread.sleep(3000);
			// clicking Sales
			driver.findElement(By.xpath("//p[text()='Sales']")).click();
			Thread.sleep(5000);
			// clicking opportunities
			WebElement clickableElement1 = driver.findElement(By.xpath("//a/span[text()='Opportunities']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", clickableElement1);
			Thread.sleep(2000);
			// clicking new option
			driver.findElement(By.xpath("//a/div[text()='New']")).click();
			Thread.sleep(2000);
			// Opportunity name
			driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Shanmuganathan");
			Thread.sleep(2000);
			// Amount
			driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys("75000");
			Thread.sleep(3000);
			// Choose the close date today
			driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
			Thread.sleep(3000);
			// CHoose the today
			driver.findElement(By.xpath("//button[text()='Today']")).click();
			Thread.sleep(3000);
			// click on stage
			driver.findElement(By.xpath("//button[@aria-label='Stage']")).click();
			Thread.sleep(3000);
			// click on need analysis
			driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
			Thread.sleep(3000);
			// click on save
			driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
			Thread.sleep(8000);
			// verify the name
			String db = driver.findElement(By.xpath("//*[@slot='primaryField']")).getText();
			if (db.contains("Shanmuganathan")) {
				System.out.println("The Account is created");
			} else {
				System.out.println("The Account is not created");
			}
			driver.close();
		} 

	

}
