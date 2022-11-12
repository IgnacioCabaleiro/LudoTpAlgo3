package algo3Ludo;


import java.util.ArrayList;

import algo3Ludo.Ficha.Estado;

public class JugadorMaquina implements ITipoJugador{

	public Ficha elegirFicha(Jugador jugador) {
		
		ArrayList<Ficha> fichas = jugador.fichas;
		ArrayList<Ficha> fichasASortear = new ArrayList<Ficha>(3);
		
		int i = 0;
		for(Ficha ficha : fichas) {
			if(fichas.get(i).estado != Estado.GANADO && fichas.get(i).estado != Estado.BASE) {
				fichasASortear.add(ficha);
				pantalla.println("-La ficha " + (i+1) + " que esta en la posicion " + ficha.casilla.posicion + "...");
				
			}
			i++;
		}
		
		return fichasASortear.get((int)(Math.random()*fichasASortear.size()));
	}

	public void salioEl6(Jugador jugador, Tablero tablero) {
		Eleccion eleccion;
		int numeroRand = (int)(Math.random()*2);
		
		if((jugador.fichasEnJuego + jugador.fichasGanadas) == 4) {
			eleccion = new EleccionMoverFicha();
			eleccion.ejecutar(jugador, tablero);
		}
		else if(jugador.fichasEnJuego == 0) {
			eleccion = new EleccionSacarFicha();
			eleccion.ejecutar(jugador, tablero);
		}
		else {
			if(numeroRand == 0) {
				eleccion = new EleccionMoverFicha();
				eleccion.ejecutar(jugador, tablero);

			}
			else {
				eleccion = new EleccionSacarFicha();
				eleccion.ejecutar(jugador, tablero);
			}
		}
	}



}
