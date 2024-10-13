package PowerUps;
import Logica.Entidad;

public abstract class PowerUps extends Entidad{
	public abstract void afectarPersonaje(Personaje p);
	public abstract void aceptarVisita(Visitor r);
}
