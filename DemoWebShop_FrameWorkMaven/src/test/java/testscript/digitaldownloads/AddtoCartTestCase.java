package testscript.digitaldownloads;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLibrary.BaseTest;
import POMRepository.DigitalDownloadsPage;
import POMRepository.ShoppingCartPage;
@Listeners(GenericLibrary.ListenersImplementation.class)
public class AddtoCartTestCase extends BaseTest
{
  @Test
  public void verify_User_Is_Able_To_Add_the_Products_to_the_cart() throws InterruptedException 
  {
	  //navigate to digital downloads page
	  homePage.getDigitalDownloadsLink().click();
	  //validation
	  Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Digital downloads");
	  Reporter.log("Digital downloads Page displayed",true);
	 
		 //products added to cart
		 DigitalDownloadsPage digital_downloads = new DigitalDownloadsPage(driver);
		 List<WebElement> addtocartall = digital_downloads.getAddtoCartDigitalButton();
		 int expectedresult = addtocartall.size();
		 for (WebElement addtocartallpdt : addtocartall) 
		 {
			addtocartallpdt.click();
			Thread.sleep(2000);	
		  }
		
		 //Navigate shopping cart
		 homePage.getShoppingCartLink().click();
		 //validation
		 
		 Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Shopping Cart");
		 Reporter.log("Shopping Cart Page displayed",true);
		 
		 ShoppingCartPage shoppingcart_page=new ShoppingCartPage(driver);	
			 //removing the product
		
			 List<WebElement> allchk = shoppingcart_page.getRemoveFromCartCheckbox();
			 int actualresult = allchk.size();
			 //validation
			 if(expectedresult==actualresult)
			 {
				 Reporter.log("verify_User_Is_Able_To_Add_the_Products_to_the_cart is pass",true);
				 
			 }
			 else
			 {
				 Reporter.log("verify_User_Is_Able_To_Add_the_Products_to_the_cart is fail",true);
			 }
			 for (WebElement allcheckbox : allchk) 
			 {
				allcheckbox.click();
			 }
			 
			 shoppingcart_page.getUpdateShoppingCartButton().click();
			 
			
		
  }
}
