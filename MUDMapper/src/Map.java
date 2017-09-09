import java.util.LinkedList;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Map extends Stage {
	LinkedList<MapField> mapFieldList;
	String name;

	public Map() {
		name = "New Map";
		mapFieldList = new LinkedList<MapField>();

		ScrollPane scroll = new ScrollPane();

		BorderPane borderPane = new BorderPane();

		GridPane grid = new GridPane();
		grid.setPrefSize(100, 100);
		grid.setMaxSize(100, 100);
		createFields(grid, 50);

		buildMapFrame(borderPane, grid);

		borderPane.setCenter(grid);
		scroll.setContent(borderPane);
		setScene(new Scene(scroll, 800, 600));
	}

	private void buildMapFrame(BorderPane borderPane, GridPane grid) {
		Button widenNorth = new Button();
		Button widenSouth = new Button();
		Button widenWest = new Button();
		Button widenEast = new Button();

		widenNorth.setPrefWidth(40);
		widenSouth.setPrefWidth(grid.getMaxWidth());
		widenSouth.setPrefWidth(grid.getPrefWidth());
		widenSouth.setMaxWidth(grid.getPrefWidth());
		widenSouth.setMaxWidth(grid.getMaxWidth());

		Label labelNorth = new Label("Go more north");
		labelNorth.setMaxWidth(10);
		labelNorth.setMaxHeight(2);
		widenNorth.setGraphic(new Group(labelNorth));

		Label labelSouth = new Label("Go more south");
		labelSouth.setMaxWidth(10);
		labelSouth.setMaxHeight(10);
		labelSouth.setPrefWidth(10);
		labelSouth.setPrefHeight(10);
		labelSouth.setFont(new Font(2));
		widenSouth.setGraphic(new Group(labelSouth));

		Label labelWest = new Label("Go more west");
		labelWest.setRotate(-90);
		labelWest.setMaxWidth(10);
		labelWest.setMaxHeight(10);
		widenWest.setGraphic(new Group(labelWest));

		Label labelEast = new Label("Go more east");
		labelEast.setRotate(90);
		labelEast.setMaxSize(20, 40);
		widenEast.setGraphic(new Group(labelEast));

		borderPane.setTop(widenNorth);
		borderPane.setBottom(widenSouth);
		borderPane.setLeft(widenWest);
		borderPane.setRight(widenEast);

		// borderPane.setTop(labelNorth);
		// borderPane.setBottom(labelSouth);
		// borderPane.setLeft(labelWest);
		// borderPane.setRight(labelEast);

		borderPane.setAlignment(widenNorth, Pos.CENTER);
		borderPane.setAlignment(widenSouth, Pos.CENTER);
		borderPane.setAlignment(widenWest, Pos.CENTER);
		borderPane.setAlignment(widenEast, Pos.CENTER);

		borderPane.getTop().setScaleX(20);
		borderPane.getBottom().setScaleX(20);
		borderPane.getLeft().setScaleY(20);
		borderPane.getRight().setScaleY(20);
	}

	public Map(String name, LinkedList<MapField> mapFieldList) {
		this.name = name;
		this.mapFieldList = mapFieldList;

		GridPane grid = new GridPane();
		grid.add(new Button("1"), 0, 0);
		grid.add(new Button("2"), 0, 3);
		grid.add(new Button("3"), 2, 0);
		setScene(new Scene(grid, 300, 250));
	}

	private void createFields(GridPane grid, int numOfLines) {
		for (int i = 0; i < numOfLines; i++) {
			for (int j = 0; j < numOfLines; j++) {
				MapField field = new MapField();
				field.setMinSize(20, 20);
				// field.setPrefSize(20, 20);
				// field.setMaxSize(20, 20);
				grid.add(field, i, j);
			}

		}

	}
}
