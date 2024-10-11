class Personaje {
    constructor() {
        this.vidas = 3;        // Inicialmente 3 vidas
        this.monedas = 0;      // Monedas iniciales
        this.puntuacion = 0;   // Puntos iniciales
        this.estado = new EstadoNormal(this);  // Comienza en estado normal
    }

    correr() {
        this.estado.correr();
    }

    saltar() {
        this.estado.saltar();
    }

    morir() {
        this.estado.morir();
        this.vidas -= 1;
        if (this.vidas === 0) {
            console.log("Game Over");
        }
    }

    sumarVida() {
        this.vidas += 1;
    }

    sumarPuntos(puntos) {
        this.puntuacion += puntos;
    }

    cambiarEstado(nuevoEstado) {
        this.estado = nuevoEstado;
    }

    aceptarVisita(visitor) {
        visitor.visitarPersonaje(this);
    }

    getVidas(){
        return this.vidas;
    }
    
    setVidas(n){
        this.vidas = n;
    }
    
    getMonedas(){
        return this.monedas;
    }
    
    setMonedas(n){
        this.monedas = n;
    }

    
     getPuntuacion(){
        return this.puntuacion;
    }
    
    setPuntuacion(n){
        this.puntuacion = n;
    }
    
    getEstado(){
        return this.estado;
    }
    
    setEstado(nuevoEstado){
        this.estado = nuevoEstado;
    }
}
