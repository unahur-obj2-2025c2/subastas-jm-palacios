package ar.edu.unahur.obj2.observer.estrategias;

public class EstrategiaConLimite implements IEstrategiaDeOferta{
    private Double limite;
    
    public EstrategiaConLimite(Double limite) {
        this.limite = limite;
    }


    @Override
    public Double calcularOferta(Double valorActual) {
        Double nuevaOferta = valorActual + 10.0;
        return nuevaOferta <= limite ? nuevaOferta : null;
    }

}
