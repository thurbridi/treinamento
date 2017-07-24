package core;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.openqa.selenium.WebDriver;

/**
 * Runner do JUnit criado com o propósito de controlar o ciclo de vida do browser a cada teste.
 * Os testes que utilizarem a annotation @RunWith na classe, estarão sob o controle deste runner.
 */

public class WebDriverRunner extends BlockJUnit4ClassRunner {

	private static WebDriver webdriver;

	public static WebDriver getWebDriver() {
		if (webdriver == null) {
			throw new RuntimeException("WebDriver não iniciado.");
		}

		return webdriver;
	}

	public WebDriverRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	protected void runChild(final FrameworkMethod method, RunNotifier notifier) {

		this.beforeTest();

		try {
			super.runChild(method, notifier);
		} finally {
			this.afterTest();
		}

	}

	private void beforeTest() {

		WebDriverRunner.webdriver = WebDriverCreator.create();

	}

	private void afterTest() {
		WebDriverRunner.webdriver.close();
		WebDriverRunner.webdriver.quit();
		WebDriverRunner.webdriver = null;
	}

}
