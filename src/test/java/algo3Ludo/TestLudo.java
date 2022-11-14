package algo3Ludo;

import algo3Ludo.Ficha.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import algo3Ludo.Casilla.*;


@RunWith(MockitoJUnitRunner.class)
public class TestLudo {

	@Mock
	Tablero tablero;
	@Test
	public void testCalcularDestino() {
		
		var ficha = new Ficha(Color.AMARILLO, Estado.JUGANDO, new Casilla(Tipo.NORMAL, 5));
		var casillaNueva = new Casilla(Tipo.NORMAL, 6);
		
		when(tablero.calcularDestino(ficha, 1)).thenReturn(casillaNueva);
		
		assertEquals(tablero.calcularDestino(ficha, 1).posicion, 6);
	}
	@Test
	public void mueveCorrectamente() {
		var ficha = new Ficha(Color.ROJO, Estado.JUGANDO, new Casilla(Tipo.NORMAL, 5));
		tablero = new Tablero();
		
		tablero.listaTablero.get(0).fichas.add(0, ficha);
		tablero.moverFicha(ficha, 1);
		
		assertEquals(6, ficha.casilla.posicion);
		assertEquals(1,tablero.listaTablero.get(6).fichas.size());
		assertEquals(Estado.JUGANDO,ficha.estado);
	}
	
	@Test 
	public void comeCorrectamente() {
		var jugador = new Jugador(Color.AMARILLO, "normal");
		var ficha1 = new Ficha(Color.AMARILLO, Estado.JUGANDO, new Casilla(Tipo.NORMAL, 5));
		var ficha2 = new Ficha(Color.ROJO, Estado.JUGANDO, new Casilla(Tipo.NORMAL, 2));
		tablero = new Tablero();
		
		jugador.fichas.add(0,ficha1);
		tablero.listaTablero.get(5).fichas.add(0, ficha1);
		jugador.fichasEnJuego = 1;
		tablero.listaTablero.get(2).fichas.add(0, ficha2);
		tablero.moverFicha(ficha2, 3);
		if(tablero.fichaCome(ficha2)) {
			tablero.comer(ficha2);
			tablero.eliminarFichaComidas(jugador);
		}
		
		assertEquals( 1, tablero.listaTablero.get(5).fichas.size());
		assertTrue(tablero.listaTablero.get(5).fichas.contains(ficha2));
		assertFalse(tablero.listaTablero.get(5).fichas.contains(ficha1));
		assertEquals(ficha1.estado, Estado.BASE);
		assertEquals(0,jugador.fichasEnJuego);
	}
	
	@Test
	public void testVerificaSiEntraRectaFinal() {
		var ficha1 = new Ficha(Color.AMARILLO, Estado.JUGANDO, new Casilla(Tipo.NORMAL, 22));
		tablero = new Tablero();
		
		tablero.listaTablero.get(22).fichas.add(0, ficha1);
		tablero.moverFicha(ficha1, 3);
		
		assertEquals(0,ficha1.casilla.posicion);
		assertEquals(Estado.FINAL,ficha1.estado);
		assertTrue(tablero.listaTablero.get(22).fichas.isEmpty());	
		assertTrue(tablero.rectaFinalAmarillo.get(0).fichas.contains(ficha1));

	}
	
	@Test
	public void whenEstaEnCasillaProtegidaThenNoLoPuedenComer() {
		var tablero = new Tablero();
		var ficha1 = new Ficha(Color.AZUL, Estado.JUGANDO, new Casilla(Tipo.PROTEGIDO, 39));
		var ficha2 = new Ficha(Color.ROJO, Estado.JUGANDO, new Casilla(Tipo.NORMAL, 36));	
		
		tablero.listaTablero.get(39).fichas.add(0, ficha1);
		tablero.listaTablero.get(36).fichas.add(0, ficha2);
		tablero.moverFicha(ficha2, 3);
		tablero.cambiarEstado(ficha1);
		tablero.cambiarEstado(ficha2);
		if(tablero.fichaCome(ficha2)) {
			tablero.comer(ficha2);
		}
		
		assertEquals(2, tablero.listaTablero.get(39).fichas.size());
		assertEquals(ficha1.estado, Estado.PROTEGIDA);
		assertEquals(ficha2.estado, Estado.PROTEGIDA);
		assertFalse(tablero.fichaCome(ficha2));
	}
	
	@Test
	public void whenInicializarJuegothenValoresCorrectosNormal() {
		var ludo = new Ludo() {
			@Override
			public void crearJugadores() {
				Jugador jugadorRojo = new Jugador(Color.ROJO,"normal");
				Jugador jugadorAzul = new Jugador(Color.AZUL,"normal");
				Jugador jugadorVerde = new Jugador(Color.VERDE,"normal");
				Jugador jugadorAmarillo = new Jugador(Color.AMARILLO,"normal");
				
				jugadores.add(jugadorVerde);
				jugadores.add(jugadorRojo);
				jugadores.add(jugadorAmarillo);
				jugadores.add(jugadorAzul);
			}
		};
		boolean esUnColorValido = false;
		
		ludo.inicializarJuego();
		if(ludo.jugadorActual.color == Color.ROJO || ludo.jugadorActual.color == Color.AMARILLO || ludo.jugadorActual.color == Color.AZUL || ludo.jugadorActual.color == Color.VERDE ) {
			esUnColorValido = true;
		}
		
		assertEquals(4 , ludo.jugadores.size());
		assertEquals("normal",ludo.jugadores.get(0).tipoJugador);
		assertTrue(esUnColorValido);
	}
	
