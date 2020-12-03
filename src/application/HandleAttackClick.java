package application;

import javafx.event.*;

public class HandleAttackClick implements EventHandler<ActionEvent>{
	private Game currentGame;
	
	public HandleAttackClick(Game curGame) {
		currentGame = curGame;
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event);
		//currentGame.runIteration();
	}
}
