package seleniumbasics;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingWebElementCommands extends Base{
	
	public void verifyWebElement() 
	{
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement messagebox = driver.findElement(By.id("single-input-field"));
		messagebox.sendKeys("test message");
		
		WebElement showbutton = driver.findElement(By.id("button-one"));
		System.out.println(showbutton.isDisplayed());
		System.out.println(showbutton.isEnabled());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(showbutton)); //explicit wait
		
		Wait<WebDriver>fluent=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		fluent.until(ExpectedConditions.elementToBeClickable(showbutton)); //fluent wait
		showbutton.click();
		
		WebElement yourmessage = driver.findElement(By.id("message-one"));
		System.out.println(yourmessage.getText());
		
		messagebox.clear();
			
	}

	public static void main(String[] args) {
		HandlingWebElementCommands commands= new HandlingWebElementCommands();
		commands.browserLaunch();
		commands.verifyWebElement();
		
	}

}
