package tests;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import dataproviders.Dataproviders;
import entidades.TestData;
import pages.CartPage;
import pages.Homepage;
import pages.PlpPage;


public class Test2 {

  WebDriver driver;

  @BeforeTest
  public void configuracion() {
    // Chromedriver version 75
    System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.get("https://www.falabella.com/falabella-cl");
  }

  @AfterMethod(alwaysRun = true)
  public void salir() {
    driver.manage().deleteAllCookies();
    driver.quit();
  }

  @Test(dataProvider = "datos1", dataProviderClass = Dataproviders.class)
  public void test2(TestData data) {
    Homepage home = new Homepage(driver);
    PlpPage plp = home.buscarProductoPorPalabra(data.getPalabra());
    String primerPrecioPlp = plp.getFirstPricePlp();
    CartPage carro = plp.agregarPrimerProductoYverBolsa();
    String precioCarro = carro.getPriceCarro();
    assertTrue(primerPrecioPlp.equals(precioCarro), "Los precios son distintos!");
  }
}
