package puzzleGame;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;

public class GameController implements MouseListener {
	public void mousePressed(MouseEvent e) {
		saySomething("Mouse pressed; # of clicks: " + e.getClickCount(), e);
	}

	public void mouseReleased(MouseEvent e) {
		saySomething("Mouse released; # of clicks: " + e.getClickCount(), e);
	}

	public void mouseEntered(MouseEvent e) {
		saySomething("Mouse entered", e);
	}

	public void mouseExited(MouseEvent e) {
		saySomething("Mouse exited", e);
	}

	public void mouseClicked(MouseEvent e) {
		saySomething("Mouse clicked (# of clicks: " + e.getClickCount() + ")",
				e);
	}

	void saySomething(String eventDescription, MouseEvent e) {
		textArea.append(eventDescription + " detected on "
				+ e.getComponent().getClass().getName() + "." + newline);
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g) {

		    }
}
