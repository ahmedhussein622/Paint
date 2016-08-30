import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.text.PlainDocument;


public class ShapesToolBar extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	JButton fill,unfill;
	JComboBox lineSize;
	PaintGUI parent;
	ArrayList<ShapeButton> shapeButton;
	
	int clicksNumber,mouseX,mouseY,clickX,clickY;
	PShape currentShape;
	JPanel t;
	
	
	public ShapesToolBar(PaintGUI p) {
		
		parent = p;
		PressingListener pressingListener = new PressingListener();
		parent.drawingSurface.addMouseListener(pressingListener);
		parent.drawingSurface.addMouseMotionListener(pressingListener);
		
		fill = new JButton(new ImageIcon("image/fill.png"));
		unfill = new JButton(new ImageIcon("image/unfill.png"));
		String a[] = new String[20];
		for(int i = 0; i < 20; i++)
			a[i] = ""+(i+1);
		lineSize = new JComboBox(a);
		lineSize.setEditable(true);
		clicksNumber = 0;
		
		shapeButton = new ArrayList<ShapeButton>();
		
	////////////////////////////////////////////////////
		SelectedButton buttonListener = new SelectedButton();
	
		
		fill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill.setBackground(Color.yellow);
				unfill.setBackground(null);
				parent.drawingfill = true;
				parent.setFilled(true);
			}
		});
		unfill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unfill.setBackground(Color.yellow);
				fill.setBackground(null);
				parent.drawingfill = false;
				parent.setFilled(false);
			}
		});
		
		lineSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox a = (JComboBox)e.getSource();
				String y  = (String)a.getSelectedItem();
				int x;
				try{
					 x = Integer.parseInt(y);
				}catch(Exception c){return;};
				if (x < 0)
					return;
				
				parent.drawingStroke = x;
				parent.setStroke(x);
			}
		});

		
	///////////////////////////////////////////////////
		
		
		lineSize.setMaximumSize(new Dimension(200,100));
		
		t = new JPanel();
		t.setLayout(new GridLayout(0,2));
		JPanel k = new JPanel();
		k.setLayout(new GridLayout(0,2));
		k.add(fill);
		k.add(unfill);
			
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(t);
		add(k);
		add(lineSize);
		add(Box.createRigidArea(new Dimension(10,600)));
	// load some default shapes
		Class cl;
		
		try{
			cl = ClassLoader.getSystemClassLoader().loadClass("PLine");
		addNewShape(cl, new ImageIcon("image/PLine.png"));
		}catch(Exception e){}
		
		try{
			cl = ClassLoader.getSystemClassLoader().loadClass("PCircle");
		addNewShape(cl, new ImageIcon("image/PCircle.png"));
		}catch(Exception e){}
		
		try{
			cl = ClassLoader.getSystemClassLoader().loadClass("PEllipse");
		addNewShape(cl, new ImageIcon("image/PEllipse.png"));
		}catch(Exception e){}
		
		try{
			cl = ClassLoader.getSystemClassLoader().loadClass("PRectangle");
		addNewShape(cl, new ImageIcon("image/PRectagnle.png"));
		}catch(Exception e){}
		
		try{
			cl = ClassLoader.getSystemClassLoader().loadClass("PSquare");
		addNewShape(cl, new ImageIcon("image/PSquare.png"));
		}catch(Exception e){}
		
		try{
			cl = ClassLoader.getSystemClassLoader().loadClass("PTriangle");
		addNewShape(cl, new ImageIcon("image/PTriangle.png"));
		}catch(Exception e){}
	}
/////////////////////////////////////////////////////////////////////////////////////
	
	public void addNewShape(Class a, ImageIcon image){

		
		ShapeButton k = new ShapeButton(a);
		if(image != null)
			k.setIcon(image);
		else
			k.setText(a.getName());
		shapeButton.add(k);
		
		t.add(k);
		t.repaint();
		
	}
	
//////////////////////////////////////////////////////////////////////////////////////	
	
	public class PressingListener extends MouseAdapter{
		
		public void mousePressed(MouseEvent e) {
			if(currentShape == null)
				return;
			clicksNumber++;
			if(currentShape.drawByUser(clicksNumber, false, e.getX(), e.getY())){
				clicksNumber = 0;
				currentShape = null;
			}
		}
		
		public void mouseMoved(MouseEvent e) {
			if(currentShape == null)
				return;
			if(currentShape.drawByUser(clicksNumber, true, e.getX(), e.getY())){
				clicksNumber = 0;
				currentShape = null;
			}	
		}
		
	}
/////////////////////////////////////////////////////////////////////////////
	
	public class ShapeButton extends JButton{
		Class shape;
		Constructor c ;
		public ShapeButton(Class a) {
			shape = a;
			
			c = null;
			try {
				 c = shape.getConstructor(JPanel.class);
				
			} catch (Exception e1) {}
			addActionListener(new SelectedButton(){
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						
						currentShape = (PShape)c.newInstance(parent.drawingSurface);
					} catch (Exception e1) {}
					super.actionPerformed(e);
				}
			});
		}
	}
	
	public class SelectedButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			currentShape.setColor(parent.drawingColor);
			currentShape.setFilled(parent.drawingfill);
			currentShape.setStroke(new BasicStroke(parent.drawingStroke));
			currentShape.setSelected(true);
			parent.shapes.add(currentShape);
			parent.undoStack.add(new ChangeAction(currentShape,ChangeAction.created));
		}
	}
}
