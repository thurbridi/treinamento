package autopractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.WebDriverManager;


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
	
	public static By byViewList() {
		return By.xpath("//i[@class='icon-th-list']/..");
	}
	
	public static By byViewGrid() {
		return By.xpath("//i[@class='icon-th-large']/..");
	}
	
	public static By byFormCompare() {
		return By.xpath("//form[@class='compare-form']");
	}
	
	public static WebElement FormCompare(int index) {
		return WebDriverManager.getWebDriver().findElements(byFormCompare()).get(index);
	}
	
	public static String FormCompareCountValue(int index) {
		WebElement compare = FormCompare(index);
		return compare.findElement(By.name("compare_product_count")).getAttribute("value");
	}
	
	public static By LinkViewedProducts() {
		return By.xpath("//div[@id='viewed-products_block_left']//a[@class='product-name']");
	}
}
