package Launcher;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import GUI.*;
import Logica.*;

public class Launcher {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Juego juego = new Juego();
                    Ranking ranking = cargarRanking();
                    ControladorVistas controladorVistas = new ControladorVistas(juego,ranking);
                    juego.setControladorVistas(controladorVistas);
                    controladorVistas.ventana.setVisible(true);
                    controladorVistas.mostrarPantallaJuego();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

     public static Ranking cargarRanking() {
                Ranking ranking = new Ranking();
                try {
                    FileInputStream fileInputStream = new FileInputStream("./score.tdp");
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    ranking = (Ranking) objectInputStream.readObject();
                    objectInputStream.close();
                } 
                catch(FileNotFoundException e) {
                    System.out.println(e.getMessage());
                } 
                catch(IOException e) {
                    System.out.println(e.getMessage());
                }
                catch(ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return ranking;
            }
}