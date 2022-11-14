package algo3Ludo;



public class EleccionMoverFicha implements Eleccion {

	//Se encarga de ejecutar la accion de mover una ficha una vez haya tirado el dado 
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
		System.out.println("El estado de la ficha (antes de mover) es " + ficha.estado);
		tablero.moverFicha(ficha , movimiento);			
		System.out.println("El estado de la ficha (dsp de mover) es " + ficha.estado);
		System.out.println("La ficha esta en la posicion " + ficha.casilla.posicion);
		
		if(tablero.fichaCome(ficha)) {
			tablero.comer(ficha);
			jugador.comio = true;
		}
		else {
			jugador.comio = false;
		}

	}

}