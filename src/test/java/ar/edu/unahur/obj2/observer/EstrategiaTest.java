package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.estrategias.EstrategiaArriesgada;
import ar.edu.unahur.obj2.observer.estrategias.EstrategiaConLimite;
import ar.edu.unahur.obj2.observer.estrategias.EstrategiaUnica;
import ar.edu.unahur.obj2.observer.excepciones.OfertaInvalidaException;

public class EstrategiaTest {
    private ProductoSubastado productoSubastado = new ProductoSubastado(10.00);
    private Subastador gonzager = new Subastador("gonzager", new EstrategiaArriesgada());
    private Subastador diazdan = new Subastador("diazdan", new EstrategiaConLimite(20.00));
    private Subastador martomau = new Subastador("martomau", new EstrategiaUnica());

    @BeforeEach
    void setUp(){
        productoSubastado.limpiarOfertasYSubastadores();
        productoSubastado.registrarSubastador(gonzager);
        productoSubastado.registrarSubastador(martomau);
        productoSubastado.registrarSubastador(diazdan);
    }
    @Test
    void dadoElEscenarioDondeDiazdanOfertaPorDebajoDelLimite20_esAceptada() {
        Oferta oferta1 = diazdan.ofertar();
        productoSubastado.agregarOferta(oferta1);       

        assertEquals(oferta1, productoSubastado.ultimaOferta());        
    }
    @Test
    void dadoElEscenarioDondeTodosofertanUnaVezCuandoDiazdanOfertaNuevamente_entoncesLanazaLaExcepcionCorrespondiente() {
        Oferta oferta1 = diazdan.ofertar();
        productoSubastado.agregarOferta(oferta1);
         Oferta oferta2 =gonzager.ofertar();
        productoSubastado.agregarOferta(oferta2);
        Oferta oferta3 = martomau.ofertar();
        productoSubastado.agregarOferta(oferta3);

        OfertaInvalidaException ex = assertThrows(OfertaInvalidaException.class, 
        ()-> diazdan.ofertar());

        assertEquals("Oferta invalida por Estartegia", ex.getMessage());
        
    }

    @Test 
    void dadoElElEscenarioDondeDiazdanOfertaDosVeces_entoncesLanazaLaExcepcionCorrespondiente(){
        Oferta oferta1 = martomau.ofertar();

        OfertaInvalidaException excepcion = assertThrows(OfertaInvalidaException.class, 
        ()->  martomau.ofertar());

        assertEquals("Oferta invalida por Estartegia", excepcion.getMessage());
    }
    
}
