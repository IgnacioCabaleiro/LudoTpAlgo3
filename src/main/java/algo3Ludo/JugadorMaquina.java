package algo3Ludo;

import java.util.ArrayList;

import javafx.scene.shape.Circle;

public class JugadorMaquina implements IJugador{

	// Una vez que salio 6 en el dado y el jugador es la máquina, 
	//desempeña la función de ejecutar de forma aleatoria el sacar una ficha de la base o mover (si se puede).
	@Override
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

	//Procedimiento que se encarga de realizar el movimiento correspondiente si el jugador es la máquina
	@Override
	public void elegirFicha(Ludo ludo, EscenaJuego escenaJuego) {
		Ficha ficha;
    	if(ludo.dado == 6 && (ludo.jugadorActual.fichasEnJuego + ludo.jugadorActual.fichasGanadas) < 4) {
    		ficha = ludo.jugadorActual.fichas.get(ludo.jugadorActual.primeroEnBase());
    	}
    	else{
    		ArrayList<Ficha> fichasASortear = new ArrayList<Ficha>();
    		for(Ficha fichaASortear : ludo.jugadorActual.fichas) {
    			if(fichaASortear.enJuego){
    				fichasASortear.add(fichaASortear);
    			}
    		}
    		int posicionSorteada = (int)(Math.random()*fichasASortear.size());
    		ficha = fichasASortear.get(posicionSorteada);	
    	}
    	
    	Circle circulo = escenaJuego.circuloElegido(ficha);
    	if(ludo.jugadaEnCondiciones(ficha)) {
    		escenaJuego.realizarMovimiento(ficha,circulo, ludo);
    	} 
		
	}
}
