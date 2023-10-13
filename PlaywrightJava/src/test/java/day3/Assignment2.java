package day3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Assignment2 {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		
		page.locator("//input[@id='user-message']").fill("0ne");
		page.locator("//button[@id='showInput']").click();
		String text = page.locator("//p[@id='message']").textContent();
		
		System.out.println(text);
		
		page.locator("//input[@id='sum1']").fill("5");
		page.locator("//input[@id='sum2']").fill("6");
		page.locator("//button[text()='Get values']").click();
		String text2 = page.locator("//p[@id='addmessage']").textContent();
		System.out.println(text2);
		
		page.close();
		browser.close();
		playwright.close();
	}

}
