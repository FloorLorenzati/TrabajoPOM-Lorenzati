package tests;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.PropertiesDriven;

import java.util.ArrayList;

public class Tests{
    //declarar atributos
    private WebDriver driver;
    private Fravega fravega;
    private ArrayList<String> excelCPG;


    //.@AfterMethod
    public void posPrueba(){
        fravega.closeBrowser();
    }



    @BeforeMethod
    public void preparacionEjecucion(){
        //Instanciar los objetos
        excelCPG = new ArrayList<>();
        //Pages
        fravega = new Fravega(driver);
        //Usamos cualquir pages para conextar a las properties
        fravega.conexionDriver
                (PropertiesDriven.getProperty("browser")
                        ,PropertiesDriven.getProperty("rutaDriver")
                        ,PropertiesDriven.getProperty("propertyDriver"));
        fravega.cargarSitio(PropertiesDriven.getProperty("url"));
        fravega.maximizarBrowser();
        //Espera pag
        fravega.threadSleep(2000);
    }

    @Test
    public void tituloListado_FRG001(){
        fravega.iraListadodeSucursales();
        System.out.println(fravega.vereficarTituloListado());
        Assertions.assertEquals(fravega.vereficarTituloListado(),"Listado de Sucursales");
    }

    @Test
    public void mensajeEdentidad_FRG002(){
        fravega.iraMisDatos();
        System.out.println(fravega.vereficarMensajeIdentidad());
        Assertions.assertEquals(fravega.vereficarMensajeIdentidad(),"Elija una de las opciones para confirmar su identidad");
    }

    @Test
    public void vereficarTituloBuscado_FRG003(){
        fravega.buscarProducto("tele");
        System.out.println(fravega.vereficarTituloBuscado());
        Assertions.assertEquals(fravega.vereficarTituloBuscado(),"Tele");
    }

    @Test
    public void vereficarTituloMedioDePago_FRG004(){
        fravega.elegirPrimerProducto("heladera");
        fravega.irAMediosDePagos();
        System.out.println(fravega.vereficarTituloMedioDePagos());
        Assertions.assertEquals(fravega.vereficarTituloMedioDePagos(),"Medios de pago y cuotas");

    }
    @Test
    public void vereficarMensajeIngresarEmail_FRG005(){
        fravega.elegirPrimerProducto("PC");
        fravega.iraComprar();
        fravega.irAFinalizarCompra();
        System.out.println(fravega.vereficarMensajeIngresarEmail());
        Assertions.assertEquals(fravega.vereficarMensajeIngresarEmail(),"Ingresa tu mail para continuar la compra.");
    }

    @Test
    public void vereficarCarritoVacio_FRG006(){
        fravega.elegirPrimerProducto("PC");
        fravega.iraComprar();
        fravega.eliminarProducto();
        System.out.println(fravega.vereficarCarritoVacio());
        Assertions.assertEquals(fravega.vereficarCarritoVacio(),"Su carrito está vacio");
    }

    @Test
    public void vereficarCambioDeCodigoPostal_FRG007(){
        fravega.cambiarcodigoPostal("7000");
        System.out.println(fravega.vereficarCambioDeCodigoPostal());
        Assertions.assertEquals(fravega.vereficarCambioDeCodigoPostal(),"Estás en\n" + "Tandil\n" + "(7000)");
    }

    @Test
    public void busquedaDeLaMarca_FRG008(){
        fravega.ingresarMarcaEnServico("hp");
        System.out.println(fravega.vereficarBusquedaDeLaMarca());
        Assertions.assertEquals(fravega.vereficarBusquedaDeLaMarca(),"HP");
    }

    @Test
    public void contactanos_FRG009(){
        fravega.iraContactanos();
        System.out.println(fravega.vereficarContactanos());
        Assertions.assertEquals(fravega.vereficarContactanos(),"Contactanos");
    }


    @Test
    public void cupon_FRG010() {
        fravega.elegirPrimerProducto("PC");
        fravega.iraComprar();
        fravega.iraCupon("CuponFravega");
        System.out.println(fravega.vereficarCupon());
        Assertions.assertEquals(fravega.vereficarCupon(),"Cupón CuponFravega inválido");
    }

    @Test
    public void filtroHogar_FRG011(){
        fravega.buscarProducto("tele");
        fravega.ponerFiltroHogar();
        System.out.println(fravega.vereficarFiltroHogar());
    }

    @Test
    public void ventaTelefonica_FRG012(){
        fravega.irAVentaTelefonica();
        System.out.println(fravega.vereficarVentaTelefonica());
        Assertions.assertEquals(fravega.vereficarVentaTelefonica(),"Venta telefónica");
    }
}
