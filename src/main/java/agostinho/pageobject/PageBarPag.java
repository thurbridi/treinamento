package agostinho.pageobject;

import org.openqa.selenium.By;

public class PageBarPag {

	public static By PAGINAS() {
		return By.xpath(".//td");
	}

	public static By PAGINA(int pag) {
		return By.xpath(".//*[text()='" + pag + "']");
	}

	public static By MAIS_PAGINAS() {
		return By.xpath(".//*[text()='Mais']");
	}

}
