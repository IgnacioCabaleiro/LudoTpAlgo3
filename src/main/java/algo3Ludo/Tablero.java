package algo3Ludo;

import java.util.ArrayList;
import algo3Ludo.Casilla.Tipo;
import algo3Ludo.Ficha.Color;
import algo3Ludo.Ficha.Estado;

public class Tablero {
	
	public ArrayList<Casilla> listaTablero;
	
	public ArrayList<Casilla> rectaFinalRojo;
	public ArrayList<Casilla> rectaFinalVerde;
	public ArrayList<Casilla> rectaFinalAmarillo;
	public ArrayList<Casilla> rectaFinalAzul;
	
	public ArrayList<Ficha> fichasGanadasRojo;
	public ArrayList<Ficha> fichasGanadasVerde;
	public ArrayList<Ficha> fichasGanadasAmarillo;
	public ArrayList<Ficha> fichasGanadasAzul;

	static final int MAX_CASILLEROS_RECTA_FINAL = 5;
	static final int POSICION_CASILLA_GANADA = 5;
	static final int CASILLA_ENTRADA_ROJO = 50;
	static final int CASILLA_ENTRADA_AZUL = 37;
	static final int CASILLA_ENTRADA_AMARILLO = 24;
	static final int CASILLA_ENTRADA_VERDE = 11;	
	static final int CANTIDAD_CASILLAS_TABLERO = 51;
	static final int CASILLA_INICIAL_ROJO = 0;
	static final int CASILLA_INICIAL_AZUL = 39;
	static final int CASILLA_INICIAL_AMARILLO = 26;
	static final int CASILLA_INICIAL_VERDE = 13;		
	
	public Tablero() {
		crearTablero();
		crearRectasFinales();
		crearFichasGanadas();
	}
	
	//Asigna a los atributos de fichasGanadas la instanciación de una lista de fichas.
	private void crearFichasGanadas() {
		fichasGanadasRojo = new ArrayList<Ficha>();
		fichasGanadasVerde = new ArrayList<Ficha>();
		fichasGanadasAmarillo = new ArrayList<Ficha>();
		fichasGanadasAzul = new ArrayList<Ficha>();
	}
	
	//Crea el tablero. En cada posicion del tablero se crea una casilla del tipo que corresponda
	//dependiendo de su posicion en el tablero
	private void crearTablero() {
		listaTablero = new ArrayList<Casilla>(CANTIDAD_CASILLAS_TABLERO);
		Casilla casilla; 
		for(int i = 0; i < CANTIDAD_CASILLAS_TABLERO+1; i ++) {
			if(i == CASILLA_INICIAL_ROJO || i == CASILLA_INICIAL_VERDE || i == CASILLA_INICIAL_AMARILLO || i == CASILLA_INICIAL_AZUL) {
				casilla = new Casilla(Tipo.PROTEGIDO, i);
			}
			else if(i == CASILLA_ENTRADA_VERDE || i == CASILLA_ENTRADA_AMARILLO || i == CASILLA_ENTRADA_AZUL || i == CASILLA_ENTRADA_ROJO) {
				casilla = new Casilla(Tipo.ENTRADA, i);
			}
			else {
				casilla = new Casilla(Tipo.NORMAL, i);
			}
			listaTablero.add(casilla);
		}
	}
	
	//Crea las cuatro rectas finales. En cada posicion de ellas se crea una casilla del tipo que corresponda
	//dependiendo de su posición
	private void crearRectasFinales() {
		
		rectaFinalRojo = new ArrayList <Casilla>();
		rectaFinalVerde = new ArrayList <Casilla>();
		rectaFinalAmarillo = new ArrayList <Casilla>();
		rectaFinalAzul = new ArrayList <Casilla>();
		Casilla casilla;
		
		for(int i = 0; i < 5 ; i++) {
			casilla = new Casilla(Tipo.FINAL, i , Color.ROJO);
			rectaFinalRojo.add(casilla);
			
			casilla = new Casilla(Tipo.FINAL, i , Color.AZUL);
			rectaFinalAzul.add(casilla);
			
			casilla = new Casilla(Tipo.FINAL, i , Color.AMARILLO);
			rectaFinalAmarillo.add(casilla);
			
			casilla = new Casilla(Tipo.FINAL, i , Color.VERDE);
			rectaFinalVerde.add(casilla);
		}
		casilla = new Casilla(Tipo.GANADA, POSICION_CASILLA_GANADA , Color.ROJO);
		rectaFinalRojo.add(casilla);
		
		casilla = new Casilla(Tipo.GANADA, POSICION_CASILLA_GANADA , Color.AZUL);
		rectaFinalAzul.add(casilla);
		
		casilla = new Casilla(Tipo.GANADA, POSICION_CASILLA_GANADA , Color.AMARILLO);
		rectaFinalAmarillo.add(casilla);
		
		casilla = new Casilla(Tipo.GANADA, POSICION_CASILLA_GANADA , Color.VERDE);
		rectaFinalVerde.add(casilla);
		
	}

