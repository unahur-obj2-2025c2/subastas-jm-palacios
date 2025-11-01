package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.estrategias.EstrategiaArriesgada;
import ar.edu.unahur.obj2.observer.excepciones.SubastadorNoAdheridoException;

public class ProductoSubastadoTest {
    private ProductoSubastado productoSubastado = new ProductoSubastado(10.00);
    private Subastador gonzager = new Subastador("gonzager", new EstrategiaArriesgada());
    private Subastador diazdan = new Subastador("diazdan", new EstrategiaArriesgada());
    private Subastador martomau = new Subastador("martomau", new EstrategiaArriesgada());

    @BeforeEach
    void setUp(){
        productoSubastado.limpiarOfertasYSubastadores();
        productoSubastado.registrarSubastador(gonzager);
        productoSubastado.registrarSubastador(martomau);
    }
    
    @Test
    void dadoElEscenario1_seVerificaQuelosSubastadoresGonzagerYMartomauRecibenCorectamenteLaUltimaOfertaREalizada(){
        Oferta oferta1 = martomau.ofertar();
        productoSubastado.agregarOferta(oferta1);         

        Oferta oferta2 = gonzager.ofertar();
        productoSubastado.agregarOferta(oferta2);         

        Oferta oferta3 = martomau.ofertar();
        productoSubastado.agregarOferta(oferta3);
         

        assertEquals(30, gonzager.getUltimaOferta());
        assertEquals(30, martomau.getUltimaOferta());        
    }

    @Test
    void dadoEscenario1_seVerificaQueLaUltimaOfertaREgistradaPertenceAMortomau(){
        Oferta oferta1 = martomau.ofertar();
        productoSubastado.agregarOferta(oferta1);         

        Oferta oferta2 = gonzager.ofertar();
        productoSubastado.agregarOferta(oferta2);         

        Oferta oferta3 = martomau.ofertar();
        productoSubastado.agregarOferta(oferta3);

        assertEquals(martomau, oferta3.getSubastador());
    }

    @Test
    void dadoEscenario1_seVerificaQueElValorDeLaUltimaOfertaSeaCorrecto30_desmostrandoElIncremento(){
        Oferta oferta1 = martomau.ofertar();
        productoSubastado.agregarOferta(oferta1);         

        Oferta oferta2 = gonzager.ofertar();
        productoSubastado.agregarOferta(oferta2);         

        Oferta oferta3 = martomau.ofertar();
        productoSubastado.agregarOferta(oferta3);

        assertEquals(30, productoSubastado.ultimaOferta().getValor());
    }

    @Test
    void dadoEscenario1_seVerificaQueLaCantidadDeOfertasRegistradassea3(){
        Oferta oferta1 = martomau.ofertar();
        productoSubastado.agregarOferta(oferta1);         

        Oferta oferta2 = gonzager.ofertar();
        productoSubastado.agregarOferta(oferta2);         

        Oferta oferta3 = martomau.ofertar();
        productoSubastado.agregarOferta(oferta3);

        assertEquals(3, productoSubastado.cantidadOfertas());
    }

    @Test
    void dadoEscenario1_alIntenatarAgregarOfertaDeDiazden_seVerificaQueLanzaExcepcionCorrrespondiente(){
        Oferta oferta1 = martomau.ofertar();
        productoSubastado.agregarOferta(oferta1);         

        Oferta oferta2 = gonzager.ofertar();
        productoSubastado.agregarOferta(oferta2);         

        Oferta oferta3 = martomau.ofertar();
        productoSubastado.agregarOferta(oferta3);

        Oferta oferta4 = diazdan.ofertar();
        SubastadorNoAdheridoException exception = assertThrows(SubastadorNoAdheridoException.class, 
        ()->productoSubastado.agregarOferta(oferta4));

        assertEquals("El subastador no participa en la subasta", exception.getMessage());
    }
    @Test
    void dadoElEscenario1_AlSacarDeLaSubastaAGonzager_siEsteOferta_seVerificaQueLanzaLaExcepcionCorespondiente(){
         Oferta oferta1 = martomau.ofertar();
        productoSubastado.agregarOferta(oferta1);         

        Oferta oferta2 = gonzager.ofertar();
        productoSubastado.agregarOferta(oferta2);         

        Oferta oferta3 = martomau.ofertar();
        productoSubastado.agregarOferta(oferta3);

        productoSubastado.eliminarSubastador(gonzager);

        Oferta oferta4 = gonzager.ofertar();
        SubastadorNoAdheridoException exception = assertThrows(SubastadorNoAdheridoException.class, 
        ()->productoSubastado.agregarOferta(oferta4));

        assertEquals("El subastador no participa en la subasta", exception.getMessage());
    }

    

}
