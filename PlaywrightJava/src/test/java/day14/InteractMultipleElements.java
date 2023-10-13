package day14;

import java.util.Iterator;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

public class InteractMultipleElements {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		
		page.navigate("https://letcode.in/elements");
		
//		Frame frame = page.frame("google_esf");
		
		page.locator("//input[@name='username']").fill("vinothkumar197");
		
		page.locator("//p[@class='control']//button[1]").click();
		
		Locator repoLinks = page.locator("ol li a");
		repoLinks.last().waitFor(new Locator.WaitForOptions()
				.setState(WaitForSelectorState.ATTACHED)
				.setTimeout(20000));
				
		int linkCount = repoLinks.count();
		
		for (int i = 0; i < linkCount; i++) {
			String textContent = repoLinks.nth(i).textContent();
			System.out.println(textContent);
		}
		
		System.out.println(linkCount);

	}

}
