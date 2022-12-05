package algo3Ludo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EscenaInicio {
	App app;
	
	public Scene crearEscena(Stage stage) {
		GridPane rootInicio = new GridPane();
		
		Label etiquetaRojo = new Label("Elegir tipo de jugador Rojo");
        Label etiquetaAzul = new Label("Elegir tipo de jugador Azul");
        Label etiquetaVerde = new Label("Elegir tipo de jugador Verde");
        Label etiquetaAmarillo = new Label("Elegir tipo de jugador Amarillo");
        
        Label respuestaRojo = new Label("");
        Label respuestaAzul = new Label("");
        Label respuestaVerde = new Label("");
        Label respuestaAmarillo = new Label("");
        
        Button boton = new Button();
	
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
        
        app = new App();
        
        boton.setText("OK");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	app.ludo.crearJugadores(choiceBox.getValue(),choiceBox1.getValue(),choiceBox2.getValue(),choiceBox3.getValue());
                app.ludo.inicializarJuego();
                EscenaJuego escenaJuego = new EscenaJuego();

                stage.setTitle("Juego");
                stage.setScene(escenaJuego.crearEscena(stage,app));
        		stage.show();
        		
            }
        });
        
        Scene sceneInicio = new Scene(rootInicio, 500, 300);
        
        return sceneInicio;
	}
}
