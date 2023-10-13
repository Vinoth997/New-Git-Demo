package day13;

import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class WindowHandling {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(headless).newPage();
		
		page.navigate("https://letcode.in/windows");
		
		//Single Page
		
//		Page popup = page.waitForPopup(()->{
//			page.locator("id=home").click();
//		});
//		popup.waitForLoadState();
//		
//		System.out.println("New Tab Title:"+popup.title());
//		System.out.println("New Tab Url:"+popup.url());
//		
//		playwright.close();
		
		//Multi Page
		
		page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(
				p-> p.context().pages().size()==3), ()->{
			page.locator("id=multi").click();
		});
		
//		page.locator("id=multi").click();
		
		List<Page> pages = page.context().pages();
		for (Page tabs : pages) {
			tabs.waitForLoadState();
			System.out.println(tabs.url());
		}
		Page alertPage = pages.get(1);
		Page dropdownPage = pages.get(2);
		
		System.out.println("Alert Page "+alertPage.textContent("h1"));
		System.out.println("DropDown Page "+dropdownPage.textContent("h1"));
		
		playwright.close();

	}

}
