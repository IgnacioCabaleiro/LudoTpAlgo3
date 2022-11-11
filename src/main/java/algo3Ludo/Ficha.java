package algo3Ludo;

public class Ficha {
	
	public enum Color { ROJO, VERDE, AMARILLO, AZUL}
	public enum Estado {BASE, JUGANDO, PROTEGIDA, FINAL, GANADO}
	public Casilla casilla;
	public boolean fueComida;
	Color color;
	Estado estado;

	public Ficha(Color color, Estado estado, Casilla casilla){
		this.color = color;
		this.estado = estado;
		this.casilla = casilla;
		
	}
}