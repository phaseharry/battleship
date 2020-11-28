package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Main extends Application {
	int selectedColumn = -1;
	int selectedRow = -1;
	
	@Override
	public void start(Stage primaryStage) {		
		//title for window
		primaryStage.setTitle("Battleship");
		
		
		
		
		/*----------Information Area----------*/
		Label yourShips = new Label("Your Ships");
		
		RadioButton carrier = new RadioButton("carrier x5");
		RadioButton battleship = new RadioButton("battleship x4");
		RadioButton destroyer = new RadioButton("destroyer x3");
		RadioButton submarine = new RadioButton("submarine x3");
		RadioButton patrolboat = new RadioButton("patrolboat x2");
		
		ToggleGroup ship = new ToggleGroup();
		carrier.setToggleGroup(ship);
		battleship.setToggleGroup(ship);
		destroyer.setToggleGroup(ship);
		submarine.setToggleGroup(ship);
		patrolboat.setToggleGroup(ship);
		
		
		Label placement = new Label("Placement");
		
		RadioButton horizontal = new RadioButton("Horizontal");
		RadioButton vertical = new RadioButton("Vertical");
		
		ToggleGroup direction = new ToggleGroup();
		horizontal.setToggleGroup(direction);
		vertical.setToggleGroup(direction);
		
		Button placeShip = new Button("Place Ship");
		Button attack = new Button("Attack");
		//attack.setOnAction(new attackClickHandler());
		Label log = new Label("Log");
		Label logContent = new Label("");
		
		//VBox for info
		VBox vInfo = new VBox(yourShips, carrier, battleship, destroyer, submarine, patrolboat, placement, horizontal, vertical, placeShip, attack, log, logContent);
		vInfo.setStyle("-fx-background-color: #A9A9A9");
		
		
		
		/*----------Board Area----------*/
		//user board
		Label userBoard = new Label("User Board");
		
		ToggleGroup uGrid = new ToggleGroup();
		
		GridPane uBoard = new GridPane();
		for (int column = 0; column < 10; column++) {
			for (int row = 0; row < 10; row++) {
				uBoard.add(setGridButton(uGrid, logContent), column, row);
			}
		}
		
		Label ucarrier = new Label("carrier: ");
		Label ubattleshipHP = new Label("battleship: ");
		Label udestroyerHP = new Label("destroyer: ");
		Label usubmarineHP = new Label("submarine: ");
		Label upatrolboatHP = new Label("patrolboat: ");
		
		//VBox for user board
		VBox vUser = new VBox(userBoard, uBoard, ucarrier, ubattleshipHP, udestroyerHP, usubmarineHP, upatrolboatHP);
		
		
		
		
		//computer board
		Label computerBoard = new Label("Computer Board");
		
		ToggleGroup cGrid = new ToggleGroup();
		
		GridPane cBoard = new GridPane();
		for (int column = 0; column < 10; column++) {
			for (int row = 0; row < 10; row++) {
				cBoard.add(setGridButton(cGrid, logContent), column, row);
			}
		}
		
		Label ccarrierHP = new Label("carrier: ");
		Label cbattleshipHP = new Label("battleship: ");
		Label cdestroyerHP = new Label("destroyer: ");
		Label csubmarineHP = new Label("submarine: ");
		Label cpatrolboatHP = new Label("patrolboat: ");
		
		//VBox for computer board
		VBox vComputer = new VBox(computerBoard, cBoard, ccarrierHP, cbattleshipHP, cdestroyerHP, csubmarineHP, cpatrolboatHP);			
		
		//HBox for board area
		HBox hBoard = new HBox(20, vUser, vComputer);
		hBoard.setId("hBoard");
		
		
		
		
		//HBox that contains everything
		HBox hbox = new HBox(10, vInfo, hBoard);
		
		
		
		
		//create a scene and display it
		Scene scene = new Scene(hbox, 700, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Create a toggle button that return its column and row indexes when clicked
	 * @param tg - ToggleGroup that ToggleButton belongs to
	 * @param l - Label for printing out information
	 * @return - ToggleButton
	 */
	public ToggleButton setGridButton(ToggleGroup tg, Label l) {
		ToggleButton button = new ToggleButton("");
		
		button.setToggleGroup(tg);
		
		button.setPrefSize(25, 25);
		
		button.setOnAction(e->{
			selectedColumn = GridPane.getColumnIndex(button);
			selectedRow = GridPane.getRowIndex(button);
			l.setText("Column: " + selectedColumn + "\nRow: " + selectedRow);
		});
		
		return button;
	}
	
	/*class attackClickHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (/*has ship) {
				//attack
			} else {
				//missed
			}
		}
	}*/
	
	/*class placeClickHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (/*horizontal is selected) {
				
			} else {
				
			}
		}
	}*/
	
	public static void main(String[] args) {		
		launch(args);
		/*Game game1 = new Game();
		game1.printPlayerShips();
		game1.printAiShips();
		game1.printRowAndColMapIdx();*/
	}
}