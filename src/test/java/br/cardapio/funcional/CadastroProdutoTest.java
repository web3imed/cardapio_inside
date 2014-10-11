package br.cardapio.funcional;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CadastroProdutoTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/cardapio";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCadastroProduto() throws Exception {
    driver.get(baseUrl + "/produto");
    driver.findElement(By.linkText("adicionar")).click();
    driver.findElement(By.name("produto.id")).clear();
    driver.findElement(By.name("produto.id")).sendKeys("1");
    driver.findElement(By.name("produto.nome")).clear();
    driver.findElement(By.name("produto.nome")).sendKeys("Pastel");
    driver.findElement(By.name("produto.valor")).clear();
    driver.findElement(By.name("produto.valor")).sendKeys("14");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("adicionar")).click();
    driver.findElement(By.name("produto.id")).clear();
    driver.findElement(By.name("produto.id")).sendKeys("2");
    driver.findElement(By.name("produto.nome")).clear();
    driver.findElement(By.name("produto.nome")).sendKeys("Pizza");
    driver.findElement(By.name("produto.valor")).clear();
    driver.findElement(By.name("produto.valor")).sendKeys("19,5");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("adicionar")).click();
    driver.findElement(By.name("produto.id")).clear();
    driver.findElement(By.name("produto.id")).sendKeys("3");
    driver.findElement(By.name("produto.nome")).clear();
    driver.findElement(By.name("produto.nome")).sendKeys("Cerveja Pilsen");
    driver.findElement(By.name("produto.valor")).clear();
    driver.findElement(By.name("produto.valor")).sendKeys("7.5");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'editar')])[2]")).click();
    driver.findElement(By.name("produto.valor")).clear();
    driver.findElement(By.name("produto.valor")).sendKeys("15");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("editar")).click();
    driver.findElement(By.name("produto.nome")).clear();
    driver.findElement(By.name("produto.nome")).sendKeys("Pastel de Frango");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'deletar')])[2]")).click();
    driver.findElement(By.linkText("deletar")).click();
    driver.findElement(By.linkText("deletar")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
