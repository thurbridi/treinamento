package agostinho.componente;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import agostinho.pageobject.GooglePag;
import agostinho.pageobject.PageBarPag;

public class PageBar extends Componente {

	public static PageBar load(WebDriver webdriver) {
		WebElement pageBarElement = webdriver.findElement(GooglePag.PAGE_BAR());
		return new PageBar(pageBarElement);
	}

	public PageBar(WebElement pageBarElement) {
		super(pageBarElement);
	}

	public void clickOnPage(WebDriver webdriver, int page) {

		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(PageBarPag.PAGINA(page)));
		this.root.findElement(PageBarPag.PAGINA(page)).click();

	}

	public List<Integer> getDisplayedPages() {

		List<Integer> pages = new LinkedList<Integer>();

		List<WebElement> linkPageElements = this.root.findElements(PageBarPag.PAGINAS());
		for (WebElement linkPageElement : linkPageElements) {
			String numberPageText = linkPageElement.getText();
			int parseInt = this.parseNumberText(numberPageText);
			if (parseInt > 0) {
				pages.add(parseInt);
			}
		}

		return pages;

	}

	private int parseNumberText(String numberText) {
		try {
			return Integer.parseInt(numberText);
		} catch (Throwable t) {
			return 0;
		}
	}

}
