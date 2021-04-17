import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class getWorldPopulationData {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM\\Drivers\\chromedriver.exe");
		String worldPopulation_xpath="(//span[@class='rts-counter'])[1]";
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/world-population/");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(driver.findElement(By.cssSelector("div[id='maincounter-wrap'] h1")).getText());
		System.out.println("-----------------------------------------------------------------");
		getPopulationData(worldPopulation_xpath);
		
		//List<WebElement> worldPopulation= driver.findElements(By.xpath("//div[@class='maincounter-number']//span[@class='rts-counter']//span"));
		//System.out.println(worldPopulation.size());
	/*	int i=0;
		while(true)
		{
			//WebDriverWait wait = new WebDriverWait(driver,15);
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='maincounter-number']//span[@class='rts-counter']//span")));
			
			System.out.println(driver.findElement(By.xpath("(//span[@class='rts-counter'])[1]")).getText());
			//i++;
			//break;
		}*/
		

	}
	
	
	public static void getPopulationData(String xpath)
	{
		while(true)
		{
			System.out.println(driver.findElement(By.xpath(xpath)).getText());
		}
	}

}
