package gameButtons;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

public class InGamePanel extends JPanel implements Observer{
	

		private JScrollPane m_gameSetupPanelScroll;
		private JButton pauseButton;  // Pause the game
		private JButton resumeButton; //resume the game
		private JButton restartButton; //restart the game
		private JButton saveButton; //save the game
		private JButton mainMenuButton; //GO back to Main Menu
		private JButton backButton; //Go back to previous page
		private JButton quitButton; //Quit the Game
		//following the game control button
		private JButton flipButton;  // flip the shape
		private JButton turningButton;  // turn the shape into different angle, can be discussed later
		private JButton redoButton;  // go to the previous step

		
		private void createComponents()
		{ // Create all the buttons
			pauseButton = new JButton("Pause");
			pauseButton.setToolTipText("<html>Start your game! <br>If not enabled, then you must select a way to play your game first: <br>Play Online, or Local Game, or PBEM, or Host Networked.</html>");
			resumeButton = new JButton("Resume");
			resumeButton.setToolTipText("");
			restartButton = new JButton("Restart");
			restartButton.setToolTipText("Restart the game");
			saveButton = new JButton("Save");
			saveButton.setToolTipText("Save the Game");
			mainMenuButton = new JButton("MainMenu");
			mainMenuButton.setToolTipText("Go back to main menu");
			backButton = new JButton("Cancel");
			backButton.setToolTipText("Go back to previous page.");
			quitButton = new JButton("Quit");
			quitButton.setToolTipText("Close the puzzle game");
			//following the game control button
			flipButton = new JButton("Flip");
			flipButton.setToolTipText("Flip the selected shape");
			turningButton = new JButton("Flip");
			turningButton.setToolTipText("Flip the selected shape");
			redoButton = new JButton("Redo");
			redoButton.setToolTipText("redo the last step");

		}
		
		private void layoutComponents()
		{
			final JPanel buttonsPanel = new JPanel();
			buttonsPanel.setBorder(new EtchedBorder());
			buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			buttonsPanel.add(newGameButton);
			buttonsPanel.add(quitButton);
			setLayout(new GridBagLayout());
			add(m_gameSetupPanelScroll, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(00, 0, 0, 0), 0, 0));

		}
		
		private void setupListeners()
		{
		
		}
		
		public static void main(final String[] args)
		{
			final JFrame f = new JFrame();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.pack();
			f.setVisible(true);
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}
}
		

