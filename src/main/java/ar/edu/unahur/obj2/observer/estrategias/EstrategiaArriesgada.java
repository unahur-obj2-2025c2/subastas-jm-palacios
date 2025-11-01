package ar.edu.unahur.obj2.observer.estrategias;

public class EstrategiaArriesgada implements IEstrategiaDeOferta{

    @Override
    public Double calcularOferta(Double valorActual) {
        return valorActual + 10.0;
    }

    

}
