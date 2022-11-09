package algo3Ludo;

import algo3Ludo.Casilla.Tipo;
import algo3Ludo.Ficha.Color;

public class Ficha {
	public enum Color { ROJO, VERDE, AMARILLO, AZUL}
	public enum Estado {BASE, JUGANDO, PROTEGIDA, FINAL, GANADO}
	public Casilla casilla;
	Color color;
	Estado estado;
	public boolean fueComida;

	public Ficha(Color color, Estado estado, Casilla casilla){
		this.color = color;
		this.estado = estado;
		this.casilla = casilla;
		
	}
}