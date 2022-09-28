package PruebaIV;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class PruebaIV {
	
	WebDriver driver;
	
	By IniciarSesion = By.className("UserInfo-module_info__name__29Sjz");
	By Email = By.id("testId-cc-login-form-email-input");
	By Password = By.id("testId-cc-login-form-password-input");
	By Enter = By.id("testId-cc-login-form-submit");
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.falabella.com.co/falabella-co");
  }
  
  
  @Test(dataProvider = "authenticationData")
  public void Login(String email, String password) {
	  if(driver.findElement(IniciarSesion).isDisplayed()) {
		  driver.findElement(IniciarSesion).click();
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.presenceOfElementLocated(Email));
		  
		  driver.findElement(Email).sendKeys(email);
		  driver.findElement(Password).sendKeys(password);
		  driver.findElement(Enter).click();
	  }
  }

  
  @DataProvider (name = "authenticationData")
  public Object[][] getData() {
	  Object[][] data = new Object[2][2];
      
      data[0][0] = "ejemplo@hotmail.com";
      data[0][1] = "*******";
      data[1][0] = "ejemplo@hotmail.com";
      data[1][1] = "*******";
      
      return data;
  }
  

  @AfterClass
  public void afterClass() {
  }

}
