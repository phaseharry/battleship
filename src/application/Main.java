package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//title for window
			primaryStage.setTitle("Battleship");
		
			/*----------Information Area----------*/
			Label yourShips = new Label("Your Ships");
			
			RadioButton shipFive = new RadioButton();
			RadioButton shipFour = new RadioButton();
			RadioButton shipThree = new RadioButton();
			RadioButton shipTwo = new RadioButton();
			
			ToggleGroup ship = new ToggleGroup();
			shipFive.setToggleGroup(ship);
			shipFour.setToggleGroup(ship);
			shipThree.setToggleGroup(ship);
			shipTwo.setToggleGroup(ship);
			
			
			Label placement = new Label("Placement");
			
			RadioButton horizontal = new RadioButton("Horizontal");
			RadioButton vertical = new RadioButton("Vertical");
			
			ToggleGroup direction = new ToggleGroup();
			horizontal.setToggleGroup(direction);
			vertical.setToggleGroup(direction);
			
			Button placeShip = new Button("Place Ship");
			Button attack = new Button("Attack");
			Label log = new Label("Log");
			
			//VBox for info
			VBox vInfo = new VBox(yourShips, shipFive, shipFour, shipThree, shipTwo, placement, horizontal, vertical, placeShip, attack, log);
			vInfo.setStyle("-fx-background-color: #A9A9A9");
			
			/*----------Board Area----------*/
			//user board
			Label userBoard = new Label("User Board");
			
			Button[][] uButton = new Button[10][10];
			
			GridPane uBoard = new GridPane();
			for (int column = 0; column < 10; column++) {
				for (int row = 0; row < 10; row++) {
					uBoard.add(uButton[column][row] = new Button("  "), column, row);
					//uButton[column][row].getStyleClass().add("boardButton");
				}
			}
			
			//VBox for user board
			VBox vUser = new VBox(userBoard, uBoard);
			
			//computer board
			Label computerBoard = new Label("Computer Board");		
			
			GridPane cBoard = new GridPane();
			for (int column = 0; column < 10; column++) {
				for (int row = 0; row < 10; row++) {
					cBoard.add(new Button("  "), column, row);
				}
			}
			
			//VBox for computer board
			VBox vComputer = new VBox(computerBoard, cBoard);			
			
			//HBox for board area
			HBox hBoard = new HBox(20, vUser, vComputer);
			hBoard.setId("hBoard");
			
			//HBox that contains everything
			HBox hbox = new HBox(10, vInfo, hBoard);
			
			//create a scene
			Scene scene = new Scene(hbox, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//set the scene to the stage
			primaryStage.setScene(scene);
			
			//show window
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
