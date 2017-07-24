package core;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverCreator {

	public static WebDriver create() {

		String file = "/chromedriver.exe";
		if (System.getProperty("os.name").equals("Linux")) {
			file = "/chromedriverlinux";
		}

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + file);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		options.addArguments("--disable-breakpad");
		options.addArguments("--disable-gpu");
		options.addArguments("--incognito");

		Map<String, Object> preferences = new Hashtable<String, Object>();
		options.setExperimentalOption("prefs", preferences);
		preferences.put("plugins.always_open_pdf_externally", Boolean.TRUE);

		WebDriver webdriver = new ChromeDriver(options);
		webdriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		webdriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		return webdriver;

	}
}
