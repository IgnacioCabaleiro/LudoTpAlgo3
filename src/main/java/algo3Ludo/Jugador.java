package algo3Ludo;

import java.util.ArrayList;

import algo3Ludo.Casilla.Tipo;
import algo3Ludo.Ficha;
import algo3Ludo.Ficha.Color;
import algo3Ludo.Ficha.Estado;


public class Jugador {
	ArrayList<Ficha> fichas;
	String tipoJugador;
	Estado estado;
	public Color color;
	boolean comio;
	int fichasEnJuego;
	int fichasJugadas;
	int movimientoARealizar;
	
	
	public Jugador(Color color, String tipoJugador){
		this.color = color;
		this.fichas = crearFichas();
		this.comio = false;
		this.fichasEnJuego = 0;
		this.fichasJugadas = 0;
		this.tipoJugador = tipoJugador;
	}
	
	public ArrayList<Ficha> crearFichas() {
		Ficha ficha;
		Casilla casilla;
		fichas = new ArrayList<Ficha>(3);
		for(int i = 0; i < 4 ; i++) {
			casilla = new Casilla(Tipo.BASE,i);
			ficha = new Ficha(color,Estado.BASE, casilla);
			fichas.add(ficha);
		}
		return fichas;
	}
	//te retorna la posicion de la primer ficha que este en base
	public int primeroEnBase() {
		int i;
		for(i = 0; i < fichas.size();i++) {
			if(fichas.get(i).estado == Estado.BASE) {
				return i;
			}
		}
		return -1;
		
	}
}