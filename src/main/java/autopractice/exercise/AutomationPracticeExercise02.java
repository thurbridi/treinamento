package autopractice.exercise;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.CatalogPag;
import autopractice.pageobject.CompareProductList;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class AutomationPracticeExercise02 {
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void compareShouldAddInOrder() {
		List<String> catalogSources = new ArrayList<String>();
		List<String> compareSources = new ArrayList<String>();
		
		// Ir para catálogo 'Women'
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiWomen());
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		
		// Adicionar primeiro, segundo e quarto item
		WebDriverManager.waitVisibleElement(CatalogPag.byViewList()).click();
		
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		Delay.of(500);
		catalogSources.add(ProductList.product(1).productId());		
		
		WebDriverManager.waitVisibleElement(ProductList.product(2).byButtonAddToCompare()).click();
		Delay.of(500);
		catalogSources.add(ProductList.product(2).productId());		
		
		WebDriverManager.waitVisibleElement(ProductList.product(4).byButtonAddToCompare()).click();
		Delay.of(500);
		catalogSources.add(ProductList.product(4).productId());
		
		// Ir para compare e verificar ordem
		WebDriverManager.waitVisibleElement(CatalogPag.byFormCompare()).click();
		compareSources.add(CompareProductList.product(1).productId());
		compareSources.add(CompareProductList.product(2).productId());
		compareSources.add(CompareProductList.product(3).productId());
		
		collector.checkThat(compareSources, org.hamcrest.Matchers.equalTo(catalogSources));
	}
	
	@Test
	public void compareShouldAddInOrder2() {
		List<String> catalogSources = new ArrayList<String>();
		List<String> compareSources = new ArrayList<String>();
		
		// Ir para catálogo 'Women'
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiWomen());
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		
		// Adicionar quarto, primeiro e segundo item
		WebDriverManager.waitVisibleElement(CatalogPag.byViewList()).click();
		
		WebDriverManager.waitVisibleElement(ProductList.product(4).byButtonAddToCompare()).click();
		Delay.of(500);
		catalogSources.add(ProductList.product(4).productId());		
		
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		Delay.of(500);
		catalogSources.add(ProductList.product(1).productId());		
		
		WebDriverManager.waitVisibleElement(ProductList.product(2).byButtonAddToCompare()).click();
		Delay.of(500);
		catalogSources.add(ProductList.product(2).productId());
		
		// Ir para compare e verificar ordem
		WebDriverManager.waitVisibleElement(CatalogPag.byFormCompare()).click();
		compareSources.add(CompareProductList.product(1).productId());
		compareSources.add(CompareProductList.product(2).productId());
		compareSources.add(CompareProductList.product(3).productId());
		
		collector.checkThat("Because of reasons", compareSources, Matchers.equalTo(catalogSources));
	}
	
	@Test
	public void addToCompareShouldChangeIcon() {
		int productIndex = 1;
		
		// Ir para o catálogo 'Women'
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiWomen());
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		
		// Clicar em 'Add to Compare'
		WebDriverManager.waitVisibleElement(CatalogPag.byViewList()).click();
		
		WebElement productAddToCompare = WebDriverManager.getWebDriver().findElement(ProductList.product(productIndex).byButtonAddToCompare());
		productAddToCompare.click();
		Delay.of(500);
		
		// Verificar o atributo 'class'
		collector.checkThat(productAddToCompare.getAttribute("class"), Matchers.equalTo("add_to_compare checked"));
		
		// Clicar em 'Compare'
		WebDriverManager.waitVisibleElement(CatalogPag.byFormCompare()).click();
		
		// Ir para catálogo 'Women'
		WebDriverManager.moveMouseTo(TopMenuPag.byLiWomen());
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		productAddToCompare = WebDriverManager.getWebDriver().findElement(ProductList.product(productIndex).byButtonAddToCompare());
		
		// Verificar o atributo 'class'
		collector.checkThat(productAddToCompare.getAttribute("class"), Matchers.equalTo("add_to_compare checked"));
	}
	
	@Test
	public void compareShouldShowCorrectQuantity() {
		// Ir para o catálogo 'Women'
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiWomen());
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		
		// Clicar em 'Add to Compare'
		WebDriverManager.waitVisibleElement(CatalogPag.byViewList()).click();
		
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		Delay.of(500);
		
		// Verificar contador dos botões compare
		String compareQuantity = CatalogPag.formCompareCountValue(0);
		collector.checkThat(compareQuantity, Matchers.equalTo("1"));
		
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		Delay.of(500);
		
		compareQuantity = CatalogPag.formCompareCountValue(0);
		
		collector.checkThat(compareQuantity, Matchers.equalTo("0"));
		
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		Delay.of(500);
		
		WebDriverManager.waitVisibleElement(ProductList.product(2).byButtonAddToCompare()).click();
		Delay.of(500);
		
		compareQuantity = CatalogPag.formCompareCountValue(0);
		
		collector.checkThat(compareQuantity, Matchers.equalTo("2"));
	}
	
	@Test
	public void priceRangeShouldFilterCorrectly() {
		
	}
}
