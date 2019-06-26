package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

  public WebDriver driver;

  public Homepage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  @FindBy(id = "searchQuestionSolr")
  protected WebElement searchBox;

  public PdpPage buscarProductoPorSku(String sku) {
    searchBox.sendKeys(sku);
    searchBox.sendKeys(Keys.ENTER);
    return new PdpPage(driver);
  }

  public PlpPage buscarProductoPorPalabra(String palabra) {
    searchBox.sendKeys(palabra);
    searchBox.sendKeys(Keys.ENTER);
    return new PlpPage(driver);
  }
}
