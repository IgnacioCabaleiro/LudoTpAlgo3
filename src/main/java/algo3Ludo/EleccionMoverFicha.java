package algo3Ludo;



public class EleccionMoverFicha implements Eleccion {

	//Se encarga de ejecutar la accion de mover una ficha una vez haya tirado el dado 
	public void ejecutar(Jugador jugador,Ficha ficha ,Tablero tablero) {
		
		System.out.println("La ficha estaba en la posicion " + ficha.casilla.posicion);
		System.out.println("El estado de la ficha (antes de mover) es " + ficha.getEstado());
		tablero.moverFicha(ficha , jugador.movimientoARealizar);			
		System.out.println("El estado de la ficha (dsp de mover) es " + ficha.getEstado());
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