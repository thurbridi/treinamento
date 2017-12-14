package autopractice.pageobject;

import org.openqa.selenium.By;

public class LayerCart {
	public static By bySpanCartProductsTotal() {
		return By.xpath("//span[@class='ajax_block_products_total']");
	}
	
	public static By bySpanCartShippingTotal() {
		return By.xpath("//span[@class='ajax_cart_shipping_cost']");
	}
	
	public static By bySpanCartTotal() {
		return By.xpath("//span[@class='ajax_block_cart_total']");
	}
	
	public static By bySpanContinueShopping() {
		return By.xpath("//span[@title='Continue shopping']");
	}
	
	public static By byLinkProceedToCheckout() {
		return By.xpath("//a[@title='Proceed to checkout']");
	}
}
