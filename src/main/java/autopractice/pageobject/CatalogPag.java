package autopractice.pageobject;

import org.openqa.selenium.By;

public class CatalogPag {

	public static String xpathPriceRangeContainer = "//div[@class='layered_slider_container']";

	public static By bySpanPriceRange() {
		return By.id("layered_price_range");
	}

	public static By byLeftPriceRange() {
		String xpath = xpathPriceRangeContainer + "//a[1]";
		return By.xpath(xpath);
	}

	public static By byRightPriceRange() {
		String xpath = xpathPriceRangeContainer + "//a[2]";
		return By.xpath(xpath);
	}

}
