class EstadoNormal extends EstadoDePersonaje {
    constructor(personaje) {
        super(personaje);  // Llama al constructor de la clase base
    }

    correr() {
        console.log("El personaje corre normalmente.");
    }

    saltar() {
        console.log("El personaje salta.");
    }

    morir() {
        console.log("El personaje ha muerto en estado normal.");
    }

    aceptarVisita(visitor) {
        visitor.visitarPersonaje(this.personaje);
    }

    getPersonaje() {
        return this.personaje;
    }
}
