package agostinho.script;

import org.openqa.selenium.WebDriver;

import agostinho.Executor;
import agostinho.comum.StringExtract;
import agostinho.fluxo.RealizarPesquisaGoogle;
import agostinho.pageobject.GooglePag;
import lombok.Getter;
import main.BuscaConfig;

public class SearchResultScript implements Executor {

	private BuscaConfig busca;

	@Getter
	private long result;

	public SearchResultScript(BuscaConfig busca) {
		this.busca = busca;
	}

	public void exec(WebDriver webdriver) {

		RealizarPesquisaGoogle.doit(webdriver, this.busca);

		String resultStatsText = webdriver.findElement(GooglePag.RESULT_STATS()).getText();
		this.result = StringExtract.firstNumberOf(resultStatsText);

	}

}
