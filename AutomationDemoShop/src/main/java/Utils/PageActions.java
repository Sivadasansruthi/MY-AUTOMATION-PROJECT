package Utils;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Context.Constants;
import Context.DriverManager;



public class PageActions {
	
WebDriver driver;
	
	public PageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickElement(WebElement element) {
		waitUntilVisible(element);
		waitUntilClickable(element);
		element.click();
	}
	
	public void setTextBox(WebElement element, String value) {
		waitUntilVisible(element);
		waitUntilClickable(element);
		element.sendKeys(value);
	}
	
	public void waitUntilVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	
	public void waitUntilClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	
	public void clickElementJavaScript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		waitUntilVisible(element);
		waitUntilClickable(element);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	
	public List<String> getTextContentList(List<WebElement> list) {
		List<String> textContent= new ArrayList<String>();
		for(WebElement listItem : list) {
			textContent.add(getElementText(listItem));
		}
		return textContent;
	}
	
	public void hoverOverItem(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	public void shortWait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForTextPresentInElement(WebElement element, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.textToBePresentInElement(element, value));
	}
	
	public void selectDropdownByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public static String getScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot)DriverManager.getDriver();
		return screenshot.getScreenshotAs(OutputType.BASE64);
	}
	
	

}
