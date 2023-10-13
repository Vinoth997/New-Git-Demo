package day6;

import java.util.function.Consumer;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Alerts {
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://letcode.in/alert");
//		page.locator("#accept").click();
		
		Consumer<Dialog> alert = new Consumer<Dialog>() {
			public void accept(Dialog d) {
				d.accept("Testing");
				page.offDialog(this);
				System.out.println(d.message());
			}
		};
		page.onDialog(alert);
		page.locator("#prompt").click();
		
		
		page.onDialog(dialog -> {
			System.out.println(dialog.defaultValue());
			System.out.println(dialog.message());
			dialog.accept("Text");
		});
		page.locator("#prompt").click();
		
		System.out.println(page.locator("#myName").textContent());
		
		playwright.close();
	}

}
