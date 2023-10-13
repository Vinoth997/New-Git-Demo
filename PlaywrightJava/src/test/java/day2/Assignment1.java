package day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Assignment1 {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		
		page.navigate("https://www.google.com/");
		String title = page.title();
		String url = page.url();
		System.out.println("Title : "+title+" URL : "+url);
		
		page.close();
		browser.close();
		playwright.close();
		
	}

}
