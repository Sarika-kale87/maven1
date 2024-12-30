package Package_1.MavenProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Alllinks_print {

	public static void main(String[] args) throws IOException {

		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.Amazon.in/");
		driver.manage().window().maximize();

		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		int count = alllinks.size();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			WebElement e1 = alllinks.get(i);
			String link = e1.getAttribute("href");
			//String text = e1.getText();
			System.out.println(link);
			//System.out.println(text);
			verifylink(link);
		}
	}

	static void verifylink(String link) throws IOException {
		try {
		URL u1 = new URL(link);

		HttpURLConnection h1 = (HttpURLConnection) u1.openConnection();
		
			if (h1.getResponseCode() == 200 || h1.getResponseCode() == 201) {
				System.out.println("It is Valid");
				System.out.println(h1.getResponseCode());
				System.out.println(h1.getResponseMessage());
				
			} else {
				System.out.println("It is invalid");
				System.out.println(h1.getResponseCode());
				System.out.println(h1.getResponseMessage());
			}
		} 
		catch (MalformedURLException m1) 
		{
			System.out.println("Handeled Exception");
			
		}
		/*catch (NullPointerException m2) 
		{
			System.out.println("Handeled Exception");
		}
*/
	}

}
