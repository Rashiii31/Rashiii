package testscript.search;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLibrary.BaseTest;
import POMRepository.DigitalDownloadsPage;
import POMRepository.SearchStorePage;
import POMRepository.ShoppingCartPage;

@Listeners(GenericLibrary.ListenersImplementation.class)
public class BlueJeansTestCase extends BaseTest
{
 @Test
 public void verify_user_Is_Able_to_Add_Jeans_to_the_cart() throws InterruptedException
 {
	 //Search for Jeans
	 homePage.getSearchStoreTextField().sendKeys("Blue Jeans");
	 homePage.getSearchButton().click();
	 
	 //validation
	 Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Search");
	 Reporter.log("Searched Jeans Page is displayed",true);
	 
	 SearchStorePage searchStore_Page=new SearchStorePage(driver);
	 
	 
	 //validation
	 Assert.assertEquals(true, searchStore_Page.getBlueJeanstext().isDisplayed());
	 Reporter.log("Blue Jeans Product is displayed",true);
	 
	 DigitalDownloadsPage digitalDownloads_page=new DigitalDownloadsPage(driver);
	 List<WebElement> cart = digitalDownloads_page.getAddtoCartDigitalButton();
	 for (WebElement addtocart : cart) 
	 {
		addtocart.click();
	 }
	//Navigate shopping cart
	   homePage.getShoppingCartLink().click();
	//validation
	 
	   Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Shopping Cart");
	   Reporter.log("Shopping Cart Page displayed",true);
	 
	 ShoppingCartPage shoppingcart_page=new ShoppingCartPage(driver);
	 
	 //changing the quantity
	   shoppingcart_page.getQtyTextField().clear();
	   Thread.sleep(3000);
	   shoppingcart_page.getQtyTextField().sendKeys("5",Keys.ENTER);
	   Thread.sleep(3000);

	//validation
      Assert.assertEquals(true,shoppingcart_page.getTotalQty().isDisplayed());
      Reporter.log("Qty added",true);
	   
	//removing the product
	
		 List<WebElement> allchk = shoppingcart_page.getRemoveFromCartCheckbox();		 
		 for (WebElement allcheckbox : allchk) 
		 {
			allcheckbox.click();
		 }
		 
		 shoppingcart_page.getUpdateShoppingCartButton().click();
		 Reporter.log("verify_user_Is_Able_to_Add_Jeans_to_the_cart() is pass",true);
		 
		 

 }
}
