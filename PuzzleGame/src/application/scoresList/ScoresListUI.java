package application.scoresList;

import application.Resourses;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScoresListUI {
	Resourses res;
	Stage previousStage;
	boolean mainStage;

	public ScoresListUI(Stage previousStage,Resourses res, boolean mainStage) {
		this.res = res;
		this.previousStage = previousStage;
		this.mainStage = mainStage;
		
	}
	
	public void show(){
		final Stage tableStage = new Stage();
		final VBox scoresList = new VBox();
		final Button btn = new Button("Return Previous View");
		btn.setOnAction(new EventHandler<ActionEvent>() {
	          @Override public void handle(ActionEvent e) {
	        	  if(mainStage){
	        		  //Main.start(previousStage);
	        	  } else {
	        		  //Main.startNewGame(previousStage);
	        	  }
	        	  tableStage.close();
	          }
	          
	      });
		scoresList.getChildren().addAll(btn);
		final Group root = new Group(scoresList);
		Scene scene = new Scene(root,res.FRAME_WIDTH/4,res.FRAME_HEIGHT/1.1);
		tableStage.setResizable(false);
		tableStage.setTitle("Game Scores");
		tableStage.setScene(scene);
		tableStage.centerOnScreen();
		tableStage.setAlwaysOnTop(true);
		tableStage.show();
		
	}

}
