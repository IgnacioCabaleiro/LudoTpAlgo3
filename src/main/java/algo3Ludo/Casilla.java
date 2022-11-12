package algo3Ludo;

import java.util.ArrayList;
import algo3Ludo.Ficha.Color;

public class Casilla {
	
	public ArrayList<Ficha> fichas;
	public int posicion;
	public enum Tipo {NORMAL ,ENTRADA, PROTEGIDO, FINAL, GANADA, BASE};
	Tipo tipoCasilla;
	Color color;

	public Casilla(Tipo tipo , int posicion){
		this.tipoCasilla = tipo;
		this.posicion = posicion;
		this.fichas = new ArrayList<Ficha>(10);
	}
	
	public Casilla(Tipo tipo, int posicion, Color color){
		this.tipoCasilla = tipo;
		this.posicion = posicion;
		this.color = color;
		this.fichas = new ArrayList<Ficha>(3);
	}
	//se encarga de  eliminar la ficha que se le pasa por parametro de la lista de fichas
	public void sacarFicha(Ficha ficha) {
		fichas.remove(ficha);
	}
	
	//se encarga de  agregar la ficha que se le pasa por parametro de la lista de fichas
	public void ponerFicha(Ficha ficha) {
		fichas.add(ficha);
		ficha.casilla.posicion = this.posicion;
		ficha.casilla.tipoCasilla = this.tipoCasilla;
		
	}
}
