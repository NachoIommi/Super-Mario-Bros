public class EstadoEstrella extends EstadoDePersonaje {
    public EstadoEstrella(Personaje personaje) {
        super(personaje);
    }

    @Override
    public void correr() {
        System.out.println("El personaje corre invulnerable en estado de estrella.");
    }

    @Override
    public void saltar() {
        System.out.println("El personaje salta invulnerable en estado de estrella.");
    }

    @Override
    public void morir() {
        System.out.println("El personaje no puede morir en estado de estrella.");
    }

    @Override
    public void aceptarVisita(Visitor visitor) {
        visitor.visitarPersonaje(personaje);
    }
}
