package algo3Ludo;

import java.util.ArrayList;
import algo3Ludo.Ficha.Color;

public class Ludo {
	
	private static final java.io.PrintStream pantalla = new java.io.PrintStream(System. out);
	public ArrayList<Jugador> jugadores;
	public Tablero tablero;
	public Jugador jugadorActual;
	public Eleccion eleccion;
	private ITipoJugador jugadorNormal;
	private ITipoJugador jugadorIA;	
	protected int cantidadDe6;
	public int dado;

	//Se encarga de inicializar los elementos necesarios para empezar el juego (tablero, jugadores, etc).
	public void inicializarJuego() {

		this.jugadores = new ArrayList<Jugador>();
		this.jugadorIA = new JugadorMaquina();
		this.jugadorNormal = new JugadorNormal();
		this.tablero = new Tablero();
		this.cantidadDe6 = 0;
		
	}
	
	public void iniciarTurno(int resultadoDado) {
		
		if(resultadoDado == 6) {
			cantidadDe6++;
		}
		else {
			cantidadDe6 = 0;
		}
		dado = resultadoDado;
		jugadorActual.comio = false;
		jugadorActual.movimientoARealizar = resultadoDado;
		
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("El turno es del " + jugadorActual.color);
		System.out.println("El resultado del dado es: " + resultadoDado);
	}
	
	
	//Segun el numero que salio en el dado se encarga de llamar a las funciones correspondientes
	public void accionDependiendoTiradaDado(Ficha fichaAUtilizar) {
		
		if(dado == 6) {
			salioEl6(fichaAUtilizar);
		}
		else if(dado != 6 && jugadorActual.fichasEnJuego > 0) {
			pantalla.println("Puede mover " + jugadorActual.fichasEnJuego + " fichas");
			eleccion = new EleccionMoverFicha();
			eleccion.ejecutar(jugadorActual,fichaAUtilizar, tablero);
		}
		else {
			pantalla.println("No puede mover ninguna ficha");
		}
		tablero.eliminarFichasGanadasDelTablero(jugadorActual);
		
		jugadorActual = cambiarTurno();		
	}
	
	//Procedimiento que se encarga de llamar al proceidmiento salioEl6 dependiendo si el jugador
	//es "normal" o la "maquina"
	public void salioEl6(Ficha ficha) {
		//cantidadDe6++;
		if(cantidadDe6 < 3) {
			if(jugadorActual.tipoJugador.equals("normal")) {
				jugadorNormal.salioEl6(jugadorActual,ficha, tablero);
			}
			else {
				jugadorIA.salioEl6(jugadorActual,ficha ,tablero);
			}
		}	
		else {
			cantidadDe6 = 0;
		}
	}
	
	//Determina que jugador comienza de forma aleatorias y lo devuelve.
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
	
	//Dependiendo de cual es el jugador actual te devuelve el turno del jugador
	//de la derecha (mirando el tablero).
	public Jugador cambiarTurno() {
		if(cantidadDe6 == 0 && !jugadorActual.comio) {
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
		}
		return jugadorActual;
		
	}
	
	//Devuelve true si alguno de los jugadores llega a 4 fichas ganadas.
	public boolean termino() {
		if(tablero.fichasGanadasAzul.size() == 4 || 
				tablero.fichasGanadasRojo.size() == 4 || 
				tablero.fichasGanadasAmarillo.size() == 4 || 
				tablero.fichasGanadasVerde.size() == 4) {
			pantalla.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
			pantalla.println("Terminooo! Gracias por jugar");
			pantalla.println("Estos son los resultados : ");
			pantalla.println("-Fichas ganadas del rojo: " + tablero.fichasGanadasRojo.size());
			pantalla.println("-Fichas ganadas del amarillo: " + tablero.fichasGanadasAmarillo.size());
			pantalla.println("-Fichas ganadas del azul: " + tablero.fichasGanadasAzul.size());
			pantalla.println("-Fichas ganadas del verde: " + tablero.fichasGanadasVerde.size());
			
			return true;
		}
		return false;
	}
	
