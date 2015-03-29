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

	public final Image BACKGROUND_IMAGE = new Image(Main.class.getResource("ui/mainUI/main.png").toString());
	public final Image START_IMAGE = new Image(Main.class.getResource("ui/mainUI/start.png").toString());
	public final Image START_IMAGE1 = new Image(Main.class.getResource("ui/mainUI/start_hover.png").toString());

	public final Image LEVEL_IMAGE = new Image(Main.class.getResource("ui/mainUI/levelselect.png").toString());
	public final Image LEVEL_IMAGE1 = new Image(Main.class.getResource("ui/mainUI/levelselect_hover.png").toString());

	
	public final Image SCORES_IMAGE = new Image(Main.class.getResource("ui/mainUI/score.png").toString());
	public final Image SCORES_IMAGE1 = new Image(Main.class.getResource("ui/mainUI/score_hover.png").toString());
	
	
	public final Image EXIT_IMAGE = new Image(Main.class.getResource("ui/mainUI/exit.png").toString());
	public final Image EXIT_IMAGE1 = new Image(Main.class.getResource("ui/mainUI/exit_hover.png").toString());

	public ImageView backgroundImage;
	public ImageView startImage;
	public ImageView startImage1;
	public ImageView levelImage;
	public ImageView levelImage1;
	public ImageView scoresImage;
	public ImageView scoresImage1;
	public ImageView exitImage;
	public ImageView exitImage1;
	
	public Resourses() {
	
		try{
			backgroundImage = new ImageView(BACKGROUND_IMAGE);
			startImage = new ImageView(START_IMAGE);
			startImage1 = new ImageView(START_IMAGE1);
			levelImage = new ImageView(LEVEL_IMAGE);
			levelImage1 = new ImageView(LEVEL_IMAGE1);
			scoresImage = new ImageView(SCORES_IMAGE);
			scoresImage1 = new ImageView(SCORES_IMAGE1);
			exitImage = new ImageView(EXIT_IMAGE);
			exitImage1 = new ImageView(EXIT_IMAGE1);
		} catch (Exception e){
			
		}
	}
	
}
