package pl.coderslab.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelMyAddressesPage {

    private final WebDriver driver;

    @FindBy(css = "a[title='Add an address']")
    private WebElement newAddressBtn;

    @FindBy(className = "address")
    private List<WebElement> addresses;

    public HotelMyAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HotelNewAddressPage addNewAddress() {
        newAddressBtn.click();
        return new HotelNewAddressPage(driver);
    }

    public boolean addressIsVisible() {
        return addresses.size() > 0;
    }
}
