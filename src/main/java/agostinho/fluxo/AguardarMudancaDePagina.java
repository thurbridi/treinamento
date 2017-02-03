package agostinho.fluxo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import agostinho.Executor;
import agostinho.pageobject.GooglePag;

public class AguardarMudancaDePagina implements Executor {

	public static void doit(WebDriver webdriver) {
		AguardarMudancaDePagina fluxo = new AguardarMudancaDePagina();
		fluxo.exec(webdriver);
	}

	public void exec(WebDriver webdriver) {

		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(GooglePag.MUDANCA_PAGINA_CARREGADA()));

	}

}
