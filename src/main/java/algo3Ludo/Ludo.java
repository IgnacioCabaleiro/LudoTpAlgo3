package algo3Ludo;


import java.util.ArrayList;

import algo3Ludo.Ficha.Color;

public class Ludo {
	
	public static final java.util.Scanner teclado = new java.util.Scanner (System. in) ;
	public static final java.io.PrintStream pantalla = new java.io.PrintStream(System. out);
	static ArrayList<Jugador> jugadores;
	Tablero tablero;
	Jugador jugadorActual;
	Eleccion eleccion;
	int cantidadDe6;
	int dado;
	
	public Ludo() {
		tablero = new Tablero();
	}
	
	public void inicializarJuego() {

		jugadores = new ArrayList<Jugador>(3);

		crearJugadores();
		
		tablero = new Tablero();
		
		cantidadDe6 = 0;
		jugadorActual = elegirQuienEmpieza();
		
	}
	
	public void jugar() {
		
		while(!termino()) {	
			jugadorActual.comio = false;
			dado = Dado.lanzarDado();
			jugadorActual.movimientoARealizar = dado;

			pantalla.println("----------------------------------------------------");
			pantalla.println("El turno es del " + jugadorActual.color);
            pantalla.println("El resultado del dado es: " + dado);
            
			if(dado == 6) {
				salioEl6();
			}
			else if(dado != 6 && jugadorActual.fichasEnJuego > 0) {
				pantalla.println("Puede mover " + jugadorActual.fichasEnJuego + " ficha");
				eleccion = new EleccionMoverFicha();
				eleccion.ejecutar(jugadorActual, tablero);
				cantidadDe6 = 0;
			}
			else {
				pantalla.println("No puede mover ninguna ficha");
				cantidadDe6 = 0;
			}
			if (cantidadDe6 == 0 && !jugadorActual.comio) {
				jugadorActual = cambiarTurno();	
			}
			restarFichasEnJuego();
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
			if(rta.equals("sacar ficha") && jugadorActual.fichasEnJuego < 4) {
				pantalla.println("Puede sacar una ficha");
				eleccion = new EleccionSacarFicha();
				eleccion.ejecutar(jugadorActual , tablero);
			}
			else if((rta.equals("mover ficha") && jugadorActual.fichasEnJuego > 0 ) || (rta.equals("sacar ficha") && jugadorActual.fichasEnJuego >= 4)){
				if(jugadorActual.fichasEnJuego >= 4) {
					pantalla.println("No puede sacar mas fichas, debe mover una ficha");
				}
				else {
					pantalla.println("Puede mover una ficha");					
				}
				eleccion = new EleccionMoverFicha();
				eleccion.ejecutar(jugadorActual, tablero);
			}
			else {
				pantalla.println("No puede mover niguna ficha, se le quitará una de la base automaticamente");
                eleccion = new EleccionSacarFicha();
                eleccion.ejecutar(jugadorActual , tablero);
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
	
	public void restarFichasEnJuego() {
		for(int i = 0; i < jugadores.size();i++) {
			for(int j = 0; j < jugadores.get(i).fichas.size();j++) {
				if(jugadores.get(i).fichas.get(j).fueComida) {
					pantalla.println("Se comio una ficha.... Es tu turno nuevamente");				
					jugadores.get(i).fichasEnJuego--;
					jugadores.get(i).fichas.get(j).fueComida = false;					
				}
			}
		}
	}
	public void crearJugadores() {
		String tipoJugador;
		
		pantalla.println("Ingrese que tipo de jugador es el jugador AZUL ('normal' o 'maquina')");
		tipoJugador = teclado.nextLine();
		Jugador jugadorAzul = new Jugador(Color.AZUL,tipoJugador);				
		
		pantalla.println("Ingrese que tipo de jugador es el jugador AMARILLO ('normal' o 'maquina')");
		tipoJugador = teclado.nextLine();
		Jugador jugadorAmarillo = new Jugador(Color.AMARILLO,tipoJugador);

		pantalla.println("Ingrese que tipo de jugador es el jugador ROJO ('normal' o 'maquina')" );
		tipoJugador = teclado.nextLine();
		Jugador jugadorRojo = new Jugador(Color.ROJO,tipoJugador);
		
		pantalla.println("Ingrese que tipo de jugador es el jugador VERDE ('normal' o 'maquina')");
		tipoJugador = teclado.nextLine();
		Jugador jugadorVerde = new Jugador(Color.VERDE,tipoJugador);
		
		jugadores.add(jugadorVerde);
		jugadores.add(jugadorRojo);
		jugadores.add(jugadorAmarillo);
		jugadores.add(jugadorAzul);
	}
}