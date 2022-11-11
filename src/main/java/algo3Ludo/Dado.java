package algo3Ludo;

public class Dado {
	
	static final int MAX_CANTIDAD_MOVIMIENTO = 6;
	
	public static int lanzarDado() {
		return (int)(Math.random()*MAX_CANTIDAD_MOVIMIENTO)+1;
	}
}
