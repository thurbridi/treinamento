package agostinho.teste;

import org.openqa.selenium.WebDriver;

import agostinho.pageobject.GooglePag;
import br.ufsc.bridge.testtools.testrunner.CasoDeTeste;
import br.ufsc.bridge.testtools.testrunner.Coletor;
import br.ufsc.bridge.testtools.testrunner.Falha;
import br.ufsc.bridge.testtools.testrunner.annotation.PreRequisito;

@PreRequisito(CDT001.class)
public class CDT002 extends CasoDeTeste {

	@Override
	public void passos(WebDriver webdriver) {

	}

	@Override
	public void asserts(WebDriver webdriver) {
		String wikiResume = webdriver.findElement(GooglePag.WIKI_RESUME()).getText();
		if (!wikiResume.trim().startsWith("Metallica é uma banda norte-americana de heavy metal originaria de Los Angeles")) {
			Coletor.getInstance().addFalha(new Falha("O wikiResume do termo metallica não se inicia como o esperado.'"));
		}
	}

}
