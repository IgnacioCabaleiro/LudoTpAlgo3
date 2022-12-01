package algo3Ludo;

import java.util.ArrayList;
import java.util.Map;
import algo3Ludo.Ficha.Estado;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
	
	GridPane rootInicio;
	Group rootJuego;
	Group rootResultados;
    Ludo ludo;
    Button botonDado;
    SceneManager sceneManager;
    ArrayList<Circle> fichasRojas;
    ArrayList<Circle> fichasVerdes;
    ArrayList<Circle> fichasAmarillas;
    ArrayList<Circle> fichasAzules;
    FadeTransition fade;
	int resultadoDado;
	boolean movimientoRealizado;
	Map<algo3Ludo.Ficha.Color, ArrayList<Circle>> fichas; 
	
	@Override
	public void start(Stage stage) throws Exception {

		ludo = new Ludo();
		rootInicio = new GridPane();
		rootJuego = new Group();
		
        Label etiquetaRojo = new Label("Elegir tipo de jugador Rojo");
        Label etiquetaAzul = new Label("Elegir tipo de jugador Azul");
        Label etiquetaVerde = new Label("Elegir tipo de jugador Verde");
        Label etiquetaAmarillo = new Label("Elegir tipo de jugador Amarillo");
        Label respuestaRojo = new Label("");
        Label respuestaAzul = new Label("");
        Label respuestaVerde = new Label("");
        Label respuestaAmarillo = new Label("");
        
        botonDado = new Button();
        Button boton = new Button();
        
		Canvas canvasJuego = new Canvas(691, 691);
		GraphicsContext gc = canvasJuego.getGraphicsContext2D();
		String imagePath = "/res/tableroludo.jpg";
		Image image = new Image(getClass().getResourceAsStream(imagePath));
		
        Scene sceneInicio = new Scene(rootInicio, 500, 300);
		Scene sceneJuego = new Scene(rootJuego,691,691);
		
		ObservableList<String> tipoJugadores = FXCollections.observableArrayList("normal", "maquina");
        ChoiceBox<String> choiceBox = new ChoiceBox<String>(tipoJugadores);
        ChoiceBox<String> choiceBox1 = new ChoiceBox<String>(tipoJugadores);
        ChoiceBox<String> choiceBox2 = new ChoiceBox<String>(tipoJugadores);
        ChoiceBox<String> choiceBox3 = new ChoiceBox<String>(tipoJugadores);
        
        String imagePath2 = "/res/dado.jpg";
		Image image2 = new Image(getClass().getResourceAsStream(imagePath2));
		ImageView imagenBoton =  new ImageView(image2);
		
		fichasRojas = new ArrayList<Circle>();
	    Circle circuloRojo1 = new Circle(115, 530, 15, Color.RED);
	    Circle circuloRojo2 = new Circle(160, 530, 15, Color.RED);
	    Circle circuloRojo3 = new Circle(115, 580, 15, Color.RED);
	    Circle circuloRojo4 = new Circle(160, 580, 15, Color.RED);
	    
		fichasVerdes = new ArrayList<Circle>();
	    Circle circuloVerde1 = new Circle(115, 115, 15, Color.GREEN);
	    Circle circuloVerde2= new Circle(160, 115, 15, Color.GREEN);
	    Circle circuloVerde3 = new Circle(115, 160, 15, Color.GREEN);
	    Circle circuloVerde4 = new Circle(160, 160, 15, Color.GREEN);

	    fichasAmarillas = new ArrayList<Circle>();
	    Circle circuloAmarillo1 = new Circle(525, 115, 15, Color.YELLOW);
	    Circle circuloAmarillo2 = new Circle(570, 115, 15, Color.YELLOW);
	    Circle circuloAmarillo3 = new Circle(525, 160, 15, Color.YELLOW);
	    Circle circuloAmarillo4 = new Circle(570, 160, 15, Color.YELLOW);

	    fichasAzules = new ArrayList<Circle>();
	    Circle circuloAzul1 = new Circle(525, 530, 15, Color.BLUE);
	    Circle circuloAzul2 = new Circle(570, 530, 15, Color.BLUE);
	    Circle circuloAzul3 = new Circle(525, 580, 15, Color.BLUE);
	    Circle circuloAzul4 = new Circle(570, 580, 15, Color.BLUE);
	    
	    fichas = Map.of(
	 			algo3Ludo.Ficha.Color.ROJO, fichasRojas,
				algo3Ludo.Ficha.Color.AZUL, fichasAzules,
				algo3Ludo.Ficha.Color.VERDE, fichasVerdes,
				algo3Ludo.Ficha.Color.AMARILLO, fichasAmarillas
		);
	    //////////////////////////////////////////////////////////// ESCENA 1 //////////////////////////////////////////////////////////////
        
	    boton.setDisable(true);
        choiceBox1.setDisable(true);
        choiceBox2.setDisable(true);
        choiceBox3.setDisable(true);
        
        ChangeListener<String> changeListener = new ChangeListener<String>() {
        	@Override
            public void changed(ObservableValue<? extends String> observable, //
                    String oldValue, String newValue) {
                if (newValue != null) {
                    respuestaRojo.setText(newValue);
                    choiceBox.setDisable(true);
                    choiceBox1.setDisable(false);
                }
            }
        };
        ChangeListener<String> changeListener1 = new ChangeListener<String>() {
        	@Override
            public void changed(ObservableValue<? extends String> observable, //
                    String oldValue, String newValue) {
                if (newValue != null) {
                    respuestaAzul.setText(newValue);
                    choiceBox1.setDisable(true);
                    choiceBox2.setDisable(false);
                }
            }
        };
        ChangeListener<String> changeListener2 = new ChangeListener<String>() {
        	@Override
            public void changed(ObservableValue<? extends String> observable, //
                    String oldValue, String newValue) {
                if (newValue != null) {
                    respuestaVerde.setText(newValue);
                    choiceBox2.setDisable(true);
                    choiceBox3.setDisable(false);
                }
            }
        };
        ChangeListener<String> changeListener3 = new ChangeListener<String>() {
        	@Override
            public void changed(ObservableValue<? extends String> observable, //
                    String oldValue, String newValue) {
                if (newValue != null) {
                    respuestaAmarillo.setText(newValue);
                    choiceBox3.setDisable(true);
                    boton.setDisable(false);
                }
            }
        };

        choiceBox.getSelectionModel().selectedItemProperty().addListener(changeListener);
        choiceBox1.getSelectionModel().selectedItemProperty().addListener(changeListener1);
        choiceBox2.getSelectionModel().selectedItemProperty().addListener(changeListener2);
        choiceBox3.getSelectionModel().selectedItemProperty().addListener(changeListener3);
        
        rootInicio.setVgap(30); 
        rootInicio.setHgap(30);
        
        rootInicio.add(etiquetaRojo, 0, 0);
        rootInicio.add(etiquetaAzul, 0, 1);
        rootInicio.add(etiquetaVerde, 0, 2);
        rootInicio.add(etiquetaAmarillo, 0, 3);
        
        rootInicio.add(choiceBox, 1, 0);
        rootInicio.add(choiceBox1, 1, 1);
        rootInicio.add(choiceBox2, 1, 2);
        rootInicio.add(choiceBox3, 1, 3);
        
        rootInicio.add(respuestaRojo, 2, 0);
        rootInicio.add(respuestaAzul, 2, 1);
        rootInicio.add(respuestaVerde, 2, 2);
        rootInicio.add(respuestaAmarillo, 2, 3);

        rootInicio.add(boton, 1, 4 );
        
        //Scene sceneInicio =  sceneManager.crearEscena1(stage);
        
        stage.setTitle("Elegir Jugadores");
        stage.setScene(sceneInicio);
        stage.show();
        
        boton.setText("OK");
        	
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
                ludo.inicializarJuego();
                ludo.crearJugadores(choiceBox.getValue(),choiceBox1.getValue(),choiceBox2.getValue(),choiceBox3.getValue());
                ludo.jugadorActual = ludo.elegirQuienEmpieza();
                stage.setTitle("Juego");
                stage.setScene(sceneJuego);
        		stage.show();
        		
            }
        });
        
