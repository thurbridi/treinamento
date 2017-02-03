package agostinho.script;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import agostinho.Executor;
import agostinho.fluxo.RealizarPesquisaGoogle;
import agostinho.pageobject.GooglePag;
import lombok.Getter;
import main.BuscaConfig;

public class SearchUrlScript implements Executor {

	private BuscaConfig busca;

	@Getter
	private List<String> urls;

	public SearchUrlScript(BuscaConfig busca) {
		this.busca = busca;
		this.urls = new LinkedList<String>();
	}

	public void exec(WebDriver webdriver) {

		RealizarPesquisaGoogle.doit(webdriver, this.busca);

		List<WebElement> urlsElements = webdriver.findElements(GooglePag.URL());
		for (WebElement urlElement : urlsElements) {
			String url = urlElement.getAttribute("href");
			System.out.println(url);
			this.urls.add(url);
		}

	}

}
