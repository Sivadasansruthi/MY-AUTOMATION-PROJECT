package com.demowebshop.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.PageActions;

public class ProductPage extends PageActions {

    WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css=".product-title a")
	private List <WebElement> searchedProduct;
	
	@FindBy(xpath="//*[@value='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(css="[value='Go to cart']")
	private WebElement goToCartBtn;
	
	@FindBy(css=".ico-cart .cart-label")
	private WebElement shoppingCartHeader;
	
	@FindBy(css=".ico-cart .cart-qty")
	private WebElement qty;
	
	@FindBy(xpath="//*[@value='Add to cart']/../preceding-sibling::*/span")
	private WebElement priceOfProduct;
	
	@FindBy(css=".product-title a")
	private WebElement searchedProduct2;
	
	@FindBy(css="#add-to-wishlist-button-14")
	private WebElement wishlistbtn;
	
	
	@FindBy(xpath="//a[@class='ico-wishlist']/span[1]")
	private WebElement wishlistlink;
	
	@FindBy(xpath="//td[@class='product']/a")
	private WebElement itemName;
	
	@FindBy(xpath="//tr[@class='cart-item-row']/td[1]/input")
	private WebElement removecheckbox;
	
	@FindBy(xpath="//*[@class='common-buttons']/input[1]")
	private WebElement updatecartBtn;
	
	@FindBy(css=".wishlist-content")
	private WebElement cartUpdateText;
	
	@FindBy(css=".product-title a")
	private WebElement searchedProduct3;
	
	@FindBy(css=".email-a-friend input")
	private WebElement sendEmailBtn;
	
	@FindBy(id ="FriendEmail")
	private WebElement emailTextBox;
	
	@FindBy(name = "send-email")
	private WebElement sendBtn;
	
	@FindBy(xpath="//*[@class='result']")
	private WebElement emailAlertmsg;
	
	
	
	
	
	
	
	
	
	public List<String> validateSearchedItemsAppearAppropriately() {
		return getTextContentList(searchedProduct);
		
	}
	
	public ProductPage addTocart() {
		clickElement(addToCartBtn);
		return this;
	}
	
	public String navigateToCart() {
		String price=getElementText(priceOfProduct);
		waitForTextPresentInElement(qty, "(1)");
		hoverOverItem( shoppingCartHeader);
		clickElement(goToCartBtn);
		return price;
	}
	
	public String getselectedproductText1()
	{
		String text= getElementText(searchedProduct2);
		return text;
	}
	
	
	public void addToWishlist()
	{   
		
		clickElement(searchedProduct2);
		clickElement(wishlistbtn);  
		clickElement(wishlistlink);
	}
	
	public String getselectedproductText2()
	{
		String text= getElementText(itemName);
		return text;
	}
	
	public void removeItem()
	{
		clickElement(removecheckbox);
		clickElement(updatecartBtn);
		
	}
	
	public String getCartUpdateMsg()
	{
		String text= getElementText(cartUpdateText);
		return text;
	}
	
	public void sendEmailToFriend(String friendEmail)
	{
		clickElement(searchedProduct3);
		clickElement(sendEmailBtn);
		setTextBox(emailTextBox, friendEmail);
		clickElement(sendBtn);
	}
	
	public String getEmailAlertMsg()
	{
		String text= getElementText(emailAlertmsg);
		return text;
	}
		
		
	
	
	

	
	
	
	
	
	
}
