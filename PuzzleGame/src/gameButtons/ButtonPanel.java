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

public class ButtonPanel extends JPanel implements Observer{
	

		private JScrollPane m_gameSetupPanelScroll;
		private JButton newGameButton;  //New Game Button
		private JButton loadGameButton; //Load Game Button
		private JButton instrButton; //Instruction
		private JButton backButton; //Go back to previous page
		private JButton quitButton; //Quit the Game

		
		private void createComponents()
		{ // create all the buttons
			newGameButton = new JButton("Play");
			newGameButton.setToolTipText("<html>Start your game! <br>If not enabled, then you must select a way to play your game first: <br>Play Online, or Local Game, or PBEM, or Host Networked.</html>");
			quitButton = new JButton("Quit");
			quitButton.setToolTipText("Close the puzzle game");
			backButton = new JButton("Cancel");
			backButton.setToolTipText("Go back to main screen.");
			instrButton = new JButton("Instruction");
			instrButton.setToolTipText("Open the instruction page");

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
		




