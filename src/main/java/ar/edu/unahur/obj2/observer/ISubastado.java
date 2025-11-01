package ar.edu.unahur.obj2.observer;

public interface ISubastado {
    void agregarOferta(Oferta unaOferta);
    void registrarSubastador(ISubastador unSubastador);
    void eliminarSubastador(ISubastador unSubastador);
    
}
