import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormPageObject {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        FormPage formPage = new FormPage();
        formPage.submitForm(driver);

        ConfirmationPage confirmationPage = new ConfirmationPage();
        confirmationPage.waitForAlertBanner(driver);

        assertEquals("The form was successfully submitted!", confirmationPage.getAlertBannerText(driver));

        driver.quit();
    }
}
