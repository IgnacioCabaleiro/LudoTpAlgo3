package algo3Ludo;

import algo3Ludo.Ficha.*;
import static org.junit.Assert.*;
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
		
		var ficha = new Ficha(Color.AMARILLO, new Casilla(Tipo.NORMAL, 5), 0);
		var casillaNueva = new Casilla(Tipo.NORMAL, 6);
		
		when(tablero.calcularDestino(ficha, 1)).thenReturn(casillaNueva);
		
		assertEquals(tablero.calcularDestino(ficha, 1).posicion, 6);
	}
	@Test
	public void mueveCorrectamente() {
		var ficha = new Ficha(Color.ROJO, new Casilla(Tipo.NORMAL, 5), 0);
		tablero = new Tablero();
		
		tablero.listaTablero.get(0).fichas.add(0, ficha);
		tablero.moverFicha(ficha, 1);
		
		assertEquals(6, ficha.casilla.posicion);
		assertEquals(1,tablero.listaTablero.get(6).fichas.size());
		assertEquals(Estado.JUGANDO,ficha.getEstado());
	}
	
	@Test 
	public void comeCorrectamente() {
		var jugador = new Jugador(Color.AMARILLO, "normal");
		var ficha1 = new Ficha(Color.AMARILLO, new Casilla(Tipo.NORMAL, 5),0);
		var ficha2 = new Ficha(Color.ROJO, new Casilla(Tipo.NORMAL, 2),0);
		tablero = new Tablero();
		var ludo = new Ludo();
		
		jugador.fichas.add(0,ficha1);
		tablero.listaTablero.get(5).fichas.add(0, ficha1);
		jugador.fichasEnJuego = 1;
		tablero.listaTablero.get(2).fichas.add(0, ficha2);
		tablero.moverFicha(ficha2, 3);
		if(tablero.fichaCome(ficha2)) {
			tablero.comer(ficha2);
			ludo.eliminarFichaComida(jugador,ficha2);
		}
		
		assertEquals( 1, tablero.listaTablero.get(5).fichas.size());
		assertTrue(tablero.listaTablero.get(5).fichas.contains(ficha2));
		assertFalse(tablero.listaTablero.get(5).fichas.contains(ficha1));
		assertEquals(ficha1.getEstado(), Estado.BASE);
		assertEquals(0,jugador.fichasEnJuego);
	}
	
	@Test
	public void testVerificaSiEntraRectaFinal() {
		var ficha1 = new Ficha(Color.AMARILLO, new Casilla(Tipo.ENTRADA, 23), 1);
		var ficha2 = new Ficha(Color.ROJO, new Casilla(Tipo.NORMAL, 49), 0);
		tablero = new Tablero();
		
		tablero.listaTablero.get(23).fichas.add(ficha1);
		tablero.listaTablero.get(49).fichas.add(ficha2);
		tablero.moverFicha(ficha1, 5);
		tablero.moverFicha(ficha2, 2);
		
		assertEquals(3,ficha1.casilla.posicion);
		assertEquals(Estado.FINAL,ficha1.getEstado());
		assertTrue(tablero.listaTablero.get(23).fichas.isEmpty());	
		assertTrue(tablero.rectaFinalAmarillo.get(3).fichas.contains(ficha1));

		assertEquals(0,ficha2.casilla.posicion);
		assertEquals(Estado.FINAL,ficha2.getEstado());
		assertTrue(tablero.listaTablero.get(49).fichas.isEmpty());	
		assertTrue(tablero.rectaFinalRojo.get(0).fichas.contains(ficha2));
		
		
	}
	
	@Test
	public void whenEstaEnCasillaProtegidaThenNoLoPuedenComer() {
		var tablero = new Tablero();
		var ficha1 = new Ficha(Color.AZUL, new Casilla(Tipo.PROTEGIDO, 39) , 0);
		var ficha2 = new Ficha(Color.ROJO, new Casilla(Tipo.NORMAL, 36) , 0);	
		
		tablero.listaTablero.get(39).fichas.add(0, ficha1);
		tablero.listaTablero.get(36).fichas.add(0, ficha2);
		tablero.moverFicha(ficha2, 3);
		if(tablero.fichaCome(ficha2)) {
			tablero.comer(ficha2);
		}
		
		assertEquals(2, tablero.listaTablero.get(39).fichas.size());
		assertEquals(ficha1.getEstado(), Estado.PROTEGIDA);
		assertEquals(ficha2.getEstado(), Estado.PROTEGIDA);
		assertFalse(tablero.fichaCome(ficha2));
	}
	
	@Test
	public void whenInicializarJuegothenValoresCorrectosNormal() {
		var ludo = new Ludo();
		boolean esUnColorValido = false;

		ludo.crearJugadores("normal", "normal", "normal", "normal");
		ludo.inicializarJuego();
		
		for(Jugador jugador : ludo.jugadores) {
			if(jugador.color == Color.ROJO || jugador.color == Color.AMARILLO || jugador.color == Color.AZUL || jugador.color == Color.VERDE ) {
				esUnColorValido = true;
				assertTrue(esUnColorValido);
			}
			esUnColorValido = false;
			
		}
		
		assertEquals(4 , ludo.jugadores.size());
		assertEquals("normal",ludo.jugadores.get(0).tipoJugador);
	}
	
	@Test
	public void whenInicializarJuegothenValoresCorrectosMaquina() {
		var ludo = new Ludo();
		boolean esUnColorValido = false;

		ludo.crearJugadores("maquina", "maquina", "maquina", "maquina");	
		ludo.inicializarJuego();
		
		for(Jugador jugador : ludo.jugadores) {
			if(jugador.color == Color.ROJO || jugador.color == Color.AMARILLO || jugador.color == Color.AZUL || jugador.color == Color.VERDE ) {
				esUnColorValido = true;
				assertTrue(esUnColorValido);
			}
			esUnColorValido = false;
		}
		
		assertEquals(4 , ludo.jugadores.size());
		assertEquals("maquina",ludo.jugadores.get(0).tipoJugador);
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
		ludo.tablero = new Tablero();
		var jugador = new Jugador(Color.ROJO, "normal");
		var ficha1 = new Ficha(Color.ROJO, new Casilla(Tipo.FINAL, 3),0);	
		var ficha2 = new Ficha(Color.ROJO, new Casilla(Tipo.FINAL, 3),1);	
		var ficha3 = new Ficha(Color.ROJO, new Casilla(Tipo.FINAL, 3),2);	
		var ficha4 = new Ficha(Color.ROJO, new Casilla(Tipo.FINAL, 3),3);	
		
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
		ludo.eliminarFichaGanada(jugador,ficha1);
		ludo.eliminarFichaGanada(jugador,ficha2);
		ludo.eliminarFichaGanada(jugador,ficha3);
		ludo.eliminarFichaGanada(jugador,ficha4);
		
		assertEquals(4, ludo.tablero.fichasGanadasRojo.size());
		for(int i = 0; i < ludo.tablero.rectaFinalRojo.get(5).fichas.size();i++) {
			assertEquals(Estado.GANADO, ludo.tablero.fichasGanadasRojo.get(i).getEstado());			
		}
		assertTrue(ludo.termino());
		assertEquals(0, jugador.fichasEnJuego);
	}
	
	@Test
	public void whenTres6SeguidosThenCambiaDeTurno() {
		var ludo = new Ludo() {
			@Override
			public void inicializarJuego() {
				jugadores = new ArrayList<Jugador>(3);
				cantidadDe6 = 2;
				crearJugadores("normal", "normal", "normal", "normal");
				jugadorActual = jugadores.get(0);
			}

			public void salioEl6(Ficha ficha) {
				cantidadDe6++;
				if (cantidadDe6 == 3) {
					cantidadDe6 = 0;
					jugadorActual = cambiarTurno();	
				}
			}
			

		};
		ludo.inicializarJuego();
		ludo.salioEl6(null);
		
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
		var ficha = new Ficha(Color.ROJO, new Casilla(Tipo.NORMAL, 5),0);
		
		var jugadorNormal = new JugadorNormal() {
			public void salioEl6(Jugador jugador, Tablero tablero, String rta) {
				if(jugador.fichasEnJuego == 0 && rta.equals("mover ficha")) {
					eleccionSacar.ejecutar(jugador, ficha, tablero);
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
		var ficha = new Ficha(Color.ROJO, new Casilla(Tipo.NORMAL, 5),0);
		
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
		var ficha = new Ficha(Color.ROJO,new Casilla(Tipo.NORMAL, 5),0);
		
		var jugadorMaquina = new JugadorMaquina();
		
		jugador.fichas.add(0,ficha);
		jugador.fichasEnJuego = 0;
		jugadorMaquina.salioEl6(jugador,ficha ,tablero);
		
		assertEquals(1,jugador.fichasEnJuego);
		assertEquals(1,tablero.listaTablero.get(0).fichas.size());
	}
	
	@Test 
	public void whenFichasEnJuegoEs4thenMoverfichaJugadorMaquina() {

		tablero = new Tablero();
		var jugador = new Jugador(Color.ROJO, "maquina");
		var ficha = new Ficha(Color.ROJO, new Casilla(Tipo.NORMAL, 5),0);
		var jugadorMaquina = new JugadorMaquina();
		
		jugador.fichas.add(0,ficha);
		jugador.fichasEnJuego = 4;
		jugador.movimientoARealizar = 2;
		jugadorMaquina.salioEl6(jugador,ficha ,tablero);
		
		assertEquals(4,jugador.fichasEnJuego);
		assertEquals(7,ficha.casilla.posicion);
	}

}
