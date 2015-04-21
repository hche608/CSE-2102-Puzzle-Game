/**
 * This is the main class
 * this class is generate a stage which can display everything
 * 
 * the contents of the stage are controlled by Game Controller
 * 
 * @author hche608
 * 
 */
package application;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static Resourses res = new Resourses();
	GameController controller;

	@Override
	public void start(Stage primaryStage) {
		// initial a background Thread
		try {
			new Thread(task).start();
		} catch (Exception e) {
			System.out.println("Background Muisc error");
		}
		// initial the Primary Stage and Game Controller
		try {
			Group root = new Group();
			GameController controller = new GameController(root);
			controller.loadMainUI();
			Scene scene = new Scene(root, res.FRAME_WIDTH, res.FRAME_HEIGHT);
			primaryStage.setResizable(false);
			primaryStage.centerOnScreen();
			primaryStage.setTitle("Tangram Game");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			System.out.println("Initial error: " + e);
			System.out.println("Crash");
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

	// Create a background Thread to play background Muisc
	Task<Void> task = new Task<Void>() {
		@Override
		public Void call() {
			while (true) {
				if (res.debug)
					System.out.println("BackGround Music");
				res.mediaPlayer.play();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException interrupted) {
					break;
				}

			}
			return null;
		}

	};

}
