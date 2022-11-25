package juegodelavida;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Necesitamos una clase JPanel que represente nuestro tablero y que a la hora de pintarse
 * le de al controlador una superficie donde pintar
 * y hacer un "override" del método paint.
 * 
 * 
 * @author andres
 *
 */

public class PanelJuego extends JPanel {
		

	   Controlador miControlador;
	
	   public PanelJuego() {
		   super();
		   //Les damos las propiedades a nuestro tablero. Su color, tamaño y borde
		   this.setBorder(BorderFactory.createLineBorder(Color.black));
		   this.setBackground(new java.awt.Color(200, 210, 220));
		   this.setSize(600,400);
		   miControlador = Controlador.getSingleton();   		   
	   }
    
	
		@Override
		public void paint(Graphics g) {
		   super.paint(g);
			
		   Graphics2D g2d = (Graphics2D) g;
		    //configuramos los gráficos para que pinte figuras suaves...
		   g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		    	
		   
		   miControlador.pintarTablero(g2d,this.getWidth(),this.getHeight());
			
		}

        
                
        
        
}
