package day11;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class LocatorsOne {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browserType.launch(headless);
		BrowserContext context = browser.newContext();
		
		Page page = context.newPage();
		
		page.navigate("https://bookcart.azurewebsites.net/");
		
		page.getByText("Login").click();
		page.getByLabel("Username").fill("brucewayne");
		page.getByLabel("Password").fill("Bruce000");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
				.setName("Login")).last().click();
		page.getByPlaceholder("Search books or authors").type("HP");
		page.getByRole(AriaRole.OPTION).nth(3).click();
		
		page.getByAltText("Book cover image").click();
		
		System.out.println(page.url());

	}

}
