package pl.coderslab.hotel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HotelSteps {

    private static WebDriver driver;

    @Given("I'm on hotel main page")
    public void imOnHotelMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @When("I sign in")
    public void iSignIn() {
        driver.findElement(By.className("user_login")).click();
    }

    @And("I enter email that is not already taken on the authentication page")
    public void iEnterEmailThatIsNotAlreadyTakenOnTheAuthenticationPage() {
        String email = String.format("artur%s@test.com", System.currentTimeMillis());
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @And("I enter name {word} surname {word} and password {word}")
    public void iEnterNameSurnameAndPassword(String firstname, String lastname, String passwd) {
        driver.findElement(By.id("customer_firstname")).sendKeys(firstname);
        driver.findElement(By.id("customer_lastname")).sendKeys(lastname);
        driver.findElement(By.id("passwd")).sendKeys(passwd);
        driver.findElement(By.name("submitAccount")).click();
    }

    @Then("I can see success message with text {string}")
    public void iCanSeeSuccessMessageWithText(String messageText) {
        WebElement alert = driver.findElement(By.className("alert-success"));
        assertTrue(alert.isDisplayed());
        assertEquals(messageText, alert.getText());
    }

    @And("I close hotel browser")
    public void iCloseHotelBrowser() {
        driver.quit();
    }
}
