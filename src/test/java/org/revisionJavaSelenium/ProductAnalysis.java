package org.revisionJavaSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class ProductAnalysis {

	public static WebDriver driver;
	List <WebElement> productNames = new ArrayList<>() ;
	List <WebElement> productPrices = new ArrayList<>() ;
	Map<Integer,WebElement> products = new HashMap<>();
	Set<Integer> productSet;
	int avg,total;
	
	@BeforeSuite
	private void browserSetup() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@BeforeTest
	private void urlLaunch() {
		driver.get("https://www.flipkart.com/");
	}
	
	@Test (priority=-1)
	private void productSearch() {
		driver.findElement(By.className("Pke_EE")).sendKeys("wire",Keys.ENTER);
	}
	
	@Test(priority=1)
	private void productAnalyze() {
		productNames = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
		productPrices = driver.findElements(By.xpath("//div[@class='Nx9bqj']"));	
		System.out.println("Size:"+productNames.size());
		for(int i = 0 ; i < productNames.size() ; i++) {
			int key = Integer.parseInt(productPrices.get(i).getText().trim().replaceAll("[^0-9]",""));
			products.put(key, productNames.get(i));
		}
		productSet = products.keySet();
		total = productSet.size();
		int totalPrice=0;
		System.out.println("Maximum price: "+Collections.max(productSet)+"\nMinimum price: "+Collections.min(productSet));
		for(int price:productSet) {
			totalPrice+=price;
		}
		avg=totalPrice/total;
		System.out.println("Average: "+avg);
	}
	
	@Test (priority=2)
	private void averagePriceProduct() {
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
