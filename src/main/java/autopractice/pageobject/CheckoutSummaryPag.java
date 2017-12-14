package autopractice.pageobject;

import org.openqa.selenium.By;

public class CheckoutSummaryPag {
	public static By bySpanTotalPrice() {
		return By.xpath("//span[@id='total_price']");
	}
	
	public static By byLinkContinueShopping() {
		return By.xpath("//a[@title='Continue shopping']");
	}
}
