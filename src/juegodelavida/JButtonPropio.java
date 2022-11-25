package juegodelavida;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JButtonPropio extends JButton {
	
	public static final byte TIPO_PAUSE = 0;
	public static final byte TIPO_START = 1;
	
	private byte tipo;
	
	
	
	public JButtonPropio(byte tipo) {
		super();
		this.tipo = tipo;
		
	}

	public byte getTipo() {
		return tipo;
	}

}
