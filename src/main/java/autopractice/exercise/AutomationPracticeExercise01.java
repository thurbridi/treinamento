package autopractice.exercise;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.CatalogPag;
import autopractice.pageobject.CheckoutSummaryPag;
import autopractice.pageobject.LayerCart;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.ProductPag;
import autopractice.pageobject.TopMenuDressesPag;
import autopractice.pageobject.TopMenuPag;
import autopractice.pageobject.TopMenuTshirtsPag;

@RunWith(WebDriverRunner.class)
public class AutomationPracticeExercise01 {
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void run() {
		// Homepage
		WebDriverManager.acessar(AutomationPracticePag.url);
		
		WebDriverManager.moveMouseTo(TopMenuPag.byLiDresses());
		WebDriverManager.waitVisibleElement(TopMenuDressesPag.byLinkSummerDresses()).click();
		
		// Summer Dresses page
		WebDriverManager.waitVisibleElement(CatalogPag.byViewList()).click();
		WebDriverManager.waitVisibleElement(ProductList.product(3).byButtonMore()).click();
		
		// Product page
		WebDriverManager.waitVisibleElement(ProductPag.byButtonPlus()).click();
		WebDriverManager.waitVisibleElement(ProductPag.byButtonPlus()).click();
		ProductPag.selectSize("M");
		ProductPag.selectColor("color_15");
		WebDriverManager.waitVisibleElement(ProductPag.byAddToCartButton()).click();
		
		// Cart Layer
		String price = WebDriverManager.getTextOfVisibleElementsWith(LayerCart.bySpanCartTotal()).get(0);
		System.out.println(price);
		WebDriverManager.waitVisibleElement(LayerCart.bySpanContinueShopping()).click();
		
		// Product page
		WebDriverManager.moveMouseTo(TopMenuPag.byLiTShirt());
		WebDriverManager.waitVisibleElement(TopMenuTshirtsPag.byLinkTshirts()).click();
		
		// T-shirts page
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCart()).click();
		
		// Cart Layer
		WebDriverManager.waitVisibleElement(LayerCart.byLinkProceedToCheckout()).click();

		// Checkout Summary
		price = WebDriverManager.getTextOfVisibleElementsWith(CheckoutSummaryPag.bySpanTotalPrice()).get(0);
		System.out.println(price);
		WebDriverManager.waitVisibleElement(CheckoutSummaryPag.byLinkContinueShopping()).click();
		
		// T-shirts page
		List<WebElement> visited_items = WebDriverManager.waitVisibleElements(CatalogPag.LinkViewedProducts());
		for(WebElement item : visited_items) {
			System.out.println(item.getAttribute("title"));
		}
		
		Delay.of(5000);
	}	
}
