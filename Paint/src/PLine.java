import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;


public class PLine extends PShape {
	
	
	
	DragableButton move,endPoint,startPoint;
	int lineSlope,lineConstant;
	
	
	
	public PLine(JPanel parent) {
		super(parent);
		data.pointX = new int[2];
		data.pointY = new int[2];
		data.selected = true;
		data.type = PData.Line;
		
		startPoint = new DragableButton(){
			
			private static final long serialVersionUID = 1L;

			void reacteToDisplacement() {
				moveStartPoint();
			};
		};
		endPoint = new DragableButton(){
			
			private static final long serialVersionUID = 1L;

			@Override
			void reacteToDisplacement() {
				moveEndPoint();
			}
		};
		move = new DragableButton(){
			
			private static final long serialVersionUID = 1L;

			@Override
			void reacteToDisplacement() {
				 movePLine();
			}
		};
		parent.add(startPoint);
		parent.add(endPoint);
		parent.add(move);
		startPoint.setSize(8,8);
		endPoint.setSize(8,8);
	
	}
	
	@Override
	public void paintComponent(Graphics2D g) {
		
		g.setColor(data.color);
		g.setStroke(data.stroke);
		g.drawLine(data.pointX[0], data.pointY[0],data.pointX[1], data.pointY[1]);
		g.setStroke(new BasicStroke(3));
		if(data.selected){
			startPoint.setLocation(data.pointX[0], data.pointY[0]);
			startPoint.setVisible(true);
			endPoint.setLocation(data.pointX[1], data.pointY[1]);
			endPoint.setVisible(true);
			move.setLocation((data.pointX[0]+data.pointX[1])/2,(data.pointY[0]+data.pointY[1])/2);
			move.setVisible(true);
		}
		else{
			startPoint.setVisible(false);
			endPoint.setVisible(false);
			move.setVisible(false);
		}
	}
	
	@Override
	boolean contains(Point e) {
		return lineContain(data.pointX[0],data.pointY[0],data.pointX[1],data.pointY[1],
				e, (int)data.stroke.getLineWidth());
	}
	
	
/////////////////////////////////////////////////////////////////////////
	// motion
	void movePLine(){
		
		data.pointX[0]+= move.displacementX;
		data.pointY[0]+= move.displacementY;
		data.pointX[1]+= move.displacementX;
		data.pointY[1]+= move.displacementY;
		data.parent.repaint();
	}
	void moveEndPoint(){
		data.pointX[1]+= endPoint.displacementX;
		data.pointY[1]+= endPoint.displacementY;
		data.parent.repaint();
	}
	void moveStartPoint(){
		data.pointX[0]+= startPoint.displacementX;
		data.pointY[0]+= startPoint.displacementY;
		data.parent.repaint();
	}
////////////////////////////////////////////////////////
	public void setStartPoint(Point p){
		data.pointX[0] = p.x;
		data.pointY[0] = p.y;
	}
	public void setEndPoint(Point p){
		data.pointX[1] = p.x;
		data.pointY[1] = p.y;
	}
	
/////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public boolean drawByUser(int clicksNumber,boolean moving, int clickX,int clickY) {
		
		if(clicksNumber == 0)
			return false;
		
		if(clicksNumber == 1 && !moving){
			data.pointX[0] = clickX;
			data.pointY[0] = clickY;
			data.pointX[1] = clickX;
			data.pointY[1] = clickY;
			repaint();
			return false;
		}
		else if(clicksNumber == 1){
			data.pointX[1] = clickX-10;
			data.pointY[1] = clickY-10;
			repaint();
			return false;
		}
		
		data.pointX[1] = clickX-10;
		data.pointY[1] = clickY-10;
		repaint();
		return true;
	}
//////////////////////////////////////////////////////////////////////////////////////
	
	
}
