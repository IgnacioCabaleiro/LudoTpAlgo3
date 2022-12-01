package algo3Ludo;

public class Ficha {
	
	public enum Color { ROJO, VERDE, AMARILLO, AZUL}
	public enum Estado {BASE, JUGANDO, PROTEGIDA, FINAL, GANADO}
	public Casilla casilla;
	public boolean fueComida;
	public boolean gano;
	public boolean enJuego;
	public int posicionListaFichas;
	public Color color;
	public Estado estado;

	public Ficha(Color color, Estado estado, Casilla casilla, int posListaFichas){
		this.color = color;
		this.estado = estado;
		this.casilla = casilla;
		this.enJuego = false;
		this.posicionListaFichas = posListaFichas;
		this.gano = false;
		
	}
	
	//Procedimiento encargado de actualizar las coordenadas de la casilla de la ficha.
	public void actualizarCoordenadas() {
		if(estado == Estado.FINAL || estado == Estado.GANADO) {
			casilla.setCoordenadasRectasFinales(color);		    					    			
		}
		else {
			casilla.setCoordenadasTablero();
		}
	}
}