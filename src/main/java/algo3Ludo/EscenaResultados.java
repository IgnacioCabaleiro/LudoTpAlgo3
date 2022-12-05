package algo3Ludo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class EscenaResultados {
	
	public Scene crearEscena(App app) {
		
		Canvas canvas = new Canvas(617, 410);
    	Group root = new Group();
		Scene scene3 = new Scene(root,617,410);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
        String imagePath = "/res/leaderboard.jpg";
		Image imagen = new Image(getClass().getResourceAsStream(imagePath));
		
	    gc.drawImage(imagen, 0, 0);
		gc.setFill(Color.CORNFLOWERBLUE);
		
		gc.fillRoundRect(231, 117, 262, 28, 0, 0);
		gc.fillRoundRect(231, 165, 262, 28, 0, 0);
		gc.fillRoundRect(231, 213, 262, 28, 0, 0);
		gc.fillRoundRect(231, 261, 262, 28, 0, 0);
		gc.fillRoundRect(140, 300, 352, 46, 0, 0);
		
		ArrayList<Color> jugadoresColores = new ArrayList<Color>();
		List<Jugador> jugadoresOrdenados = new ArrayList<Jugador>();
		jugadoresOrdenados = app.ludo.jugadores.stream().sorted((x1,x2)->x2.fichasGanadas - x1.fichasGanadas).collect(Collectors.toList());
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
		gc.strokeText("¡¡Gracias por jugar!!", 260, 325, 250);
	   
		Circle circuloPrimerLugar = new Circle(200, 130, 20, jugadoresColores.get(0));
	    Circle circuloSegundoLugar = new Circle(200, 176, 20, jugadoresColores.get(1));
	    Circle circuloTercerLugar = new Circle(200, 227, 20, jugadoresColores.get(2));
	    Circle circuloCuartoLugar = new Circle(200, 274, 20, jugadoresColores.get(3));
		
		root.getChildren().addAll(canvas,circuloPrimerLugar,circuloSegundoLugar,circuloTercerLugar,circuloCuartoLugar);
		

		
		return scene3;
	}

}
