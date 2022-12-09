package algo3Ludo;

import java.util.ArrayList;
import java.util.Map;
import algo3Ludo.Ficha.Estado;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EscenaJuego {
	
	private Group rootJuego;
	public boolean movimientoRealizado;
	private int coordenadaX;
	private int coordenadaY;
	private int resultadoDado;
	private Button botonDado;
	private ArrayList<Circle> fichasRojas;
	private ArrayList<Circle> fichasVerdes;
	private ArrayList<Circle> fichasAmarillas;
	private ArrayList<Circle> fichasAzules;
	public Map<algo3Ludo.Ficha.Color, ArrayList<Circle>> fichas; 
	
	public Scene crearEscena(Stage stage, Ludo ludo,EscenaJuego escenaJuego) {
		rootJuego = new Group();
        botonDado = new Button();
        
		Canvas canvasJuego = new Canvas(691, 691);
		GraphicsContext gc = canvasJuego.getGraphicsContext2D();
		
		String imagePath = "/res/tableroludo.jpg";
		Image image = new Image(getClass().getResourceAsStream(imagePath));
		
        String imagePath2 = "/res/dado.jpg";
		Image image2 = new Image(getClass().getResourceAsStream(imagePath2));
		ImageView imagenBoton =  new ImageView(image2);
		

	    Circle circuloRojo1 = new Circle(115, 530, 15, Color.RED);
	    Circle circuloRojo2 = new Circle(160, 530, 15, Color.RED);
	    Circle circuloRojo3 = new Circle(115, 580, 15, Color.RED);
	    Circle circuloRojo4 = new Circle(160, 580, 15, Color.RED);   
		
	    Circle circuloVerde1 = new Circle(115, 115, 15, Color.GREEN);
	    Circle circuloVerde2 = new Circle(160, 115, 15, Color.GREEN);
	    Circle circuloVerde3 = new Circle(115, 160, 15, Color.GREEN);
	    Circle circuloVerde4 = new Circle(160, 160, 15, Color.GREEN);
	   
	    Circle circuloAmarillo1 = new Circle(525, 115, 15, Color.YELLOW);
	    Circle circuloAmarillo2 = new Circle(570, 115, 15, Color.YELLOW);
	    Circle circuloAmarillo3 = new Circle(525, 160, 15, Color.YELLOW);
	    Circle circuloAmarillo4 = new Circle(570, 160, 15, Color.YELLOW);

	    Circle circuloAzul1 = new Circle(525, 530, 15, Color.BLUE);
	    Circle circuloAzul2 = new Circle(570, 530, 15, Color.BLUE);
	    Circle circuloAzul3 = new Circle(525, 580, 15, Color.BLUE);
	    Circle circuloAzul4 = new Circle(570, 580, 15, Color.BLUE);
	    
		fichasRojas = new ArrayList<Circle>();  
		fichasVerdes = new ArrayList<Circle>();
		fichasAmarillas = new ArrayList<Circle>();
	    fichasAzules = new ArrayList<Circle>();
	    fichas = Map.of(
	 			algo3Ludo.Ficha.Color.ROJO, fichasRojas,
				algo3Ludo.Ficha.Color.AZUL, fichasAzules,
				algo3Ludo.Ficha.Color.VERDE, fichasVerdes,
				algo3Ludo.Ficha.Color.AMARILLO, fichasAmarillas
		);
	    
        fichasRojas.add(circuloRojo1);
	    fichasRojas.add(circuloRojo2);
	    fichasRojas.add(circuloRojo3);
	    fichasRojas.add(circuloRojo4);
	    
	    fichasVerdes.add(circuloVerde1);
	    fichasVerdes.add(circuloVerde2);
	    fichasVerdes.add(circuloVerde3);
	    fichasVerdes.add(circuloVerde4);
	    
	    fichasAzules.add(circuloAzul1);
	    fichasAzules.add(circuloAzul2);
	    fichasAzules.add(circuloAzul3);
	    fichasAzules.add(circuloAzul4);
	    
	    fichasAmarillas.add(circuloAmarillo1);
	    fichasAmarillas.add(circuloAmarillo2);
	    fichasAmarillas.add(circuloAmarillo3);
	    fichasAmarillas.add(circuloAmarillo4);
	    
		circuloAzul1.setId("fichaAzul1");
		circuloAzul2.setId("fichaAzul2");
		circuloAzul3.setId("fichaAzul3");
		circuloAzul4.setId("fichaAzul4");
		circuloRojo1.setId("fichaRojo1");
		circuloRojo2.setId("fichaRojo2");
		circuloRojo3.setId("fichaRojo3");
		circuloRojo4.setId("fichaRojo4");
		circuloVerde1.setId("fichaVerde1");
		circuloVerde2.setId("fichaVerde2");
		circuloVerde3.setId("fichaVerde3");
		circuloVerde4.setId("fichaVerde4");
		circuloAmarillo1.setId("fichaAmarillo1");
		circuloAmarillo2.setId("fichaAmarillo2");
		circuloAmarillo3.setId("fichaAmarillo3");
		circuloAmarillo4.setId("fichaAmarillo4");
	    
		botonDado.setLayoutX(318);
		botonDado.setLayoutY(325);
		botonDado.setGraphic(imagenBoton);
		
        imagenBoton.setFitWidth(40);
        imagenBoton.setPreserveRatio(true);
        imagenBoton.setCache(true);
        
        Text texto = new Text();
        texto.setX(25);
        texto.setY(25);
        texto.setStyle("-fx-font: 16 calibri;");
        texto.setFill(Color.WHITE);
        texto.setStroke(Color.WHITE);
        texto.setStrokeWidth(1);        
        rootJuego.getChildren().add(texto);
        
		botonDado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            	resultadoDado = Dado.lanzarDado();
            	movimientoRealizado = false;
            	
                rootJuego.getChildren().remove(texto);
                texto.setText("El turno es del jugador "+ ludo.jugadorActual.color);
                rootJuego.getChildren().add(texto);
                
                efectoFadeCirculos(ludo);
                botonDado.setGraphic(cambiarImagenDado(resultadoDado));
                jugar(stage,ludo,escenaJuego);
                
            }
        });
		
		gc.drawImage(image, 0, 0);
		
		rootJuego.getChildren().addAll(canvasJuego,botonDado,circuloVerde1,circuloVerde2,circuloVerde3,circuloVerde4,circuloRojo1,circuloRojo2,circuloRojo3,circuloRojo4,circuloAzul1,circuloAzul2,circuloAzul3,circuloAzul4,circuloAmarillo1,circuloAmarillo2,circuloAmarillo3,circuloAmarillo4);		
		
		Scene sceneJuego = new Scene(rootJuego,691,691);
		
		return sceneJuego;
	}
	
	//Procedimiento encargado de inicializar cada turno verificando que no haya terminado la partida
	private void jugar(Stage stage, Ludo ludo, EscenaJuego escenaJuego) {
		
		botonDado.setDisable(true);                	
		
        ludo.iniciarTurno(resultadoDado);
     	if((resultadoDado == 6 || ludo.jugadorActual.fichasEnJuego > 0) && ludo.cantidadDe6 < 3) {  	
     		elegirFicha(ludo.jugadorActual, ludo, escenaJuego);     			
     	}
     	else {
     		botonDado.setDisable(false);
     		ludo.cantidadDe6 = 0;
     		if(!ludo.jugadorActual.comio) {
     			ludo.jugadorActual = ludo.cambiarTurno();	     			
     		}
     	}                	

         eliminarFichas(ludo);
         
         if(ludo.termino()) {
        	 
        	 EscenaResultados escenaResultados = new EscenaResultados();
        	 stage.setTitle("Partida finalizada");
        	 stage.setScene(escenaResultados.crearEscena(ludo,stage));
        	 stage.show();
         }
	}

	//Procedimiento que se encarga de elegir la ficha a mover dependiendo del tipo de jugador
	private void elegirFicha(Jugador jugador, Ludo ludo, EscenaJuego escenaJuego){	
		
		jugador.elegirFicha(ludo, escenaJuego);		
	
	}
	
	//Procedimiento que se encarga de mover la ficha en el tablero y por pantalla
	public void realizarMovimiento(Ficha ficha, Circle circulo, Ludo ludo) {
		
			ludo.accionDependiendoTiradaDado(ficha);
			movimientoRealizado = true;
			
			circulo.setStroke(Color.BLACK);
			botonDado.setDisable(false);
			
			setCoordenadas(ficha);				
			if(ludo.tablero.listaTablero.get(ficha.casilla.posicion).fichas.size() > 2) {
				circulo.relocate(coordenadaX + 5,coordenadaY + 5);		    			
			}
			else if(ludo.tablero.listaTablero.get(ficha.casilla.posicion).fichas.size() > 1) {
				circulo.relocate(coordenadaX - 5,coordenadaY - 5);
			}
			else{
				circulo.relocate(coordenadaX, coordenadaY);		    			
			}
	}

	
	//Si hay alguna ficha con el marcador gano o fueComida en true la elimina del tablero y todas las acciones pertinentes.
	private void eliminarFichas(Ludo ludo) {	
		
		ArrayList<Jugador> jugadores = ludo.jugadores;
		
		for(int i = 0; i < jugadores.size();i++) {
			for(int j = 0; j < jugadores.get(i).fichas.size(); j++) {
				if(jugadores.get(i).fichas.get(j).gano) {
					
					ludo.eliminarFichaGanada(jugadores.get(i), jugadores.get(i).fichas.get(j));
					rootJuego.getChildren().remove(circuloElegido(jugadores.get(i).fichas.get(j)));
				
				}
				else if(jugadores.get(i).fichas.get(j).fueComida){
					ludo.eliminarFichaComida(jugadores.get(i) , jugadores.get(i).fichas.get(j));
					circuloElegido(jugadores.get(i).fichas.get(j))
					.relocate(
							circuloElegido(jugadores.get(i).fichas.get(j)).getCenterX()-15,
							circuloElegido(jugadores.get(i).fichas.get(j)).getCenterY()-15
					);
				}
				jugadores.get(i).fichas.get(j).fueComida = false;
				jugadores.get(i).fichas.get(j).gano = false;	
			}
		}
	}
	
	//Procedimiento que retorna el circulo que simboliza cada ficha dependiendo de la ficha que le pasen.
	public Circle circuloElegido(Ficha ficha) {
		
		if(ficha.color == algo3Ludo.Ficha.Color.AMARILLO) {
			return fichasAmarillas.get(ficha.posicionListaFichas);				
		}
		else if(ficha.color == algo3Ludo.Ficha.Color.ROJO) {
			return fichasRojas.get(ficha.posicionListaFichas);				
		}
		else if(ficha.color == algo3Ludo.Ficha.Color.AZUL) {
			return fichasAzules.get(ficha.posicionListaFichas);				
		}
		else if(ficha.color == algo3Ludo.Ficha.Color.VERDE) {
			return fichasVerdes.get(ficha.posicionListaFichas);				
		}
		return null;
	}
	
	//Procedimiento que retorna la imagen de una tirada del dado dependiendo que número salga.
	private ImageView cambiarImagenDado(int dado) {
        String imagePath = null;
		if(dado == 1) {
			imagePath = "/res/dado1.jpg";	
		}
		else if(dado == 2) {
			imagePath = "/res/dado2.jpg";
		}
		else if(dado == 3) {
			imagePath = "/res/dado3.jpg";
		}
		else if(dado == 4) {
			imagePath = "/res/dado4.jpg";
		}
		else if(dado == 5) {
			imagePath = "/res/dado5.jpg";
		}
		else if(dado == 6) {
			imagePath = "/res/dado6.jpg";
		}
		
		Image imagenDado = new Image(getClass().getResourceAsStream(imagePath));
		ImageView imagenView =  new ImageView(imagenDado);
		
        imagenView.setFitWidth(36);
        imagenView.setPreserveRatio(true);
        imagenView.setCache(true);
        
		return imagenView;
	}
	
	//Se encarga de producir un efecto "fade" en los circulos cuando es su turno.
	public void efectoFadeCirculos(Ludo ludo) {
	    FadeTransition fade;
		algo3Ludo.Ficha.Color color = ludo.jugadorActual.color;
		
		for(Circle circulo: fichas.get(color)) {		    	
			
			fade = new FadeTransition();
			fade.setNode(circulo);
			fade.setCycleCount(1);
			fade.setDuration(Duration.millis(1000));
			fade.setInterpolator(Interpolator.LINEAR);
			fade.setFromValue(0);
			fade.setToValue(1);
			fade.play();
		}
	}
	private void setCoordenadas(Ficha ficha) {
		if(ficha.getEstado() == Estado.FINAL || ficha.getEstado() == Estado.GANADO) {
			setCoordenadasRectasFinales(ficha.color, ficha.casilla.posicion);
		}
		else {
			setCoordenadasTablero(ficha.casilla.posicion);
		}
	}
	//Procedimiento que se encarga de establecer las coordenadas de las casillas del tablero. 
		public void setCoordenadasTablero(int posicion) {

			if(posicion == 51) {
				coordenadaX = 285;
				coordenadaY = 650;	
			}
			else if(posicion == 0 ||posicion == 1 ||posicion == 2 ||posicion == 3 ||posicion == 4 ) {
				coordenadaX = 285;
				coordenadaY = 605 - 45*posicion;			
			}
			else if(posicion == 44 ||posicion == 45 ||posicion == 46 ||posicion == 47 ||posicion == 48||posicion == 49 ) {
				coordenadaX = 375;
				coordenadaY = 425 + 45*(posicion-44);			
			}
			else if(posicion == 43 ||posicion == 42 ||posicion == 41 ||posicion == 40 ||posicion == 39||posicion == 38 ) {
				coordenadaX = 650 - 45*(posicion-38);
				coordenadaY = 375;	
			}
			else if(posicion == 31 ||posicion == 32 ||posicion == 33 ||posicion == 34 ||posicion == 35||posicion == 36 ) {
				coordenadaX = 425 + 45*(posicion-31);
				coordenadaY = 285;
			} 
			else if(posicion == 5 || posicion == 6 ) {
				coordenadaX = 240 - 45*(posicion-5);
				coordenadaY = 375;	
			}
			else if(posicion == 7||posicion == 8||posicion == 9||posicion == 10) {
				coordenadaX = 145 - 45*(posicion - 7);
				coordenadaY = 375;	
			}
			else if(posicion == 17 || posicion == 16 ) {
				coordenadaX = 195 + 45*(posicion-16);
				coordenadaY = 285;	
			}
			else if(posicion == 15||posicion == 14 || posicion == 13||posicion == 12) {
				coordenadaX = 10 + 45*(posicion-12);
				coordenadaY = 285;	
			}
			else if(posicion == 18 || posicion == 19 ) {
				coordenadaX = 285;
				coordenadaY = 240 - 45*(posicion-18);
			}
			else if(posicion == 20||posicion == 21 || posicion == 22||posicion == 23) {
				coordenadaX = 285;
				coordenadaY = 145 - 45*(posicion-20);	
			}
			else if(posicion == 30 || posicion == 29 ) {
				coordenadaX = 375;
				coordenadaY = 195 + 45*(posicion-29);
			}
			else if(posicion == 28||posicion == 27 || posicion == 26||posicion == 25) {
				coordenadaX = 375;
				coordenadaY = 10 + 45*(posicion-25);	
			}
			else if(posicion == 50) {
				coordenadaX = 330;
				coordenadaY = 650;
			}
			else if(posicion == 37) {
				coordenadaX = 650;
				coordenadaY = 330;	
			}
			else if(posicion == 24) {
				coordenadaX = 330;
				coordenadaY = 10;	
			}
			else if(posicion == 11) {
				coordenadaX = 10;
				coordenadaY = 330;	
			}		
		}
		
		//Procedimiento que se encarga de establecer las coordenadas de las casillas de las rectas finales. 
		public void setCoordenadasRectasFinales(algo3Ludo.Ficha.Color color, int posicion) {	
			if(color == algo3Ludo.Ficha.Color.ROJO) {
				coordenadaX = 330;
				if(posicion == 0) {
					coordenadaY = 605;	
				}
				if(posicion == 1) {
					coordenadaY = 560;		
				}
				if(posicion == 2) {
					coordenadaY = 515;		
				}
				if(posicion == 3) {
					coordenadaY = 470;		
				}
				if(posicion == 4) {
					coordenadaY = 425;		
				}
				if(posicion == 5) {
					coordenadaY = 375;		
				}
			}
			else if(color == algo3Ludo.Ficha.Color.AMARILLO) {
				coordenadaX = 330;
				if(posicion == 0) {
					coordenadaY = 55;	
				}
				if(posicion == 1) {
					coordenadaY = 100;		
				}
				if(posicion == 2) {
					coordenadaY = 145;		
				}
				if(posicion == 3) {
					coordenadaY = 195;		
				}
				if(posicion == 4) {
					coordenadaY = 240;		
				}
				if(posicion == 5) {
					coordenadaY = 285;		
				}
			}
			else if(color == algo3Ludo.Ficha.Color.AZUL) {
				coordenadaY = 330;
				if(posicion == 0) {
					coordenadaX = 605;	
				}
				if(posicion == 1) {
					coordenadaX = 560;	
				}
				if(posicion == 2) {
					coordenadaX = 515;	
				}
				if(posicion == 3) {
					coordenadaX = 470;	
				}
				if(posicion == 4) {
					coordenadaX = 425;	
				}
				if(posicion == 5) {
					coordenadaX = 375;	
				}
			}
			else if(color == algo3Ludo.Ficha.Color.VERDE) {
				coordenadaY = 330;
				if(posicion == 0) {
					coordenadaX = 55;	
				}
				if(posicion == 1) {
					coordenadaX = 100;		
				}
				if(posicion == 2) {
					coordenadaX = 145;	
				}
				if(posicion == 3) {
					coordenadaX = 195;	
				}
				if(posicion == 4) {
					coordenadaX = 240;	
				}
				if(posicion == 5) {
					coordenadaX = 285;	
				}
			}
		}
		//Procedimiento que retorna la Ficha a mover dependiendo del id que se le pase.
		public Ficha fichaElegida(String ficha,ArrayList<Jugador> jugadores) {
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
}
