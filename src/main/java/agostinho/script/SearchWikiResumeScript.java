package agostinho.script;

import org.openqa.selenium.WebDriver;

import agostinho.Executor;
import agostinho.fluxo.RealizarPesquisaGoogle;
import agostinho.pageobject.GooglePag;
import lombok.Getter;
import main.BuscaConfig;

public class SearchWikiResumeScript implements Executor {

	private BuscaConfig busca;

	@Getter
	private String wikiResume;

	public SearchWikiResumeScript(BuscaConfig busca) {
		this.busca = busca;
	}

	public void exec(WebDriver webdriver) {

		RealizarPesquisaGoogle.doit(webdriver, this.busca);
		this.wikiResume = webdriver.findElement(GooglePag.WIKI_RESUME()).getText();

	}

}
