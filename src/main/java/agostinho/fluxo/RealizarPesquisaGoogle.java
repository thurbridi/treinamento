package agostinho.fluxo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import agostinho.Executor;
import agostinho.componente.PageBar;
import agostinho.config.Config;
import agostinho.pageobject.FerramentasBarPag;
import agostinho.pageobject.GooglePag;
import main.BuscaConfig;
import main.Delay;
import main.IntervaloDeBusca;

public class RealizarPesquisaGoogle implements Executor {

	private BuscaConfig buscaConfig;

	public static void doit(WebDriver webdriver, BuscaConfig busca) {
		RealizarPesquisaGoogle fluxo = new RealizarPesquisaGoogle(busca);
		fluxo.exec(webdriver);
	}

	public RealizarPesquisaGoogle(BuscaConfig busca) {
		this.buscaConfig = busca;
	}

	public void exec(WebDriver webdriver) {

		webdriver.get(Config.URL_GOOGLE);

		webdriver.findElement(GooglePag.CAMPO_BUSCA()).sendKeys(this.buscaConfig.getTermo());
		webdriver.findElement(GooglePag.LUPA_PESQUISAR()).click();

		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(GooglePag.RESULT_STATS()));

		if (this.buscaConfig.getIntervalo() != null) {
			this.selecionarIntervalo(webdriver, this.buscaConfig.getIntervalo());
		}

		if (this.buscaConfig.getPagina() > 0) {
			this.mudarParaPagina(webdriver, this.buscaConfig.getPagina());
		}

	}

	private void selecionarIntervalo(WebDriver webdriver, IntervaloDeBusca intervalo) {

		WebDriverWait wait = new WebDriverWait(webdriver, 5);

		webdriver.findElement(GooglePag.BOTAO_FERRAMENTAS()).click();
		Delay.of(500);
		webdriver.findElement(FerramentasBarPag.BOTAO_FERRAMENTA_INTERVALO()).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(FerramentasBarPag.OPCAO_INTERVALO(intervalo))).click();
		Delay.of(1000);

	}

	private void mudarParaPagina(WebDriver webdriver, int pag) {

		PageBar pageBar = PageBar.load(webdriver);
		List<Integer> displayedPages = pageBar.getDisplayedPages();

		while (!displayedPages.contains(pag)) {

			pageBar.clickOnPage(webdriver, displayedPages.get(displayedPages.size() - 1));
			AguardarMudancaDePagina.doit(webdriver);
			pageBar = PageBar.load(webdriver);
			displayedPages = pageBar.getDisplayedPages();
		}

		pageBar.clickOnPage(webdriver, pag);
		AguardarMudancaDePagina.doit(webdriver);

	}

}
