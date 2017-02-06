package agostinho.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import agostinho.fluxo.RealizarPesquisaGoogle;
import br.ufsc.bridge.testtools.testrunner.CasoDeTeste;
import br.ufsc.bridge.testtools.testrunner.Coletor;
import br.ufsc.bridge.testtools.testrunner.Falha;
import main.BuscaConfig;

public class CDT001 extends CasoDeTeste {

	@Override
	public void passos(WebDriver webdriver) {

		BuscaConfig busca = new BuscaConfig();
		busca.setTermo("metallica");
		RealizarPesquisaGoogle.doit(webdriver, busca);

	}

	@Override
	public void asserts(WebDriver webdriver) {

		WebElement resultElement = webdriver.findElement(By.id("resultStats"));

		if (!resultElement.isDisplayed()) {
			Coletor.getInstance().addFalha(new Falha("O resultado da busca não está visível."));
		}

		if (!resultElement.getText().trim().startsWith("Aproximadamente")) {
			Coletor.getInstance().addFalha(new Falha("O resultado da busca não se inicia com 'Aproximadamente...'"));
		}

	}

}
