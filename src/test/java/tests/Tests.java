package tests;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.DataDriven;
import utils.PropertiesDriven;

import java.util.ArrayList;

public class Tests{
    //declarar atributos
    private WebDriver driver;
    private Fravega fravega;
    private ArrayList<String> excelFRG;


    //.@AfterMethod
    public void posPrueba(){
        fravega.closeBrowser();
    }



    @BeforeMethod
    public void preparacionEjecucion(){
        //Instanciar los objetos
        excelFRG = new ArrayList<>();
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
        excelFRG = DataDriven.getData("FRG - 001");
        fravega.iraListadodeSucursales();
        System.out.println(fravega.vereficarTituloListado());
        Assertions.assertEquals(fravega.vereficarTituloListado(),excelFRG.get(1));
    }

    @Test
    public void mensajeEdentidad_FRG002(){
        excelFRG = DataDriven.getData("FRG - 002");
        fravega.iraMisDatos();
        System.out.println(fravega.vereficarMensajeIdentidad());
        Assertions.assertEquals(fravega.vereficarMensajeIdentidad(),excelFRG.get(1));
    }

    @Test
    public void vereficarTituloBuscado_FRG003(){
        excelFRG = DataDriven.getData("FRG - 003");
        fravega.buscarProducto(excelFRG.get(1));
        System.out.println(fravega.vereficarTituloBuscado());
        Assertions.assertEquals(fravega.vereficarTituloBuscado(),excelFRG.get(2));
    }

    @Test
    public void vereficarTituloMedioDePago_FRG004(){
        excelFRG = DataDriven.getData("FRG - 004");
        fravega.elegirPrimerProducto(excelFRG.get(1));
        fravega.irAMediosDePagos();
        System.out.println(fravega.vereficarTituloMedioDePagos());
        Assertions.assertEquals(fravega.vereficarTituloMedioDePagos(),excelFRG.get(2));

    }
    @Test
    public void vereficarMensajeIngresarEmail_FRG005(){
        excelFRG = DataDriven.getData("FRG - 005");
        fravega.elegirPrimerProducto(excelFRG.get(1));
        fravega.iraComprar();
        fravega.irAFinalizarCompra();
        System.out.println(fravega.vereficarMensajeIngresarEmail());
        Assertions.assertEquals(fravega.vereficarMensajeIngresarEmail(),excelFRG.get(2));
    }

    @Test
    public void vereficarCarritoVacio_FRG006(){
        excelFRG = DataDriven.getData("FRG - 006");
        fravega.elegirPrimerProducto(excelFRG.get(1));
        fravega.iraComprar();
        fravega.eliminarProducto();
        System.out.println(fravega.vereficarCarritoVacio());
        Assertions.assertEquals(fravega.vereficarCarritoVacio(),excelFRG.get(2));
    }

    @Test
    public void vereficarCambioDeCodigoPostal_FRG007(){
        excelFRG = DataDriven.getData("FRG - 007");
        fravega.cambiarcodigoPostal(excelFRG.get(1));
        System.out.println(fravega.vereficarCambioDeCodigoPostal());
        Assertions.assertEquals(fravega.vereficarCambioDeCodigoPostal(),excelFRG.get(2));
    }

    @Test
    public void busquedaDeLaMarca_FRG008(){
        excelFRG = DataDriven.getData("FRG - 008");
        fravega.ingresarMarcaEnServico(excelFRG.get(1));
        System.out.println(fravega.vereficarBusquedaDeLaMarca());
        Assertions.assertEquals(fravega.vereficarBusquedaDeLaMarca(),excelFRG.get(2));
    }

    @Test
    public void contactanos_FRG009(){
        excelFRG = DataDriven.getData("FRG - 009");
        fravega.iraContactanos();
        System.out.println(fravega.vereficarContactanos());
        Assertions.assertEquals(fravega.vereficarContactanos(),excelFRG.get(1));
    }


    @Test
    public void cupon_FRG010() {
        excelFRG = DataDriven.getData("FRG - 010");
        fravega.elegirPrimerProducto(excelFRG.get(1));
        fravega.iraComprar();
        fravega.iraCupon(excelFRG.get(2));
        System.out.println(fravega.vereficarCupon());
        Assertions.assertEquals(fravega.vereficarCupon(),excelFRG.get(3));
    }

    @Test
    public void filtroHogar_FRG011(){
        excelFRG = DataDriven.getData("FRG - 011");
        fravega.buscarProducto(excelFRG.get(1));
        fravega.ponerFiltroHogar();
        System.out.println(fravega.vereficarFiltroHogar());
        Assertions.assertEquals(fravega.vereficarFiltroHogar(),excelFRG.get(2));
    }

    @Test
    public void ventaTelefonica_FRG012(){
        excelFRG = DataDriven.getData("FRG - 012");
        fravega.irAVentaTelefonica();
        System.out.println(fravega.vereficarVentaTelefonica());
        Assertions.assertEquals(fravega.vereficarVentaTelefonica(),excelFRG.get(1));
    }
}