	//Se encarga de asignarle la casilla destino a la ficha y eliminarla de la casilla actual 
	//dependiendo su posicion en el tablero (FUNCIÓN MUY LIOSA).
	public void moverFicha(Ficha ficha, int movimiento) {
		
		Casilla casillaActual = ficha.casilla;
		Casilla casillaDestino = calcularDestino(ficha,movimiento);	
		
		if(casillaActual.posicion == casillaDestino.posicion && ficha.getEstado() == Estado.FINAL) {
			System.out.println("No se pudo mover porque tiene que sacar el numero exacto o menor para ganar");
		}
		else if((casillaActual.tipoCasilla == Tipo.NORMAL || casillaActual.tipoCasilla == Tipo.PROTEGIDO) && casillaDestino.tipoCasilla == Tipo.FINAL) {
			listaTablero.get(casillaActual.posicion).fichas.removeIf(x-> x == ficha);
			casillaDestino.ponerFicha(ficha);
		}
		else if(casillaActual.tipoCasilla == Tipo.FINAL && casillaDestino.tipoCasilla != Tipo.GANADA){
			removerFichaDeRectaFinal(ficha);
			casillaDestino.ponerFicha(ficha);
		}
		
		else {
			listaTablero.get(casillaActual.posicion).fichas.removeIf(x-> x == ficha);
			casillaDestino.ponerFicha(ficha);
		}
		
		if(casillaDestino.tipoCasilla == Tipo.GANADA) {
			
			Color color = ficha.color;
			
			removerFichaDeRectaFinal(ficha);
			
			if (color == Color.AMARILLO) {
				fichasGanadasAmarillo.add(ficha);			
				System.out.println("La ficha amarilla llego a la meta");
			}
			else if (color == Color.AZUL) {
				fichasGanadasAzul.add(ficha);			
				System.out.println("La ficha azul llego a la meta");
			}
			else if (color == Color.ROJO) {
				fichasGanadasRojo.add(ficha);
				System.out.println("La ficha roja llego a la meta");
			}
			else if (color == Color.VERDE) {
				fichasGanadasVerde.add(ficha);		
				System.out.println("La ficha verde llego a la meta");
			}
			
			ficha.gano = true;
		}		
	}
	
	//devuelve la casilla donde tendria que ir la ficha de acuerdo al movimiento que se realiza
	public Casilla calcularDestino(Ficha ficha, int movimiento) {
		Casilla casillaActual;
		if(ficha.getEstado() == Estado.FINAL) {
			casillaActual = new Casilla(ficha.casilla.tipoCasilla,ficha.casilla.posicion,ficha.color);			
		}
		else {
			casillaActual = new Casilla(ficha.casilla.tipoCasilla,ficha.casilla.posicion);	
		}
		Color color = ficha.color;
		int i = 0;
		while (i < movimiento && casillaActual.tipoCasilla != Tipo.GANADA) {
			if(casillaActual.posicion == CANTIDAD_CASILLAS_TABLERO) {
				casillaActual = listaTablero.get(0);
			}
			else if (color == Color.AMARILLO && casillaActual.posicion == CASILLA_ENTRADA_AMARILLO) {
					casillaActual = rectaFinalAmarillo.get(0);
				}
			else if (color == Color.AZUL && casillaActual.posicion == CASILLA_ENTRADA_AZUL) {
					casillaActual = rectaFinalAzul.get(0);
				}
			else if (color == Color.ROJO && casillaActual.posicion == CASILLA_ENTRADA_ROJO) {
					casillaActual = rectaFinalRojo.get(0);
				}
			else if (color == Color.VERDE && casillaActual.posicion == CASILLA_ENTRADA_VERDE) {
					casillaActual = rectaFinalVerde.get(0);
				}
	
			else if (casillaActual.tipoCasilla == Tipo.NORMAL || casillaActual.tipoCasilla == Tipo.PROTEGIDO || casillaActual.tipoCasilla == Tipo.ENTRADA) {
				casillaActual = listaTablero.get(casillaActual.posicion+1);
			}
			else if(casillaActual.tipoCasilla == Tipo.FINAL) {
			
				casillaActual = movimientoDentroRectaFinal(color,casillaActual,movimiento-i);
				return casillaActual;
			}
			i++;
		}
		return casillaActual;
	}
	
