package ar.edu.unahur.obj2.observer;

public class Subastador implements ISubastador{
    private final String nombreUsuario;
    private Double ultimaOferta;    

    public Subastador(String nombreUsuario, Double ultimaOferta) {
        this.nombreUsuario = nombreUsuario;
        this.ultimaOferta = 0.0;      
    }  

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    @Override
    public void actualizar(Oferta oferta) {
        ultimaOferta = oferta.getValor();
        System.out.println(nombreUsuario + " recibio nueva oferta de $: " + oferta.getValor()) ;

    }

    @Override
    public Oferta ofertar() {
        Double nuevaOferta = ultimaOferta + 10.0;
        return new Oferta(this, nuevaOferta);
    }
    
}
