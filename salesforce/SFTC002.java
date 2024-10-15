package salesforce;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFTC002 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * Testcase 2(Edit):
		 * 
		 * 1.Launch the browser. 2.Load the URL: https://login.salesforce.com. 3.Enter
		 * the username as dilip@testleaf.com. 4.Enter the password as August@2024.
		 * 5.Click on the Login button. 6.Click on the toggle menu button in the left
		 * corner. 7.Click on "View All" and select "Sales" from the App Launcher.
		 * 8.Click on the "Opportunity" tab. 9.Search for the Opportunity 'Salesforce
		 * Automation by Your Name'. 10.Click on the Dropdown icon and select 'Edit'.
		 * 11.Choose the close date as Tomorrow's date. 12.Select 'Stage' as 'Perception
		 * Analysis'. 13.Select 'Delivery/Installation Status' as 'In Progress'.
		 * 14.Enter Description as 'SalesForce'. 15.Click on 'Save' and verify the Stage
		 * as 'Perception Analysis'.
		 */
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
				// 1.clicking on toggle menu
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				Thread.sleep(3000);
				// 2.Clicking on view all
				driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
				Thread.sleep(3000);
				// 2.clicking Sales
				driver.findElement(By.xpath("//p[text()='Sales']")).click();
				Thread.sleep(5000);
				// 4.clicking opportunities
				WebElement clickableElement1 = driver.findElement(By.xpath("//a/span[text()='Opportunities']"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", clickableElement1);
				Thread.sleep(2000);
				// 5.Search for the opportunity
				driver.findElement(By.xpath("//input[@name=\"Opportunity-search-input\"]")).sendKeys("Salesforce Automation by Shanmuganathan" + Keys.ENTER);
				Thread.sleep(2000);
	
				// 6.click on edit dropdown
				driver.findElement(By.xpath("//span/div/a")).click();
				Thread.sleep(2000);
	
				// 7.Click on the Dropdown icon and select 'Edit'
				WebElement clickdropdown = driver.findElement(By.xpath("//div[text()='Edit']"));
				executor.executeScript("arguments[0].click();", clickdropdown);
				Thread.sleep(2000);
	
				// 8.Choose the close date as Tomorrow's date
				LocalDate tomorrow = LocalDate.now().plusDays(1);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String tomorrowDate = tomorrow.format(formatter);
				WebElement closeDateField = new WebDriverWait(driver, Duration.ofSeconds(10))
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='CloseDate']")));
				closeDateField.clear();
				closeDateField.sendKeys(tomorrowDate);
	
				// 9.Select 'Stage' as 'Perception Analysis'\
				driver.findElement(By.xpath("//button[@aria-label='Stage']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
				Thread.sleep(3000);
	
				// 10.Select 'Delivery/Installation Status' as 'In Progress'
				WebElement Deliverystatus = driver.findElement(By.xpath(
						"(//button[@class='slds-combobox_input slds-input_faux fix-slds-input_faux slds-combobox_input-value'])[4]"));
				executor.executeScript("arguments[0].click();", Deliverystatus);
	
				driver.findElement(By.xpath("//span[text()='In progress']")).click();
				Thread.sleep(3000);
				// 11.Enter Description as 'SalesForce'
				driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("SalesForce");
				Thread.sleep(3000);
				// 12.Click on 'Save' and verify the Stage as 'Perception Analysis'
				driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
				
				driver.close();
			
		}
	
	}
