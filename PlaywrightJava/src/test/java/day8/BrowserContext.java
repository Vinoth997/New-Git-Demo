package day8;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContext {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browserType.launch(headless);
		com.microsoft.playwright.BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://bookcart.azurewebsites.net/");
		page.click("//span[text()='Login']/ancestor::button");
		page.fill("//input[@data-placeholder='Username']", "brucewayne");
		page.fill("//input[@data-placeholder='Password']", "Bruce000");
		page.click("//button[@color='primary']");
		
//		String userName = page.textContent("//button[contains(@class,'mat-button mat-button-base ng-star-inserted')]/span[@class='mat-button-wrapper']");
		String UserName = page.textContent("//button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base ng-star-inserted']");
		
		
//		System.out.println(UserName);
		System.out.println("UserName 1 : "+UserName.split(" ")[1].split(" ")[0]);
		
		com.microsoft.playwright.BrowserContext newContext = browser.newContext();
		Page newPage = newContext.newPage();
		newPage.navigate("https://bookcart.azurewebsites.net/");
//		String UserName2 = newPage.textContent("//button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base ng-star-inserted']");
//		
//		System.out.println("UserName 2 : "+UserName2);
		
		page.bringToFront();
		page.fill("//input[@placeholder='Search books or authors']", "HP4");
		
		playwright.close();
		
		
	}

}
