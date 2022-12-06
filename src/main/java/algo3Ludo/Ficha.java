package algo3Ludo;

public class Ficha {
	
	public enum Color { ROJO, VERDE, AMARILLO, AZUL }
	public enum Estado { BASE, JUGANDO, PROTEGIDA, FINAL, GANADO }
	public Color color;
	public Casilla casilla;
	public boolean fueComida;
	public boolean gano;
	public boolean enJuego;
	public int posicionListaFichas;

	public Ficha(Color color,Casilla casilla, int posListaFichas){
		this.color = color;
		this.casilla = casilla;
		this.posicionListaFichas = posListaFichas;
		this.enJuego = false;
		this.gano = false;
		this.fueComida = false;
		
	}
	//devuelve el estado de la ficha dependiendo de la casilla donde esta
	public Estado getEstado() {
		switch (casilla.tipoCasilla) {
		  case PROTEGIDO: 
			  return Estado.PROTEGIDA;
		  case NORMAL: 
			  return Estado.JUGANDO;
		  case BASE: 
			  return Estado.BASE;
		  case ENTRADA:
			  return Estado.JUGANDO;
		  case FINAL:
			  return Estado.FINAL;
		  case GANADA:
			  return Estado.GANADO;
		  default:
			  return null;
		}
	}
}