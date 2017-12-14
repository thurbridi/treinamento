package autopractice.pageobject;

import org.openqa.selenium.By;

import core.WebDriverManager;

public class ProductPag {
	public static By byButtonPlus() {
		return By.xpath("//i[@class='icon-plus']/..");
	}
	
	public static By byButtonMinus() {
		return By.xpath("//i[@class='icon-minus']/..");
	}
	
	public static By byAddToCartButton() {
		return By.xpath("//p[@id='add_to_cart']/button");
	}	
	
	public static By byDivProductAttributes() {
		return By.xpath("//div[@class='product_attributes clearfix']");
	}
	
	public static By byUlColorToPickList() {
		return By.xpath("//ul[@id='color_to_pick_list']");
	}	
	
	public static void selectSize(String size) {
		WebDriverManager.waitVisibleElement(By.xpath("//div[@id='attributes']//select/..")).click();
		WebDriverManager.waitVisibleElement(By.xpath("//div[@id='attributes']//select/option[@title='" + size + "']")).click();
	}
	
	public static void selectColor(String color_id) {
		WebDriverManager.waitVisibleElement(By.xpath("//ul[@id='color_to_pick_list']//a[@id='" + color_id + "']")).click();
	}
}
