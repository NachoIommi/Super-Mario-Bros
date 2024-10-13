package GUI;

import java.awt.Color; 
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PantallaInicial extends JPanel{
	
	protected ControladorVistas controladorVistas;
	protected JLabel imagenInicio;
	protected JTextField ingresarNombre;
	protected JButton botonIngresarNombre;
	/*
	 * Creo el panel
	 */
	public PantallaInicial(ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
		this.setSize(800,600);
		this.setLayout(null);
		this.setVisible(true);
		//agregarPanelBotones();
		//agregarBotonComenzar();
		agregarNombre();
		agregarBotonIngresarNombre();
		agregarModosDeJuego();
		agregarImagen();
		
	}
	
	public void agregarImagen() {
		imagenInicio = new JLabel();
		imagenInicio.setSize(800, 600);
		ImageIcon icono = new ImageIcon(this.getClass().getResource("/imagenes/pantallaPrincipal.png"));
		Image imagenEscalada = icono.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imagenEscalada);
		imagenInicio.setIcon(iconoEscalado);
		this.add(imagenInicio);
	}
	
	public void agregarBotonIngresarNombre() {
		botonIngresarNombre = new JButton();
		botonIngresarNombre.setText("Ingresar Nombre");
		botonIngresarNombre.setBounds(250, 370, 300, 20);
		botonIngresarNombre.setOpaque(false);
		botonIngresarNombre.setContentAreaFilled(false);
		botonIngresarNombre.setBorderPainted(false);
		registrarOyenteBotonNombre();
		this.add(botonIngresarNombre);
	}
	
	public void agregarNombre() {
		ingresarNombre = new JTextField();
		ingresarNombre.setText("Ingrese su Nombre");
		ingresarNombre.setBounds(250, 350, 300, 20);
		ingresarNombre.setBorder(null);
		ingresarNombre.setBackground(Color.black);
		this.add(ingresarNombre);
	}
	
	public void registrarOyenteBotonNombre() {
		botonIngresarNombre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controladorVistas.juego.iniciarJuego();
				}
		});
	}
	
	public void agregarModosDeJuego() {
		
	}
	
	
}
	
