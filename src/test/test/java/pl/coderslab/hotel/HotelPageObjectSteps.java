package pl.coderslab.hotel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HotelPageObjectSteps {

    private WebDriver driver;
    private HotelAuthPage authPage;
    private HotelMyAccountPage myAccountPage;
    private HotelMyAddressesPage myAddressesPage;
    private HotelNewAddressPage newAddressPage;

    @Given("I'm on the hotel authentication page")
    public void imOnTheHotelAuthenticationPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");
        authPage = new HotelAuthPage(driver);
    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String login, String passwd) {
        myAccountPage = authPage.loginAs(login, passwd);
    }

    @And("I go to my addresses page")
    public void iGoToMyAddressesPage() {
        myAddressesPage = myAccountPage.goToMyAddressesPage();
    }

    @When("I add new address")
    public void iAddNewAddress() {
        newAddressPage = myAddressesPage.addNewAddress();
    }

    @Then("I can see there is no addresses")
    public void iCanSeeThereIsNoAddresses() {
        assertFalse(myAddressesPage.addressIsVisible(), "No addresses should be added to the account");
    }

    @And("I enter new address {string}, {string}, {string}, {string}")
    public void iEnterNewAddress(String address, String postalCode, String city, String phoneNumber) {
        newAddressPage.enterNewAddressData(address, city, postalCode, phoneNumber);
    }

    @Then("I can see new address")
    public void iCanSeeNewAddress() {
        assertTrue(myAddressesPage.addressIsVisible(), "Created address should be visible");
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }
}
