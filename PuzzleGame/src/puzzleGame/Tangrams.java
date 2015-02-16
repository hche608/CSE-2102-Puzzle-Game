package puzzleGame;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tangrams extends JFrame {
	private Label _label;
	
<<<<<<< HEAD
/*	
	public void Tangrams() {
=======
	
	public Tangrams() {
>>>>>>> 2d1c4c638e15e82c0bae9ae4f2443d2d48db1b10
		this.setSize(300, 300);
		this.setVisible(true);
		
		_label = new Label("Tangram Game", Label.CENTER);
		add(_label);
		
	}*/
    public Tangrams() {
        setTitle("Tangram Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Container cp = getContentPane();
        
        
        setPreferredSize(new Dimension(300, 300));
        pack();
    }

	public static void main(String[] args) {
		//Tangrams tangrams = new Tangrams();
		
		new Tangrams().setVisible(true);
	}


}
