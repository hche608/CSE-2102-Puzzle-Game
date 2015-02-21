package puzzleGame;
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Tangrams extends JFrame {
	//private Label _label;
	private final PlayArea playArea;
	private Player player;

/*	
	public void Tangrams() {

	
	public Tangrams() {

		this.setSize(300, 300);
		this.setVisible(true);
		
		_label = new Label("Tangram Game", Label.CENTER);
		add(_label);
		
	}*/
    public Tangrams() {
        setTitle("Tangram Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();
        
        playArea = new PlayArea();
        cp.add(playArea, BorderLayout.CENTER);
        
        // Set up menu bar:
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        
        menuBar.add(fileMenu);
        
        JMenuItem newgame = fileMenu.add("New Game");
        newgame.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent e) {
        		player.setPlayerName(JOptionPane.showInputDialog("Please input your name: "));
        	}
        });
		JMenuItem pause = fileMenu.add("Pause Game");
		JMenuItem resume = fileMenu.add("Resume Game");
		JMenuItem scores = fileMenu.add("Scores");

        
        fileMenu.addSeparator();

        JMenuItem ExitGame = new JMenuItem("Exit", KeyEvent.VK_X);
        ExitGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        ExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (JOptionPane.showConfirmDialog(playArea,
                        "Really exit from Game?",
                        "Please confirm",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            		System.exit(0);
            	}
            	
            }
        });
        fileMenu.add(ExitGame);
        
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(helpMenu);
        
        
        
        // Set initial dimension and pack:
        setPreferredSize(new Dimension(800, 600));
        pack();
    }

	public static void main(String[] args) {
		//Tangrams tangrams = new Tangrams();
		
		new Tangrams().setVisible(true);
	}


}
