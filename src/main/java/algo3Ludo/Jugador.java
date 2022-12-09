package algo3Ludo;

import java.util.ArrayList;

import algo3Ludo.Casilla.Tipo;
import algo3Ludo.Ficha.Color;
import algo3Ludo.Ficha.Estado;


public class Jugador {
	public ArrayList<Ficha> fichas;
	public IJugador tipoJugador;
	public Color color;
	public boolean comio;
	public int fichasEnJuego;
	public int fichasGanadas;
	public int movimientoARealizar;
	public boolean esNormal;
	public boolean esMaquina;
	
	
	public Jugador(Color color, String tipoJugador){
		this.color = color;
		this.fichas = crearFichas();
		this.comio = false;
		this.fichasEnJuego = 0;
		this.fichasGanadas = 0;
		this.tipoJugador = convertirTipoJugador(tipoJugador);
	}
	//se encarga de crear 4 fichas para el jugador y las devuelve en forma de lista
	public ArrayList<Ficha> crearFichas() {
		Ficha ficha;
		Casilla casilla;
		fichas = new ArrayList<Ficha>();
		for(int i = 0; i < 4 ; i++) {
			casilla = new Casilla(Tipo.BASE,i);
			ficha = new Ficha(color,casilla, i);
			fichas.add(i,ficha);
		}
		return fichas;
	}
	public IJugador convertirTipoJugador(String s) {
		if(s.equals("normal")) {
			tipoJugador = new JugadorNormal();
			esNormal = true;
			esMaquina = false;
			return tipoJugador;
		}
		else {
			tipoJugador = new JugadorMaquina();
			esMaquina = true;
			esNormal = false;
			return tipoJugador;
		}
	}
	//te retorna la posicion de la primer ficha que este en base
	public int primeroEnBase() {
		int i;
		for(i = 0; i < fichas.size();i++) {
			if(fichas.get(i).getEstado() == Estado.BASE) {
				return i;
			}
		}
		return -1;
		
	}
	
	public void elegirFicha(Ludo ludo,EscenaJuego escenaJuego) {
		tipoJugador.elegirFicha(ludo,escenaJuego);
	}
	
	public void salioEl6(Jugador jugador, Ficha ficha ,Tablero tablero) {
		tipoJugador.salioEl6(jugador, ficha, tablero);
	}
}
