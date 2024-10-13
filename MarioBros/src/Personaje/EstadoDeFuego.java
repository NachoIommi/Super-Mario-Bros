package Personaje;

class EstadoDeFuego extends EstadoDePersonaje {
	
    public EstadoDeFuego(Personaje personaje) {
        super(personaje);  // Llama al constructor de la clase base
    }

    public void correr() {
    	System.out.println("El personaje corre lanzando bolas de fuego.");
    }

    public void saltar() {
    	System.out.println("El personaje salta mientras lanza bolas de fuego.");
    }

    public void morir() {
    	System.out.println("El personaje ha muerto en estado de fuego.");
    }

    public void aceptarVisita(Visitor visitor) {
        visitor.visitarPersonaje(this.personaje);
    }

    public Personaje getPersonaje() {
        return this.personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
      
}