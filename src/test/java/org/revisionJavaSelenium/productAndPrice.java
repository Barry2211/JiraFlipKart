package org.revisionJavaSelenium;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class productAndPrice {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.className("Pke_EE")).sendKeys("wire",Keys.ENTER);
		List<WebElement> productNames = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
		List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='Nx9bqj']"));
		Map<Integer,WebElement> products =new HashMap<>();
		for(int i = 0 ; i < productNames.size() ; i++) {
			int key = Integer.parseInt(productPrices.get(i).getText().trim().replaceAll("[^0-9]",""));
			products.put(key, productNames.get(i));
		}
		Set<Integer> productSet = products.keySet();
		int total = productSet.size();
		int totalPrice=0;
		System.out.println("Maximum price: "+Collections.max(productSet)+"\nMinimum price: "+Collections.min(productSet));
		for(int price:productSet) {
			totalPrice+=price;
		}
		int avg=totalPrice/total;
		System.out.println("Average: "+avg);
		List <Integer> prodList = new ArrayList<>(productSet);
		Collections.sort(prodList);
		System.out.println(prodList);
		for(int j = 0 ; j < total ; j++) {
			if((prodList.get(j)<=avg) &&(avg <= prodList.get(j+1))) {
				if((avg-prodList.get(j))< (prodList.get(j+1)-avg)) {
					int avgProduct = prodList.get(j);
					products.get(avgProduct).click();
					break;
				}
				else {
					int avgProduct = prodList.get(j+1);
					products.get(avgProduct).click();
					break;
				}	
			}
		}	
	}
}
