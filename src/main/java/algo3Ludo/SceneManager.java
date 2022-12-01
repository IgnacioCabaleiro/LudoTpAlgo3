package algo3Ludo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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

public class SceneManager {
	App app;
	GridPane root;
	Group root2;
	Group root3;
	
//	
	public void crearEscena1(Stage stage) {
		
//		rootInicio = new GridPane();
//		rootJuego = new Group();
//		
//        Label etiquetaRojo = new Label("Elegir tipo de jugador Rojo");
//        Label etiquetaAzul = new Label("Elegir tipo de jugador Azul");
//        Label etiquetaVerde = new Label("Elegir tipo de jugador Verde");
//        Label etiquetaAmarillo = new Label("Elegir tipo de jugador Amarillo");
//        Label respuestaRojo = new Label("");
//        Label respuestaAzul = new Label("");
//        Label respuestaVerde = new Label("");
//        Label respuestaAmarillo = new Label("");
//        
//        botonNormal = new Button();
//        Button boton = new Button();
//        
//		Canvas canvasJuego = new Canvas(691, 691);
//		GraphicsContext gc = canvasJuego.getGraphicsContext2D();
//		String imagePath = "C:\\Users\\Pc\\eclipse-workspace\\algo3Ludo\\src\\main\\java\\res\\tableroludo.jpg";
//		Image image = new Image(imagePath);
//		
//        Scene sceneInicio = new Scene(rootInicio, 500, 300);
//		Scene sceneJuego = new Scene(rootJuego,691,691);
//		
//		ObservableList<String> tipoJugadores = FXCollections.observableArrayList("normal", "maquina");
//       
//		ImageView imagenBoton =  new ImageView("C:\\Users\\Pc\\eclipse-workspace\\algo3Ludo\\src\\main\\java\\res\\boton_presionado-removebg-preview.png");
//		app.fichasRojas = new ArrayList<Circle>(4);
//	    Circle circuloRojo1 = new Circle(115, 530, 15, Color.RED);
//	    Circle circuloRojo2 = new Circle(160, 530, 15, Color.RED);
//	    Circle circuloRojo3 = new Circle(115, 580, 15, Color.RED);
//	    Circle circuloRojo4 = new Circle(160, 580, 15, Color.RED);
//	    
//		app.fichasVerdes = new ArrayList<Circle>(4);
//	    Circle circuloVerde1 = new Circle(115, 115, 15, Color.GREEN);
//	    Circle circuloVerde2= new Circle(160, 115, 15, Color.GREEN);
//	    Circle circuloVerde3 = new Circle(115, 160, 15, Color.GREEN);
//	    Circle circuloVerde4 = new Circle(160, 160, 15, Color.GREEN);
//
//	    app.fichasAmarillas = new ArrayList<Circle>(4);
//	    Circle circuloAmarillo1 = new Circle(525, 115, 15, Color.YELLOW);
//	    Circle circuloAmarillo2 = new Circle(570, 115, 15, Color.YELLOW);
//	    Circle circuloAmarillo3 = new Circle(525, 160, 15, Color.YELLOW);
//	    Circle circuloAmarillo4 = new Circle(570, 160, 15, Color.YELLOW);
//
//	    app.fichasAzules = new ArrayList<Circle>(4);
//	    Circle circuloAzul1 = new Circle(525, 530, 15, Color.BLUE);
//	    Circle circuloAzul2 = new Circle(570, 530, 15, Color.BLUE);
//	    Circle circuloAzul3 = new Circle(525, 580, 15, Color.BLUE);
//	    Circle circuloAzul4 = new Circle(570, 580, 15, Color.BLUE);
//	    
//	    boton.setDisable(true);
//        choiceBox1.setDisable(true);
//        choiceBox2.setDisable(true);
//        choiceBox3.setDisable(true);
//        
//        ChangeListener<String> changeListener = new ChangeListener<String>() {
//        	@Override
//            public void changed(ObservableValue<? extends String> observable, //
//                    String oldValue, String newValue) {
//                if (newValue != null) {
//                    respuestaRojo.setText(newValue);
//                    choiceBox.setDisable(true);
//                    choiceBox1.setDisable(false);
//                }
//            }
//        };
//        ChangeListener<String> changeListener1 = new ChangeListener<String>() {
//        	@Override
//            public void changed(ObservableValue<? extends String> observable, //
//                    String oldValue, String newValue) {
//                if (newValue != null) {
//                    respuestaAzul.setText(newValue);
//                    choiceBox1.setDisable(true);
//                    choiceBox2.setDisable(false);
//                }
//            }
//        };
//        ChangeListener<String> changeListener2 = new ChangeListener<String>() {
//        	@Override
//            public void changed(ObservableValue<? extends String> observable, //
//                    String oldValue, String newValue) {
//                if (newValue != null) {
//                    respuestaVerde.setText(newValue);
//                    choiceBox2.setDisable(true);
//                    choiceBox3.setDisable(false);
//                }
//            }
//        };
//        ChangeListener<String> changeListener3 = new ChangeListener<String>() {
//        	@Override
//            public void changed(ObservableValue<? extends String> observable, //
//                    String oldValue, String newValue) {
//                if (newValue != null) {
//                    respuestaAmarillo.setText(newValue);
//                    choiceBox3.setDisable(true);
//                    boton.setDisable(false);
//                }
//            }
//        };
//
//        choiceBox.getSelectionModel().selectedItemProperty().addListener(changeListener);
//        choiceBox1.getSelectionModel().selectedItemProperty().addListener(changeListener1);
//        choiceBox2.getSelectionModel().selectedItemProperty().addListener(changeListener2);
//        choiceBox3.getSelectionModel().selectedItemProperty().addListener(changeListener3);
//        
//        rootInicio.setVgap(30); 
//        rootInicio.setHgap(30);
//        
//        rootInicio.add(etiquetaRojo, 0, 0);
//        rootInicio.add(etiquetaAzul, 0, 1);
//        rootInicio.add(etiquetaVerde, 0, 2);
//        rootInicio.add(etiquetaAmarillo, 0, 3);
//        
//        rootInicio.add(choiceBox, 1, 0);
//        rootInicio.add(choiceBox1, 1, 1);
//        rootInicio.add(choiceBox2, 1, 2);
//        rootInicio.add(choiceBox3, 1, 3);
//        
//        rootInicio.add(respuestaRojo, 2, 0);
//        rootInicio.add(respuestaAzul, 2, 1);
//        rootInicio.add(respuestaVerde, 2, 2);
//        rootInicio.add(respuestaAmarillo, 2, 3);
//
//        rootInicio.add(boton, 1, 4 );
//        return scene;
}
/*
	public Scene crearEscena2(Stage stage) {
		root2 = new Group();
		botonNormal = new Button();
		
		ImageView imagenBoton =  new ImageView("C:\\Users\\Pc\\eclipse-workspace\\algo3Ludo\\src\\main\\java\\res\\boton_presionado-removebg-preview.png");
		botonNormal.setLayoutX(310.5);
		botonNormal.setLayoutY(325);
		botonNormal.setGraphic(imagenBoton);
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
	    Circle circuloAzul1 = new Circle(525, 530, 15, Color.BLUE);
	    Circle circuloAzul2 = new Circle(570, 530, 15, Color.BLUE);
	    Circle circuloAzul3 = new Circle(525, 580, 15, Color.BLUE);
	    Circle circuloAzul4 = new Circle(570, 580, 15, Color.BLUE);
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

		Canvas canvas = new Canvas(691, 691);
		canvas.setOnMouseClicked((MouseEvent event) -> {
			System.out.println(event.getX());
			System.out.println(event.getY());
		});
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		String imagePath = "C:\\Users\\Pc\\eclipse-workspace\\algo3Ludo\\src\\main\\java\\res\\tableroludo.jpg";
		Image image = new Image(imagePath);

		gc.drawImage(image, 0, 0);
		root2.getChildren().addAll(canvas,botonNormal,circuloVerde1,circuloVerde2,circuloVerde3,circuloVerde4,circuloRojo1,circuloRojo2,circuloRojo3,circuloRojo4,circuloAzul1,circuloAzul2,circuloAzul3,circuloAzul4,circuloAmarillo1,circuloAmarillo2,circuloAmarillo3,circuloAmarillo4);
		
		Scene scene2 = new Scene(root2,691,691);
		
		return scene2;
	}
*/
	public Scene crearEscena3(Stage stage , Ludo ludo) {
		
		Canvas canvas = new Canvas(617, 410);
    	Group root = new Group();
		Scene scene3 = new Scene(root,617,410);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		String imagePath = "C:\\Users\\Pc\\eclipse-workspace\\algo3Ludo\\src\\main\\java\\res\\leaderboard.png";
		Image image = new Image(imagePath);
		
	    gc.drawImage(image, 0, 0);
		gc.setFill(Color.CORNFLOWERBLUE);
		
		gc.fillRoundRect(231, 117, 262, 28, 0, 0);
		gc.fillRoundRect(231, 165, 262, 28, 0, 0);
		gc.fillRoundRect(231, 213, 262, 28, 0, 0);
		gc.fillRoundRect(231, 261, 262, 28, 0, 0);
		gc.fillRoundRect(140, 300, 352, 46, 0, 0);
		ArrayList<Color> jugadoresColores = new ArrayList<Color>();
		List<Jugador> jugadoresOrdenados = new ArrayList<Jugador>();
		jugadoresOrdenados = ludo.jugadores.stream().sorted((x1,x2)->x2.fichasGanadas - x1.fichasGanadas).collect(Collectors.toList());
		for(int i = 0 ; i < jugadoresOrdenados.size(); i++) {
			if(jugadoresOrdenados.get(i).color == algo3Ludo.Ficha.Color.ROJO) {
				jugadoresColores.add(i, Color.RED);
			}
			else if(jugadoresOrdenados.get(i).color == algo3Ludo.Ficha.Color.AMARILLO) {
				jugadoresColores.add(i, Color.YELLOW);
			}
			else if(jugadoresOrdenados.get(i).color == algo3Ludo.Ficha.Color.VERDE) {
				jugadoresColores.add(i, Color.GREEN);
			}
			else if(jugadoresOrdenados.get(i).color == algo3Ludo.Ficha.Color.AZUL) {
				jugadoresColores.add(i, Color.BLUE);
			}
		}

		gc.strokeText("El ganador es el "+ jugadoresOrdenados.get(0).color +" con "+jugadoresOrdenados.get(0).fichasGanadas+" fichas ganadas ", 234, 135, 250);
		gc.strokeText("El segundo lugar es para el "+ jugadoresOrdenados.get(1).color +" con "+jugadoresOrdenados.get(1).fichasGanadas+" fichas ganadas", 234, 184, 250);
		gc.strokeText("El tercer lugar es para el "+ jugadoresOrdenados.get(2).color +" con "+jugadoresOrdenados.get(2).fichasGanadas+" fichas ganadas ", 234, 235, 250);
		gc.strokeText("El ultimo lugar es para el "+ jugadoresOrdenados.get(3).color +" con "+jugadoresOrdenados.get(3).fichasGanadas+" fichas ganadas ", 234, 284, 250);
	   
		Circle circuloPrimerLugar = new Circle(200, 130, 20, jugadoresColores.get(0));
	    Circle circuloSegundoLugar = new Circle(200, 176, 20, jugadoresColores.get(1));
	    Circle circuloTercerLugar = new Circle(200, 227, 20, jugadoresColores.get(2));
	    Circle circuloCuartoLugar = new Circle(200, 276, 20, jugadoresColores.get(3));
		//gc.strokeText("El ganador es el ROJO con 4 fichas ganadas ", 234, 135, 250);
		root.getChildren().addAll(canvas,circuloPrimerLugar,circuloSegundoLugar,circuloTercerLugar,circuloCuartoLugar);
		
		stage.setTitle("Partida finalizada");
		
		return scene3;
	}

}
