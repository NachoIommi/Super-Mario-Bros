class EstadoDeFuego extends EstadoDePersonaje {
    constructor(personaje) {
        super(personaje);  // Llama al constructor de la clase base
    }

    correr() {
        console.log("El personaje corre lanzando bolas de fuego.");
    }

    saltar() {
        console.log("El personaje salta mientras lanza bolas de fuego.");
    }

    morir() {
        console.log("El personaje ha muerto en estado de fuego.");
    }

    aceptarVisita(visitor) {
        visitor.visitarPersonaje(this.personaje);
    }

    getPersonaje() {
        return this.personaje;
    }

    setPersonaje(personaje) {
        this.personaje = personaje;
    }
}

setPersonaje(personaje) {
        this.personaje = personaje;
}