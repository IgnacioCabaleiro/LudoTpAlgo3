package algo3Ludo;

public class Ficha {
	
	public enum Color { ROJO, VERDE, AMARILLO, AZUL}
	public enum Estado {BASE, JUGANDO, PROTEGIDA, FINAL, GANADO}
	public Casilla casilla;
	public boolean fueComida;
	public boolean gano;
	public boolean enJuego;
	public int posicionListaFichas;
	Color color;
	Estado estado;

	public Ficha(Color color, Estado estado, Casilla casilla, int posListaFichas){
		this.color = color;
		this.estado = estado;
		this.casilla = casilla;
		this.enJuego = false;
		this.posicionListaFichas = posListaFichas;
		this.gano = false;
		
	}
}