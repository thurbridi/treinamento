package main;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuscaConfig {

	private String termo;
	private int pagina;
	private IntervaloDeBusca intervalo;

}
