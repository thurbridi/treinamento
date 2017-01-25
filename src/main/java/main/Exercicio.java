package main;

import java.util.List;

public interface Exercicio {

	public long getNumeroAproximadoDoResultadoDaBuscaPor(String termo);

	public List<String> getUrls(String termo);

	public List<String> getUrls(String termo, int pag);

	public List<String> getUrls(BuscaConfig config);

}
