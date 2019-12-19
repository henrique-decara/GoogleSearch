package it_selenium.selenium.webdriver.basic;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
	
	public static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\henrique.cara\\\\Documents\\\\Estudos\\\\Java\\\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		driver.manage().window().maximize();  /*Maximiza a janela*/
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("q")).sendKeys("ul do brasil"); /*Procura o elemento pelo nome "q" e insere a string entre parenteses*/
		
		Thread.sleep(10000);
		
		List<WebElement> list= driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
		
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++)
		{
			String listitem=list.get(i).getText();
			
			System.out.println(listitem);
			if(listitem.contains("ul do brasil"))
			{
				list.get(i).click();
				break;
			}
		}
		
		
	}

}