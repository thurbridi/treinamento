package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.WebDriverManager;
import pageobject.WikiPag;

/**
 * Passos (parametrizáveis ou não) realizados sobre a Wikipedia.
 *
 */

public class WikiStep {

	/**
	 * Realiza uma pesquisa partir de um termo.
	 */
	public static void search(String termSeach) {

		WebDriver webdriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webdriver, 5);

		wait.until(ExpectedConditions.visibilityOfElementLocated(WikiPag.inputSearch())).sendKeys(termSeach);
		String url = webdriver.getCurrentUrl();
		webdriver.findElement(WikiPag.inputSearchSubmit()).click();

	}

	/**
	 * Retorna o valor do título do artigo aberto.
	 */
	public static String getPageHeader() {

		WebDriver webdriver = WebDriverManager.getWebDriver();
		return webdriver.findElement(WikiPag.titlePage()).getText();

	}

}
