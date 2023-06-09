package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class Fravega extends BaseClass {
    public Fravega(WebDriver driver) {
        super(driver);
    }

    //fravega XPATH
    //-1
    //Cerrar Mensaje del principio
    By clickCerrarMensaje = By.xpath("//button[@class=\"sc-exiMOr jpVnmJ\"]");
    //Sucursales Navbar
    By clickSucursales = By.xpath("//*[@id=\"__next\"]/div[2]/header/div[1]/ul/li[3]/a/span/span");
    //Seleccionar listado sucursales
    By clickListadoSuc = By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/a");
    //Vereficar Titulo
    By verefTituloListado = By.xpath("//h1[normalize-space()=\"Listado de Sucursales\"]");

    //-2
    //Mi Cuenta
    By clickMiCuenta = By.xpath("//a/div[normalize-space()=\"Mi cuenta\"]");
    //Mis Datos
    By clickMisDatos = By.xpath("//section/a[@href=\"https://www.fravega.com/mi-cuenta/datos\"]");
    //Elegir Opciones de Identidad
    By verefMensajeIdentidad = By.xpath("//span[normalize-space()=\"Elija una de las opciones para confirmar su identidad\"]");

    //-3
    //Buscador
    By escrbBuscador = By.xpath("//input[@placeholder=\"Buscar productos\"]");
    //Vereficar Titulo buscado
    By verefTituloBuscado = By.xpath("//h1[@data-test-id=\"result-title\"]");

    //-4
    //Click en el primer producto
    By clikPrimerProduct = By.xpath("//ul[@data-test-id=\"results-list\"]/li[1]");

    //Ir a medios de pagos
    By clickMedioDePagos = By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div/a");

    //Vereficar titulo de medio de pagos
    By verefTituloMedioPagos = By.xpath("//p[@class=\"sc-9d446dcb-6 dkvjnK\"]");

    //-5
    //click en comprar
    By clickComprar = By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div[7]/button");
    //Finalizar compra
    By clickfinalizarCompra = By.xpath("//a[@href=\"#/orderform\"]");
    //Vereficar mensaje de ingresar email
    By verefIngresarEmail = By.xpath("//span[normalize-space()=\"Ingresa tu mail para continuar la compra.\"]");

    //-6
    //Elimar Producto
    By clickEliminarProduc = By.xpath("//td[@class=\"item-remove\"]");
    //Texto de carrito Vacio
    By verefCarritoVacio = By.xpath("//h2[normalize-space()=\"Su carrito está vacio\"]");

    //-7
    //Cambiar Codigo Postal
    By clickcodigoPostal = By.xpath("//button[@data-test-id=\"geo-sticky\"]");
    //Ingresar Codigo Postal
    By escrbCodigoPostal = By.xpath("//input[@name=\"postalNumber\"]");
    //Vereficar el cambio de codigo postal
    By verefCambioPostal = By.xpath("//p[@class=\"sc-iuAqRD fvJZEs\"]");

    //-8
    //Ir a servicio Tecnico
    By clickServicioTecnico = By.xpath("//*[@id=\"__next\"]/div[2]/header/div[1]/ul/li[2]/a");
    //Ingresar Marca del producto
    By escrbMarca = By.xpath("//input[@placeholder=\"Ingresá la marca de tu producto\"]");
    //Vereficar el contenido despues de la busqueda
    By verefBusquedaDeMarca = By.xpath("//h2[@class=\"sc-kcuKUB iaKKvN\"]");

    //-9
    //Centro de ayuda

    By clickCentroAyuda = By.xpath("//*[@id=\"__next\"]/div[2]/header/div[1]/ul/li[5]/a/span/span");

    //contactanos
    By clickContactanos = By.xpath("//a[normalize-space()=\"CONTACTANOS\"]");

    //Validar CONTACTANOS
    By varefContactanos = By.xpath("//h2[normalize-space()=\"Contactanos\"]");

    //-10
    //Click en input cupon
    By clickCupon = By.xpath("//*[@id=\"cart-coupon\"]");

    //Validar CuponFravega
    By verefCuponFrav = By.xpath("//span[@class=\"vtex-front-messages-detail\"]");

    //-11
    //click en el filtro Hogar
    By clickFiltroHogar = By.xpath("//a[@href=\"/l/pequenos-electrodomesticos/hogar/?keyword=tele\"]");
    //Validar Filtro Hogar
    By verefFiltroHogar = By.xpath("//span[@itemprop=\"name\" and normalize-space() = \"Hogar\"]");

    //-12
    //Ir a venta telefonica
    By clickVentaTelefonica = By.xpath("//*[@id=\"__next\"]/div[2]/header/div[1]/ul/li[4]/span");
    // Vereficar titulo venta telefonica
    By verefVentaTelefonica = By.xpath("//h1");



//1
    public void iraListadodeSucursales() {
        click(clickCerrarMensaje);
        click(clickSucursales);
        threadSleep(2000);
        click(clickListadoSuc);
    }

    public String vereficarTituloListado(){
        wait(verefTituloListado,5);
        return getText(verefTituloListado);
    }
//2
    public void iraMisDatos(){
        click(clickCerrarMensaje);
        click(clickMiCuenta);
        wait(clickMiCuenta,5);
        click(clickMisDatos);
    }

    public String vereficarMensajeIdentidad(){
        wait(verefMensajeIdentidad,10);
        return getText(verefMensajeIdentidad);
    }
    //3
    public void buscarProducto(String texto){
        click(clickCerrarMensaje);
        click(escrbBuscador);
        write(escrbBuscador,texto);
        enterBuscador(escrbBuscador);
    }

    public String vereficarTituloBuscado(){
        wait(verefTituloBuscado,5);
        return getText(verefTituloBuscado);
    }

    //4
    public void elegirPrimerProducto(String texto){
        buscarProducto(texto);
        wait(clikPrimerProduct,5);
        click(clikPrimerProduct);
    }

    public void irAMediosDePagos(){
        wait(clickMedioDePagos,5);
        click(clickMedioDePagos);
    }

    public String vereficarTituloMedioDePagos(){
        wait(verefTituloMedioPagos,5);
        return getText(verefTituloMedioPagos);
    }


    public void iraComprar(){
        wait(clickComprar,5);
        click(clickComprar);
    }
    //5
    public void irAFinalizarCompra(){
        wait(clickfinalizarCompra,5);
        click(clickfinalizarCompra);
    }
    public String vereficarMensajeIngresarEmail(){
        wait(verefIngresarEmail,5);
        return getText(verefIngresarEmail);
    }

    //6
    public void eliminarProducto(){
        wait(clickEliminarProduc,5);
        click(clickEliminarProduc);
    }
    public String vereficarCarritoVacio(){
        wait(verefCarritoVacio,10);
        return getText(verefCarritoVacio);
    }

    //7
    public void cambiarcodigoPostal(String texto){
        click(clickCerrarMensaje);
        click(clickcodigoPostal);
        wait(escrbCodigoPostal,5);
        click(escrbCodigoPostal);
        write(escrbCodigoPostal,texto);
        enterBuscador(escrbCodigoPostal);
    }

    public String vereficarCambioDeCodigoPostal(){
        wait(verefCambioPostal,5);
        threadSleep(2000);
        return getText(verefCambioPostal);
    }

    //-8
    public void ingresarMarcaEnServico(String texto){
        click(clickCerrarMensaje);
        click(clickServicioTecnico);
        wait(escrbMarca,5);
        click(escrbMarca);
        write(escrbMarca,texto);
        enterBuscador(escrbMarca);
    }

    public String vereficarBusquedaDeLaMarca(){
        wait(verefBusquedaDeMarca,5);
        return getText(verefBusquedaDeMarca);
    }

    //-9
    public void iraContactanos() {
        click(clickCerrarMensaje);
        click(clickCentroAyuda);
        threadSleep(2000);
        click(clickContactanos);
    }

    public String vereficarContactanos(){
        wait(varefContactanos,5);
        return getText(varefContactanos);
    }

    //-10
    public void iraCupon(String texto) {
        wait(clickCupon,5);
        click(clickCupon);
        write(clickCupon,texto);
        enterBuscador(clickCupon);
    }

    public String vereficarCupon(){
        //wait(varefContactanos,5);
        threadSleep(3000);
        return getText(verefCuponFrav);
    }

    //11
    public void ponerFiltroHogar(){
        wait(clickFiltroHogar,5);
        click(clickFiltroHogar);
    }

    public String vereficarFiltroHogar(){
        wait(verefFiltroHogar,5);
        return getText(verefFiltroHogar);
    }

    //12
    public void irAVentaTelefonica(){
        click(clickCerrarMensaje);
        click(clickVentaTelefonica);
        wait(verefVentaTelefonica,5);
    }

    public String vereficarVentaTelefonica(){
        return getText(verefVentaTelefonica);
    }
}


