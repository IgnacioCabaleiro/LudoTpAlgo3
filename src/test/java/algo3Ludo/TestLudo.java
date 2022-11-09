package algo3Ludo;

import algo3Ludo.Dado;
import algo3Ludo.Ficha;
import algo3Ludo.Ficha.*;
import algo3Ludo.Ludo;
import algo3Ludo.Tablero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import algo3Ludo.Casilla;
import algo3Ludo.Casilla.*;
import algo3Ludo.Tablero.*;



public class TestLudo {
	@Test
	public void mueveCorrectamente() {
		System.out.println("---------------------------TEST 1----------------------------------");
		var tablero = new Tablero();
		var eleccionMover = new EleccionMoverFicha();
		var eleccionSacar = new EleccionSacarFicha();
		var jugador1 = new Jugador(Color.ROJO, "normal");
		jugador1.movimientoARealizar = 1;
		
		eleccionSacar.ejecutar(jugador1, tablero);
		eleccionMover.ejecutar(jugador1, tablero);
		
		assertEquals(1, jugador1.fichas.get(0).casilla.posicion);
		assertEquals(1, tablero.listaTablero.get(1).fichas.size());
		assertEquals(Estado.JUGANDO, jugador1.fichas.get(0).estado);
	}
	@Test
	public void testChequeaSiCome() {
		System.out.println("---------------------------TEST 2----------------------------------");

		var tablero = new Tablero();
		var eleccionMover = new EleccionMoverFicha();
		var eleccionSacar = new EleccionSacarFicha();
		var jugador1 = new Jugador(Color.ROJO, "normal");
		var jugador2 = new Jugador(Color.AZUL, "normal");
		jugador2.movimientoARealizar = 14; //me muevo 14 casillas de una asi no tengo que mover de a 6
		jugador1.movimientoARealizar = 1;		
		
		eleccionSacar.ejecutar(jugador1, tablero);
		eleccionMover.ejecutar(jugador1, tablero);//para sacarlo de la casilla protegida
		eleccionSacar.ejecutar(jugador2, tablero);
		eleccionMover.ejecutar(jugador2, tablero);
		
		assertEquals( 1, tablero.listaTablero.get(1).fichas.size());//verifica si comio
		assertEquals(jugador2.fichas.get(0) , tablero.listaTablero.get(1).fichas.get(0));//verifica si la que quedo es la azul
		assertEquals(jugador1.fichas.get(0).estado, Estado.BASE);//verifica que la ficha haya vuelto a base
	}
	
	@Test
	public void testVerificaSiEntraRectaFinal() {
		System.out.println("---------------------------TEST 3----------------------------------");
		var tablero = new Tablero();
		var eleccionMover = new EleccionMoverFicha();
		var eleccionSacar = new EleccionSacarFicha();
		var jugador1 = new Jugador(Color.ROJO, "normal");

		jugador1.movimientoARealizar = 51;		
		eleccionSacar.ejecutar(jugador1, tablero);
		eleccionMover.ejecutar(jugador1, tablero);
		
		assertEquals(0,jugador1.fichas.get(0).casilla.posicion);//quiere decir que entro, porque sino saltaria 51
		assertEquals(Estado.FINAL,jugador1.fichas.get(0).estado );
		for(int i = 0; i < tablero.listaTablero.size(); i++) {
			assertTrue(tablero.listaTablero.get(i).fichas.isEmpty());//verifca que todo el tablero este vacio	
		}
	}
	@Test
	public void whenEstaEnCasillaProtegidaThenNoCome() {
		System.out.println("---------------------------TEST 4----------------------------------");
		var tablero = new Tablero();
		var eleccionMover = new EleccionMoverFicha();
		var eleccionSacar = new EleccionSacarFicha();
		var jugador1 = new Jugador(Color.ROJO, "normal");
		var jugador2 = new Jugador(Color.AZUL, "normal");
		jugador2.movimientoARealizar = 13; //me muevo 13 casillas de una asi no tengo que mover de a 6		
		
		eleccionSacar.ejecutar(jugador1, tablero);
		eleccionSacar.ejecutar(jugador2, tablero);
		eleccionMover.ejecutar(jugador2, tablero);
		
		assertEquals(2, tablero.listaTablero.get(0).fichas.size());//verifica si comio
		assertEquals(jugador1.fichas.get(0).estado, Estado.PROTEGIDA);
		assertEquals(jugador2.fichas.get(0).estado, Estado.PROTEGIDA);
	}
}
