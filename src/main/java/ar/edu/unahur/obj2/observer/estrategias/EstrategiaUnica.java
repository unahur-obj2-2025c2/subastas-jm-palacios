package ar.edu.unahur.obj2.observer.estrategias;

public class EstrategiaUnica implements IEstrategiaDeOferta{
    private Boolean yaOferto = Boolean.FALSE;    

    @Override
    public Double calcularOferta(Double valorActual) {
        if (yaOferto){
            return null;
        }
        yaOferto = Boolean.TRUE;  
        return valorActual + 10.00;

    }

}
