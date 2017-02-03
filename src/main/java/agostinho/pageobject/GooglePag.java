package agostinho.pageobject;

import org.openqa.selenium.By;

public class GooglePag {

	public static By CAMPO_BUSCA() {
		return By.id("lst-ib");
	}

	public static By LUPA_PESQUISAR() {
		return By.id("_fZl");
	}

	public static By RESULT_STATS() {
		return By.id("resultStats");
	}

	public static By WIKI_RESUME() {
		return By.xpath("//*[contains(@class,'kno-rdesc')]");
	}

	public static By PAGE_BAR() {
		return By.id("navcnt");
	}

	public static By MUDANCA_PAGINA_CARREGADA() {
		return By.xpath("//*[@id='flyr' and @class='flyr-c']");
	}

	public static By BOTAO_FERRAMENTAS() {
		return By.id("hdtb-tls");
	}

	public static By MENU_FERRAMENTAS() {
		return By.id("hdtbMenus");
	}

	public static By URL() {
		return By.xpath("//h3[@class='r']//a");
	}

}
