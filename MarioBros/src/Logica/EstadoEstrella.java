package Logica;
public class EstadoEstrella extends EstadoDePersonaje {
	
    public EstadoEstrella(Personaje personaje) {
        super(personaje);
    }

    public void correr() {
        System.out.println("El personaje corre invulnerable en estado de estrella.");
    }

    public void saltar() {
        System.out.println("El personaje salta invulnerable en estado de estrella.");
    }

    public void morir() {
        System.out.println("El personaje no puede morir en estado de estrella.");
    }

    public void aceptarVisita(Visitor visitor) {
        visitor.visitarPersonaje(personaje);
    }
    
    public Personaje getPersonaje() {
        return this.personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
    
}
