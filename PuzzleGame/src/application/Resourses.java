package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Resourses {
	
	public final int FRAME_WIDTH = 800;	
	public final int FRAME_HEIGHT = 600;
	public final int BTNS_WIDTH = 300;
	public final int BTNS_HEIGHT = 250;
	
	public final int BTN_MINWIDTH = 70;
	public final int BTN_MINHEIGHT = 50;
	
	public Image background_image;
	
	/*
	 * Resources for main UI 
	 */
	public Image mainUI_background_image;
	public Image mainUI_start_image;
	public Image mainUI_start_image1;

	public Image mainUI_level_image;
	public Image mainUI_level_image1;

	public Image mainUI_scores_image;
	public Image mainUI_scores_image1;
	
	public Image mainUI_exit_image;
	public Image mainUI_exit_image1;

	public ImageView background_Image;
	public ImageView mainUI_background_Image;
	public ImageView mainUI_start_Image;
	public ImageView mainUI_start_Image1;
	public ImageView mainUI_level_Image;
	public ImageView mainUI_level_Image1;
	public ImageView mainUI_scores_Image;
	public ImageView mainUI_scores_Image1;
	public ImageView mainUI_exit_Image;
	public ImageView mainUI_exit_Image1;
	
	
	/*
	 * Resources for main UI 
	 */


	
	
	/*
	 * Resources for GamePanel UI 
	 */
	
	
	public Resourses() {

		try{
			background_image = new Image(Main.class.getResource("resourses/background.png").toString());
			
			mainUI_background_image = new Image(Main.class.getResource("resourses/mainUI/main.png").toString());
			
			mainUI_start_image = new Image(Main.class.getResource("resourses/mainUI/start.png").toString());
			mainUI_start_image1 = new Image(Main.class.getResource("resourses/mainUI/start_hover.png").toString());

			mainUI_level_image = new Image(Main.class.getResource("resourses/mainUI/levelselect.png").toString());
			mainUI_level_image1 = new Image(Main.class.getResource("resourses/mainUI/levelselect_hover.png").toString());

			mainUI_scores_image = new Image(Main.class.getResource("resourses/mainUI/score.png").toString());
			mainUI_scores_image1 = new Image(Main.class.getResource("resourses/mainUI/score_hover.png").toString());
			
			mainUI_exit_image = new Image(Main.class.getResource("resourses/mainUI/exit.png").toString());
			mainUI_exit_image1 = new Image(Main.class.getResource("resourses/mainUI/exit_hover.png").toString());

			// 
			
			
			
		} catch (Exception e){
			System.out.println("Loading resourses error");
		}
		
		try{

			background_Image = new ImageView(background_image);
			
			mainUI_background_Image = new ImageView(mainUI_background_image);
			mainUI_start_Image = new ImageView(mainUI_start_image);
			mainUI_start_Image1 = new ImageView(mainUI_start_image1);
			mainUI_level_Image = new ImageView(mainUI_level_image);
			mainUI_level_Image1 = new ImageView(mainUI_level_image1);
			mainUI_scores_Image = new ImageView(mainUI_scores_image);
			mainUI_scores_Image1 = new ImageView(mainUI_scores_image1);
			mainUI_exit_Image = new ImageView(mainUI_exit_image);
			mainUI_exit_Image1 = new ImageView(mainUI_exit_image1);
			
			
			
		} catch (Exception e){
			
		}
	}
	
}
