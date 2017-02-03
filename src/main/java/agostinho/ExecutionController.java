package agostinho;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExecutionController {

	public static void execute(Executor executor) {

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
		WebDriver webdriver = new ChromeDriver(options);
		webdriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		try {
			executor.exec(webdriver);
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			webdriver.close();
			webdriver.quit();
		}

	}

}