	@Test
	public void whenInicializarJuegothenValoresCorrectosMaquina() {
		var ludo = new Ludo() {
			@Override
			public void crearJugadores() {
				Jugador jugadorRojo = new Jugador(Color.ROJO,"maquina");
				Jugador jugadorAzul = new Jugador(Color.AZUL,"maquina");
				Jugador jugadorVerde = new Jugador(Color.VERDE,"maquina");
				Jugador jugadorAmarillo = new Jugador(Color.AMARILLO,"maquina");
				
				jugadores.add(jugadorVerde);
				jugadores.add(jugadorRojo);
				jugadores.add(jugadorAmarillo);
				jugadores.add(jugadorAzul);
			}
		};
		boolean esUnColorValido = false;
		
		ludo.inicializarJuego();
		if(ludo.jugadorActual.color == Color.ROJO || ludo.jugadorActual.color == Color.AMARILLO || ludo.jugadorActual.color == Color.AZUL || ludo.jugadorActual.color == Color.VERDE ) {
			esUnColorValido = true;
		}
		
		assertEquals(4 , ludo.jugadores.size());
		assertEquals("maquina",ludo.jugadores.get(0).tipoJugador);
		assertTrue(esUnColorValido);
	}
	
	@Test
	public void testCrearListasCorrectamente() {
		tablero = new Tablero();
		
		assertEquals(52,tablero.listaTablero.size());
		assertEquals(6,tablero.rectaFinalAmarillo.size());
		assertEquals(Tipo.FINAL,tablero.rectaFinalAzul.get(3).tipoCasilla);
		assertEquals(Tipo.GANADA,tablero.rectaFinalRojo.get(5).tipoCasilla);
		assertTrue(tablero.fichasGanadasVerde.isEmpty());
	
	}
	
	@Test
	public void whenTodasFichasGanadasthenTermina() {
		var ludo = new Ludo();
		ludo.tablero = new Tablero() {
			@Override
			public void cambiarEstado(Ficha ficha) {
				if(ficha.casilla.tipoCasilla == Tipo.GANADA) {
					ficha.estado = Estado.GANADO;
					ficha.gano = true;
				}
			}
		};
		var jugador = new Jugador(Color.ROJO, "normal");
		var ficha1 = new Ficha(Color.ROJO, Estado.FINAL, new Casilla(Tipo.FINAL, 3));	
		var ficha2 = new Ficha(Color.ROJO, Estado.FINAL, new Casilla(Tipo.FINAL, 3));	
		var ficha3 = new Ficha(Color.ROJO, Estado.FINAL, new Casilla(Tipo.FINAL, 3));	
		var ficha4 = new Ficha(Color.ROJO, Estado.FINAL, new Casilla(Tipo.FINAL, 3));	
		
		jugador.fichasEnJuego = 0;
		
		jugador.fichas.add(ficha1);
		jugador.fichas.add(ficha2);
		jugador.fichas.add(ficha3);
		jugador.fichas.add(ficha4);
		ludo.tablero.rectaFinalRojo.get(3).fichas.add(0, ficha1);
		jugador.fichasEnJuego++;
		ludo.tablero.rectaFinalRojo.get(3).fichas.add(1, ficha2);
		jugador.fichasEnJuego++;
		ludo.tablero.rectaFinalRojo.get(3).fichas.add(2, ficha3);
		jugador.fichasEnJuego++;
		ludo.tablero.rectaFinalRojo.get(3).fichas.add(3, ficha4);
		jugador.fichasEnJuego++;
		ludo.tablero.moverFicha(ficha1, 2);
		ludo.tablero.moverFicha(ficha2, 2);
		ludo.tablero.moverFicha(ficha3, 2);
		ludo.tablero.moverFicha(ficha4, 2);
		ludo.tablero.cambiarEstado(ficha1);
		ludo.tablero.cambiarEstado(ficha2);
		ludo.tablero.cambiarEstado(ficha3);
		ludo.tablero.cambiarEstado(ficha4);
		ludo.tablero.eliminarFichasGanadas(jugador);
		
		assertEquals(4, ludo.tablero.fichasGanadasRojo.size());
		for(int i = 0; i < ludo.tablero.rectaFinalRojo.get(5).fichas.size();i++) {
			assertEquals(Estado.GANADO, ludo.tablero.fichasGanadasRojo.get(i).estado);			
		}
		assertTrue(ludo.termino());
		assertEquals(0, jugador.fichasEnJuego);
	}
	
