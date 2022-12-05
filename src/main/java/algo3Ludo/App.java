package algo3Ludo;

import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {
	
	public Ludo ludo;
	
	public App() {
		ludo = new Ludo();
	}

	@Override
	public void start(Stage stage) throws Exception {

        EscenaInicio escenaInicio = new EscenaInicio();
        stage.setTitle("Elegir Jugadores");
        stage.setScene(escenaInicio.crearEscena(stage));
        stage.show();
    
	}
	
	public static void main(String[] args) {
		launch();
	}
	
	
}
