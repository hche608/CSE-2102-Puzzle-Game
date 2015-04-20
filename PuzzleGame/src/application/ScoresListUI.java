	/**
	 * This is a interface of Score Panel
	 * this class is controlled by GameController
	 * 
	 * this class only allocates all labels and buttons on the Panel
	 * 
	 * @author hche608
	 * 
	 */
package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;

public class ScoresListUI {
	Resourses res = Main.res;
	Group root;

	public ScoresListUI(GameController controller) {
		root = new Group();
		try {
			final Button btn = new Button("Return Previous View");
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					controller.loadMainUI();
				}

			});
			root.getChildren().add(btn);
		} catch (Exception e) {
			System.out.println("Initial Scores UI error: " + e);
		}

	}

	public Group getScoresUI() {
		return root;
	}

}
