import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;

import org.omg.CORBA.UserException;


public class DrawingButton extends JButton {
	
	protected PData data;
	protected DrawingSurface drawingSurface;
	protected ArrayList<PShape> shapes;
	public boolean enabled,shapeCreated;
	public int clicksNumber;
	protected PShape currentShape;
	Stack<ChangeAction> undoStack;
	
	DrawingButton(PData p, DrawingSurface d,ArrayList<PShape> a,Stack<ChangeAction> s) {
		
		data = p;
		drawingSurface = d;
		shapes = a;
		undoStack = s;
		
		enabled = false;
		clicksNumber = 0;
		shapeCreated = false;
		currentShape = null;
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enabled = true;
			}
		});
		
		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!enabled)
					return;
				clicksNumber++;
				userDrawing(e);
			}
			
			public void mouseMoved(MouseEvent e) {
				if(!enabled)
					return;
				userDrawing(e);
			}
		};
		
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
		
	}
	
	 DrawingButton(){
		
		enabled = false;
		clicksNumber = 0;
		shapeCreated = false;
		currentShape = null;
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enabled = true;
			}
		});
		
		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!enabled)
					return;
				clicksNumber++;
				userDrawing(e);
			}
			
			public void mouseMoved(MouseEvent e) {
				if(!enabled)
					return;
				userDrawing(e);
			}
		};
		
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
		
	}
	
	
	protected void userDrawing(MouseEvent e){ // handle user drawings will be overridden later
		
		// set enabled to false after finishing drawing
		// set clicksNumber to 0 after finishing drawing
	}
	
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////	
	
	
							  /////////////////////////
							 // setters and getters //
							/////////////////////////
	
	public PData getData() {
		return data;
	}
	public void setData(PData data) {
		this.data = data;
	}
	public DrawingSurface getDrawingSurface() {
		return drawingSurface;
	}
	public void setDrawingSurface(DrawingSurface drawingSurface) {
		this.drawingSurface = drawingSurface;
	}
	public ArrayList<PShape> getShapes() {
		return shapes;
	}
	public void setShapes(ArrayList<PShape> shapes) {
		this.shapes = shapes;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
