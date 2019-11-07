package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Shared {
	static Properties prop;

	
	public static Properties readPropertyFile(String path) {
		FileInputStream f;
		try {
			f= new FileInputStream(new File(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found");
		}
		
		prop=new Properties();
		prop.getProperty(path);
		
		return prop;
		}
	
	
	public static void openBrowser(WebDriver driver) {
		
		if(prop.get("Browser").equals("Chrome")) {
			driver=new ChromeDriver();
		}
		
		else if(prop.get("Browser").equals("Firefox")) {
			driver=new FirefoxDriver();
		}
		
		else if(prop.get("Browser").equals("InternetExplore")) {
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("Driver is not found");
		}
		
	}
}
