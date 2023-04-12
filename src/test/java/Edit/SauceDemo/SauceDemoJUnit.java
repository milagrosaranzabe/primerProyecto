package Edit.SauceDemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoJUnit {
	
	String url = "https://www.saucedemo.com/";
	WebDriver driver;
	
	//CP 01 - Comprar un producto en Sauce Demo
	@Test
	public void login() {
		
		// Abrir navegador (Open the browser)
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Iniciar sesión (Login)
		WebElement txtUsername = driver.findElement(By.id("user-name"));
		txtUsername.sendKeys("standard_user");
		
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys("secret_sauce");
		
		WebElement btnLogin = driver.findElement(By.id("login-button"));
		btnLogin.click();
		
		// Agregar producto al carrito (Add a product to cart)
		WebElement btnAddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		btnAddToCart.click();
		
		// Ir al carro de compras (Go to the Cart)
		WebElement btnCart = driver.findElement(By.cssSelector(".shopping_cart_link"));
		btnCart.click();
		
		// Seguir proceso de compra (Checkout in Cart)
		WebElement btnCheckout = driver.findElement(By.id("checkout"));
		btnCheckout.click();
		
		// Completar el formuario de compra (Checkout's information form)
		WebElement txtFirstname = driver.findElement(By.id("first-name"));
		txtFirstname.sendKeys("Milagros");
		
		WebElement txtLastname = driver.findElement(By.id("last-name"));
		txtLastname.sendKeys("Aranzabe");
		
		WebElement txtCode = driver.findElement(By.id("postal-code"));
		txtCode.sendKeys("7000");
		
		WebElement btnContinue = driver.findElement(By.id("continue"));
		btnContinue.click();
		
		// Terminar el proceso de compra (Finish checkout)
		WebElement btnFinish = driver.findElement(By.id("finish"));
		btnFinish.click();
		
		// Validar que es la pantalla correcta
		String urlActual = driver.getCurrentUrl();
		String urlEsperada = "https://www.saucedemo.com/checkout-complete.html";
		
		Assert.assertEquals(urlActual, urlEsperada);
		
		// Cerrar el navegador (Close the browser)
		driver.close();
		
	}
	
}
