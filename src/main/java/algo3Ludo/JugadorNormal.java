package algo3Ludo;

import java.util.ArrayList;

import algo3Ludo.Ficha.Estado;

public class JugadorNormal implements ITipoJugador{

	public Ficha elegirFicha(Jugador jugador) {
		ArrayList<Ficha> fichas = jugador.fichas;
		ArrayList<String> numeros = new ArrayList<String>(3);
		if(jugador.fichasEnJuego > 0) {
			int i = 0;
			for(Ficha ficha:fichas) {
				if(ficha.estado != Estado.BASE && ficha.estado != Estado.GANADO) {
					pantalla.println("-La ficha " + (i+1) +" que esta en la posicion " + ficha.casilla.posicion + "...");
					numeros.add(String.valueOf(i+1));
					
				}
				i++;				
			}
			pantalla.println("Ponga que numero de ficha quiere mover");
			String rta = teclado.nextLine();
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
		}
		return null;
		
	}
 	
}
