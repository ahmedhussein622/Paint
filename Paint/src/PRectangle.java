import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JPanel;


public class PRectangle extends PShape{
	
	DragableButton leftUpper,leftButtom,rightUpper,rightButtom,move;
	
	public PRectangle(JPanel p) {
		super(p);
		data.pointX = new int[4];
		data.pointY = new int[4];
		data.type = PData.Rectangle;
		
		leftUpper = new DragableButton(){
			private static final long serialVersionUID = 1L;

		void reacteToDisplacement() {leftUpperMotion();}};
		leftButtom = new DragableButton(){
			private static final long serialVersionUID = 1L;

		void reacteToDisplacement() {leftBottomMotion();}};
		rightButtom = new DragableButton(){
			private static final long serialVersionUID = 1L;

		void reacteToDisplacement() {rightButtomMotion();}};
		rightUpper = new DragableButton(){
			private static final long serialVersionUID = 1L;

		void reacteToDisplacement() {rigthUpperMotion();}};
		move = new DragableButton(){
			private static final long serialVersionUID = 1L;

		void reacteToDisplacement() {moving();}};
		data.parent.add(leftButtom);
		data.parent.add(leftUpper);
		data.parent.add(rightButtom);
		data.parent.add(rightUpper);
		data.parent.add(move);
	}
	
	@Override
	public void paintComponent(Graphics2D g) {
		
		paintShape(g);
		g.setStroke(new BasicStroke(3));
		if(data.selected){
			leftUpper.setLocation(data.pointX[0]-4,data.pointY[0]-4);
			rightUpper.setLocation(data.pointX[1]-4, data.pointY[1]-4);
			rightButtom.setLocation(data.pointX[2]-4, data.pointY[2]-4);
			leftButtom.setLocation(data.pointX[3]-4, data.pointY[3]-4);
			move.setLocation((data.pointX[0]+data.pointX[1])/2-4, (data.pointY[0]+data.pointY[3])/2-4);
			rightButtom.setVisible(true);
			rightUpper.setVisible(true);
			leftButtom.setVisible(true);
			leftUpper.setVisible(true);
			move.setVisible(true);
		}
		
		else {
			rightButtom.setVisible(false);
			rightUpper.setVisible(false);
			leftButtom.setVisible(false);
			leftUpper.setVisible(false);
			move.setVisible(false);
		}
		
	}
	
	void setRectangle(Point a,Point b){
		data.pointX[0] = a.x;
		data.pointY[0] = a.y;
		data.pointX[1] = b.x;
		data.pointY[1] = a.y ;
		data.pointX[2] = b.x;
		data.pointY[2] = b.y;
		data.pointX[3] = a.x;
		data.pointY[3] = b.y;
		
	}
	
	@Override
	boolean contains(Point e) {
		if(!data.filled){
			if(lineContain(data.pointX[0],data.pointY[0], data.pointX[1],data.pointY[1], e, 
				(int)data.stroke.getLineWidth()))return true;
			if(lineContain(data.pointX[1],data.pointY[1], data.pointX[2],data.pointY[2], e, 
					(int)data.stroke.getLineWidth()))return true;
			if(lineContain(data.pointX[3],data.pointY[3], data.pointX[2],data.pointY[2], e, 
					(int)data.stroke.getLineWidth()))return true;
			if(lineContain(data.pointX[0],data.pointY[0], data.pointX[3],data.pointY[3], e, 
					(int)data.stroke.getLineWidth()))return true;
			}
			if(data.filled)
				return new Polygon(data.pointX, data.pointY, 4).contains(e);
			
			return false;
	}
	
	void paintShape(Graphics2D g){
		
		g.setColor(data.color);
		g.setStroke(data.stroke);
		if(data.filled){
			g.fillPolygon(data.pointX, data.pointY, 4);
			return;
		}
		g.drawLine(data.pointX[0], data.pointY[0], data.pointX[1], data.pointY[1]);
		g.drawLine(data.pointX[1], data.pointY[1], data.pointX[2], data.pointY[2]);
		g.drawLine(data.pointX[2], data.pointY[2], data.pointX[3], data.pointY[3]);
		g.drawLine(data.pointX[0], data.pointY[0], data.pointX[3], data.pointY[3]);
		
	}
/////////////////////////////////////////////////////////////////////////////
	// motion
	public void moving(){
		int i;
		for(i = 0; i < 4; i++){
			data.pointX[i]+= move.displacementX;
			data.pointY[i]+= move.displacementY;
		}
		data.parent.repaint();
	}
	
	public void leftUpperMotion(){
		data.pointX[0] += leftUpper.displacementX;
		data.pointY[0] += leftUpper.displacementY;
		
		data.pointY[1] += leftUpper.displacementY;
		data.pointX[3] += leftUpper.displacementX;
		data.parent.repaint();
	}
	
	public void leftBottomMotion(){
		data.pointX[3] += leftButtom.displacementX;
		data.pointY[3] += leftButtom.displacementY;
		
		data.pointY[2] += leftButtom.displacementY;
		data.pointX[0] += leftButtom.displacementX;
		data.parent.repaint();
	}
	
	public void rigthUpperMotion(){
		data.pointX[1] += rightUpper.displacementX;
		data.pointY[1] += rightUpper.displacementY;
		
		data.pointY[0] += rightUpper.displacementY;
		data.pointX[2] += rightUpper.displacementX;
		data.parent.repaint();
	}
	public void rightButtomMotion(){
		data.pointX[2] += rightButtom.displacementX;
		data.pointY[2] += rightButtom.displacementY;
		
		data.pointY[3] += rightButtom.displacementY;
		data.pointX[1] += rightButtom.displacementX;
		data.parent.repaint();
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Override
	public boolean drawByUser(int clicksNumber, boolean moving, int clickX,
			int clickY) {
		
		if(clicksNumber == 0)
			return false;
		setSelected(true);
		if(clicksNumber == 2)
			return true;
		
		
		if(clicksNumber == 1 && !moving){
			setRectangle(new Point(clickX ,clickY), new Point(clickX ,clickY));
			repaint();
			return false;
		}
		
		
		data.pointX[2] = clickX-10;
		data.pointY[2] = clickY-10;
		data.pointX[1] = data.pointX[2];
		data.pointY[1] = data.pointY[0];
		data.pointX[3] = data.pointX[0];
		data.pointY[3] = data.pointY[2];
		repaint();
		
		return false;
	}
}
