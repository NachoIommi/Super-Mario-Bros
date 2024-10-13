package Logica;
class EstadoDePersonaje {
	
	protected Personaje personaje;
	
	public EstadoDePersonaje(Personaje personaje) {
        this.personaje = personaje;  // Referencia al personaje. (Esto no esta en el diagrama, va con constructor?)
    }
	
    public void correr() {
        throw new Error("Este método debe ser implementado por las subclases");
    }

    public void saltar() {
        throw new Error("Este método debe ser implementado por las subclases");
    }

    public void morir() {
        throw new Error("Este método debe ser implementado por las subclases");
    }

    public void aceptarVisita(Visitor visitor) {
        throw new Error("Este método debe ser implementado por las subclases");
    }
}