	//Se encarga de crear los jugadores preguntadole al usuario si quiere que sean "normal" o "maquina"
	//y los agrega a la lista de jugadores
	public void crearJugadores(String tipoJugadorRojo, String tipoJugadorAzul, String tipoJugadorAmarillo, String tipoJugadorVerde) {
		
		Jugador jugadorAzul = new Jugador(Color.AZUL,tipoJugadorAzul);				
		
		Jugador jugadorAmarillo = new Jugador(Color.AMARILLO,tipoJugadorAmarillo);

		Jugador jugadorRojo = new Jugador(Color.ROJO,tipoJugadorRojo);

		Jugador jugadorVerde = new Jugador(Color.VERDE,tipoJugadorVerde);
		
		jugadores.add(jugadorVerde);
		jugadores.add(jugadorRojo);
		jugadores.add(jugadorAmarillo);
		jugadores.add(jugadorAzul);
	}
	
	//Procedimiento que retorna la Ficha a mover dependiendo del id que se le pase.
	public Ficha fichaElegida(String ficha) {
		if(ficha.equals("fichaAzul1")) {
			return jugadores.get(3).fichas.get(0);
		}
		else if(ficha.equals("fichaAzul2")) {
			return jugadores.get(3).fichas.get(1);
		}
		else if(ficha.equals("fichaAzul3")) {
			return jugadores.get(3).fichas.get(2);
		}
		else if(ficha.equals("fichaAzul4")) {
			return jugadores.get(3).fichas.get(3);
		}
		else if(ficha.equals("fichaAmarillo1")) {
			return jugadores.get(2).fichas.get(0);
		}
		else if(ficha.equals("fichaAmarillo2")) {
			return jugadores.get(2).fichas.get(1);
		}
		else if(ficha.equals("fichaAmarillo3")) {
			return jugadores.get(2).fichas.get(2);
		}
		else if(ficha.equals("fichaAmarillo4")) {
			return jugadores.get(2).fichas.get(3);
		}
		else if(ficha.equals("fichaRojo1")) {
			return jugadores.get(1).fichas.get(0);
		}
		else if(ficha.equals("fichaRojo2")) {
			return jugadores.get(1).fichas.get(1);
		}
		else if(ficha.equals("fichaRojo3")) {
			return jugadores.get(1).fichas.get(2);
		}
		else if(ficha.equals("fichaRojo4")) {
			return jugadores.get(1).fichas.get(3);
		}
		else if(ficha.equals("fichaVerde1")) {
			return jugadores.get(0).fichas.get(0);
		}
		else if(ficha.equals("fichaVerde2")) {
			return jugadores.get(0).fichas.get(1);
		}
		else if(ficha.equals("fichaVerde3")) {
			return jugadores.get(0).fichas.get(2);
		}
		else if(ficha.equals("fichaVerde4")) {
			return jugadores.get(0).fichas.get(3);
		}
		
		return null;
	}

	//Procedimiento que retorna true si la jugada a realizar es optima.
	public boolean jugadaEnCondiciones(Ficha ficha) {
		if((ficha.enJuego || jugadorActual.fichasEnJuego == 0 || 
				(dado == 6 &&(jugadorActual.fichasGanadas + jugadorActual.fichasEnJuego) <= 4))) {
			return true;
		}
		return false;
	}
	
	//Procedimiento que modifica los atributos correspondientes en el caso que una ficha fue comida.
	public void eliminarFichaComida(Jugador jugador, Ficha ficha) {
		jugador.fichasEnJuego--;
		jugador.fichasGanadas++;
		ficha.enJuego = false;
	}
	
	//Procedimiento que modifica los atributos correspondientes en el caso que una ficha ganó.
	public void eliminarFichaGanada(Jugador jugador, Ficha ficha) {
		jugador.fichasEnJuego--;
		ficha.enJuego = false;
	}
}