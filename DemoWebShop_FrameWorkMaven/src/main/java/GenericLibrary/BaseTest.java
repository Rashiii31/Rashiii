package GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import POMRepository.HomePage;
import POMRepository.LoginPage;


public class BaseTest
{
	public DataUtility data_utility=new DataUtility();
	  public WebDriver driver;
	  public static WebDriver listernersDriver;
	  public HomePage homePage;
	  public SoftAssert sa;
	  public WebDriverUtility webdriver_utility;
	  
	  @BeforeClass(alwaysRun = true)
	  public void launchtheBrowser() throws IOException
	  {
		  
		  driver=new ChromeDriver();
		  listernersDriver=driver;
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get(data_utility.getDataFromProperties("url"));
	  }
	  
	  @BeforeMethod(alwaysRun = true)
	  
	  public void performLogin() throws IOException 
	  {
		  homePage =new HomePage(driver);
		  homePage.getLoginLink().click();
		  
		  LoginPage login_page=new LoginPage(driver);
		  login_page.getEmailTextField().sendKeys(data_utility.getDataFromProperties("email"));
		  login_page.getPasswordTextField().sendKeys(data_utility.getDataFromProperties("pwd"));
		  login_page.getLoginButton().click();
		  
	  }
	  
	  @AfterMethod(alwaysRun = true)
	  public void performLogut() 
	  {
		  homePage.getLogoutLink().click();
	  }
	  
	  @AfterClass(alwaysRun = true)
	  public void closetheBrowser()
	  {
		  driver.quit();
	  }

}
