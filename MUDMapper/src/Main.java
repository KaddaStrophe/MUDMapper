import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("MUDMapper");

		Button newButton = new Button();
		newButton.setText("New Map");
		newButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Create new map");
				Map newMap = new Map();
				newMap.show();
			}
		});

		Button loadButton = new Button();
		loadButton.setText("Load Map");
		loadButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Load existing map");
			}
		});

		VBox choose = new VBox();
		choose.getChildren().add(newButton);
		choose.getChildren().add(loadButton);
		primaryStage.setScene(new Scene(choose, 300, 250));
		primaryStage.show();
	}

}
