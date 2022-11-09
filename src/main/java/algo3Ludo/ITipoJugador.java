package algo3Ludo;

import algo3Ludo.Ficha;
import algo3Ludo.Jugador;

public interface ITipoJugador {
	
	public static final java.util.Scanner teclado = new java.util.Scanner (System. in) ;
	public static final java.io.PrintStream pantalla = new java.io.PrintStream(System. out);
	
	public Ficha elegirFicha(Jugador jugador);
}