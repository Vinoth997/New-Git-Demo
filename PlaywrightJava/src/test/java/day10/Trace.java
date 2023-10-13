package day10;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class Trace {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browserType.launch(headless);
		BrowserContext context = browser.newContext();
		
		context.tracing().start(
				new Tracing.StartOptions()
				.setScreenshots(true)
				.setSnapshots(true)
				.setSources(!true)
				);
		
		Page page = context.newPage();
		
		page.navigate("https://letcode.in/");
		page.click("//a[text()='Work-Space']");
		page.click("//a[@href='/edit']");
		page.fill("#fullName", "Testing");
		page.type("#join", " man");
		String text = page.textContent("#getMe");
		System.out.println(text);
		page.locator("#clearMe").clear();
		
		Page newPage = context.newPage();
		newPage.navigate("https://bookcart.azurewebsites.net/");
		
		page.navigate("https://bookcart.azurewebsites.net/");
		page.click("//span[text()='Login']/ancestor::button");
		page.fill("//input[@data-placeholder='Username']", "brucewayne");
		page.fill("//input[@data-placeholder='Password']", "Bruce000");
		page.click("//button[@color='primary']");
		
		context.tracing().stop(
				new Tracing.StopOptions()
				.setPath(Paths.get("trace.zip"))
				);
		
		context.close();
		playwright.close();
		
	}

}
