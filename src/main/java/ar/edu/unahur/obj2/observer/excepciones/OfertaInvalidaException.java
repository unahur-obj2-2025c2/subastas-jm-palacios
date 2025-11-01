package ar.edu.unahur.obj2.observer.excepciones;

public class OfertaInvalidaException extends RuntimeException{
    public OfertaInvalidaException(String mensaje){
        super(mensaje);
    }

}
