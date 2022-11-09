package algo3Ludo;


import java.util.ArrayList;

import algo3Ludo.Ficha.Color;
import algo3Ludo.Ficha.Estado;
import algo3Ludo.Jugador;
import algo3Ludo.Tablero;
import algo3Ludo.Eleccion;

import algo3Ludo.ITipoJugador;

public class Ludo {
	
	Tablero tablero;
	public static final java.util.Scanner teclado = new java.util.Scanner (System. in) ;
	public static final java.io.PrintStream pantalla = new java.io.PrintStream(System. out);
	static ArrayList<Jugador> jugadores;
	Jugador jugadorActual;
	Eleccion eleccion;
	int cantidadDe6;
	int dado;

	public void inicializarJuego() {

		jugadores = new ArrayList<Jugador>(3);
		Jugador jugadorAzul = new Jugador(Color.AZUL,"normal");				
		Jugador jugadorAmarillo = new Jugador(Color.AMARILLO,"normal");
		Jugador jugadorRojo = new Jugador(Color.ROJO,"normal");
		Jugador jugadorVerde = new Jugador(Color.VERDE,"normal");
		
		jugadores.add(jugadorVerde);
		jugadores.add(jugadorRojo);
		jugadores.add(jugadorAmarillo);
		jugadores.add(jugadorAzul);

		tablero = new Tablero();
		
		cantidadDe6 = 0;
		jugadorActual = elegirQuienEmpieza();
		
	}
	
	public void jugar() {
		
		while(!termino()) {	
			System.out.println("----------------------------------------------------");
			for(int i = 0; i < tablero.listaTablero.size();i++) {
				System.out.print(i + "" + tablero.listaTablero.get(i).fichas);
			}
			System.out.println("");
			dado = Dado.lanzarDado();
			System.out.println("El turno es del "+ jugadorActual.color);
			System.out.println(dado);
			jugadorActual.movimientoARealizar = dado;
			if(dado == 6) { //caso que sale 6
				salioEl6();
			}
			else if(dado != 6 && jugadorActual.fichasEnJuego > 0) { // caso que no sale el 6
				System.out.println("Puede mover "+jugadorActual.fichasEnJuego+" ficha");
				eleccion = new EleccionMoverFicha();
				eleccion.ejecutar(jugadorActual, tablero);
				cantidadDe6 = 0;
			}
			else { // cuando no tiene ninguna ficha para mover
				System.out.println("No puede mover ninguna ficha");
				cantidadDe6 = 0;
			}
			if (cantidadDe6 == 0 && !jugadorActual.comio) {
				jugadorActual = cambiarTurno();	
			}
			for(int i = 0; i < jugadores.size();i++) {
				for(int j = 0; j < jugadores.get(i).fichas.size();j++) {
					if(jugadores.get(i).fichas.get(j).fueComida) {
						jugadores.get(i).fichasEnJuego--;
					}
				}
			}
		}
	}
	
	public void salioEl6() {
		cantidadDe6++;
		String rta;
		if(cantidadDe6 < 3) {
			pantalla.println("Sacaste 6: elegi si queres sacar ficha o mover una existente");
			rta = teclado.nextLine();
			while(!rta.equals("sacar ficha") && !rta.equals("mover ficha")) {
				pantalla.println("Sacaste 6: elegi si queres sacar ficha o mover una existente (~mover ficha~ o ~sacar ficha~)");
				rta = teclado.nextLine();
			}
			if(rta.equals("sacar ficha") && jugadorActual.fichasJugadas < 4) {
				System.out.println("Puede sacar una ficha");
				eleccion = new EleccionSacarFicha();
				eleccion.ejecutar(jugadorActual , tablero);
			}
			else {
				System.out.println("Puede mover una ficha");
				eleccion = new EleccionMoverFicha();
				eleccion.ejecutar(jugadorActual, tablero);
			}
		}
		else {
			cantidadDe6 = 0;
		}
	}
	
	public Jugador elegirQuienEmpieza() {
		int resultado = (int)(Math.random()*4)+1;
		
		if(resultado == 1) {
			return jugadores.get(0);//Verde
		}
		else if(resultado == 2) {
			return jugadores.get(1);//Rojo
		}
		else if(resultado == 3) {
			return jugadores.get(2);//Amarillo
		}
		else {
			return jugadores.get(3);//Azul
		}
	}
	
	public Jugador cambiarTurno() {
		if(jugadorActual.color == Color.ROJO) {
			return jugadores.get(3);
		}
		else if(jugadorActual.color == Color.AZUL) {
			return jugadores.get(2);
		}
		else if(jugadorActual.color == Color.AMARILLO) {
			return jugadores.get(0);
		}
		else if(jugadorActual.color == Color.VERDE) {
			return jugadores.get(1);
		}
		return null;
		
	}
	
	public boolean termino() {
		if(tablero.fichasGanadasAzul.size() == 4 || 
				tablero.fichasGanadasRojo.size() == 4 || 
				tablero.fichasGanadasAmarillo.size() == 4 || 
				tablero.fichasGanadasVerde.size() == 4) {
			return true;
		}
		return false;
	}
	
	
}