package algo3Ludo;

import java.util.ArrayList;
import java.util.Map;

import algo3Ludo.Ficha.Estado;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class App extends Application {
	
	GridPane rootInicio;
	Group rootJuego;
	Group rootResultados;
	ArrayList<Circle> fichasRojas;
	ArrayList<Circle> fichasVerdes;
    ArrayList<Circle> fichasAmarillas;
    ArrayList<Circle> fichasAzules;
    ArrayList<Circle> fichas;
    Ludo ludo;
    Button botonNormal;
    SceneManager sceneManager;
	int resultadoDado;
	boolean movimientoRealizado;
	
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
        
        botonNormal = new Button();
       Button boton = new Button();
        
		Canvas canvasJuego = new Canvas(691, 691);
		GraphicsContext gc = canvasJuego.getGraphicsContext2D();
		String imagePath = "C:\\Users\\Pc\\eclipse-workspace\\algo3Ludo\\src\\main\\java\\res\\tableroludo.jpg";
		Image image = new Image(imagePath);
		
        Scene sceneInicio = new Scene(rootInicio, 500, 300);
		Scene sceneJuego = new Scene(rootJuego,691,691);
		
		ObservableList<String> tipoJugadores = FXCollections.observableArrayList("normal", "maquina");
        ChoiceBox<String> choiceBox = new ChoiceBox<String>(tipoJugadores);
        ChoiceBox<String> choiceBox1 = new ChoiceBox<String>(tipoJugadores);
        ChoiceBox<String> choiceBox2 = new ChoiceBox<String>(tipoJugadores);
        ChoiceBox<String> choiceBox3 = new ChoiceBox<String>(tipoJugadores);
        
		ImageView imagenBoton =  new ImageView("C:\\Users\\Pc\\eclipse-workspace\\algo3Ludo\\src\\main\\java\\res\\boton_presionado-removebg-preview.png");
		fichasRojas = new ArrayList<Circle>(4);
	    Circle circuloRojo1 = new Circle(115, 530, 15, Color.RED);
	    Circle circuloRojo2 = new Circle(160, 530, 15, Color.RED);
	    Circle circuloRojo3 = new Circle(115, 580, 15, Color.RED);
	    Circle circuloRojo4 = new Circle(160, 580, 15, Color.RED);
	    
		fichasVerdes = new ArrayList<Circle>(4);
	    Circle circuloVerde1 = new Circle(115, 115, 15, Color.GREEN);
	    Circle circuloVerde2= new Circle(160, 115, 15, Color.GREEN);
	    Circle circuloVerde3 = new Circle(115, 160, 15, Color.GREEN);
	    Circle circuloVerde4 = new Circle(160, 160, 15, Color.GREEN);

	    fichasAmarillas = new ArrayList<Circle>(4);
	    Circle circuloAmarillo1 = new Circle(525, 115, 15, Color.YELLOW);
	    Circle circuloAmarillo2 = new Circle(570, 115, 15, Color.YELLOW);
	    Circle circuloAmarillo3 = new Circle(525, 160, 15, Color.YELLOW);
	    Circle circuloAmarillo4 = new Circle(570, 160, 15, Color.YELLOW);

	    fichasAzules = new ArrayList<Circle>(4);
	    Circle circuloAzul1 = new Circle(525, 530, 15, Color.BLUE);
	    Circle circuloAzul2 = new Circle(570, 530, 15, Color.BLUE);
	    Circle circuloAzul3 = new Circle(525, 580, 15, Color.BLUE);
	    Circle circuloAzul4 = new Circle(570, 580, 15, Color.BLUE);
	    
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
        
        //Scene sceneInicio =  sceneManager.crearEscena1(stage,boton,choiceBox,choiceBox1,choiceBox2,choiceBox3);
        
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
	    
		botonNormal.setLayoutX(310.5);
		botonNormal.setLayoutY(325);
		botonNormal.setGraphic(imagenBoton);
		
        imagenBoton.setFitWidth(50);
        imagenBoton.setPreserveRatio(true);
        imagenBoton.setCache(true);
        
		botonNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	resultadoDado = Dado.lanzarDado();
                movimientoRealizado = false;
                
            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Resultado del dado...");
                alert.setHeaderText("El jugador " + ludo.jugadorActual.color + " saco el número");
                alert.setContentText("" + resultadoDado);
                alert.showAndWait();
                
                jugar(stage);
                
            }
        });
		
		canvasJuego.setOnMouseClicked((MouseEvent event) -> {
			System.out.println(event.getX());
			System.out.println(event.getY());
		});
		
		gc.drawImage(image, 0, 0);
		rootJuego.getChildren().addAll(canvasJuego,botonNormal,circuloVerde1,circuloVerde2,circuloVerde3,circuloVerde4,circuloRojo1,circuloRojo2,circuloRojo3,circuloRojo4,circuloAzul1,circuloAzul2,circuloAzul3,circuloAzul4,circuloAmarillo1,circuloAmarillo2,circuloAmarillo3,circuloAmarillo4);
		
	}
	
	//Es el procedimiento encargado de crear un bucle en el cual se permita 
	//inicializar el dado una vez por turno, cambiar de turno y llamar a otros procedimientos
	//que se encargan de los movimientos

	public void jugar(Stage stage) {
		
		botonNormal.setDisable(true);                	
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
     		botonNormal.setDisable(false);
     		ludo.cantidadDe6 = 0;
     		ludo.jugadorActual = ludo.cambiarTurno();	
     	}                	
         
         eliminarFichaComidas();
         eliminarFichasGanadas();
         
         if(ludo.termino()) {
         	sceneManager = new SceneManager();
         	Scene escenaResultados = sceneManager.crearEscena3(stage,ludo);
         	stage.setTitle("Gracias por jugar!");
         	stage.setScene(escenaResultados);
     		stage.show();
         }
	}
	
	public void elegirFicha(algo3Ludo.Ficha.Color color , Jugador jugador){	
		
		if(jugador.tipoJugador.equals("normal")) {
			accionJugadorNormal();
		}
		else {
			accionJugadorMaquina();
		}
	}
	
	public void accionJugadorNormal() {
		
		algo3Ludo.Ficha.Color color = ludo.jugadorActual.color;
		Map<algo3Ludo.Ficha.Color, ArrayList<Circle>> fichas = Map.of(
				algo3Ludo.Ficha.Color.ROJO, fichasRojas,
				algo3Ludo.Ficha.Color.AZUL, fichasAzules,
				algo3Ludo.Ficha.Color.VERDE, fichasVerdes,
				algo3Ludo.Ficha.Color.AMARILLO, fichasAmarillas
				);
		
		for(Circle circulo: fichas.get(color)) {		    	
			
			circulo.setOnMouseClicked((MouseEvent event)-> {
				
				if(!movimientoRealizado && color == ludo.jugadorActual.color) {
					Ficha ficha = ludo.fichaElegida(circulo.getId());
					
					if(ludo.fichaEnCondiciones(ficha)) {
						realizarMovimiento(ficha,circulo);
					}
					else {
						accionJugadorNormal();
					}
				}
				
			});
		}	
	}
	
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
    	if(ludo.fichaEnCondiciones(ficha)) {
			realizarMovimiento(ficha,circulo);
    	} 
	}
	
	public void realizarMovimiento(Ficha ficha, Circle circulo) {
		
			ludo.accionDependiendoTiradaDado(ficha);
			ludo.actualizarCoordenadas(ficha);
			
			movimientoRealizado = true;
			
			circulo.setStroke(Color.BLACK);
			botonNormal.setDisable(false);
			
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

	
	//Si hay alguna ficha con el marcador gano en true la elimina del tablero, resta las fichasEnJUego y suma fichasGanadas.
	public void eliminarFichasGanadas() {	
		for(int i = 0; i < ludo.jugadores.size();i++) {
			for(int j = 0; j < ludo.jugadores.get(i).fichas.size(); j++) {
				if(ludo.jugadores.get(i).fichas.get(j).gano) {
					
					ludo.jugadores.get(i).fichasEnJuego--;
					ludo.jugadores.get(i).fichasGanadas++;
					ludo.jugadores.get(i).fichas.get(j).enJuego = false;
					rootJuego.getChildren().remove(circuloElegido(ludo.jugadores.get(i).fichas.get(j)));
				}
				
				ludo.jugadores.get(i).fichas.get(j).gano = false;	
			}
		}
	}
	
	//Si hay alguna ficha con el marcador fueComida en true resta fichasEnJuego en uno.
	public void eliminarFichaComidas() {
		for(int i = 0; i < ludo.jugadores.size() ;i++) {
			for(int j = 0; j < ludo.jugadores.get(i).fichas.size();j++) {
				if(ludo.jugadores.get(i).fichas.get(j).fueComida  ) {
	
					ludo.jugadores.get(i).fichasEnJuego--;
					ludo.jugadores.get(i).fichas.get(j).enJuego = false;
					circuloElegido(ludo.jugadores.get(i).fichas.get(j))
					.relocate(circuloElegido(ludo.jugadores.get(i).fichas.get(j)).getCenterX()-15,
							circuloElegido(ludo.jugadores.get(i).fichas.get(j)).getCenterY()-15);
			}
			ludo.jugadores.get(i).fichas.get(j).fueComida = false;	
		}
	}
	}
		
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
	
	public static void main(String[] args) {
		launch();
	}
	
	
}
