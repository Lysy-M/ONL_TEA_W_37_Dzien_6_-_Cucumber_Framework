package pl.coderslab.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelMyAccountPage {

    private final WebDriver driver;

    @FindBy(className = "alert-success")
    private WebElement successAlert;

    @FindBy(className = "account_user_name")
    private WebElement userInfo;

    @FindBy(css = "a[title='Home']")
    private WebElement homeBtn;

    @FindBy(css = "a[title='Addresses']")
    private WebElement myAddressesBtn;

    public HotelMyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSuccessAlertDisplayed() {
        return successAlert.isDisplayed();
    }

    public String getSuccessMessage() {
        return successAlert.getText();
    }

    public String getUserName() {
        return userInfo.getText();
    }

    public HotelMyAddressesPage goToMyAddressesPage() {
        myAddressesBtn.click();
        return new HotelMyAddressesPage(driver);
    }
}
