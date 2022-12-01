package algo3Ludo;

import java.util.ArrayList;
import algo3Ludo.Ficha.Color;

public class Casilla {
	
	public ArrayList<Ficha> fichas;
	public int posicion;
	public enum Tipo {NORMAL ,ENTRADA, PROTEGIDO, FINAL, GANADA, BASE};
	public int coordenadaX;
	public int coordenadaY;
	public boolean entro;
	public Tipo tipoCasilla;
	public Color color;
	

	public Casilla(Tipo tipo , int posicion){
		this.tipoCasilla = tipo;
		this.posicion = posicion;
		this.fichas = new ArrayList<Ficha>();
		setCoordenadasTablero();
	}
	
	public Casilla(Tipo tipo, int posicion, Color color){
		this.tipoCasilla = tipo;
		this.posicion = posicion;
		this.color = color;
		this.fichas = new ArrayList<Ficha>();
		setCoordenadasRectasFinales(color);
	}
	//se encarga de  eliminar la ficha que se le pasa por parametro de la lista de fichas
	public void sacarFicha(Ficha ficha) {
		fichas.remove(ficha);
		ficha.casilla.posicion = this.posicion;
		ficha.casilla.tipoCasilla = this.tipoCasilla;	
	}

	//se encarga de  agregar la ficha que se le pasa por parametro de la lista de fichas
	public void ponerFicha(Ficha ficha) {
		fichas.add(ficha);
		ficha.casilla.posicion = this.posicion;
		ficha.casilla.tipoCasilla = this.tipoCasilla;	
	}
	
	//Procedimiento que se encarga de establecer las coordenadas de las casillas del tablero. 
	public void setCoordenadasTablero() {

		if(posicion == 51) {
			coordenadaX = 285;
			coordenadaY = 650;	
		}
		else if(posicion == 0 ||posicion == 1 ||posicion == 2 ||posicion == 3 ||posicion == 4 ) {
			coordenadaX = 285;
			coordenadaY = 605 - 45*posicion;			
		}
		else if(posicion == 44 ||posicion == 45 ||posicion == 46 ||posicion == 47 ||posicion == 48||posicion == 49 ) {
			coordenadaX = 375;
			coordenadaY = 425 + 45*(posicion-44);			
		}
		else if(posicion == 43 ||posicion == 42 ||posicion == 41 ||posicion == 40 ||posicion == 39||posicion == 38 ) {
			coordenadaX = 650 - 45*(posicion-38);
			coordenadaY = 375;	
		}
		else if(posicion == 31 ||posicion == 32 ||posicion == 33 ||posicion == 34 ||posicion == 35||posicion == 36 ) {
			coordenadaX = 425 + 45*(posicion-31);
			coordenadaY = 285;
		} 
		else if(posicion == 5 || posicion == 6 ) {
			coordenadaX = 240 - 45*(posicion-5);
			coordenadaY = 375;	
		}
		else if(posicion == 7||posicion == 8||posicion == 9||posicion == 10) {
			coordenadaX = 145 - 45*(posicion - 7);
			coordenadaY = 375;	
		}
		else if(posicion == 17 || posicion == 16 ) {
			coordenadaX = 195 + 45*(posicion-16);
			coordenadaY = 285;	
		}
		else if(posicion == 15||posicion == 14 || posicion == 13||posicion == 12) {
			coordenadaX = 10 + 45*(posicion-12);
			coordenadaY = 285;	
		}
		else if(posicion == 18 || posicion == 19 ) {
			coordenadaX = 285;
			coordenadaY = 240 - 45*(posicion-18);
		}
		else if(posicion == 20||posicion == 21 || posicion == 22||posicion == 23) {
			coordenadaX = 285;
			coordenadaY = 145 - 45*(posicion-20);	
		}
		else if(posicion == 30 || posicion == 29 ) {
			coordenadaX = 375;
			coordenadaY = 195 + 45*(posicion-29);
		}
		else if(posicion == 28||posicion == 27 || posicion == 26||posicion == 25) {
			coordenadaX = 375;
			coordenadaY = 10 + 45*(posicion-25);	
		}
		else if(posicion == 50) {
			coordenadaX = 330;
			coordenadaY = 650;
		}
		else if(posicion == 37) {
			coordenadaX = 650;
			coordenadaY = 330;	
		}
		else if(posicion == 24) {
			coordenadaX = 330;
			coordenadaY = 10;	
		}
		else if(posicion == 11) {
			coordenadaX = 10;
			coordenadaY = 330;	
		}		
	}
	
	//Procedimiento que se encarga de establecer las coordenadas de las casillas de las rectas finales. 
	public void setCoordenadasRectasFinales(Color color) {		
		if(color == Color.ROJO) {
			coordenadaX = 330;
			if(posicion == 0) {
				coordenadaY = 605;	
			}
			if(posicion == 1) {
				coordenadaY = 560;		
			}
			if(posicion == 2) {
				coordenadaY = 515;		
			}
			if(posicion == 3) {
				coordenadaY = 470;		
			}
			if(posicion == 4) {
				coordenadaY = 425;		
			}
			if(posicion == 5) {
				coordenadaY = 375;		
			}
		}
		else if(color == Color.AMARILLO) {
			coordenadaX = 330;
			if(posicion == 0) {
				coordenadaY = 55;	
			}
			if(posicion == 1) {
				coordenadaY = 100;		
			}
			if(posicion == 2) {
				coordenadaY = 145;		
			}
			if(posicion == 3) {
				coordenadaY = 195;		
			}
			if(posicion == 4) {
				coordenadaY = 240;		
			}
			if(posicion == 5) {
				coordenadaY = 285;		
			}
		}
		else if(color == Color.AZUL) {
			coordenadaY = 330;
			if(posicion == 0) {
				coordenadaX = 605;	
			}
			if(posicion == 1) {
				coordenadaX = 560;	
			}
			if(posicion == 2) {
				coordenadaX = 515;	
			}
			if(posicion == 3) {
				coordenadaX = 470;	
			}
			if(posicion == 4) {
				coordenadaX = 425;	
			}
			if(posicion == 5) {
				coordenadaX = 375;	
			}
		}
		else if(color == Color.VERDE) {
			coordenadaY = 330;
			if(posicion == 0) {
				coordenadaX = 55;	
			}
			if(posicion == 1) {
				coordenadaX = 100;		
			}
			if(posicion == 2) {
				coordenadaX = 145;	
			}
			if(posicion == 3) {
				coordenadaX = 195;	
			}
			if(posicion == 4) {
				coordenadaX = 240;	
			}
			if(posicion == 5) {
				coordenadaX = 285;	
			}
		}
	}
}
