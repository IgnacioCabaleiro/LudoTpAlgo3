package algo3Ludo;

import java.util.ArrayList;

import algo3Ludo.Ficha;
import algo3Ludo.Casilla.Tipo;
import algo3Ludo.Ficha.Color;

public class Casilla {
	public ArrayList<Ficha> fichas;
	public int posicion;
	Tipo tipoCasilla;
	Color color;
	public enum Tipo {NORMAL ,ENTRADA, PROTEGIDO, FINAL, GANADA, BASE};

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
	public void sacarFicha(Ficha ficha) {
		fichas.remove(ficha);
	}
	public void ponerFicha(Ficha ficha) {
		fichas.add(ficha);
		ficha.casilla.posicion = this.posicion;
		ficha.casilla.tipoCasilla = this.tipoCasilla;
	}
}
