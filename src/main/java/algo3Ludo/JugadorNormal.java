package algo3Ludo;

import java.util.ArrayList;

import algo3Ludo.Ficha.Estado;

public class JugadorNormal implements ITipoJugador{

	// Da al usuario la posiblidad de elegir una ficha para mover de las que tiene disponible. Devuelve dicha ficha
	public Ficha elegirFicha(Jugador jugador) {
		ArrayList<Ficha> fichas = jugador.fichas;
		ArrayList<String> numeros = new ArrayList<String>(3);
		String rta;
		int i = 0;
		
		for(Ficha ficha:fichas) {
			if(ficha.estado != Estado.BASE && ficha.estado != Estado.GANADO) {
				pantalla.println("-La ficha " + (i+1) +" que esta en la posicion " + ficha.casilla.posicion + "...");
				numeros.add(String.valueOf(i+1));	
			}
			i++;				
		}
		
		pantalla.println("Ponga que numero de ficha quiere mover");
		rta = teclado.nextLine();
		while(!numeros.contains(rta)) {
			pantalla.println("Ponga que numero de ficha quiere mover que este en el juego");
			rta = teclado.nextLine();
		}
		
		if(rta.equals("1")) {
			return fichas.get(0);
		}
		else if(rta.equals("2")) {
			return fichas.get(1);
		}
		else if(rta.equals("3")) {
			return fichas.get(2);
		}
		else if(rta.equals("4")) {
			return fichas.get(3);
		}
		return null;
	}
	
	// Una vez que salio 6 en el dado y el jugador es el usuario, 
	//desempeña la función de preguntarle al usuario si quiere sacar una ficha o moverla (si se puede).
	public void salioEl6(Jugador jugador, Tablero tablero) {
		String rta;
		Eleccion eleccion;
		pantalla.println("Sacaste 6: elegi si queres sacar ficha o mover una existente");
		rta = teclado.nextLine();
		while(!rta.equals("sacar ficha") && !rta.equals("mover ficha")) {
			pantalla.println("Sacaste 6: elegi si queres sacar ficha o mover una existente (~mover ficha~ o ~sacar ficha~)");
			rta = teclado.nextLine();
		}
		if(rta.equals("sacar ficha") && jugador.fichasEnJuego < 4) {
			pantalla.println("Puede sacar una ficha");
			eleccion = new EleccionSacarFicha();
			eleccion.ejecutar(jugador , tablero);
		}
		else if((rta.equals("mover ficha") && jugador.fichasEnJuego > 0 ) || (rta.equals("sacar ficha") && jugador.fichasEnJuego == 4)){
			if(jugador.fichasEnJuego == 4) {
				pantalla.println("No puede sacar mas fichas, debe mover una ficha");
			}
			else {
				pantalla.println("Puede mover una ficha");					
			}
			eleccion = new EleccionMoverFicha();
			eleccion.ejecutar(jugador, tablero);
		}
		else {
			pantalla.println("No puede mover niguna ficha, se le quitará una de la base automaticamente");
            eleccion = new EleccionSacarFicha();
            eleccion.ejecutar(jugador , tablero);
		}	
	}
 	
}
