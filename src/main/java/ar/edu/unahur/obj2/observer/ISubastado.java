package ar.edu.unahur.obj2.observer;

public interface ISubastado {
    void agregarOferta(Oferta unaOferta);
    void registrarSubatador(ISubastador unSubastador);
    void eliminarSubastador(ISubastador unSubastador);
    void notificar(Oferta unaOferta);
}
