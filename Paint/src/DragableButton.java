import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;


public class DragableButton extends JButton implements MouseListener,MouseMotionListener,KeyListener {
	
	
	private static final long serialVersionUID = 1L;
	public int displacementX,displacementY,draggingX,draggingY;
	private boolean pressed;
	
	DragableButton(){
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		pressed = false;
		
		setSize(8, 8);
		
	}
	
	void reacteToDisplacement(){
		
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		requestFocus();
		if(!pressed)
			return;
		
		displacementX = e.getX() - draggingX;
		displacementY = e.getY() - draggingY;
		draggingX = e.getX();
		draggingY = e.getY();
		reacteToDisplacement();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressed = true;
		draggingX = e.getX();
		draggingY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		pressed = false;
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		displacementX = 0;
		displacementY = 0;
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			displacementY =-1;
			break;
		case KeyEvent.VK_DOWN:
			displacementY = 1;
			break;
		case KeyEvent.VK_LEFT:
			displacementX =-1;
			break;
		case KeyEvent.VK_RIGHT:
			displacementX = 1;
			break;
		default:return;
		}
		
		reacteToDisplacement();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
