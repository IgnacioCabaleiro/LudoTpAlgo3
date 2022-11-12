package algo3Ludo;


import java.util.ArrayList;
import algo3Ludo.Casilla.Tipo;
import algo3Ludo.Ficha.Color;
import algo3Ludo.Ficha.Estado;

public class Tablero {
	
	ArrayList<Casilla> listaTablero;
	
	ArrayList<Casilla> rectaFinalRojo;
	ArrayList<Casilla> rectaFinalVerde;
	ArrayList<Casilla> rectaFinalAmarillo;
	ArrayList<Casilla> rectaFinalAzul;
	
	ArrayList<Ficha> fichasGanadasRojo;
	ArrayList<Ficha> fichasGanadasVerde;
	ArrayList<Ficha> fichasGanadasAmarillo;
	ArrayList<Ficha> fichasGanadasAzul;

	static final int MAX_CASILLEROS_RECTA_FINAL = 5;
	static final int POSICION_CASILLA_GANADA = 5;
	static final int CASILLA_ENTRADA_ROJO = 50;
	static final int CASILLA_ENTRADA_AZUL = 37;
	static final int CASILLA_ENTRADA_AMARILLO = 24;
	static final int CASILLA_ENTRADA_VERDE = 11;	
	static final int MAX_CANT_FICHAS = 3;
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
	
	public void crearFichasGanadas() {
		fichasGanadasRojo = new ArrayList<Ficha>(MAX_CANT_FICHAS);
		fichasGanadasVerde = new ArrayList<Ficha>(MAX_CANT_FICHAS);
		fichasGanadasAmarillo = new ArrayList<Ficha>(MAX_CANT_FICHAS);
		fichasGanadasAzul = new ArrayList<Ficha>(MAX_CANT_FICHAS);
	}
	
