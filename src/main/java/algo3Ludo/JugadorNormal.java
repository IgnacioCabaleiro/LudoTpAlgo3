package algo3Ludo;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class JugadorNormal implements IJugador{
	
	// Una vez que salio 6 en el dado y el jugador es el usuario, 
	//desempeña la función de preguntarle al usuario si quiere sacar una ficha o moverla (si se puede).
	@Override
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
	
	//Procedimiento que se encarga de realizar el movimiento correspondiente si el jugador no es la máquina
	@Override
	public void elegirFicha(Ludo ludo, EscenaJuego escenaJuego) {
		
		algo3Ludo.Ficha.Color color = ludo.jugadorActual.color;
		
		for(Circle circulo: escenaJuego.fichas.get(color)) {		    	
			
			circulo.setOnMouseClicked((MouseEvent event)-> {
				
				if(!escenaJuego.movimientoRealizado && color == ludo.jugadorActual.color) {
					Ficha ficha = escenaJuego.fichaElegida(circulo.getId(),ludo.jugadores);
					
					if(ludo.jugadaEnCondiciones(ficha)) {
						escenaJuego.realizarMovimiento(ficha,circulo,ludo);
					}
					else {
						elegirFicha(ludo,escenaJuego);
					}
				}				
			});	
		}	
	}
}
