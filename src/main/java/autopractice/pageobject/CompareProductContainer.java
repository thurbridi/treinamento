package autopractice.pageobject;

import org.openqa.selenium.By;

import core.WebDriverManager;

public class CompareProductContainer {
	private String startXpath;
	private String imgBlock;
	private String productName;
	private String priceContainer;
	private String productDescription;
	private String buttonContainer;
	
	public CompareProductContainer(String xpath) {
		this.startXpath = xpath;
		this.imgBlock = xpath + "/div[contains(@class, 'product-image-block')]";
		this.productName = xpath + "//a[contains(@class, 'product-name')]";
		this.priceContainer = xpath + "/div[contains(@class, 'price-container')]";
		this.productDescription = xpath + "/div[contains(@class, 'product_desc')]";
		this.buttonContainer = xpath + "//div[contains(@class, 'button-container')]";
	}
	
	public By by() {
		return By.xpath(this.startXpath);
	}
	
	public By byImg() {
		return By.xpath(this.imgBlock + "//img");
	}
	
	public By byLinkName() {
		return By.xpath(productName);
	}
	
	public By bySpanPrice() {
		return By.xpath(this.priceContainer + "//span[@class='price product-price']");
	}
	
	public By bySpanOldPrice() {
		return By.xpath(this.priceContainer + "//span[@class='old-price product-price']");
	}
	
	public By bySpanPricePercentReduction() {
		return By.xpath(this.priceContainer + "//span[@class='price-percent-reduction']");
	}
	
	public By byProductDesc() {
		return By.xpath(this.productDescription);
	}
	
	public By byButtonAddToCart() {
		return By.xpath(this.buttonContainer + "//a[contains(@class, 'ajax_add_to_cart_button')]");
	}
	
	public By byButtonView() {
		return By.xpath(this.buttonContainer + "//a[contains(@class, 'lnk_view')]");
	}
	
	public String productId() {
		return WebDriverManager.getWebDriver().findElement(byButtonAddToCart()).getAttribute("data-id-product");
	}
}
