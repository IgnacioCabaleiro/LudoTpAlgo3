package algo3Ludo;

import algo3Ludo.Casilla.Tipo;
import algo3Ludo.Ficha.Color;
import algo3Ludo.Ficha.Estado;

public class EleccionSacarFicha implements Eleccion {

	public void ejecutar(Jugador jugador, Tablero tablero) {
		
		int posicion = jugador.primeroEnBase();
		Ficha fichaAJugar = jugador.fichas.get(posicion);
			if(jugador.color == Color.ROJO) {			
				tablero.listaTablero.get(0).fichas.add(fichaAJugar);
				fichaAJugar.casilla.posicion = 0;
			}
			else if(jugador.color == Color.AMARILLO) {
				tablero.listaTablero.get(26).fichas.add(fichaAJugar);
				fichaAJugar.casilla.posicion = 26;
			}
			else if(jugador.color == Color.AZUL) {
				tablero.listaTablero.get(39).fichas.add(fichaAJugar);
				fichaAJugar.casilla.posicion = 39;
			}
			else if(jugador.color == Color.VERDE) {
				tablero.listaTablero.get(13).fichas.add(fichaAJugar);
				fichaAJugar.casilla.posicion = 13;
			}
			fichaAJugar.estado = Estado.PROTEGIDA;
			fichaAJugar.casilla.tipoCasilla = Tipo.PROTEGIDO;
			jugador.fichasEnJuego++;
			jugador.fichasJugadas++;

	}

}
