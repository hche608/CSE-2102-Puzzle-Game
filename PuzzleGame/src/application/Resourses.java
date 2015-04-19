package application;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class Resourses {

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
	final int numOfLevel = 3;
	public final double title_size = 50.0;
	public final double label_size = 25.0;

	public final double[] Triangle_L = { 0.0, 0.0, 0.0, Cube_Size,
			Cube_Size / 2, Cube_Size / 2 };
	public final double[] Triangle_M = { 0.0, 0.0, 0.0, Cube_Size,
			Cube_Size / 2, Cube_Size / 2 };
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
	public Image background_image;
	public ImageView background_Image;
	public Font minecrafter_font_title;
	public Font minecrafter_font_label;
	/*
	 * Resources for main UI
	 */

	public Image mainUI_start_image;
	public Image mainUI_start_image1;
	public Image mainUI_level_image;
	public Image mainUI_level_image1;
	public Image mainUI_scores_image;
	public Image mainUI_scores_image1;
	public Image mainUI_exit_image;
	public Image mainUI_exit_image1;

	public ImageView mainUI_start_Image;
	public ImageView mainUI_start_Image1;
	public ImageView mainUI_level_Image;
	public ImageView mainUI_level_Image1;
	public ImageView mainUI_scores_Image;
	public ImageView mainUI_scores_Image1;
	public ImageView mainUI_exit_Image;
	public ImageView mainUI_exit_Image1;

	/*
	 * Resources for Level_Selevt UI
	 */
	public ArrayList<Image> LevelUI_images;

	public ArrayList<ImageView> LevelUI_Images;

	/*
	 * Resources for GamePanel UI
	 */
	public Image gamePanelUI_undo_image;
	public Image gamePanelUI_redo_image;
	public Image gamePanelUI_clockwise_rotate_image;
	public Image gamePanelUI_counterclockwise_rotate_image;
	public Image gamePanelUI_flip_image;

	public Image gamePanelUI_mute_image;
	public Image gamePanelUI_next_image;
	public Image gamePanelUI_previous_image;
	public Image gamePanelUI_pause_image;

	public ImageView gamePanelUI_undo_Image;
	public ImageView gamePanelUI_redo_Image;
	public ImageView gamePanelUI_clockwise_rotate_Image;
	public ImageView gamePanelUI_counterclockwise_rotate_Image;
	public ImageView gamePanelUI_flip_Image;

	public ImageView gamePanelUI_mute_Image;
	public ImageView gamePanelUI_next_Image;
	public ImageView gamePanelUI_previous_Image;
	public ImageView gamePanelUI_pause_Image;

	public Resourses() {
		try {
			minecrafter_font_title = Font.loadFont(
					getClass().getResourceAsStream(
							"/application/resourses/Minecraftia2.ttf"),
					title_size);
			minecrafter_font_label = Font.loadFont(
					getClass().getResourceAsStream(
							"/application/resourses/Minecraftia2.ttf"),
					label_size);

			// System.out.println("load font OK!!");

		} catch (Exception e) {
			System.out.println("Load Font error");
		}
		try {
			background_image = new Image(Main.class.getResource(
					"resourses/background.png").toString());

			mainUI_start_image = new Image(Main.class.getResource(
					"resourses/mainUI/start.png").toString());
			mainUI_start_image1 = new Image(Main.class.getResource(
					"resourses/mainUI/start_hover.png").toString());

			mainUI_level_image = new Image(Main.class.getResource(
					"resourses/mainUI/levelselect.png").toString());
			mainUI_level_image1 = new Image(Main.class.getResource(
					"resourses/mainUI/levelselect_hover.png").toString());

			mainUI_scores_image = new Image(Main.class.getResource(
					"resourses/mainUI/score.png").toString());
			mainUI_scores_image1 = new Image(Main.class.getResource(
					"resourses/mainUI/score_hover.png").toString());

			mainUI_exit_image = new Image(Main.class.getResource(
					"resourses/mainUI/exit.png").toString());
			mainUI_exit_image1 = new Image(Main.class.getResource(
					"resourses/mainUI/exit_hover.png").toString());

			LevelUI_images = new ArrayList<Image>();

			for (int i = 0; i < numOfLevel; i++) {
				LevelUI_images.add(new Image(Main.class.getResource(
						"resourses/LevelUI/" + (i + 1) + "_normal.png")
						.toString()));
			}

			//
			gamePanelUI_undo_image = new Image(Main.class.getResource(
					"resourses/GamePanelUI/Function_Buttons/redo.png")
					.toString());
			gamePanelUI_redo_image = new Image(Main.class.getResource(
					"resourses/GamePanelUI/Function_Buttons/redo.png")
					.toString());
			gamePanelUI_clockwise_rotate_image = new Image(
					Main.class
							.getResource(
									"resourses/GamePanelUI/Function_Buttons/clockwise_rotate.png")
							.toString());
			gamePanelUI_counterclockwise_rotate_image = new Image(
					Main.class
							.getResource(
									"resourses/GamePanelUI/Function_Buttons/counterclockwise_rotate.png")
							.toString());
			gamePanelUI_flip_image = new Image(Main.class.getResource(
					"resourses/GamePanelUI/Function_Buttons/Flip.png")
					.toString());

			gamePanelUI_mute_image = new Image(Main.class.getResource(
					"resourses/GamePanelUI/Lower_Buttons/Mute.png").toString());
			gamePanelUI_next_image = new Image(Main.class.getResource(
					"resourses/GamePanelUI/Lower_Buttons/Next.png").toString());
			gamePanelUI_previous_image = new Image(Main.class.getResource(
					"resourses/GamePanelUI/Lower_Buttons/Previous.png")
					.toString());
			gamePanelUI_pause_image = new Image(Main.class.getResource(
					"resourses/GamePanelUI/Lower_Buttons/Pause.png").toString());

		} catch (Exception e) {
			System.out.println("Loading resourses error" + e);

		}

		try {

			background_Image = new ImageView(background_image);

			mainUI_start_Image = new ImageView(mainUI_start_image);
			mainUI_start_Image1 = new ImageView(mainUI_start_image1);
			mainUI_level_Image = new ImageView(mainUI_level_image);
			mainUI_level_Image1 = new ImageView(mainUI_level_image1);
			mainUI_scores_Image = new ImageView(mainUI_scores_image);
			mainUI_scores_Image1 = new ImageView(mainUI_scores_image1);
			mainUI_exit_Image = new ImageView(mainUI_exit_image);
			mainUI_exit_Image1 = new ImageView(mainUI_exit_image1);

			LevelUI_Images = new ArrayList<ImageView>();
			for (int i = 0; i < numOfLevel; i++) {
				ImageView temp = new ImageView(LevelUI_images.get(i));
				LevelUI_Images.add(temp);
			}

			/*
			 * 
			 */
			gamePanelUI_undo_Image = new ImageView(gamePanelUI_undo_image);
			gamePanelUI_redo_Image = new ImageView(gamePanelUI_redo_image);
			gamePanelUI_clockwise_rotate_Image = new ImageView(
					gamePanelUI_clockwise_rotate_image);
			gamePanelUI_counterclockwise_rotate_Image = new ImageView(
					gamePanelUI_counterclockwise_rotate_image);
			gamePanelUI_flip_Image = new ImageView(gamePanelUI_flip_image);

			gamePanelUI_mute_Image = new ImageView(gamePanelUI_mute_image);
			gamePanelUI_next_Image = new ImageView(gamePanelUI_next_image);
			gamePanelUI_previous_Image = new ImageView(
					gamePanelUI_previous_image);
			gamePanelUI_pause_Image = new ImageView(gamePanelUI_pause_image);

		} catch (Exception e) {
			System.out.println("Loading content error" + e);

		}
	}

}
