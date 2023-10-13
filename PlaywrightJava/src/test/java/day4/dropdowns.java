package day4;

import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class dropdowns {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(headless).newPage();
		
		page.navigate("https://letcode.in/dropdowns");
		
//		page.selectOption("//select[@id='fruits']", "1");
		
		Locator dropDown = page.locator("//select[@id='fruits']");
//		dropDown.selectOption("2");
//		dropDown.selectOption(new SelectOption().setLabel("Pine Apple"));
		dropDown.selectOption(new SelectOption().setIndex(3));
		
		String text = page.locator("//p[@class='subtitle']").textContent();
		System.out.println(text);
		
		Locator herosDropDown = page.locator("id=superheros");
		herosDropDown.selectOption(new String[] {"bt","bp","gr"});
		
		Locator langDropDown = page.locator("#lang");
		Locator options = langDropDown.locator("option");
		List<String> allInnerTexts = options.allInnerTexts();
		allInnerTexts.forEach(i-> System.out.println(i));
		
		
		int length = options.count();
		System.out.println("Lenght : "+length);
		langDropDown.selectOption(new SelectOption().setIndex(length-1));
				
//		page.close();
//		playwright.close();
						
	}

}
