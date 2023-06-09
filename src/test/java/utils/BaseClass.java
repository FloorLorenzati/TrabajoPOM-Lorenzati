package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.StringTokenizer;

public class BaseClass {
    //Atributos
    protected WebDriver driver;
    protected static WebDriverWait wait;


    //Accesadores y mutadores
    public WebDriver getDriver() {
        return driver;
    }

    //Constructor
    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    //Acciones con selenium


    //Cargar el sitio
    public void cargarSitio(String url){
        this.driver.get(url);
    }

    //EsperasExplicitas
    public  WebElement wait(By localizador, int tiempo){
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(tiempo));
        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    //EsperasImplicitas
    public void threadSleep(int milisegundos) {
        try{
            Thread.sleep(milisegundos);
        }catch(Exception e){
            System.out.println("Ocurrio un error durante la espera..");
            System.out.println(e.getStackTrace());
        }
    }

    //Click
    public void click(By locator){
        driver.findElement(locator).click();
    }

    //obtenerTexto
    public String getText(By localizador){
        return this.driver.findElement(localizador).getText();
    }


    //agregarTexto
    public void write(By localizador,String texto){
        estaHabilitado(localizador);
        this.driver.findElement(localizador).sendKeys(texto);
    }

    //enter
    public void enterBuscador(By localizador){
        estaHabilitado(localizador);
        this.driver.findElement(localizador).sendKeys(Keys.ENTER);
    }

    //Entrar en el iframe
    public void entrarIfreme(int indice){
        driver.switchTo().frame(indice);
    }


    //maximizarBrowser
    public void maximizarBrowser(){
        this.driver.manage().window().maximize();
    }

    //cerrarBrowser
    public void closeBrowser(){
        this.driver.close();
    }

    //Scroll
    public void scroll(int xPixeles, int yxPixeles){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+xPixeles+","+yxPixeles+")");
    }



    //conexionDriver
    public WebDriver conexionDriver(String browser,String rutaDriver, String propertyDriver){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty(propertyDriver,rutaDriver);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            this.driver = new ChromeDriver(options);
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty(propertyDriver,rutaDriver);
            this.driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("IExplorer")){
            System.setProperty(propertyDriver,rutaDriver);
            this.driver = new InternetExplorerDriver();
        }
        return this.driver;
    }

    public boolean estaHabilitado(By localizador){
        try{
            return this.driver.findElement(localizador).isEnabled();
        }catch (Exception e){
            System.out.println("No se verifico que el elemento asociado el locator:"+localizador.toString()+" estuviera habilitado");
            return false;
        }
    }

    public String obtenerUrlPagina(){
        return this.driver.getCurrentUrl();
    }
}
