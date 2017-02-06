package agostinho.teste;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import br.ufsc.bridge.testtools.browser.WebDriverManager;

public class ChromeDriverManager implements WebDriverManager {

	private WebDriver webdriver;

	public WebDriver createWebDriver() {

		String soName = System.getProperty("os.name");
		String pathChromeDriver = "";
		if (soName.equals("Linux")) {
			pathChromeDriver = "chromedriverlinux";
		} else {
			pathChromeDriver = "chromedriver.exe";
		}

		System.setProperty("webdriver.chrome.driver", pathChromeDriver);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		this.webdriver = new ChromeDriver(options);
		this.webdriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		return this.webdriver;
	}

	public void closeWebDriver() {

		this.webdriver.close();
		this.webdriver.quit();

	}

}
