package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlpPage {

  public WebDriver driver;
  Actions action;

  public PlpPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  @FindBy(xpath = "(//div[@class='fb-price-list']/p)[1]")
  protected WebElement primerPrecioPlp;

  @FindBy(xpath = "(//button[@class='btn-add-to-basket'])[1]")
  protected WebElement primerBotonAgregar;

  @FindBy(xpath = "(//a[text()='Ver Bolsa de Compras'])[2]")
  protected WebElement botonVerBolsa;

  public String getFirstPricePlp() {
    return primerPrecioPlp.getText();
  }

  public CartPage agregarPrimerProductoYverBolsa() {
    action = new Actions(driver);
    action.moveToElement(primerPrecioPlp);
    primerBotonAgregar.click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOf(botonVerBolsa));
    botonVerBolsa.click();
    return new CartPage(driver);
  }

}
