package comcast_selenium_framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SampeAssign {
	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("./data/commonData.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		//String Browser = pobj.getProperty("browser");
		String Url = pobj.getProperty("url");
		String Username = pobj.getProperty("username");
		String Password = pobj.getProperty("password");
		
		WebDriver driver= new FirefoxDriver();;
		
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys( Password);
		driver.findElement(By.name("submitButton")).click();
		
	}

}
