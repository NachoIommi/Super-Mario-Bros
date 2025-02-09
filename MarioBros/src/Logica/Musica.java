package Logica;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import java.io.File;

public class Musica {

    private static Musica archivo = null;
    private Clip clipMusica, clipSonido;

    private Musica() {
    	 try {
             clipMusica = AudioSystem.getClip();
         } catch (LineUnavailableException e) {
             e.printStackTrace();
         }
    }

    public static Musica getMusica() {
        if (archivo == null) {
            archivo = new Musica();
        }
        return archivo;
    }

    public void reproducirMusica(String rutaArchivo) {
        try {
        	detenerMusica();
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(rutaArchivo));
            clipMusica = AudioSystem.getClip();
            clipMusica.open(audioStream);
            clipMusica.start();
            clipMusica.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void reproducirMusicaSinLoop(String rutaArchivo) {
        try {
        	detenerMusica();
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(rutaArchivo));
            clipMusica = AudioSystem.getClip();
            clipMusica.open(audioStream);
            clipMusica.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void reproducirSonido(String rutaArchivo) {
        try {
        	AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(rutaArchivo));
            clipSonido = AudioSystem.getClip();
            clipSonido.open(audioStream);
            clipSonido.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void detenerMusica() {
        if (clipMusica != null && clipMusica.isRunning()) {
            clipMusica.stop();
        }
    }

    public void reiniciarMusica() {
        if (clipMusica != null) {
        	detenerMusica();
            clipMusica.setFramePosition(0);
            clipMusica.start();
        }
    }
}