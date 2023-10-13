package day7;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HttpAuthentication {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
				.setHttpCredentials("admin","admin"));
		Page page = context.newPage();
		
		page.navigate("https://the-internet.herokuapp.com/basic_auth");
		
		String text = page.locator("//div[@class='example']//p").textContent();
		System.out.println(text);
		
		
		playwright.close();
		
	}

}
