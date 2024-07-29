package POMRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalDownloadsPage 

{
	@FindBy(xpath="//input[@value='Add to cart']")
	 private List<WebElement> addtoCartDigitalButton;
	
	@FindBy(xpath ="//h2[@class='product-title']")
	private List<WebElement>  digitalAllProductsLink;
      
	public DigitalDownloadsPage(WebDriver driver)
    {
 	   PageFactory.initElements(driver, this);
    }

	

	public List<WebElement> getAddtoCartDigitalButton() {
		return addtoCartDigitalButton;
	}



	public List<WebElement> getDigitalAllProductsLink() {
		return digitalAllProductsLink;
	}

	
	
	
	
}
