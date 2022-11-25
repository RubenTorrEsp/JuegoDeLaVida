package juegodelavida;

import java.awt.Graphics2D;

public class Controlador {
	
	private static Controlador miSingleton;
	
	private Escenario miEscenario;
	private boolean bJugando;
	
	private Controlador() {		
		bJugando = false;
		miEscenario = new Escenario();
	}
	
	static public Controlador getSingleton() {
		if (miSingleton == null)
			miSingleton = new Controlador();
		
		return miSingleton;
	}
	
	public void resetea(float semilla) {
		miEscenario.reset(semilla);
	}
	
	public void simular() {
		if (bJugando)
			miEscenario.simulaTurno();
	}
	
	public void pintarTablero(Graphics2D g2d, int w, int h) {
		miEscenario.pintate(g2d,w,h);
	}
	
	
	public void setJugando(boolean bJugando) {
		this.bJugando = bJugando;
	}

}
