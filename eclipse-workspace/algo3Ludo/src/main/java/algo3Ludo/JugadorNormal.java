package algo3Ludo;

public class JugadorNormal implements ITipoJugador{
	
	// Una vez que salio 6 en el dado y el jugador es el usuario, 
	//desempeña la función de preguntarle al usuario si quiere sacar una ficha o moverla (si se puede).
	public void salioEl6(Jugador jugador, Ficha ficha ,Tablero tablero) {
		Eleccion eleccion;
	
		if(!ficha.enJuego && (jugador.fichasEnJuego + jugador.fichasGanadas) < 4) {
			eleccion = new EleccionSacarFicha();
			eleccion.ejecutar(jugador , ficha, tablero);
		}
		else if((ficha.enJuego && jugador.fichasEnJuego > 0 ) || (!ficha.enJuego && jugador.fichasEnJuego == 4)){
			if(jugador.fichasEnJuego == 4) {
				pantalla.println("No puede sacar mas fichas, debe mover una ficha");
			}
			else {
				pantalla.println("Puede mover una ficha");
				
			}
			eleccion = new EleccionMoverFicha();
			eleccion.ejecutar(jugador,ficha, tablero);
		}
	}
 	
}
