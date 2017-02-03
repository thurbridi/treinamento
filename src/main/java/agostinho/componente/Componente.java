package agostinho.componente;

import org.openqa.selenium.WebElement;

public abstract class Componente {

	protected WebElement root;

	public Componente(WebElement root) {
		this.root = root;
	}

}
