package day9;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RecordTestAsVideo {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browserType.launch(headless);
		BrowserContext newContext = browser.newContext(new Browser.NewContextOptions()
				.setRecordVideoDir(Paths.get("videos/"))
				.setRecordVideoSize(1280, 720));
		Page page = newContext.newPage();
		
		page.navigate("https://bookcart.azurewebsites.net/");
		
		page.navigate("https://bookcart.azurewebsites.net/");
		page.click("//span[text()='Login']/ancestor::button");
		page.fill("//input[@data-placeholder='Username']", "brucewayne");
		page.fill("//input[@data-placeholder='Password']", "Bruce000");
		page.click("//button[@color='primary']");
		
		newContext.close();
		playwright.close();

	}

}
