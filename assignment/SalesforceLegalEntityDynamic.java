package week6.assignment;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SalesforceLegalEntityDynamic extends SalesforceLogin{
	@DataProvider
	public String[][] sendData() {
		String[][] data=new String[1][1];
		data[0][0]="Mahalakshmi";
		return data;
	}
	@Test(dataProvider="sendData")
	public void runLegalEntityDynamic(String name){
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by "+name);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String text = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		System.out.println(text);
		if(text.contains(name)) {
			System.out.println("Legal Entity name is correct");
		}
		else {
			System.out.println("Not Correct");
		}
		
	}

}
