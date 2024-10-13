package Logica;
class Personaje {
	
	//atributos
	protected int vidas;
	protected int monedas;
	protected int puntuacion;
	private EstadoDePersonaje estado;
	
    Personaje() {
        this.vidas = 3;        // Inicialmente 3 vidas
        this.monedas = 0;      // Monedas iniciales
        this.puntuacion = 0;   // Puntos iniciales
        this.estado = new EstadoNormal(this);  // Comienza en estado normal
    }

    public void correr() {
        this.estado.correr();
    }

    public void saltar() {
        this.estado.saltar();
    }

    public void morir() {
        this.estado.morir();
        this.vidas -= 1;
        if (this.vidas == 0) {
        	System.out.println("Game Over");
        }
    }

    public void sumarVida() {
        this.vidas += 1;
    }

    public void sumarPuntos(int puntos) {
        this.puntuacion += puntos;
    }

    public void cambiarEstado(EstadoDePersonaje nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void aceptarVisita(Visitor visitor) {
        visitor.visitarPersonaje(this);
    }

    public int getVidas(){
        return this.vidas;
    }
    
    public void setVidas(int n){
        this.vidas = n;
    }
    
    public int getMonedas(){
        return this.monedas;
    }
    
    public void setMonedas(int n){
        this.monedas = n;
    }

    
    public int getPuntuacion(){
        return this.puntuacion;
    }
    
    public void setPuntuacion(int n){
        this.puntuacion = n;
    }
    
    public EstadoDePersonaje getEstado(){
        return this.estado;
    }
    
    public void setEstado(EstadoDePersonaje nuevoEstado){
        this.estado = nuevoEstado;
    }
}
