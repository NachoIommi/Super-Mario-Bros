package Logica;
class EstadoDePersonaje {
    constructor(personaje) {
        this.personaje = personaje;  // Referencia al personaje
    }

    correr() {
        throw new Error("Este método debe ser implementado por las subclases");
    }

    saltar() {
        throw new Error("Este método debe ser implementado por las subclases");
    }

    morir() {
        throw new Error("Este método debe ser implementado por las subclases");
    }

    aceptarVisita(visitor) {
        throw new Error("Este método debe ser implementado por las subclases");
    }
}