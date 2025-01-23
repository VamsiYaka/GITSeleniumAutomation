import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Introdution {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String name = "Staples";
		
		  String[] itemsNeeded = {"Cadbury Dairy Milk Fruit and Nut Chocolate Bars",
		  "PARLE Melody Chocolaty Toffee",
		  "Cadbury Dairy Milk Silk Hazelnut Chocolate Bars",
		  "KARACHI BAKERY Plain Soan Papdi Mithai Box"};
		 

		System.setProperty("webdriver.chromedriver", "C:\\Users\\vamsi\\Downloads\\chromedriver_win32");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@aria-label='Grocery']")).click();

		driver.findElement(By.xpath("//*[@title='Enter pincode']")).sendKeys("500019");

		driver.findElement(By.xpath("//*[@title='Enter pincode']")).sendKeys(Keys.ENTER);

		String NeededIteam1 = "Packaged Food";

		String NeededIteam2 = "Chocolates & Sweets";

		Actions a = new Actions(driver);

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Oixg6R']")));

		List<WebElement> products1 = driver.findElements(By.xpath("//div[@class='Oixg6R']"));

		System.out.println(products1.size());

		for (int i = 0; i < products1.size(); i++) {

			// String nameofProduct=

			System.out.println(products1.get(i).getText());

			String nameofProduct = products1.get(i).getText();

			if (nameofProduct.contentEquals(NeededIteam1)) {

				a.moveToElement(products1.get(i)).build().perform();

			}
		}

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ZLM5Ff VIQuXm']/a")));

		List<WebElement> product2 = driver.findElements(By.xpath("//*[@class='ZLM5Ff VIQuXm']/a"));

		System.out.println(product2.size());

		for (int j = 0; j < product2.size(); j++) {

			System.out.println(product2.get(j).getText());

			String nameProducts2 = product2.get(j).getText();

			if (nameProducts2.contentEquals(NeededIteam2)) {

				a.moveToElement(product2.get(j)).click().build().perform();

				break;

			}

		}

		/*
		 * w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
		 * "//*[@class='WSL9JP']/a")));
		 * 
		 * List<WebElement> optNext=
		 * driver.findElements(By.xpath("//*[@class='WSL9JP']/a"));
		 * 
		 * System.out.println( optNext.size());
		 * 
		 * for(int b=0;b<optNext.size();b++) {
		 */

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='MrGHbB']/a")));

		List<WebElement> listOfProducts = driver.findElements(By.xpath("//*[@class='MrGHbB']/a"));

		System.out.println(listOfProducts.size());

		/*
		 * for (int z = 0; z < listOfProducts.size(); z++) {
		 * System.out.println(listOfProducts.get(z).getText()); }
		 */

		int m = 0;

		for (int k = 0; k < listOfProducts.size(); k++) {

			// System.out.println( listOfProducts.get(k).getText());

			String productTest = listOfProducts.get(k).getText();

			List itemsNeededlist = Arrays.asList(itemsNeeded);

			if (itemsNeededlist.contains(productTest)) {

				driver.findElements(By.xpath("//*[@class='QqFHMw PxrzFS']")).get(k - m).click();

				if (m == itemsNeeded.length) {
					break;

				}

				m++;

			}

			// addIteams(driver, addIteams);
		}

		driver.findElement(By.xpath("//*[text()='Cart']")).click();

		Thread.sleep(3000);

		String TotalCost = driver.findElement(By.xpath("(//*[@class='_1Y9Lgu'])[2]")).getText();
		
	//String[] name1=	TotalCost.split("?");	
	
//System.out.println(	name1[1].trim());
		System.out.println("Total cost"+"=" +":" + TotalCost);
		
	String savedmoney=	driver.findElement(By.xpath("//*[@class='IbVNxe']")).getText();
	
String[]   finalamount=	savedmoney.split("save");

           String amount=  finalamount[1].trim();

System.out.println("You saved : "+amount);

		// driver.findElement(By.xpath("//*[text()='Next']")).click();

	}
}

/*
 * private static void addIteams(WebDriver driver) { // TODO Auto-generated
 * method stub
 * 
 * 
 * List<WebElement> listOfProducts=
 * driver.findElements(By.xpath("//*[@class='MrGHbB']/a"));
 * 
 * for(int k=0;k<listOfProducts.size();k++) {
 * 
 * System.out.println( listOfProducts.get(k).getText());
 * 
 * }
 * 
 * }
 */
