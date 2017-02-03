package agostinho;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExecutionController {

	public static void execute(Executor executor) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
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
