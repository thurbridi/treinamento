package autopractice.pageobject;

import org.openqa.selenium.By;

public class TopMenuTshirtsPag {
	public static By byLinkTshirts() {
		return By.xpath(getXpathLink("T-shirts"));
	}

	private static String getXpathLink(String text) {
		return TopMenuPag.xpathTShirtSubmenu + "//a[text()='" + text + "']";
	}
}