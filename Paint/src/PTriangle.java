import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JPanel;


public class PTriangle extends PShape {
	
	
	int tmpX,tmpY;
	DragableButton move,firstPoint,secondPoint,thirdPoint;
	
	public PTriangle(JPanel p) {
		super(p);
		data.pointX = new int[3];
		data.pointY = new int[3];
		data.selected = true;
		data.type = PData.Triagle;
		
		move = new DragableButton(){
			
			private static final long serialVersionUID = 1L;

			void reacteToDisplacement() {
				moveTriangle();
			}
		};
		firstPoint = new DragableButton(){
			
			private static final long serialVersionUID = 1L;

			@Override
			void reacteToDisplacement() {
				moveFirstPoint();
			}
		};
		secondPoint = new DragableButton(){
			
			private static final long serialVersionUID = 1L;

			@Override
			void reacteToDisplacement() {
				moveSecondPoint();
			}
		};
		thirdPoint = new DragableButton(){
			
			private static final long serialVersionUID = 1L;

			@Override
			void reacteToDisplacement() {
				moveThirdPoint();
			}
		};
		
		data.parent.add(move);
		data.parent.add(firstPoint);
		data.parent.add(secondPoint);
		data.parent.add(thirdPoint);
	}

	@Override
	public void paintComponent(Graphics2D g) {

		
		g.setColor(data.color);
		g.setStroke(data.stroke);
		if(!data.filled){
			g.draw(new Polygon(data.pointX, data.pointY, 3));
		}
		else {
			g.fillPolygon(data.pointX, data.pointY, 3);
		}
		g.setStroke(new BasicStroke(3));
		if(data.selected){
			firstPoint.setLocation(data.pointX[0], data.pointY[0]);
			secondPoint.setLocation(data.pointX[1],data.pointY[1]);
			thirdPoint.setLocation(data.pointX[2],data. pointY[2]);
			tmpX = (data.pointX[0] + data.pointX[1] + data.pointX[2])/3;
			tmpY = (data.pointY[0] +data. pointY[1] + data.pointY[2])/3;
			move.setLocation(tmpX, tmpY);
			
			move.setVisible(true);
			firstPoint.setVisible(true);
			secondPoint.setVisible(true);
			thirdPoint.setVisible(true);
		}
		else{
			move.setVisible(false);
			firstPoint.setVisible(false);
			secondPoint.setVisible(false);
			thirdPoint.setVisible(false);
		}
	}
	
	public void setFirstPoint(Point e){
		data.pointX[0] = e.x;
		data.pointY[0] = e.y;
	}
	public void setSecondPoint(Point e){
		data.pointX[1] = e.x;
		data.pointY[1] = e.y;
	}
	public void setThirdtPoint(Point e){
		data.pointX[2] = e.x;
		data.pointY[2] = e.y;
	}
////////////////////////////////////////////////////////////////////////////////////
	void moveTriangle(){
		int i;
		for( i = 0 ; i < 3; i++)
			data.pointX[i]+= move.displacementX;
		for( i = 0 ; i < 3; i++)
			data.pointY[i]+= move.displacementY;
		data.parent.repaint();
	}
	
	void moveFirstPoint(){
		data.pointX[0] += firstPoint.displacementX;
		data.pointY[0] += firstPoint.displacementY;
		data.parent.repaint();
	}
	void moveSecondPoint(){
		data.pointX[1] += secondPoint.displacementX;
		data.pointY[1] += secondPoint.displacementY;
		data.parent.repaint();
	}
	void moveThirdPoint(){
		data.pointX[2] += thirdPoint.displacementX;
		data.pointY[2] += thirdPoint.displacementY;
		data.parent.repaint();
	}
	
	@Override
	boolean contains(Point e) {
		if(!data.filled){
		if(lineContain(data.pointX[0],data.pointY[0], data.pointX[1],data.pointY[1], e, 
			(int)data.stroke.getLineWidth()))return true;
		if(lineContain(data.pointX[1],data.pointY[1], data.pointX[2],data.pointY[2], e, 
				(int)data.stroke.getLineWidth()))return true;
		if(lineContain(data.pointX[0],data.pointY[0], data.pointX[2],data.pointY[2], e, 
				(int)data.stroke.getLineWidth()))return true;
		}
		else if(data.filled)
			return new Polygon(data.pointX, data.pointY, 3).contains(e);
		
		return false;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public boolean drawByUser(int clicksNumber, boolean moving, int clickX,
			int clickY) {
		
		if(clicksNumber == 0)
			return false;
		
		setSelected(true);
		if(clicksNumber == 3)
			return true;
		
		
		if(clicksNumber == 1 && !moving){
			
			for(int i = 0; i < 3; i++){
				data.pointX[i] = clickX;
				data.pointY[i] = clickY;
			}
			repaint();
			return false;
		}
		
		if(clicksNumber == 1 || (clicksNumber == 2 && !moving)){
			for(int i = 1; i < 3; i++){
				data.pointX[i] = clickX-10;
				data.pointY[i] = clickY-10;
			}
			repaint();
			return false;
		}
		
		data.pointX[2] = clickX -10;
		data.pointY[2] = clickY -10;
		repaint();
		
		return false;
	}
	
	
}
