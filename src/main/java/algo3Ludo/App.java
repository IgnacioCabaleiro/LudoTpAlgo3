package algo3Ludo;

import java.util.ArrayList;

import algo3Ludo.Casilla.Tipo;
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
	
	ArrayList<Circle> fichasRojas;
	ArrayList<Circle> fichasVerdes;
    ArrayList<Circle> fichasAmarillas;
    ArrayList<Circle> fichasAzules;
    ArrayList<Circle> fichas;
	int resultadoDado;
	boolean movimientoRealizado;
	Ludo ludo;
	Button botonNormal;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		ludo = new Ludo();
		//Escena2
		GridPane root = new GridPane();
        Button boton = new Button();
        Label label = new Label("Elegir tipo de jugador Rojo");
        Label label1 = new Label("Elegir tipo de jugador Azul");
        Label label2 = new Label("Elegir tipo de jugador Verde");
        Label label3 = new Label("Elegir tipo de jugador Amarillo");
        Label greetingLabel = new Label("");
        Label greetingLabel1 = new Label("");
        Label greetingLabel2 = new Label("");
        Label greetingLabel3 = new Label("");
        ObservableList<String> tipoJugadores = FXCollections.observableArrayList("normal", "maquina");

        ChoiceBox<String> choiceBox = new ChoiceBox<String>(tipoJugadores);
        ChoiceBox<String> choiceBox1 = new ChoiceBox<String>(tipoJugadores);
        ChoiceBox<String> choiceBox2 = new ChoiceBox<String>(tipoJugadores);
        ChoiceBox<String> choiceBox3 = new ChoiceBox<String>(tipoJugadores);
       
        boton.setDisable(true);
        choiceBox1.setDisable(true);
        choiceBox2.setDisable(true);
        choiceBox3.setDisable(true);
        
        ChangeListener<String> changeListener = new ChangeListener<String>() {
        	@Override
            public void changed(ObservableValue<? extends String> observable, //
                    String oldValue, String newValue) {
                if (newValue != null) {
                    greetingLabel.setText(newValue);
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
                    greetingLabel1.setText(newValue);
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
                    greetingLabel2.setText(newValue);
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
                    greetingLabel3.setText(newValue);
                    choiceBox3.setDisable(true);
                    boton.setDisable(false);
                }
            }
        };

        choiceBox.getSelectionModel().selectedItemProperty().addListener(changeListener);
        choiceBox1.getSelectionModel().selectedItemProperty().addListener(changeListener1);
        choiceBox2.getSelectionModel().selectedItemProperty().addListener(changeListener2);
        choiceBox3.getSelectionModel().selectedItemProperty().addListener(changeListener3);
        
        root.setVgap(30); 
        root.setHgap(30);
        
        root.add(label, 0, 0);
        root.add(label1, 0, 1);
        root.add(label2, 0, 2);
        root.add(label3, 0, 3);
        
        root.add(choiceBox, 1, 0);
        root.add(choiceBox1, 1, 1);
        root.add(choiceBox2, 1, 2);
        root.add(choiceBox3, 1, 3);
        
        root.add(greetingLabel, 2, 0);
        root.add(greetingLabel1, 2, 1);
        root.add(greetingLabel2, 2, 2);
        root.add(greetingLabel3, 2, 3);

        root.add(boton, 1, 4 );
        
        stage.setTitle("Elegir Jugadores");
        Scene scene = new Scene(root, 500, 300);
        stage.setScene(scene);
        stage.show();
        
    //Escena2
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Group root2 = new Group();
		botonNormal = new Button();
		
		ImageView imagenBoton =  new ImageView("C:\\Users\\Pc\\eclipse-workspace\\algo3Ludo\\resources\\boton_presionado-removebg-preview.png");
		botonNormal.setLayoutX(310.5);
		botonNormal.setLayoutY(325);
		botonNormal.setGraphic(imagenBoton);
		fichas = new ArrayList<Circle>();
		fichasRojas = new ArrayList<Circle>(4);
		
	    Circle circuloRojo1 = new Circle(115, 530, 15, Color.RED);
	    Circle circuloRojo2 = new Circle(160, 530, 15, Color.RED);
	    Circle circuloRojo3 = new Circle(115, 580, 15, Color.RED);
	    Circle circuloRojo4 = new Circle(160, 580, 15, Color.RED);
	    fichasRojas.add(circuloRojo1);
	    fichasRojas.add(circuloRojo2);
	    fichasRojas.add(circuloRojo3);
	    fichasRojas.add(circuloRojo4);
		fichasVerdes = new ArrayList<Circle>(4);
	    Circle circuloVerde1 = new Circle(115, 115, 15, Color.GREEN);
	    Circle circuloVerde2= new Circle(160, 115, 15, Color.GREEN);
	    Circle circuloVerde3 = new Circle(115, 160, 15, Color.GREEN);
	    Circle circuloVerde4 = new Circle(160, 160, 15, Color.GREEN);
	    fichasVerdes.add(circuloVerde1);
	    fichasVerdes.add(circuloVerde2);
	    fichasVerdes.add(circuloVerde3);
	    fichasVerdes.add(circuloVerde4);
	    fichasAmarillas = new ArrayList<Circle>(4);
	    Circle circuloAmarillo1 = new Circle(525, 115, 15, Color.YELLOW);
	    Circle circuloAmarillo2 = new Circle(570, 115, 15, Color.YELLOW);
	    Circle circuloAmarillo3 = new Circle(525, 160, 15, Color.YELLOW);
	    Circle circuloAmarillo4 = new Circle(570, 160, 15, Color.YELLOW);
	    fichasAmarillas.add(circuloAmarillo1);
	    fichasAmarillas.add(circuloAmarillo2);
	    fichasAmarillas.add(circuloAmarillo3);
	    fichasAmarillas.add(circuloAmarillo4);
	    fichasAzules = new ArrayList<Circle>(4);
	    Circle circuloAzul1 = new Circle(527, 530, 15, Color.BLUE);
	    Circle circuloAzul2 = new Circle(572, 530, 15, Color.BLUE);
	    Circle circuloAzul3 = new Circle(527, 580, 15, Color.BLUE);
	    Circle circuloAzul4 = new Circle(572, 580, 15, Color.BLUE);
	    fichasAzules.add(circuloAzul1);
	    fichasAzules.add(circuloAzul2);
	    fichasAzules.add(circuloAzul3);
	    fichasAzules.add(circuloAzul4);
	    
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
	    
        imagenBoton.setFitWidth(50);
        imagenBoton.setPreserveRatio(true);
        imagenBoton.setCache(true);
        
		botonNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	resultadoDado = Dado.lanzarDado();
                
            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Resultado del dado...");
                alert.setHeaderText("El jugador "+ludo.jugadorActual.color+" saco el número");
                alert.setContentText(""+ resultadoDado);
                alert.showAndWait();
                botonNormal.setDisable(true);                	
                
                ludo.jugar(resultadoDado);
                
                if(resultadoDado == 6 || ludo.jugadorActual.fichasEnJuego > 0) {
                	elegirFicha(ludo.jugadorActual.color);

                }
                else {
                    botonNormal.setDisable(false);   
                    ludo.jugadorActual = ludo.cambiarTurno();	
                }
