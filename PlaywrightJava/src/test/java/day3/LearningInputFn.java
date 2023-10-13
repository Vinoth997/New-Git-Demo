package day3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearningInputFn {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://letcode.in/edit");
		
		page.locator("//input[@id='fullName']").fill("Vinoth");
//		page.fill("//input[@id='fullName']", "Vinoth");
		Locator locator = page.locator("//input[@id='join']");
		locator.press("End");
		locator.type(" man");
		locator.press("Tab");
		
		String attribute = page.locator("id=getMe").getAttribute("value");
		System.out.println(attribute);
		
		page.locator("//input[@id='clearMe']").clear();
		
		
//		page.close();
//		browser.close();
//		playwright.close();
	}

}
