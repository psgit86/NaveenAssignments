import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CarouselHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.noon.com/uae-en/");

		
		printCarouselItems(3);

		driver.quit();
	}

	public static void printCarouselItems(int carouselOrder) throws InterruptedException {
		
		
		WebElement carouselTitle = driver.findElement(By.xpath("(//div[@class='sc-fvhGYg kHEClt'])["+carouselOrder+"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", carouselTitle);
		js.executeScript("window.scrollBy(0,700)");
		System.out.println(carouselTitle.getText());
		List<WebElement> products = null;
		Set<String> allProducts = new HashSet<>();
		// Xpath for the right Arrow
		WebElement rightArrow = driver.findElement(
				By.xpath("(//div[@class='sc-GTWni GkeGT']//div[contains(@class,'swiper-button-next')])["+carouselOrder+"]"));
		//OLDER XPATH STATIC
//		By.xpath("(//div[@class='sc-GTWni GkeGT']//div[contains(@class,'swiper-button-next')])[1]"));
		while (rightArrow.isDisplayed()) {
			products = driver.findElements(By.xpath("//div[@data-qa='product-name']"));
			for (WebElement product : products)
				allProducts.add(product.getText());
			rightArrow.click();
			Thread.sleep(1000);
		}
		System.out.println(products.size());
		allProducts.stream().sorted().forEach(s -> System.out.println(s));
	}

}
