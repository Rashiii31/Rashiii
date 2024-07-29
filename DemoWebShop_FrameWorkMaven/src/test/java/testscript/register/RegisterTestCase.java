package testscript.register;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLibrary.BaseTest;
import POMRepository.RegisterPage;

@Listeners(GenericLibrary.ListenersImplementation.class)
public class RegisterTestCase extends BaseTest
{
	@Test(groups = "functional",dataProvider = "RegisterData")
    public void verify_User_Is_Able_to_Register(String firstName,String lastName,String email,String password,String confirmPassword) throws EncryptedDocumentException, IOException 
	{
	 String modEmail=new Random().nextInt(3000)+email;
	   homePage.getLogoutLink().click();
	   homePage.getRegisterLink().click();
	   //validation
	   Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Register");
	   Reporter.log("Register Page displayed",true);
	   //performing register
	   
	   //Using DataProvider
	    RegisterPage register_page=new RegisterPage(driver);
	    register_page.getGenderRadioButton().click();
	    register_page.getFirstNameTextField().sendKeys(firstName);
	    register_page.getLastNameTextField().sendKeys(lastName);
	    register_page.getEmailTextField().sendKeys(modEmail);
	    register_page.getPasswordTextField().sendKeys(password);
	    register_page.getConfirmPasswordTextField().sendKeys(confirmPassword);
	    register_page.getRegisterButton().click();
	   
	    
//	    register_page.getFirstNameTextField().sendKeys(DataUtility.getDataFromExcel("RegisterData", 1, 0));
//	    register_page.getLastNameTextField().sendKeys(DataUtility.getDataFromExcel("RegisterData", 1, 1));
//	    register_page.getEmailTextField().sendKeys(DataUtility.getDataFromExcel("RegisterData", 1, 2));
//	    register_page.getPasswordTextField().sendKeys(DataUtility.getDataFromExcel("RegisterData", 1, 3));
//	    register_page.getConfirmPasswordTextField().sendKeys(DataUtility.getDataFromExcel("RegisterData", 1, 4));
//	    register_page.getRegisterButton().click();
//	    //validation
	    Assert.assertEquals(driver.getCurrentUrl(),"https://demowebshop.tricentis.com/registerresult/1");
		Reporter.log("verify_User_Is_Able_to_Register is pass",true);
	}
		@DataProvider(name="RegisterData")
		public Object[][] dataSupply() throws EncryptedDocumentException, IOException
		{
		return	data_utility.getMultipleDataFromExcel("RegisterData");
		}
	    
    }

