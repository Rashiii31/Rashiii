package testscript.books;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLibrary.BaseTest;
import POMRepository.Books;
import POMRepository.FictionEx;
import POMRepository.Wishlist;

@Listeners(GenericLibrary.ListenersImplementation.class)
public class WishlistTestCase extends BaseTest
{
  @Test(groups = "integration")
  public void verify_User_Is_Able_To_Add_Product_To_Wishlist() throws InterruptedException 
  {
	  homePage.getBooksLink().click();
	  //validation
	  Thread.sleep(2000);
	  Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books");
	  Reporter.log("books Page is displayed",true);
	  
		
	  //navigate to books
	  Books books_page=new Books(driver);
	  List<WebElement> allbookslink = books_page.getBooksNamesLink();
	  for (WebElement allbooks : allbookslink) 
	    {
			if(allbooks.getText().equals("Fiction EX"))
			{
				allbooks.click();
				break;
			}
		}
	  //validation
	  Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Fiction EX");
	  Reporter.log("fiction ex books Page displayed",true);
	  //navigate to fictionex page
			  FictionEx fiction_page=new FictionEx(driver);
	  String expectedtext = fiction_page.getFictionExText().getText();
	  fiction_page.getAddtoWishListButton().click();
	  
	  homePage.getWishlistLink().click();
	  //validation
	  Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Wishlist");
	  Reporter.log("wishlist Page displayed",true);
	 
	  driver.navigate().refresh();
	  
	  Wishlist wishlist_page=new Wishlist(driver);
	  String actualtext = wishlist_page.getFictionExWishListText().getText();
	  //validation
	  
		  Assert.assertEquals(actualtext, expectedtext);
		  Reporter.log("verify_User_Is_Able_To_Add_Product_To_Wishlist is pass",true);
		  
		  
	  //remove the products
	  List<WebElement> allremovecheckbox = wishlist_page.getRemoveBooksFromcart();
	  for (WebElement allchecbox : allremovecheckbox) 
	  {
		allchecbox.click();
	   }
	  wishlist_page.getUpdateWishlistButton().click();
	  
	  
  }
}
