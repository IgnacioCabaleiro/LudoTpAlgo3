package algo3Ludo;


import java.util.ArrayList;

import algo3Ludo.Ficha.Estado;

public class JugadorMaquina implements ITipoJugador{

	public Ficha elegirFicha(Jugador jugador) {
		ArrayList<Ficha> fichas = jugador.fichas;
		ArrayList<Ficha> fichasASortear = new ArrayList<Ficha>(3);
		
		int i = 0;
		for(Ficha ficha : fichas) {
			if(fichas.get(i).estado != Estado.GANADO && fichas.get(i).estado != Estado.BASE) {
				fichasASortear.add(ficha);
			}
			i++;
		}
		int numeroRand = (int)(Math.random()*fichasASortear.size());
		
		return fichasASortear.get(numeroRand);
	}
}