//        		ludo.tablero.eliminarFichasGanadas(ludo.jugadorActual);
      			
                if(ludo.termino()) {
                	//cambiar de escena a resultados(?)
                }
                
            }
        });
		
		Canvas canvas = new Canvas(691, 691);
		canvas.setOnMouseClicked((MouseEvent event) -> {
			System.out.println(event.getX());
			System.out.println(event.getY());
		});
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		String imagePath = "C:\\Users\\Pc\\eclipse-workspace\\algo3Ludo\\resources\\tableroludo.jpg";
		Image image = new Image(imagePath);
		Scene scene2 = new Scene(root2,691,691);

		gc.drawImage(image, 0, 0);
		root2.getChildren().addAll(canvas,botonNormal,circuloVerde1,circuloVerde2,circuloVerde3,circuloVerde4,circuloRojo1,circuloRojo2,circuloRojo3,circuloRojo4,circuloAzul1,circuloAzul2,circuloAzul3,circuloAzul4,circuloAmarillo1,circuloAmarillo2,circuloAmarillo3,circuloAmarillo4);
		
		boton.setText("OK");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	stage.close();
                ludo.inicializarJuego();
                ludo.crearJugadores(choiceBox.getValue(),choiceBox1.getValue(),choiceBox2.getValue(),choiceBox3.getValue());
                ludo.jugadorActual = ludo.elegirQuienEmpieza();
        		stage.setScene(scene2);
        		stage.show();
            }
        });
	}
		
	public void elegirFicha(algo3Ludo.Ficha.Color color){	
		if(color == algo3Ludo.Ficha.Color.ROJO) {
			for(Circle circulo: fichasRojas) {
		    	circulo.setOnMouseClicked((MouseEvent event)-> {
		    		Ficha ficha = ludo.fichaElegida(circulo.getId());
		    		ludo.accionDependiendoTiradaDado(ficha);
		    		ficha.casilla.setCoordenadasTablero();
		    		botonNormal.setDisable(false);
		    		circulo.setStroke(Color.BLACK);
		    		if(ficha.estado!=Estado.BASE) {
		    			circulo.relocate(ficha.casilla.coordenadaX, ficha.casilla.coordenadaY);		    			
		    			ficha.enJuego = true;
		    		}
		    	});	
                ludo.jugadorActual = ludo.cambiarTurno();	
			}
		}
		else if(color == algo3Ludo.Ficha.Color.AZUL) {
				
			for(Circle circulo: fichasAzules) {
				circulo.setOnMouseClicked((MouseEvent event)-> {
					Ficha ficha = ludo.fichaElegida(circulo.getId());
					System.out.println(ficha.casilla.posicion);
					ludo.accionDependiendoTiradaDado(ficha);	
		    		System.out.println(ficha.casilla.posicion);
		    		ficha.casilla.setCoordenadasTablero();
		    		botonNormal.setDisable(false);
		    		circulo.setStroke(Color.BLACK);
		    		if(ficha.estado!=Estado.BASE) {
		    			circulo.relocate(ficha.casilla.coordenadaX, ficha.casilla.coordenadaY);		    			
		    			ficha.enJuego = true;
		    		}
				});
                ludo.jugadorActual = ludo.cambiarTurno();	

			}
		}
		else if(color == algo3Ludo.Ficha.Color.AMARILLO) {
			for(Circle circulo: fichasAmarillas) {
				circulo.setOnMouseClicked((MouseEvent event)-> {
					Ficha ficha = ludo.fichaElegida(circulo.getId());
					System.out.println(ficha.casilla.posicion);
		    		ludo.accionDependiendoTiradaDado(ficha);
		    		System.out.println(ficha.casilla.posicion);
		    		ficha.casilla.setCoordenadasTablero();
		    		botonNormal.setDisable(false);
		    		circulo.setStroke(Color.BLACK);
		    		if(ficha.estado!=Estado.BASE) {
		    			circulo.relocate(ficha.casilla.coordenadaX, ficha.casilla.coordenadaY);		    			
		    			ficha.enJuego = true;
		    		}
				});	
                ludo.jugadorActual = ludo.cambiarTurno();
			}
		}
		else if(color == algo3Ludo.Ficha.Color.VERDE) {
			for(Circle circulo: fichasVerdes) {
				circulo.setOnMouseClicked((MouseEvent event)-> {
					Ficha ficha = ludo.fichaElegida(circulo.getId());
					System.out.println(ficha.casilla.posicion);
					ludo.accionDependiendoTiradaDado(ficha);	
		    		System.out.println(ficha.casilla.posicion);
		    		ficha.casilla.setCoordenadasTablero();
		    		botonNormal.setDisable(false);
		    		circulo.setStroke(Color.BLACK);
		    		if(ficha.estado!=Estado.BASE) {
		    			circulo.relocate(ficha.casilla.coordenadaX, ficha.casilla.coordenadaY);		    			
		    			ficha.enJuego = true;
		    		}
				});	
                ludo.jugadorActual = ludo.cambiarTurno();	
			}
		}
	}
	public static void main(String[] args) {
		launch();
	}
	
	
}
