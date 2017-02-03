package agostinho;

import java.util.List;

import agostinho.script.SearchResultScript;
import agostinho.script.SearchUrlScript;
import agostinho.script.SearchWikiResumeScript;
import main.BuscaConfig;
import main.Exercicio;
import main.IntervaloDeBusca;

public class Main implements Exercicio {

	public static void main(String[] args) {

		Main main = new Main();
		BuscaConfig busca = new BuscaConfig();
		busca.setTermo("teste");
		busca.setIntervalo(IntervaloDeBusca.NO_ULTIMO_ANO);
		busca.setPagina(15);
		main.getUrls(busca);
		// System.out.println(result);

	}

	public long getNumeroAproximadoDoResultadoDaBuscaPor(String termo) {

		BuscaConfig busca = new BuscaConfig();
		busca.setTermo(termo);

		SearchResultScript script = new SearchResultScript(busca);
		ExecutionController.execute(script);

		return script.getResult();
	}

	public List<String> getUrls(String termo) {

		BuscaConfig config = new BuscaConfig();
		config.setTermo(termo);

		SearchUrlScript script = new SearchUrlScript(config);
		ExecutionController.execute(script);

		return script.getUrls();

	}

	public List<String> getUrls(String termo, int pag) {

		BuscaConfig config = new BuscaConfig();
		config.setTermo(termo);
		config.setPagina(pag);

		SearchUrlScript script = new SearchUrlScript(config);
		ExecutionController.execute(script);

		return script.getUrls();

	}

	public List<String> getUrls(BuscaConfig config) {

		SearchUrlScript script = new SearchUrlScript(config);
		ExecutionController.execute(script);

		return script.getUrls();
	}

	public String getWikiResume(String termo) {

		BuscaConfig busca = new BuscaConfig();
		busca.setTermo(termo);

		SearchWikiResumeScript script = new SearchWikiResumeScript(busca);
		ExecutionController.execute(script);

		return script.getWikiResume();
	}

}
