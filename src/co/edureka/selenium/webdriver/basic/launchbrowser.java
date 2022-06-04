package co.edureka.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class launchbrowser {
	public static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
 
		//open the web app
		driver.navigate().to("https://www.amazon.com.br/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		
		// confere o titulo
		if(title.equalsIgnoreCase("Amazon.com.br"))
			System.out.println("title confere");
		else
			System.out.println(title);
		
		//localiza na pagina web o elemento all
		String tagname="";
		tagname = driver.findElement(By.cssSelector("#nav-hamburger-menu > span")).getText();
		System.out.println(tagname);
		
		//dropdown
		WebElement category = driver.findElement(By.cssSelector("#nav-hamburger-menu"));
		Actions action = new Actions(driver);
		action.moveToElement(category);
		action.click();
		action.perform();
		Thread.sleep(2000);
		
		WebElement books = driver.findElement(By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible > li:nth-child(11) > a > i"));
		action.moveToElement(books);
		action.click();
		action.perform();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Todos os eBooks")).click();
		Thread.sleep(2000);
		
		WebElement myElement=driver.findElement(By.id("twotabsearchtextbox"));
		myElement.sendKeys("Harry Potter");
		
		driver.findElement(By.className("nav-search-submit")).click();
		Thread.sleep(2000);
		
		
	
		

	}

}