	@Test
	public void whenTres6SeguidosThenCambiaDeTurno() {
		var ludo = new Ludo() {
			@Override
			public void crearJugadores() {
				Jugador jugadorRojo = new Jugador(Color.ROJO,"normal");
				Jugador jugadorAzul = new Jugador(Color.AZUL,"normal");
				Jugador jugadorVerde = new Jugador(Color.VERDE,"normal");
				Jugador jugadorAmarillo = new Jugador(Color.AMARILLO,"normal");
				
				jugadores.add(jugadorVerde);
				jugadores.add(jugadorRojo);
				jugadores.add(jugadorAmarillo);
				jugadores.add(jugadorAzul);
			}
			@Override
			public void inicializarJuego() {
				jugadores = new ArrayList<Jugador>(3);
				cantidadDe6 = 2;
				crearJugadores();
				jugadorActual = jugadores.get(0);
			}
			@Override
			public void jugar() {
				if (cantidadDe6 == 0) {
					jugadorActual = cambiarTurno();	
				}
			}

		};
		ludo.inicializarJuego();
		ludo.salioEl6();
		ludo.jugar();
		
		assertEquals(0 , ludo.cantidadDe6);
		assertEquals(ludo.jugadorActual.color , Color.ROJO);
		
	}
	
	@Test
	public void whenTirarDadothenNumeroEntre1y6() {
		int tirada = Dado.lanzarDado();
		
		assertTrue(tirada <= 6);
		assertTrue(tirada > 0);
	}
	//saca ficha automaticamente porque no tiene ninguna ficha para mover
	@Test
	public void whenMoverFichaYFichasEnJuegoEs0thenSacarFichaJugadorNormal() {


		tablero = new Tablero();
		var eleccionSacar = new EleccionSacarFicha();
		var jugador = new Jugador(Color.ROJO, "normal");
		var ficha = new Ficha(Color.ROJO, Estado.JUGANDO, new Casilla(Tipo.NORMAL, 5));
		
		var jugadorNormal = new JugadorNormal() {
			public void salioEl6(Jugador jugador, Tablero tablero, String rta) {
				if(jugador.fichasEnJuego == 0 && rta.equals("mover ficha")) {
					eleccionSacar.ejecutar(jugador, tablero);
				}
			}
		};
		
		jugador.fichas.add(ficha);
		jugador.fichasEnJuego = 0;
		jugadorNormal.salioEl6(jugador, tablero, "mover ficha");
		
		assertEquals(1,jugador.fichasEnJuego);
		assertEquals(1,tablero.listaTablero.get(0).fichas.size());
	}
	
	@Test
	public void whenSacarFichaYFichasEnJuegoEs4thenMoverficha() {
		tablero = new Tablero();
		var jugador = new Jugador(Color.ROJO, "normal");
		var ficha = new Ficha(Color.ROJO, Estado.JUGANDO, new Casilla(Tipo.NORMAL, 5));
		
		var jugadorNormal = new JugadorNormal() {
			public void salioEl6(Jugador jugador, Tablero tablero, String rta) {
				if(jugador.fichasEnJuego == 4 && rta.equals("sacar ficha")) {
					tablero.moverFicha(jugador.fichas.get(0), 2);
				}
			}
		};
		
		jugador.fichas.add(0,ficha);
		jugador.fichasEnJuego = 4;
		jugadorNormal.salioEl6(jugador, tablero, "sacar ficha");
		assertEquals(4,jugador.fichasEnJuego);
		assertEquals(7,ficha.casilla.posicion);
		assertEquals(1,tablero.listaTablero.get(7).fichas.size());
	}
	
	@Test
	public void whenFichasEnJuegoEs0thenSacarFichaJugadorMaquina() {

		tablero = new Tablero();
		var jugador = new Jugador(Color.ROJO, "maquina");
		var ficha = new Ficha(Color.ROJO, Estado.JUGANDO, new Casilla(Tipo.NORMAL, 5));
		
		var jugadorMaquina = new JugadorMaquina();
		
		jugador.fichas.add(0,ficha);
		jugador.fichasEnJuego = 0;
		jugadorMaquina.salioEl6(jugador, tablero);
		
		assertEquals(1,jugador.fichasEnJuego);
		assertEquals(1,tablero.listaTablero.get(0).fichas.size());
	}
	
	@Test 
	public void whenFichasEnJuegoEs4thenMoverfichaJugadorMaquina() {

		tablero = new Tablero();
		var jugador = new Jugador(Color.ROJO, "maquina");
		var ficha = new Ficha(Color.ROJO, Estado.JUGANDO, new Casilla(Tipo.NORMAL, 5));
		var jugadorMaquina = new JugadorMaquina();
		
		jugador.fichas.add(0,ficha);
		jugador.fichasEnJuego = 4;
		jugador.movimientoARealizar = 2;
		jugadorMaquina.salioEl6(jugador, tablero);
		
		assertEquals(4,jugador.fichasEnJuego);
		assertEquals(7,ficha.casilla.posicion);
	}
}
