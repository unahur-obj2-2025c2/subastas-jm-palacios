package ar.edu.unahur.obj2.observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.observer.excepciones.SubastadorNoAdheridoException;

public class ProductoSubastado implements ISubastado{
    private Set<ISubastador> subastadores = new HashSet<>();
    private List<Oferta> ofertas = new ArrayList<>();   
    private Double ofertaInicial;

    public ProductoSubastado(Double ofertaInicial) {
        this.ofertaInicial = ofertaInicial;
    }
    public void actualizaOfertaInicial(Oferta nuevaOferta){
        ofertaInicial = nuevaOferta.getValor();
    }
    public Double getOfertaInicial() {
        return ofertaInicial;
    }
    @Override
    public void agregarOferta(Oferta nuevaOferta) {
        if(!subastadores.contains(nuevaOferta.getSubastador())){
            throw new SubastadorNoAdheridoException("El subastador no participa en la subasta");
        }
        ofertas.add(nuevaOferta);
        actualizaOfertaInicial(nuevaOferta);
    }

    @Override
    public void registrarSubatador(ISubastador unSubastador) {
        subastadores.add(unSubastador);
    }

    @Override
    public void eliminarSubastador(ISubastador unSubastador) {
        subastadores.remove(unSubastador);
    }

    @Override
    public void notificar(Oferta unaOferta) {
        subastadores.forEach(s->s.actualizar(unaOferta));
    }
    
}
