package ar.edu.unahur.obj2.observer;

public class Oferta {
    private final ISubastador subastador;
    private final Double valor;
    
    public Oferta(ISubastador subastador, Double valor) {
        this.subastador = subastador;
        this.valor = valor;
    }
    public ISubastador getSubastador() {
        return subastador;
    }
    public Double getValor() {
        return valor;
    }
    
    

}
