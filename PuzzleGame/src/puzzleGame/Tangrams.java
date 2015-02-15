package puzzleGame;
import javax.swing.*;
import java.awt.*;

public class Tangrams extends JFrame {
	private Label _label;
	
	
	public void Tangrams() {
		this.setSize(300, 300);
		this.setVisible(true);
		
		_label = new Label("Tangram Game", Label.CENTER);
		add(_label);
		
	}

	public static void main(String[] args) {
		Tangrams tangrams = new Tangrams();
	}
}
