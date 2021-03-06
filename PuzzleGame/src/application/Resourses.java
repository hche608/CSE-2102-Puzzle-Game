/**
 * This is a Resource class
 * 
 * @author hche608
 * 
 */
package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

public class Resourses {

	public final boolean debug = false;

	public final double FRAME_WIDTH = 800.0;
	public final double FRAME_HEIGHT = 600.0;
	public final double BTNS_WIDTH = 300.0;
	public final double BTNS_HEIGHT = 250.0;
	public final double BTN_LEVEL = 60;

	public final double BTN_MINWIDTH = 70.0;
	public final double BTN_MINHEIGHT = 50.0;

	public final double O_pointX = 50.0;
	public final double O_pointY = 350.0;

	public final double Cube_Size = 150.0;

	public final int countdown = 50;

	public final int numOfLevel = 12;

	public final double title_size = 50.0;
	public final double label_size = 25.0;

	public final double[] Triangle_L = { 0.0, 0.0, 0.0, Cube_Size,
			Cube_Size / 2, Cube_Size / 2 };
	public final double[] Triangle_M = { 0.0, 0.0, 0.0, Cube_Size / 2,
			Cube_Size / 2, 0.0 };
	public final double[] Triangle_S = { 0.0, 0.0, 0.0, Cube_Size / 2,
			Cube_Size / 4, Cube_Size / 4 };

	public final double[] Square_S = { Cube_Size * 3 / 4, Cube_Size / 4,
			Cube_Size, Cube_Size / 2, Cube_Size * 3 / 4, Cube_Size * 3 / 4,
			Cube_Size / 2, Cube_Size / 2 };
	public final double[] Rhombus_S = { 0.0, Cube_Size, Cube_Size / 4,
			Cube_Size * 3 / 4, Cube_Size * 3 / 4, Cube_Size * 3 / 4,
			Cube_Size / 2, Cube_Size };

	/*
	 * Resources for common area
	 */

	public BufferedReader br;
	
	public ImageView background_Image;
	public ImageView btn_OK_Image;
	public ImageView btn_OK_Image1;
	public ImageView btn_CANCEL_Image;
	public ImageView btn_CANCEL_Image1;
	public ImageView btn_Return_Image;
	public ImageView btn_Return_Image1;

	public Font minecrafter_font_title;
	public Font minecrafter_font_label;
	/*
	 * Resources for main UI
	 */

	public ImageView mainUI_start_Image;
	public ImageView mainUI_start_Image1;
	public ImageView mainUI_about_Image;
	public ImageView mainUI_about_Image1;
	public ImageView mainUI_scores_Image;
	public ImageView mainUI_scores_Image1;
	public ImageView mainUI_exit_Image;
	public ImageView mainUI_exit_Image1;

	/*
	 * Resources for new_Player UI
	 */
	public ImageView last_Player_Image;
	public ImageView last_Player_Image1;
	
	
	/*
	 * Resources for Level_Select UI
	 */
	public Image level_lock_Image;
	public ArrayList<ImageView> LevelUI_Images;
	public ArrayList<ImageView> LevelUI_Images1;

	/*
	 * Resources for GamePanel UI
	 */

	public ImageView gamePanelUI_main_menu_Image;
	public ImageView gamePanelUI_main_menu_Image1;

	public ImageView gamePanelUI_next_Image;
	public ImageView gamePanelUI_next_Image1;
	public ImageView gamePanelUI_previous_Image;
	public ImageView gamePanelUI_previous_Image1;
	public ImageView gamePanelUI_pause_Image;
	public ImageView gamePanelUI_pause_Image1;
	public ImageView gamePanelUI_continue_Image;
	public ImageView gamePanelUI_continue_Image1;

	public ImageView gamePanelUI_music_Image;
	public ImageView gamePanelUI_music_Image1;
	public ImageView gamePanelUI_stopped_music_Image;
	public ImageView gamePanelUI_stopped_music_Image1;
	
