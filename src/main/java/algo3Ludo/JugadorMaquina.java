package algo3Ludo;


public class JugadorMaquina implements ITipoJugador{
	
	//Devuelve una ficha disponible para mover de forma aleatoria
//	public Ficha elegirFicha(Jugador jugador) {
//		
//		ArrayList<Ficha> fichas = jugador.fichas;
//		ArrayList<Ficha> fichasASortear = new ArrayList<Ficha>(3);
//		
//		int i = 0;
//		for(Ficha ficha : fichas) {
//			if(fichas.get(i).estado != Estado.GANADO && fichas.get(i).estado != Estado.BASE) {
//				fichasASortear.add(ficha);
//				pantalla.println("-La ficha " + (i+1) + " que esta en la posicion " + ficha.casilla.posicion + "...");
//				
//			}
//			i++;
//		}
//		
//		return fichasASortear.get((int)(Math.random()*fichasASortear.size()));
//	}

	// Una vez que salio 6 en el dado y el jugador es la máquina, 
	//desempeña la función de ejecutar de forma aleatoria el sacar una ficha de la base o mover (si se puede).
	public void salioEl6(Jugador jugador,Ficha ficha ,Tablero tablero) {
		Eleccion eleccion;
		
		if((jugador.fichasEnJuego + jugador.fichasGanadas) == 4) {
			eleccion = new EleccionMoverFicha();
			eleccion.ejecutar(jugador,ficha,tablero);
		}
		else if(jugador.fichasEnJuego == 0) {
			eleccion = new EleccionSacarFicha();
			eleccion.ejecutar(jugador,ficha, tablero);
		}
		else {
			if(ficha.enJuego) {
				eleccion = new EleccionMoverFicha();
				eleccion.ejecutar(jugador,ficha, tablero);

			}
			else {
				eleccion = new EleccionSacarFicha();
				eleccion.ejecutar(jugador,ficha, tablero);
			}
		}
	}



}
