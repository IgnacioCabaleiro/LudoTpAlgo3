package algo3Ludo;


import algo3Ludo.Casilla.Tipo;
import algo3Ludo.Ficha.Estado;

public class EleccionMoverFicha implements Eleccion {

	public void ejecutar(Jugador jugador, Tablero tablero) {
		int movimiento = jugador.movimientoARealizar;
		Ficha ficha;
		ITipoJugador jugadorNormal = new JugadorNormal();
		ITipoJugador jugadorIA = new JugadorMaquina();
		if(jugador.tipoJugador.equals("normal")) {			
			ficha = jugadorNormal.elegirFicha(jugador);
		}
		else {			
			ficha = jugadorIA.elegirFicha(jugador);
		}
		System.out.println("La ficha estaba en la posicion " + ficha.casilla.posicion);
		System.out.println("El estado de la ficha es (antes de mover) " + ficha.estado);
		tablero.moverFicha(ficha , movimiento);			
		System.out.println("El estado de la ficha es (dsp de mover) " + ficha.estado);
		System.out.println("La ficha esta en la posicion " + ficha.casilla.posicion);
		
		if(ficha.estado == Estado.GANADO) {
			jugador.fichasEnJuego--;
		}

		if(tablero.fichaCome(ficha) && ficha.casilla.tipoCasilla != Tipo.PROTEGIDO) {
			tablero.comer(ficha);
			jugador.comio = true;
			ficha.fueComida = true;
		}
		else {
			jugador.comio = false;
			ficha.fueComida = false;
		}

	}

}