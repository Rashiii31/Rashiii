package TestScripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLibrary.BaseTest;
import GenericLibrary.WebDriverUtility;
import POMRepository.Books;
import POMRepository.FictionEx;
import POMRepository.ShoppingCartPage;
import POMRepository.Wishlist;
@Listeners(GenericLibrary.ListenersImplementation.class)
public class JewelryTestCase extends BaseTest
{
 @Test	
 public void verify_User_Is_Able_To_Add_Product_To_Wishlist_and_Cart() throws InterruptedException 
 {
	 //navigate jewelry page
	 homePage.getJeweleryLink().click();
	 
	 
	 //validation
	  Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Jewelry");
	  Reporter.log("Jewelry Page displayed",true);
	  
	 Books books_Page=new Books(driver);
	  
	 webdriver_utility=new WebDriverUtility();
	 //sort the jewelry
	 webdriver_utility.selectOptionByVisibleText(books_Page.getSortByDropdown(), "Name: A to Z");
	 Thread.sleep(2000);
	 //sort the quantity size
	 webdriver_utility.selectOptionByVisibleText(books_Page.getDisplayDropdown(), "4");
 
	  
	  //Navigate to Black & White Diamond Heart page
	  List<WebElement> allpdtlink = books_Page.getBooksNamesLink();
	  for (WebElement blackWhiteDiamond : allpdtlink)
	  {
		  if(blackWhiteDiamond.getText().equals("Black & White Diamond Heart"))
			{
				blackWhiteDiamond.click();
				break;
			}
	  }
	  //validation
	  Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Black & White Diamond Heart");
	  Reporter.log("Black & White Diamond Heart is Page displayed",true);
	  
	  FictionEx fictionEx_Page=new FictionEx(driver);
	  fictionEx_Page.getAddtoWishListButton().click();
	  
	  //navigate to wishlist
	  homePage.getWishlistLink().click();
	  
	  //validation
	  Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Wishlist");
	  Reporter.log("wishlist Page displayed",true);
	 
	  
	  Wishlist wishlist_page=new Wishlist(driver);
	  
	//
	  List<WebElement> alladdtocartcheckbox = wishlist_page.getRemoveaddtoCartCheckbox();
	  for (WebElement addtocartallcheckbox : alladdtocartcheckbox) 
	  {
		addtocartallcheckbox.click();
	  }
	  
	  wishlist_page.getAddtoCartButton().click();
	  //navigate to cart
	homePage.getShoppingCartLink().click();

	  //validation
	  Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Shopping Cart");
	  Reporter.log("Shopping Cart Page displayed",true);
		
	  ShoppingCartPage shoppingcart_page=new ShoppingCartPage(driver);	
		//removing the product
	
	  List<WebElement> allchk = shoppingcart_page.getRemoveFromCartCheckbox();
	  for (WebElement allcheckbox : allchk) 
		 {
			allcheckbox.click();
		 }
		 
	  webdriver_utility.captureScreenshot(driver, "sasi");
		 shoppingcart_page.getUpdateShoppingCartButton().click();
		 
		 
	  
	  

	  
	 
 }
}
