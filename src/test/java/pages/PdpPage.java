package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PdpPage {

  public WebDriver driver;

  public PdpPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  @FindBy(xpath = "//*[@class='fb-price-list fb-product-cta__prices']/p")
  protected WebElement precioPdp;

  @FindBy(xpath = "//button[text()='Agregar a la bolsa']")
  protected WebElement botonAgregar;

  @FindBy(xpath = "(//a[text()='Ver Bolsa de Compras'])[2]")
  protected WebElement botonVerBolsa;

  public String getPricePdp() {
    return precioPdp.getText();
  }

  public CartPage agregarProductoYverBolsa() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOf(botonAgregar));
    botonAgregar.click();
    wait.until(ExpectedConditions.visibilityOf(botonVerBolsa));
    botonVerBolsa.click();
    return new CartPage(driver);
  }

}
