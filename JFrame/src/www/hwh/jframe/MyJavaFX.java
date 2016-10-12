package www.hwh.jframe;

import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;


@SuppressWarnings("restriction")
public class MyJavaFX extends Application {

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Circle circle = new Circle();
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		circle.setStyle("-fx-fill: blue;");
		Label label = new Label("hehe");
		label.setFont(Font.font("Times New Roman"));
		//circle.setStroke(Color.BLACK);
		//circle.setFill(Color.BLUE);
		
		Pane pane = new Pane();
		//pane.getChildren().add(circle);
		pane.getChildren().add(label);
		//pane.setRotate(45);
		pane.setStyle("-fx-border-color: black");
		
		
		Scene scene = new Scene(pane,200,205);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		DoubleProperty d1 = new SimpleDoubleProperty(1);
		DoubleProperty d2 = new SimpleDoubleProperty(2);
		d2.bind(d1.divide(4));
		d1.setValue(4.0);
		System.out.println(d2.getValue());
		
	}

}