	//Cuando la ficha esta en la recta final se encarga de realizar la validacion de si su
	//movimiento es el exacto o menor para llegar a la casilla ganada.
	private Casilla movimientoDentroRectaFinal(Color color, Casilla casilla,int movimiento) {
		
		int posicionFicha = casilla.posicion;
		
		if((movimiento + posicionFicha) < MAX_CASILLEROS_RECTA_FINAL+1 ) {
			int posDestino = (casilla.posicion + movimiento);
			if (color == Color.AMARILLO) {
				casilla = rectaFinalAmarillo.get(posDestino);			
			}
			else if (color == Color.AZUL) {
				casilla = rectaFinalAzul.get(posDestino);
			}
			else if (color == Color.ROJO) {
				casilla = rectaFinalRojo.get(posDestino);
			}
			else if (color == Color.VERDE) {
				casilla = rectaFinalVerde.get(posDestino);
			}
			casilla.posicion = posDestino;
		}
		return casilla;
	}
	
	//Se elimina la primera ficha que se encuentra en la posición de la ficha (que pasamos por parámetro)
	// que tenga diferente color al de la ficha
	public void comer(Ficha ficha) {
		Casilla casilla = ficha.casilla;
		for (Ficha fichaCasilla : this.listaTablero.get(casilla.posicion).fichas) {
			if (fichaCasilla.color != ficha.color) {	
				fichaCasilla.casilla.tipoCasilla = Tipo.BASE;
				fichaCasilla.fueComida = true;
				listaTablero.get(casilla.posicion).fichas.removeIf(x-> x == fichaCasilla);
				break;
			}
			else {
				fichaCasilla.fueComida = false;
			}
		}	
	}
	
	//Devuelve true si en la posición de la ficha hay alguna otra ficha de distinto color.
	public boolean fichaCome(Ficha ficha) {
		for (Ficha fichaCasilla : this.listaTablero.get(ficha.casilla.posicion).fichas) {
			if (fichaCasilla.color != ficha.color && (ficha.casilla.tipoCasilla == Tipo.NORMAL||ficha.casilla.tipoCasilla == Tipo.ENTRADA)) {
				return true;
			}
		}			
		return false;
	}
	
	public void eliminarFichasGanadasDelTablero(Jugador jugadorActual) {
		for(int i = 0; i < listaTablero.size();i++) {
			for(int j = 0; j < listaTablero.get(i).fichas.size();j++) {
				if(listaTablero.get(i).fichas.get(j).gano) {
					listaTablero.get(i).fichas.remove(listaTablero.get(i).fichas.get(j));
				}
			}
		}
	}
	
	//Dentro de la recta final (dependiendo del color) elimina la ficha de la casillaActual 
	private void removerFichaDeRectaFinal(Ficha ficha){
		Casilla casillaActual = ficha.casilla;
		if(ficha.color == Color.AMARILLO) {
			rectaFinalAmarillo.get(casillaActual.posicion).fichas.removeIf(x-> x == ficha);
		}
		else if(ficha.color == Color.ROJO) {
			rectaFinalRojo.get(casillaActual.posicion).fichas.removeIf(x-> x == ficha);
		}
		else if (ficha.color == Color.VERDE) {
			rectaFinalVerde.get(casillaActual.posicion).fichas.removeIf(x-> x == ficha);
		}
		else if(ficha.color == Color.AZUL) {
			rectaFinalAzul.get(casillaActual.posicion).fichas.removeIf(x-> x == ficha);
		}
	}
}
	

