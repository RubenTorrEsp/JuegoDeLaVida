package juegodelavida;

import java.awt.Color;
import java.awt.Graphics2D;

public class Escenario {
	
	//ESTADO
	
	private static final int ANCHO = 100;
	private static final int ALTO = 100;
	
	//Utilizaremos un array de booleanos para simular las celulas. True - VIVA.
	private boolean[][] tabla;
	
	
	
	
	//COMPORTAMIENTO
	public Escenario() {
		tabla = new boolean[ANCHO][ALTO];
	}
	
	
	
	public void reset(float semilla) {
		for (int i=0;i<ANCHO;i++)
			for (int j=0;j<ALTO;j++) 
				if (Math.random() < semilla) tabla[i][j]=true;	
				else tabla[i][j]=false;
	}


	public void simulaTurno() {
		for (int i=0;i<ANCHO;i++)
			for (int j=0;j<ALTO;j++) 
				simulaCelda(i,j);		
	}

	public void pintate(Graphics2D g2d,int w, int h) {
		for (int i=0;i<ANCHO;i++)
			for (int j=0;j<ALTO;j++) 
				if (tabla[i][j]) {
				    pintaCelda(i,j,g2d,w,h);	
				}
	}
	
    private void simulaCelda(int i, int j) {
    	int minX,maxX,minY,maxY;  //Calculo el area de influencia primero
    	int celdasVivas=0;
    	
    	minX = i-1;
    	if (minX<0) minX=0;
    	
    	minY = j-1;
    	if (minY<0) minY=0;
    	
    	maxX = i+1;
    	if (maxX==ANCHO) maxX--;
    	
    	maxY = j+1;
    	if (maxY==ALTO) maxY--;
    	
    	for (int n=minX;n<=maxX;n++)
    		for(int k=minY;k<=maxY;k++)
    			if (tabla[n][k]) celdasVivas++;
    	
    	celdasVivas--;  //Quitamos la propia celda en cálculo
    	
    	if (celdasVivas==2 && tabla[i][j]==false) tabla[i][j]=true;
    	if ((celdasVivas<2 || celdasVivas>5) && tabla[i][j]==true) tabla[i][j]=false;
    	
    }
    
    
    private void pintaCelda(int i, int j, Graphics2D g2d,int w,int h) {
    	int altoCelda,anchoCelda;
    	
    	anchoCelda = w/ANCHO;
    	altoCelda = h/ALTO;
    	
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(i*anchoCelda, j*altoCelda, anchoCelda, altoCelda);
    	
    }
}