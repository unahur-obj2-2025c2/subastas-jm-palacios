package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.estrategias.IEstrategiaDeOferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaInvalidaException;

public class Subastador implements ISubastador{
    private final String nombreUsuario;
    private Double ultimaOferta = 0.0;
    private IEstrategiaDeOferta estrategia;    

    public Subastador(String nombreUsuario , IEstrategiaDeOferta estrategia) {
        this.nombreUsuario = nombreUsuario;
        this.estrategia = estrategia;
    }  

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Double getUltimaOferta() {
        return ultimaOferta;
    }

    @Override
    public void reiniciarPuja(){
        ultimaOferta = 0.0;
    }

    @Override
    public void actualizar(Oferta oferta) {
        ultimaOferta = oferta.getValor(); 
    }

    @Override
    public Oferta ofertar() {
        Double nuevaOferta = estrategia.calcularOferta(ultimaOferta);
        if(nuevaOferta == null){
            throw new OfertaInvalidaException("Oferta invalida por Estartegia");
        }
        return new Oferta(this, nuevaOferta);
    }
    
}
