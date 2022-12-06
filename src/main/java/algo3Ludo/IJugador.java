package algo3Ludo;

public interface IJugador {
	
	public static final java.io.PrintStream pantalla = new java.io.PrintStream(System. out);
	
	// ejecuta la accion de que salio un 6 dependiendo si si el jugador es el usuario o se "maneja solo"
	public void salioEl6(Jugador jugador,Ficha ficha ,Tablero tablero);
}