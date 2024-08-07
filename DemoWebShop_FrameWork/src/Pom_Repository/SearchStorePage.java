package Pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchStorePage 
{
	@FindBy(xpath ="//input[@class='search-text valid']")
	 private WebElement searchKeywordTextfield;
   
   @FindBy(xpath = "//h2[@class='product-title']//a[text()='Blue Jeans']")
	 private WebElement BlueJeanstext;
   
   public SearchStorePage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }

	public WebElement getSearchKeywordTextfield() {
		return searchKeywordTextfield;
	}

	public WebElement getBlueJeanstext() {
		return BlueJeanstext;
	}


}
