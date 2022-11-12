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
	ITipoJugador jugadorNormal;
	ITipoJugador jugadorIA;	
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
		jugadorIA = new JugadorMaquina();
		jugadorNormal = new JugadorNormal();
	}
	
	public void jugar() {
		
		while(!termino()) {	
			jugadorActual.comio = false;
			dado = Dado.lanzarDado();
			jugadorActual.movimientoARealizar = dado;
			for(int i = 0; i < tablero.listaTablero.size();i++) {
			System.out.print(i + "" + tablero.listaTablero.get(i).fichas);
			}
			System.out.println("--------------------------------------------------s");
			for(int i = 0; i < jugadorActual.fichas.size();i++) {
				if(jugadorActual.fichas.get(i).fueComida  ) {
					jugadorActual.fichasEnJuego--;
					pantalla.println("Se resta xq fue comida--------------------------------------------------------------------------------------");
					pantalla.println(jugadorActual.fichas.get(i));
					//teclado.nextLine();
				}
				jugadorActual.fichas.get(i).fueComida = false;	
			}
			System.out.println(jugadorActual.fichasEnJuego+"----------------------");
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
			System.out.println(jugadorActual.fichas);
			for(int i = 0; i < jugadorActual.fichas.size();i++) {
				if(jugadorActual.fichas.get(i).gano) {
					pantalla.println("Se resta xq gano-----------------------------------------------------------------------------------------");
					//teclado.nextLine();
					jugadorActual.fichasEnJuego--;
					jugadorActual.fichasGanadas++;
				}
				jugadorActual.fichas.get(i).gano = false;	
			}
			if (cantidadDe6 == 0 && !jugadorActual.comio) {
				jugadorActual = cambiarTurno();	
			}
			System.out.println(tablero.fichasGanadasAmarillo);
			System.out.println(tablero.fichasGanadasRojo);
			System.out.println(tablero.fichasGanadasAzul);
			System.out.println(tablero.fichasGanadasVerde);
			
		}
	}
	
	public void salioEl6() {
		cantidadDe6++;
		if(cantidadDe6 < 3) {
			if(jugadorActual.tipoJugador == "normal") {
				jugadorNormal.salioEl6(jugadorActual, tablero);
			}
			else {
				jugadorIA.salioEl6(jugadorActual, tablero);
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
			System.out.println("Terminooo! Gracias por jugar");
			return true;
		}
		return false;
	}
	
	public void restarFichasEnJuego() {
		for(int i = 0; i < jugadores.size();i++) {
			for(int j = 0; j < jugadores.get(i).fichas.size();j++) {
				System.out.println(jugadores.get(i).fichas.get(j).fueComida);
				if(jugadores.get(i).fichas.get(j).fueComida) {
					jugadores.get(i).fichas.get(j).fueComida = false;	
					jugadores.get(i).fichasEnJuego--;
					pantalla.println("Se comio una ficha.... Es tu turno nuevamente");									
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