	public void crearTablero() {
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
	
	public void crearRectasFinales() {
		
		rectaFinalRojo = new ArrayList <Casilla>(MAX_CASILLEROS_RECTA_FINAL);
		rectaFinalVerde = new ArrayList <Casilla>(MAX_CASILLEROS_RECTA_FINAL);
		rectaFinalAmarillo = new ArrayList <Casilla>(MAX_CASILLEROS_RECTA_FINAL);
		rectaFinalAzul = new ArrayList <Casilla>(MAX_CASILLEROS_RECTA_FINAL);
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

	public void moverFicha(Ficha ficha, int movimiento) {
		Casilla casillaActual = ficha.casilla;
		Casilla casillaDestino = calcularDestino(ficha,movimiento);
		
		if(casillaActual.posicion == casillaDestino.posicion && ficha.estado == Estado.FINAL) {
			System.out.println("No se pudo mover porque tiene que sacar el numero exacto o menor para ganar");
		}
		else {
			casillaActual.sacarFicha(ficha);
			listaTablero.get(casillaActual.posicion).fichas.remove(ficha);
			casillaDestino.ponerFicha(ficha);
			
			
		}
	
		cambiarEstado(ficha);

		if(casillaDestino.tipoCasilla == Tipo.GANADA) {
			Color color = ficha.color;
			if (color == Color.AMARILLO) {
				fichasGanadasAmarillo.add(ficha);
				rectaFinalAmarillo.remove(ficha);
				System.out.println("La ficha amarilla llego a la meta");
			}
			else if (color == Color.AZUL) {
				fichasGanadasAzul.add(ficha);
				rectaFinalAzul.remove(ficha);
				System.out.println("La ficha azul llego a la meta");
			}
			else if (color == Color.ROJO) {
				fichasGanadasRojo.add(ficha);
				rectaFinalRojo.remove(ficha);
				System.out.println("La ficha roja llego a la meta");
			}
			else if (color == Color.VERDE) {
				fichasGanadasVerde.add(ficha);
				rectaFinalVerde.remove(ficha);
				System.out.println("La ficha verde llego a la meta");
			}
		}
	}
	
	public Casilla calcularDestino(Ficha ficha, int movimiento) {
		Casilla casillaActual = ficha.casilla;
		Color color = ficha.color;
		int i = 0;
		while (i < movimiento && casillaActual.tipoCasilla != Tipo.GANADA) {
			if(casillaActual.posicion == CANTIDAD_CASILLAS_TABLERO) {
				casillaActual = listaTablero.get(0);
			}
			else if (color == Color.AMARILLO && casillaActual.posicion == CASILLA_ENTRADA_AMARILLO) {
					casillaActual = rectaFinalAmarillo.get(0);
					casillaActual.posicion = 0;
				}
			else if (color == Color.AZUL && casillaActual.posicion == CASILLA_ENTRADA_AZUL) {
					casillaActual = rectaFinalAzul.get(0);
					casillaActual.posicion = 0;
				}
			else if (color == Color.ROJO && casillaActual.posicion == CASILLA_ENTRADA_ROJO) {
					casillaActual = rectaFinalRojo.get(0);
					casillaActual.posicion = 0;
				}
			else if (color == Color.VERDE && casillaActual.posicion == CASILLA_ENTRADA_VERDE) {
					casillaActual = rectaFinalVerde.get(0);
					casillaActual.posicion = 0;
				}
	
			else if (casillaActual.tipoCasilla == Tipo.NORMAL || casillaActual.tipoCasilla == Tipo.PROTEGIDO || casillaActual.tipoCasilla == Tipo.ENTRADA) {
				casillaActual = listaTablero.get(casillaActual.posicion+1);
			}
			else if(casillaActual.tipoCasilla == Tipo.FINAL) {
				ficha.casilla.posicion = casillaActual.posicion;
				casillaActual = movimientoDentroRectaFinal(ficha,movimiento-i);
				return casillaActual;
			
			}
			i++;
		}
		return casillaActual;
	}
	public Casilla movimientoDentroRectaFinal(Ficha ficha, int movimiento) {
		
		Casilla casilla = ficha.casilla;
		int posicionFicha = casilla.posicion;
		
		if((movimiento + posicionFicha) < MAX_CASILLEROS_RECTA_FINAL+1 ) {
			Color color = ficha.color;
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
		cambiarEstado(ficha);
		return casilla;
	}
	
	public void cambiarEstado(Ficha ficha) {
		if(ficha.casilla.tipoCasilla == Tipo.PROTEGIDO) {
			ficha.estado = Estado.PROTEGIDA;
		}
		else if(ficha.casilla.tipoCasilla == Tipo.NORMAL) {
			ficha.estado = Estado.JUGANDO;
		}
		else if(ficha.casilla.tipoCasilla == Tipo.FINAL) {
			ficha.estado = Estado.FINAL;
		}
		else if(ficha.casilla.tipoCasilla == Tipo.GANADA) {
			ficha.estado = Estado.GANADO;
		}
	}
	public void comer(Ficha ficha) {
		Casilla casilla = ficha.casilla;
		Ficha fichaAComer = null;
		for (Ficha fichaCasilla : this.listaTablero.get(casilla.posicion).fichas) {
			if (fichaCasilla.color != ficha.color) {			
				fichaAComer = fichaCasilla;
				casilla.sacarFicha(fichaAComer);
				listaTablero.get(casilla.posicion).fichas.remove(fichaAComer);
				fichaAComer.fueComida = true;
				fichaAComer.estado = Estado.BASE;
				break;//solo puede eliminar a una, falla si tiene que eliminar a dos o mas (???)
			}
		}	
	}
	public boolean fichaCome(Ficha ficha) {
		boolean comio = false;
		for (Ficha fichaCasilla : this.listaTablero.get(ficha.casilla.posicion).fichas) {
			if (fichaCasilla.color != ficha.color) {
				return comio = true;
			}
		}			
		return comio;
	}
	
}
