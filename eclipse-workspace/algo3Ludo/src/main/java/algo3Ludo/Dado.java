package algo3Ludo;

public class Dado {
	
	private static final int MAX_CANTIDAD_MOVIMIENTO = 6;
	
	//retorna un numero entre 1 y 6 que simula el tiro de un dado
	public static int lanzarDado() {
		return (int)(Math.random()*MAX_CANTIDAD_MOVIMIENTO)+1;
	}
}
