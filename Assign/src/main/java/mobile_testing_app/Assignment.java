package mobile_testing_app;


import mobile_testing_app.MobileTesting;

import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.*;

public class Assignment {
	private static String[] loginPageElements = {"com.experitest.ExperiBank:id/usernameTextField", "com.experitest.ExperiBank:id/passwordTextField", "com.experitest.ExperiBank:id/loginButton"};
	private static String[] summaryPageElements = {"com.experitest.ExperiBank:id/makePaymentButton", "com.experitest.ExperiBank:id/logoutButton"};
	private static String[] paymentPageElements = {"com.experitest.ExperiBank:id/phoneTextField", "com.experitest.ExperiBank:id/nameTextField", "com.experitest.ExperiBank:id/nameTextField",
										"com.experitest.ExperiBank:id/amountLabel", "com.experitest.ExperiBank:id/amount", "com.experitest.ExperiBank:id/countryTextField",
										"com.experitest.ExperiBank:id/countryButton", "com.experitest.ExperiBank:id/sendPaymentButton", "com.experitest.ExperiBank:id/cancelButton"};
	

	/* Start Here */
	
	public static void run() throws NoSuchElementException {
		AndroidDriver<AndroidElement> driver = (AndroidDriver<AndroidElement>) MobileTesting.getDriver();
		
		long timeout = 6; // 6 seconds
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		/* Start testing */
		AndroidElement element;
		Actions action = new Actions(driver);
		Alert alert;
		
		// (1) Check if on login page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginPageElements[0])));
		
		MobileTesting.printTest(1);
		
		// (2) Type the string "company" to the username field
		element = driver.findElementById("com.experitest.ExperiBank:id/usernameTextField");
		element.sendKeys("company");
		
		MobileTesting.printTest(2);
		
		// (3) Focus the password field
		element = driver.findElementById("com.experitest.ExperiBank:id/passwordTextField");
		element.click();
		
		MobileTesting.printTest(3);
		
		// (4) Type the string "company" to the password field
		element.sendKeys("company");
		
		MobileTesting.printTest(4);
		
		// (5) Focus the username field
		element = driver.findElementById("com.experitest.ExperiBank:id/usernameTextField");
		element.click();
		
		MobileTesting.printTest(5);
		
		// (6) Empty out the username field
		element.clear();
		
		MobileTesting.printTest(6);
		
		// (7) Press the login button and ensure still on login page
		element = driver.findElementById("com.experitest.ExperiBank:id/loginButton");
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginPageElements[0])));
		
		MobileTesting.printTest(7);
		
		// (8) Re-type "company" to the username field
		element = driver.findElementById("com.experitest.ExperiBank:id/usernameTextField");
		element.sendKeys("company");
		
		MobileTesting.printTest(8);
		
		// (9) Press the login button and ensure now on summary page with $100
		element = driver.findElementById("com.experitest.ExperiBank:id/loginButton");
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(summaryPageElements[0])));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(summaryPageElements[1])));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'100')]")));
		
		MobileTesting.printTest(9);
		
		// (10) Press the make payment button and ensure now on payment page
		element = driver.findElementById("com.experitest.ExperiBank:id/makePaymentButton");
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(paymentPageElements[0])));
		
		MobileTesting.printTest(10);
		
		// (11) Type the string "612-555-0112" to the phone field
		element = driver.findElementById("com.experitest.ExperiBank:id/phoneTextField");
		element.sendKeys("612-555-0112");
		
		MobileTesting.printTest(11);
		
		// (12) Type the string "Alice" to the name text field
		element = driver.findElementById("com.experitest.ExperiBank:id/nameTextField");
		element.sendKeys("Alice");
		
		MobileTesting.printTest(12);
		
		// (13) Drag the amount slider to $35
		element = driver.findElementById("com.experitest.ExperiBank:id/amount");
		Point sliderLoc = element.getLocation();
		Dimension sliderSize = element.getSize();
		int startX = sliderLoc.getX();
		int targetX = startX + (int) (sliderSize.getWidth() * 0.35);
		int y = sliderLoc.getY() + (sliderSize.getHeight() / 2);
		action.moveToElement(element, 0, 0)
			  .clickAndHold()
			  .moveByOffset(targetX - startX, 0)
			  .release()
			  .perform();
		
		MobileTesting.printTest(13);
		
		// (14) Press the send payment button and ensure still on payment page
		element = driver.findElementById("com.experitest.ExperiBank:id/sendPaymentButton");
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(paymentPageElements[0])));
		
		MobileTesting.printTest(14);
		
		// (15) Type the string "United States" to the country text field
		element = driver.findElementById("com.experitest.ExperiBank:id/countryTextField");
		element.sendKeys("United States");
		
		MobileTesting.printTest(15);
		
		// (16) Press the cancel button and ensure now on summary page with $100
		element = driver.findElementById("com.experitest.ExperiBank:id/cancelButton");
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(summaryPageElements[0])));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'100')]")));
		
		MobileTesting.printTest(16);
		
		// (17) Press the make payment button and ensure now on payment page with default values
		element = driver.findElementById("com.experitest.ExperiBank:id/makePaymentButton");
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(paymentPageElements[0])));
		
		MobileTesting.printTest(17);
		
		// (18) Type the string "612-555-0355" to the phone field
		element = driver.findElementById("com.experitest.ExperiBank:id/phoneTextField");
		element.sendKeys("612-555-0355");
		
		MobileTesting.printTest(18);
				
		// (19) Type the string "Bob" to the name text field
		element = driver.findElementById("com.experitest.ExperiBank:id/nameTextField");
		element.sendKeys("Bob");
		
		MobileTesting.printTest(19);
		
		// (20) Drag the amount slider to $55
		element = driver.findElementById("com.experitest.ExperiBank:id/amount");
		sliderLoc = element.getLocation();
		sliderSize = element.getSize();
		startX = sliderLoc.getX();
		targetX = startX + (int) (sliderSize.getWidth() * 0.55);
		action.moveToElement(element, 0, 0)
			  .clickAndHold()
			  .moveByOffset(targetX - startX, 0)
			  .release()
			  .perform();
		
		MobileTesting.printTest(20);
		
		// (21) Press the country button
		element = driver.findElementById("com.experitest.ExperiBank:id/countryButton");
		element.click();
		
		MobileTesting.printTest(21);
		
		// (22) Select France from the country list (13th on the list)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/countryList")));
		for (int i = 0; i < 12; i++) {
			driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_DOWN);
		}
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_CENTER);
		
		MobileTesting.printTest(22);
		
		// (23) Press the send payment button and ensure alert appears
		element = driver.findElementById("com.experitest.ExperiBank:id/sendPaymentButton");
		element.click();
		alert = wait.until(ExpectedConditions.alertIsPresent());
		
		MobileTesting.printTest(23);
		
		// (24) Dismiss the alert and ensure now on payment page
		alert.dismiss();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(paymentPageElements[0])));
		
		MobileTesting.printTest(24);
		
		// (25) Press the send payment button and ensure alert appears again
		element = driver.findElementById("com.experitest.ExperiBank:id/sendPaymentButton");
		element.click();
		alert = wait.until(ExpectedConditions.alertIsPresent());
		
		MobileTesting.printTest(25);
		
		// (26) Accept the alert and ensure now on summary page
		alert.accept();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(summaryPageElements[0])));
		
		MobileTesting.printTest(26);
		
		// (27) Press the logout button and ensure now on login page
		element = driver.findElementById("com.experitest.ExperiBank:id/logoutButton");
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginPageElements[0])));
		
		MobileTesting.printTest(27);
	}
}
