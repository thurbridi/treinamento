package agostinho.pageobject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import main.IntervaloDeBusca;

public class FerramentasBarPag {

	private static final Map<IntervaloDeBusca, String> mapIdIntervalo = Collections.unmodifiableMap(new HashMap<IntervaloDeBusca, String>() {
		{
			this.put(IntervaloDeBusca.EM_QUALQUER_DATA, "qdr_");
			this.put(IntervaloDeBusca.NA_ULTIMA_HORA, "qdr_h");
			this.put(IntervaloDeBusca.NAS_ULTIMAS_24_HORAS, "qdr_d");
			this.put(IntervaloDeBusca.NA_ULTIMA_SEMANA, "qdr_w");
			this.put(IntervaloDeBusca.NO_ULTIMO_MES, "qdr_m");
			this.put(IntervaloDeBusca.NO_ULTIMO_ANO, "qdr_y");
		}
	});

	public static By BOTAO_FERRAMENTA_INTERVALO() {
		return By.xpath("(//*[@class='hdtb-mn-hd'])[3]");
	}

	public static By OPCAO_INTERVALO(IntervaloDeBusca intervalo) {
		return By.id(mapIdIntervalo.get(intervalo));
	}

}
