package day5;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class RecordScript {
	
	  public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://letcode.in/");
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Work-Space")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Drop-Down")).click();
	      page.locator("#fruits").selectOption("0");
	      page.getByText("You have selected Apple").click();
	      page.locator("#superheros").selectOption("am");
	      page.locator("#superheros").selectOption("aq");
	      page.locator("#superheros").selectOption("ta");
	      page.locator("#superheros").selectOption("am");
	      page.locator("#superheros").selectOption("aq");
	      page.locator("#superheros").selectOption("gr");
	      page.locator("#superheros").selectOption(new String[] {"ek", "gr"});
	      page.locator("#superheros").selectOption(new String[] {"ek", "ff", "gr"});
	      page.locator("#lang").selectOption("java");
	      page.locator("#country").selectOption("India");
	      playwright.close();
	    }
	  }

}
