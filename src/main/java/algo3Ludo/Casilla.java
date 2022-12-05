package algo3Ludo;

import java.util.ArrayList;
import algo3Ludo.Ficha.Color;

public class Casilla {
	
	public enum Tipo {NORMAL ,ENTRADA, PROTEGIDO, FINAL, GANADA, BASE};
	public Tipo tipoCasilla;
	public ArrayList<Ficha> fichas;
	public int posicion;

	

	public Casilla(Tipo tipo , int posicion){
		this.tipoCasilla = tipo;
		this.posicion = posicion;
		this.fichas = new ArrayList<Ficha>();
	}
	
	public Casilla(Tipo tipo, int posicion, Color color){
		this.tipoCasilla = tipo;
		this.posicion = posicion;
		this.fichas = new ArrayList<Ficha>();
	}

	//se encarga de  agregar la ficha que se le pasa por parametro de la lista de fichas
	public void ponerFicha(Ficha ficha) {
		fichas.add(ficha);
		ficha.casilla.posicion = this.posicion;
		ficha.casilla.tipoCasilla = this.tipoCasilla;
	}
}
