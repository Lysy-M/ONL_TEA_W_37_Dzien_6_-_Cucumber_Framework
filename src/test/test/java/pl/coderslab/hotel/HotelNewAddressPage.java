package pl.coderslab.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelNewAddressPage {

    private final WebDriver driver;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "postcode")
    private WebElement postalCodeInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "phone_mobile")
    private WebElement phoneNumberInput;

    @FindBy(name = "submitAddress")
    private WebElement submitBtn;

    public HotelNewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterNewAddressData(String address, String city, String postalCode, String phoneNumber) {
        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.clear();
        cityInput.sendKeys(city);

        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);

        submitBtn.click();
    }
}
