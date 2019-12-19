package it_selenium.selenium.webdriver.basic;

/**
 * Busca no google usando Selenium, navegador Google Chrome 7.9
 * Java SE 12
 */

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
		
		driver.get("http://www.google.com");  /*Abre a url*/
		
		driver.manage().window().maximize();  /*Maximiza a janela*/
		
		Thread.sleep(2000); /*Espera 2 segundos*/
		
		driver.findElement(By.name("q")).sendKeys("ul do brasil"); /*Procura o elemento pelo nome "q" e insere a string entre parenteses*/
		
		Thread.sleep(10000); /*Espera 10 segundos*/
		
		List<WebElement> list= driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']")); /*Procura pelo elemento pelo Xpath*/
		
		System.out.println(list.size());  /*Imprime o tamanho da lista*/
		
		for(int i=0;i<list.size();i++)
		{
			String listitem=list.get(i).getText();
			
			System.out.println(listitem);
			if(listitem.contains("ul do brasil")) /*Caso encontre o conteúdo entre parênteses, ele clica e printa na tela*/
			{
				list.get(i).click();
				break;
			}
		}
		
		
	}

}