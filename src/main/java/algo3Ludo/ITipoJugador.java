package algo3Ludo;

public interface ITipoJugador {
	
	public static final java.util.Scanner teclado = new java.util.Scanner (System. in) ;
	public static final java.io.PrintStream pantalla = new java.io.PrintStream(System. out);
	
	public Ficha elegirFicha(Jugador jugador);
	public void salioEl6(Jugador jugador, Tablero tablero);
}