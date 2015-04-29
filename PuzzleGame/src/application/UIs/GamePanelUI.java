/**
 * This is a interface of Game Panel
 * this class is controlled by GameController
 * 
 * this class only allocates all labels and buttons on the Panel
 * 
 * @author hche608
 * 
 */
package application.UIs;

import application.Main;
import application.Resourses;
import application.Controllers.GameController;
import javafx.animation.Animation.Status;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GamePanelUI {
	private Resourses res = Main.res;
	private Group root;
	GameController controller;

	public GamePanelUI(GameController controller) {
		root = new Group();
		try {

			this.controller = controller;
			/*
			 * Bottom Line
			 */

			Text counter = new Text("Time: ");
			counter.setFont(res.minecrafter_font_label);
			counter.setFill(Color.BLACK);
			counter.setTranslateX(50);
			counter.setTranslateY(50);

			final Button btn_main = new Button();
			btn_main.setGraphic(res.gamePanelUI_main_menu_Image);
			btn_main.setBorder(null);
			btn_main.setBackground(null);
			btn_main.setScaleShape(false);
			btn_main.setTranslateX(-8);
			btn_main.setTranslateY(res.FRAME_HEIGHT - 55);
			btn_main.setCursor(Cursor.HAND);
			btn_main.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_main.setGraphic(res.gamePanelUI_main_menu_Image1);
					if(controller.isSoundFXPlaying())
						res.mouseEnterFXmediaPlayer.play();
				}
			});
			btn_main.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_main.setGraphic(res.gamePanelUI_main_menu_Image);
				}
			});
			btn_main.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					controller.loadMainUI();
				}
			});
			
			final Button btn_pre = new Button();
			btn_pre.setGraphic(res.gamePanelUI_previous_Image);
			btn_pre.setBorder(null);
			btn_pre.setBackground(null);
			btn_pre.setScaleShape(false);
			btn_pre.setTranslateX(125);
			btn_pre.setTranslateY(res.FRAME_HEIGHT - 55);
			btn_pre.setCursor(Cursor.HAND);
			btn_pre.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_pre.setGraphic(res.gamePanelUI_previous_Image1);
					if(controller.isSoundFXPlaying())
						res.mouseEnterFXmediaPlayer.play();
				}
			});
			btn_pre.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_pre.setGraphic(res.gamePanelUI_previous_Image);
				}
			});
			btn_pre.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					controller.previousLevel();
				}
			});

			final Button btn_pause = new Button();
			if (controller.getCountDownStatus()  == Status.RUNNING){
				btn_pause.setGraphic(res.gamePanelUI_pause_Image);
			} else {
				btn_pause.setGraphic(res.gamePanelUI_continue_Image);
			}
			btn_pause.setBorder(null);
			btn_pause.setBackground(null);
			btn_pause.setTranslateX(258);
			btn_pause.setTranslateY(res.FRAME_HEIGHT - 55);
			btn_pause.setCursor(Cursor.HAND);
			btn_pause.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					if (controller.getCountDownStatus()  == Status.RUNNING){
						btn_pause.setGraphic(res.gamePanelUI_pause_Image1);
					} else {
						btn_pause.setGraphic(res.gamePanelUI_continue_Image1);
					}					
					if(controller.isSoundFXPlaying())
						res.mouseEnterFXmediaPlayer.play();
				}
			});
			btn_pause.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					if (controller.getCountDownStatus()  == Status.RUNNING){
						btn_pause.setGraphic(res.gamePanelUI_pause_Image);
					} else {
						btn_pause.setGraphic(res.gamePanelUI_continue_Image);
					}
				}
			});
			btn_pause.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					if (controller.getCountDownStatus() == Status.RUNNING){
						btn_pause.setGraphic(res.gamePanelUI_continue_Image);
					} else {
						btn_pause.setGraphic(res.gamePanelUI_pause_Image);
					}
					controller.pauseORresumeTimer();
				}
			});

			final Button btn_next = new Button();
			btn_next.setGraphic(res.gamePanelUI_next_Image);
			btn_next.setBorder(null);
			btn_next.setBackground(null);
			btn_next.setTranslateX(391);
			btn_next.setTranslateY(res.FRAME_HEIGHT - 55);
			btn_next.setCursor(Cursor.HAND);
			btn_next.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_next.setGraphic(res.gamePanelUI_next_Image1);
					if(controller.isSoundFXPlaying())
						res.mouseEnterFXmediaPlayer.play();
				}
			});
			btn_next.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					btn_next.setGraphic(res.gamePanelUI_next_Image);

				}
			});
			btn_next.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					controller.nextLevel();
				}
			});

			final Button btn_music = new Button();
			if(controller.isMusicPlaying()){
				btn_music.setGraphic(res.gamePanelUI_music_Image);
			} else {
				btn_music.setGraphic(res.gamePanelUI_stopped_music_Image);
			}	
			btn_music.setBorder(null);
			btn_music.setBackground(null);
			btn_music.setTranslateX(524);
			btn_music.setTranslateY(res.FRAME_HEIGHT - 55);
			btn_music.setCursor(Cursor.HAND);
			btn_music.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					if(controller.isMusicPlaying()){
						btn_music.setGraphic(res.gamePanelUI_music_Image1);
					} else {
						btn_music.setGraphic(res.gamePanelUI_stopped_music_Image1);
					}	
					if(controller.isSoundFXPlaying())
						res.mouseEnterFXmediaPlayer.play();
				}
			});
			btn_music.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					if(controller.isMusicPlaying()){
						btn_music.setGraphic(res.gamePanelUI_music_Image);
					} else {
						btn_music.setGraphic(res.gamePanelUI_stopped_music_Image);
					}	
				}
			});
			btn_music.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					if(controller.isMusicPlaying()){
						btn_music.setGraphic(res.gamePanelUI_stopped_music_Image);
						res.backgoundMediaPlayer.stop();
						controller.setMusicPlaying(false);
					} else {
						btn_music.setGraphic(res.gamePanelUI_music_Image);
						res.backgoundMediaPlayer.play();
						controller.setMusicPlaying(true);
					}	
				}
			});
			
			final Button btn_soundFX = new Button();
			if(controller.isSoundFXPlaying()){
				btn_soundFX.setGraphic(res.gamePanelUI_soundFX_Image);
			} else {
				btn_soundFX.setGraphic(res.gamePanelUI_stopped_soundFX_Image);
			}
			btn_soundFX.setBorder(null);
			btn_soundFX.setBackground(null);
			btn_soundFX.setTranslateX(657);
			btn_soundFX.setTranslateY(res.FRAME_HEIGHT - 55);
			btn_soundFX.setCursor(Cursor.HAND);
			btn_soundFX.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					if(controller.isSoundFXPlaying()){
						btn_soundFX.setGraphic(res.gamePanelUI_soundFX_Image1);
					} else {
						btn_soundFX.setGraphic(res.gamePanelUI_stopped_soundFX_Image1);
					}	
					if(controller.isSoundFXPlaying())
						res.mouseEnterFXmediaPlayer.play();
				}
			});
			btn_soundFX.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					if(controller.isSoundFXPlaying()){
						btn_soundFX.setGraphic(res.gamePanelUI_soundFX_Image);
					} else {
						btn_soundFX.setGraphic(res.gamePanelUI_stopped_soundFX_Image);
					}	
				}
			});
			btn_soundFX.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					if(controller.isSoundFXPlaying()){
						btn_soundFX.setGraphic(res.gamePanelUI_stopped_soundFX_Image);
						//res.backgoundMediaPlayer.stop();
						controller.setSoundFXPlaying(false);
					} else {
						btn_soundFX.setGraphic(res.gamePanelUI_soundFX_Image);
						//res.backgoundMediaPlayer.play();
						controller.setSoundFXPlaying(true);
					}	
				}
			});

			Group lowBTNs = new Group(btn_main, btn_pre, btn_pause, btn_next, btn_music,btn_soundFX);
			root.getChildren().addAll(lowBTNs, counter);

		} catch (Exception e) {
			System.out.println("Initial game panel error: " + e);
		}

	}

	public Group getGamePanelUI() {
		return root;
	}

}
