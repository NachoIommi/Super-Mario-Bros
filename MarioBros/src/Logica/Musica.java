package Logica;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import java.io.File;

public class Musica { //Actua como la clase singleton, musica = singleton aca

    private static Musica instancia = null;
    private Clip clip;

    private Musica() { // es privado para evitar instanciación externa
    	 try {
             clip = AudioSystem.getClip();
         } catch (LineUnavailableException e) {
             e.printStackTrace();
         }
    }

    // Método estático para obtener la única instancia
    public static Musica getInstancia() {
        if (instancia == null) {
            instancia = new Musica();
        }
        return instancia;
    }

    public void reproducirMusica(String rutaArchivo) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(rutaArchivo));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void detenerMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void reiniciarMusica() {
        if (clip != null) {
            clip.setFramePosition(0); // Reposicionar al inicio
            clip.start();
        }
    }
}