////////////////////////////////////////////////////////////// ESCENA 2 //////////////////////////////////////////////////////////////

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
	    
		botonDado.setLayoutX(318 );
		botonDado.setLayoutY(325);
		botonDado.setGraphic(imagenBoton);
		
        imagenBoton.setFitWidth(40);
        imagenBoton.setPreserveRatio(true);
        imagenBoton.setCache(true);
        
		botonDado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	resultadoDado = Dado.lanzarDado();
                movimientoRealizado = false;
                
            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Resultado del dado...");
                alert.setHeaderText("El jugador " + ludo.jugadorActual.color + " saco el número");
                alert.setContentText("" + resultadoDado);
                alert.showAndWait();
                efectoFadeCirculos();
                botonDado.setGraphic(cambiarImagenDado(resultadoDado));
                jugar(stage);
                
            }
        });
		
		gc.drawImage(image, 0, 0);
		rootJuego.getChildren().addAll(canvasJuego,botonDado,circuloVerde1,circuloVerde2,circuloVerde3,circuloVerde4,circuloRojo1,circuloRojo2,circuloRojo3,circuloRojo4,circuloAzul1,circuloAzul2,circuloAzul3,circuloAzul4,circuloAmarillo1,circuloAmarillo2,circuloAmarillo3,circuloAmarillo4);
		
	}
	
	//Procedimiento encargado de inicializar cada turno verificando que no haya terminado la partida

	public void jugar(Stage stage) {
		
		botonDado.setDisable(true);                	
		ludo.dado = resultadoDado;
		ludo.jugadorActual.comio = false;
		ludo.jugadorActual.movimientoARealizar = resultadoDado;
		
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("El turno es del " + ludo.jugadorActual.color);
		System.out.println("El resultado del dado es: " + resultadoDado);
         
     	if((resultadoDado == 6 || ludo.jugadorActual.fichasEnJuego > 0)) {  	
     		elegirFicha(ludo.jugadorActual.color, ludo.jugadorActual);
     	}
     	else {
     		botonDado.setDisable(false);
     		ludo.cantidadDe6 = 0;
     		ludo.jugadorActual = ludo.cambiarTurno();	
     	}                	

         eliminarFichas();
         
         if(ludo.termino()) {
         	sceneManager = new SceneManager();
         	Scene escenaResultados = sceneManager.crearEscena3(stage,ludo);
         	
         	stage.setScene(escenaResultados);
     		stage.show();
         }
	}
	
	//Procedimiento que se encarga de elegir la ficha a mover dependiendo del tipo de jugador
	public void elegirFicha(algo3Ludo.Ficha.Color color , Jugador jugador){	
		
		if(jugador.tipoJugador.equals("normal")) {
			accionJugadorNormal();
		}
		else {
			accionJugadorMaquina();
		}
	}
	
	//Procedimiento que se encarga de realizar el movimiento correspondiente si el jugador no es la máquina
	public void accionJugadorNormal() {
		
		algo3Ludo.Ficha.Color color = ludo.jugadorActual.color;
	
		for(Circle circulo: fichas.get(color)) {		    	
			
			circulo.setOnMouseClicked((MouseEvent event)-> {
				
				if(!movimientoRealizado && color == ludo.jugadorActual.color) {
					Ficha ficha = ludo.fichaElegida(circulo.getId());
					
					if(ludo.jugadaEnCondiciones(ficha)) {
						realizarMovimiento(ficha,circulo);
					}
					else {
						accionJugadorNormal();
					}
				}				
			});
		}	
	}
	
	//Procedimiento que se encarga de realizar el movimiento correspondiente si el jugador es la máquina
	public void accionJugadorMaquina() {
		Ficha ficha;
    	if(resultadoDado == 6 && (ludo.jugadorActual.fichasEnJuego + ludo.jugadorActual.fichasGanadas) < 4) {
    		ficha = ludo.jugadorActual.fichas.get(ludo.jugadorActual.primeroEnBase());
    	}
    	else{
    		ArrayList<Ficha> fichasASortear = new ArrayList<Ficha>();
    		for(Ficha fichaASortear : ludo.jugadorActual.fichas) {
    			if(fichaASortear.estado == Estado.FINAL &&(resultadoDado + fichaASortear.casilla.posicion > 6)) {
    				
    			}
    			else if(fichaASortear.enJuego){
    				fichasASortear.add(fichaASortear);
    			}
    		}
    		int posicionSorteada = (int)(Math.random()*fichasASortear.size());
    		ficha = fichasASortear.get(posicionSorteada);	
    	}
    	
    	Circle circulo = circuloElegido(ficha);
    	if(ludo.jugadaEnCondiciones(ficha)) {
			realizarMovimiento(ficha,circulo);
    	} 
	}
	
	//Procedimiento que se encarga de mover la ficha en el tablero y por pantalla
	public void realizarMovimiento(Ficha ficha, Circle circulo) {
		
			ludo.accionDependiendoTiradaDado(ficha);
			ficha.actualizarCoordenadas();
			
			movimientoRealizado = true;
			
			circulo.setStroke(Color.BLACK);
			botonDado.setDisable(false);
			
			if(ludo.tablero.listaTablero.get(ficha.casilla.posicion).fichas.size() > 2) {
				circulo.relocate(ficha.casilla.coordenadaX + 5, ficha.casilla.coordenadaY + 5);		    			
			}
			else if(ludo.tablero.listaTablero.get(ficha.casilla.posicion).fichas.size() > 1) {
				circulo.relocate(ficha.casilla.coordenadaX - 5, ficha.casilla.coordenadaY - 5);
			}
			else{
				circulo.relocate(ficha.casilla.coordenadaX, ficha.casilla.coordenadaY);		    			
			}
	}

	
	//Si hay alguna ficha con el marcador gano o fueComida en true la elimina del tablero y todas las acciones pertinentes.
	public void eliminarFichas() {	
		
		ArrayList<Jugador> jugadores = ludo.jugadores;
		
		for(int i = 0; i < jugadores.size();i++) {
			for(int j = 0; j < jugadores.get(i).fichas.size(); j++) {
				if(jugadores.get(i).fichas.get(j).gano) {
					
					ludo.eliminarFichaComida(jugadores.get(i) , jugadores.get(i).fichas.get(j));
					rootJuego.getChildren().remove(circuloElegido(jugadores.get(i).fichas.get(j)));
				
				}
				else if(jugadores.get(i).fichas.get(j).fueComida){
					
					ludo.eliminarFichaGanada(jugadores.get(i), jugadores.get(i).fichas.get(j));
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
	public ImageView cambiarImagenDado(int dado) {
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
	public void efectoFadeCirculos() {
		
		algo3Ludo.Ficha.Color color = ludo.jugadorActual.color;
		
		for(Circle circulo: fichas.get(color)) {		    	
			
			fade = new FadeTransition();
			fade.setNode(circulo);
			fade.setDuration(Duration.millis(1000));
			fade.setInterpolator(Interpolator.LINEAR);
			fade.setFromValue(0);
			fade.setToValue(1);
			fade.play();
		}
	}
	
	public static void main(String[] args) {
		launch();
	}
	
	
}
