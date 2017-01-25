package exemplo;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import main.BuscaConfig;
import main.Exercicio;

public class ExercicioExemplo implements Exercicio {

	public static void main(String[] args) {
		ExercicioExemplo ex = new ExercicioExemplo();
		long result = ex.getNumeroAproximadoDoResultadoDaBuscaPor("metallica");
		System.out.println(result);

	}

	public long getNumeroAproximadoDoResultadoDaBuscaPor(String termo) {

		WebDriver webdriver = null;
		long result = 0;

		try {
			String string = Main.class.getResource("/chromedriver.exe").getPath();
			System.setProperty("webdriver.chrome.driver", string);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			webdriver = new ChromeDriver(options);
			webdriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

			webdriver.get("https://www.google.com.br/");
			Delay.of(1000);
			webdriver.findElement(By.id("lst-ib")).sendKeys(termo);
			Delay.of(1000);

			String resultString = webdriver.findElement(By.id("resultStats")).getText();
			Pattern pattern = Pattern.compile("(\\d+\\.?)+");
			Matcher matcher = pattern.matcher(resultString);
			matcher.find();
			String justNumber = matcher.group();

			NumberFormat nf = NumberFormat.getInstance();
			try {
				Number number = nf.parse(justNumber);
				result = number.longValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} finally {
			webdriver.close();
			webdriver.quit();
		}

		return result;
	}

	public List<String> getUrls(String termo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getUrls(String termo, int pag) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getUrls(BuscaConfig config) {
		// TODO Auto-generated method stub
		return null;
	}

}
