import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;


public abstract class PShape {
	
	
	PData data;
	
	public PShape(JPanel parent) {
		data  = new PData();
		data.parent = parent;
		data.color = Color.black;
		data.stroke = new BasicStroke(2);
		data.filled =  false;
		parent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				boolean t = contains(e.getPoint());
				if(data.selected && !t){
					if(e.isControlDown())
						return;
					data.selected = false;
					repaint();
				}
				else if(!data.selected && t){
					data.selected = true;
					repaint();
				}
			}
		});
		
	}

	public void repaint(){data.parent.repaint();}
	public void paintComponent(Graphics2D g) {
		
	}
	
	 boolean contains(Point e){
		return false;
	}
	
	 public boolean isSelected(){
		 return data.selected;
	 }
	 
	public void setColor(Color d){
		data.color = d;
	}
	public void setFilled(boolean f){
		data.filled = f;
	}
	Color getColor(){
		return data.color;
	}
	public void setData(PData d){
		data = d;
	}
	public PData getDataCopy(){
		return data.getCopy();
	}
	void setSelected(boolean f){
		data.selected = f;
	}
	boolean  isFilled(){
		return data.filled;
	}
	
	BasicStroke getStroke(){
		return data.stroke;
	}
	public void setStroke(BasicStroke s){
		data.stroke = s;
	}
	
	public static boolean lineContain(int x1,int y1,int x2,int y2,Point e ,int tolerance){
		
		tolerance+= 5;
		int tmp,smale,big;
		double lineSlope,lineConstant;
		smale = x1;
		big = x2;
		
		if(smale > big ){tmp = smale;smale = big; big = tmp;}
		if(x1 != x2 && (e.x < smale || e.x > big))
			return false;
		
		smale = y1;
		big = y2;
		if(smale > big){tmp = smale;smale = big; big = tmp;}
		if(y1 != y2 && (e.y < smale || e.y > big))
			return false;
		
		if(y1  == y2){
			
			return Math.abs(y1 - e.y) <= tolerance; 
		}
		if(x1 == x2){
			return Math.abs(x1 - e.x) <= tolerance; 
		}
		
		lineSlope = - ((double)y1 - y2)/(x1 - x2);
		lineConstant = - (y1 +lineSlope*x1);
		double x = Math.abs( lineSlope*e.x+e.y+lineConstant)/Math.sqrt(lineSlope*lineSlope+1);
		if(x <= tolerance)
			return true;
		
		return false;
	}
	
////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean drawByUser(int clicksNumber,boolean moving,int clickX,int clickY){
		
		return true;
	}

}
