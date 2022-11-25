package juegodelavida;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class MainFrame extends JFrame implements ActionListener {

	private long iteraciones;
	private JPanel mainPanel;
	private PanelJuego miPanelJuego;
	private Controlador miControlador;
	private JPanel botonera;	    
	private JButtonPropio start;
	private JButtonPropio pause;
	private JLabel lInfo;
	private JLabel lSemilla;
	private JTextField tfSemilla;
	
	private boolean bJugando;
	private boolean bEmpezar;
		
	
	public MainFrame(String title) {
		super(title);
		iteraciones=0;
		
		miControlador = Controlador.getSingleton();
				
		bJugando = false;
		bEmpezar = false;
					
		//asignamos el tamaño a nuestra ventana, y hacemos que se cierre cuando nos pulsan
		//la X de cerrar la ventana
	    this.setSize(600,600);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    //3. Ahora creamos los componentes y los ponemos en la frame (ventana).
	    
	    //El panel de fondo. Rellena el frame, y sirve de contenedor del tablero y de la botonera.
	    mainPanel = new JPanel(new BorderLayout());
	    miPanelJuego = new PanelJuego();
	    
	   	    	   	   
	    //Ahora el turno de la botonera. Tendrá los dos botones
	    botonera = new JPanel();
	    botonera.setBorder(BorderFactory.createLineBorder(Color.black));
	    botonera.setBackground(new java.awt.Color(180, 180, 200));
	    	
	    //turno de los botones de empezar y pausar/continuar
	    start = new JButtonPropio(JButtonPropio.TIPO_START);
	    start.setSize(50, 20);
	    start.setText("Start");
	    start.addActionListener(this);
	    
	    pause = new JButtonPropio(JButtonPropio.TIPO_PAUSE);
	    pause.setSize(50, 20);
	    pause.setText("Pause");
	    pause.addActionListener(this);
	    pause.setEnabled(false);
	    
	    
	    lInfo = new JLabel("Pulse Start para empezar");
	    lSemilla= new JLabel("Semilla:");
		tfSemilla = new JTextField(4);
		tfSemilla.setText("0.3");
	       
	    //Añadimos los componentes uno a uno, cada uno en su contenedor, y al final el panel principal
	    //se añade al frame principal.
	    botonera.add(start);
	    botonera.add(pause);
	    botonera.add(lSemilla);
	    botonera.add(tfSemilla);
	    botonera.add(lInfo);
	    
	    
	    mainPanel.add(botonera,BorderLayout.PAGE_END);
	    mainPanel.add(miPanelJuego,BorderLayout.CENTER);
	    mainPanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(90, 100, 120),10,false));
	    this.add(mainPanel);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch (((JButtonPropio)arg0.getSource()).getTipo()) {
		case JButtonPropio.TIPO_START:
			empezar();
			break;
		case JButtonPropio.TIPO_PAUSE:
			pausar();
			break;
		}
		
	}

	//Pulsan el botón Start
	private void empezar() {
		bJugando = true;
		miControlador.resetea(Float.valueOf(this.tfSemilla.getText()));
		iteraciones=0;
		miControlador.setJugando(bJugando);
		pause.setEnabled(true);
	}
	
	
	//Pulsan el botón Pausar
	private void pausar() {
		if (bJugando) {
			bJugando = false;
			pause.setText("Continuar");
			start.setEnabled(false);
		} else {
			bJugando = true;
			pause.setText("Pausar");
			start.setEnabled(true);
		}
		miControlador.setJugando(bJugando);
		
	}
	
	public void incrementaTurno() {
		if(bJugando) {
			iteraciones++;
			this.lInfo.setText("Iteraciones: "+ String.valueOf(iteraciones));			
		}
	}
	
}
