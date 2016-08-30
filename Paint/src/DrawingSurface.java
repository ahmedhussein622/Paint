import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class DrawingSurface extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	public ArrayList<PShape> shapes;
	private ArrayList<PShape> selectedShapes;
	private ArrayList<PShape> tmp;
	DrawingSurface(ArrayList<PShape> s){
		shapes = s;
		setLayout(null);
		selectedShapes = new ArrayList<PShape>();
		tmp = new ArrayList<PShape>();
		setBorder(BorderFactory.createEtchedBorder());
		setBackground(Color.white);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		selectedShapes.clear();
		tmp.clear();
		for(int i = 0; i < shapes.size(); i++){
			if(shapes.get(i).isSelected())
				selectedShapes.add(shapes.get(i));
			else
				tmp.add(shapes.get(i));
		}
		shapes.clear();
		for(int i = 0; i < tmp.size();i++)
			shapes.add(tmp.get(i));
		for(int i = 0; i < selectedShapes.size();i++)
			shapes.add(selectedShapes.get(i));
		for(int i = 0; i < shapes.size(); i++)
			shapes.get(i).paintComponent(g2);
	}
}
