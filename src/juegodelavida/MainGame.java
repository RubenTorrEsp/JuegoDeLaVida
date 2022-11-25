package juegodelavida;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainGame {
	
		
	
	public static void main(String[] args) throws InterruptedException {
		int contador=0;	  //Contador de turnos    	    	    	   
	
		MainFrame frame;
		Controlador miControlador = Controlador.getSingleton();
	    
	    frame = new MainFrame("Juego de la Vida v1.0");
	    
	    frame.setVisible(true);
		
		while (true) {  //por siempre jamás (hasta que nos cierren la ventana) estamos controlando el juego.
			
						
	    	miControlador.simular();
	    	frame.incrementaTurno();
	    	
	    	frame.repaint();
			
	    	//Esperamos para dar tiempo al thread de repintado a pintar.
	    	
	        Thread.sleep(100);	    	
	    }
	}
	
	
}
