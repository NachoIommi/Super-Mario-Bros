package Logica;
public class PiranhaInvulnerable implements EstadosDePiranhaPlant {
    private PiranhaPlant piranha;

    public PiranhaInvulnerable(PiranhaPlant piranha) {
        this.piranha = piranha;
    }

    @Override
    public void moverse() {
        System.out.println("La Piranha Plant es invulnerable y no se mueve.");
    }

    @Override
    public void morir() {
        System.out.println("La Piranha Plant invulnerable no puede morir.");
    }

    @Override
    public void aceptarVisita(Visitor visitor) {
        visitor.visitarPiranhaPlant(piranha);
    }
}
