package comcast_selenium_framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("./data/commonData.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String Browser = pobj.getProperty("browser");
		String Url = pobj.getProperty("url");
		String Username = pobj.getProperty("username");
		String Password = pobj.getProperty("password");
		
		/*Random r=new Random();
		int randomNum=r.nextInt(10000);
		FileInputStream fi =new FileInputStream("./data/testdata.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("org");
		Row ro = sh.getRow(1);
		String orgName = ro.getCell(2).getStringCellValue()+randomNum;*/
		
		WebDriver driver;
		if(Browser.equals("firefox")) {
			driver= new FirefoxDriver();
			}
		else if(Browser.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else {
			driver= new InternetExplorerDriver();
		}
		
	
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get(Url);
	driver.findElement(By.name("user_name")).sendKeys(Username);
	driver.findElement(By.name("user_password")).sendKeys( Password);
	driver.findElement(By.name("submitButton")).click();
	
    WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	Actions act= new Actions(driver);
	act.moveToElement(ele1).perform();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			
	}
}


