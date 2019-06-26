package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

  public WebDriver driver;

  public CartPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  @FindBy(xpath = "(//*[@class='fb-pod__internet-prices__from'])[1]")
  protected WebElement precioCarro;

  public String getPriceCarro() {
    return precioCarro.getText();
  }

}