	public ImageView gamePanelUI_soundFX_Image;
	public ImageView gamePanelUI_soundFX_Image1;
	public ImageView gamePanelUI_stopped_soundFX_Image;
	public ImageView gamePanelUI_stopped_soundFX_Image1;


	// Background Music
	public AudioClip backgoundMediaPlayer;
	public AudioClip mouseEnterFXmediaPlayer;
	public AudioClip mouseClickedFXmediaPlayer;
	public AudioClip shapesMatchedFXmediaPlayer;
	public AudioClip shapesRotatedFXmediaPlayer;
	public AudioClip completedFXmediaPlayer;

	public Resourses() {
		// Background music
		try {
			backgoundMediaPlayer = new AudioClip(getClass()
					.getResource("/application/resourses/music/background.mp3")
					.toURI().toString());
			backgoundMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		} catch (Exception e) {
			System.out.println("Load background music error");
		}

		// FX music
		try {
			mouseEnterFXmediaPlayer = new AudioClip(getClass()
					.getResource(
							"/application/resourses/music/mouseEnterFX.wav")
					.toURI().toString());

			mouseClickedFXmediaPlayer = new AudioClip(getClass()
					.getResource(
							"/application/resourses/music/mouseClickedFX.wav")
					.toURI().toString());

			shapesMatchedFXmediaPlayer = new AudioClip(getClass()
					.getResource("/application/resourses/music/matchedFX.wav")
					.toURI().toString());

			shapesRotatedFXmediaPlayer = new AudioClip(getClass()
					.getResource(
							"/application/resourses/music/shapeRotatedFX.wav")
					.toURI().toString());

			completedFXmediaPlayer = new AudioClip(
					getClass()
							.getResource(
									"/application/resourses/music/completedFX.wav")
							.toURI().toString());

		} catch (Exception e) {
			System.out.println("Load FX music error");
		}

		// Fonts
		try {
			minecrafter_font_title = Font.loadFont(
					getClass().getResourceAsStream(
							"/application/resourses/Minecraftia2.ttf"),
					title_size);
			minecrafter_font_label = Font.loadFont(
					getClass().getResourceAsStream(
							"/application/resourses/Minecraftia2.ttf"),
					label_size);

		} catch (Exception e) {
			System.out.println("Load Font error");
		}

		// Load levels
		try {
			br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/application/resourses/LevelInfo.ini")));
		} catch (Exception e){
			System.out.println("Load levels error: "  + e);
		}
		
		// Images
		try {

			background_Image = new ImageView(new Image(Main.class.getResource(
					"/application/resourses/background.png").toString()));

			btn_OK_Image = new ImageView(new Image(Main.class.getResource(
					"/application/resourses/Common_btns/OK.png").toString()));

			btn_OK_Image1 = new ImageView(new Image(Main.class.getResource(
					"/application/resourses/Common_btns/OK_hover.png")
					.toString()));

			btn_CANCEL_Image = new ImageView(
					new Image(Main.class.getResource(
							"/application/resourses/Common_btns/Cancel.png")
							.toString()));

			btn_CANCEL_Image1 = new ImageView(new Image(Main.class.getResource(
					"/application/resourses/Common_btns/Cancel_hover.png")
					.toString()));

			btn_Return_Image = new ImageView(
					new Image(Main.class.getResource(
							"/application/resourses/Common_btns/Return.png")
							.toString()));

			btn_Return_Image1 = new ImageView(new Image(Main.class.getResource(
					"/application/resourses/Common_btns/return_hover.png")
					.toString()));

			mainUI_start_Image = new ImageView(new Image(Main.class
					.getResource("/application/resourses/mainUI/start.png")
					.toString()));
			mainUI_start_Image1 = new ImageView(new Image(Main.class
					.getResource(
							"/application/resourses/mainUI/start_hover.png")
					.toString()));
			mainUI_about_Image = new ImageView(new Image(Main.class
					.getResource("/application/resourses/mainUI/about.png")
					.toString()));
			mainUI_about_Image1 = new ImageView(new Image(Main.class
					.getResource(
							"/application/resourses/mainUI/about_hover.png")
					.toString()));
			mainUI_scores_Image = new ImageView(new Image(Main.class
					.getResource("/application/resourses/mainUI/score.png")
					.toString()));
			mainUI_scores_Image1 = new ImageView(new Image(Main.class
					.getResource(
							"/application/resourses/mainUI/score_hover.png")
					.toString()));
			mainUI_exit_Image = new ImageView(new Image(Main.class.getResource(
					"/application/resourses/mainUI/exit.png").toString()));
			mainUI_exit_Image1 = new ImageView(new Image(
					Main.class.getResource(
							"/application/resourses/mainUI/exit_hover.png")
							.toString()));

			/*
			 *  new PlayerUI
			 */
			
			last_Player_Image = new ImageView(new Image(Main.class.getResource(
					"/application/resourses/newPlayerUI/lastplay.png").toString()));
			last_Player_Image1 = new ImageView(new Image(Main.class.getResource(
					"/application/resourses/newPlayerUI/lastplay_hover.png").toString()));
			
			/*
			 * level select UI
			 */
			
			level_lock_Image = new Image(Main.class.getResource(
					"/application/resourses/LevelUI/level_lock.png").toString());
			LevelUI_Images = new ArrayList<ImageView>();
			LevelUI_Images1 = new ArrayList<ImageView>();
			for (int i = 0; i < numOfLevel; i++) {
				ImageView temp = new ImageView(new Image(Main.class
						.getResource(
								"/application/resourses/LevelUI/" + (i + 1)
										+ "_normal.png").toString()));
				LevelUI_Images.add(temp);
				ImageView temp1 = new ImageView(new Image(Main.class
						.getResource(
								"/application/resourses/LevelUI/" + (i + 1)
										+ "_hover.png").toString()));
				LevelUI_Images1.add(temp1);
			}

			/*
			 * game board UI
			 */
			gamePanelUI_main_menu_Image = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/Main_menu.png")
									.toString()));
			gamePanelUI_main_menu_Image1 = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/Main_menu_hover.png")
									.toString()));

			gamePanelUI_next_Image = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/next.png")
									.toString()));
			gamePanelUI_next_Image1 = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/next_hover.png")
									.toString()));
			gamePanelUI_previous_Image = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/previous.png")
									.toString()));
			gamePanelUI_previous_Image1 = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/previous_hover.png")
									.toString()));
			gamePanelUI_pause_Image = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/pause.png")
									.toString()));
			gamePanelUI_pause_Image1 = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/pause_hover.png")
									.toString()));
			gamePanelUI_continue_Image = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/continue.png")
									.toString()));
			gamePanelUI_continue_Image1 = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/continue_hover.png")
									.toString()));

			gamePanelUI_music_Image = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/music.png")
									.toString()));
			gamePanelUI_music_Image1 = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/music_hover.png")
									.toString()));
			gamePanelUI_stopped_music_Image = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/stopmusic.png")
									.toString()));
			gamePanelUI_stopped_music_Image1 = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/stopmusic_hover.png")
									.toString()));
			
			gamePanelUI_soundFX_Image = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/soundFX.png")
									.toString()));
			gamePanelUI_soundFX_Image1 = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/soundFX_hover.png")
									.toString()));
			gamePanelUI_stopped_soundFX_Image = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/stopsoundFX.png")
									.toString()));
			gamePanelUI_stopped_soundFX_Image1 = new ImageView(
					new Image(
							Main.class
									.getResource(
											"/application/resourses/GamePanelUI/Lower_Buttons/stopsoundFX_hover.png")
									.toString()));



		} catch (Exception e) {
			System.out.println("Loading content error" + e);

		}
	}

}
