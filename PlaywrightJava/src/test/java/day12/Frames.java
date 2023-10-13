package day12;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Frame;

public class Frames {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browserType.launch(headless);
		BrowserContext context = browser.newContext();
		
		Page page = context.newPage();
		
		page.navigate("https://letcode.in/frame");
		
		Frame frame = page.frame("firstFr");
		frame.locator("//input[@name='fname']").fill("Testing");
		frame.getByPlaceholder("Enter email").fill("Demo");
		
		Frame innerFrame = page.frameByUrl(Pattern.compile("innerFrame"));
		innerFrame.getByPlaceholder("Enter email").fill("test@gmail.com");
		
	}

}
