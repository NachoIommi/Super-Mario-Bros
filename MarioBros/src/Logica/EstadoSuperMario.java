package Logica;

class EstadoSuperMario extends EstadoDePersonaje {
	
    public EstadoSuperMario(Personaje personaje) {
        super(personaje);  // Llama al constructor de la clase base
    }

    public void correr() {
        System.out.println("El personaje corre normalmente.");
    }

    public void saltar() {
    	System.out.println("El personaje salta.");
    }

    public void morir() {
    	System.out.println("El personaje ha muerto en estado SuperMario.");
    }

    public void aceptarVisita(Visitor visitor) {
        visitor.visitarPersonaje(this.personaje);
    }

    public Personaje getPersonaje() {
        return this.personaje;
    }
}