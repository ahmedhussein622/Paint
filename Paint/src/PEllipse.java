
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;



public class PEllipse extends PRectangle{
	
	public PEllipse(JPanel p) {
		super(p);
		data.type = PData.Ellipse;
	}
	
	@Override
	void paintShape(Graphics2D g) {
		orderPoints();
		g.setColor(data.color);
		g.setStroke(data.stroke);
		// get correct corner points
		int bigX,bigY,smallX,smallY;
		bigX = Math.max(data.pointX[0], Math.max(data.pointX[1],data.pointX[2]));
		bigY = Math.max(data.pointY[0], Math.max(data.pointY[1],data.pointY[2]));
		smallX = Math.min(data.pointX[0], Math.min(data.pointX[1],data.pointX[2]));
		smallY = Math.min(data.pointY[0], Math.min(data.pointY[1],data.pointY[2]));
		
		if(!data.filled)
		g.drawOval(smallX, smallY,Math.abs(bigX-smallX),
				Math.abs(bigY-smallY));
		else{
			g.fillOval(smallX, smallY,Math.abs(bigX-smallX),
					Math.abs(bigY-smallY));
		}
	}
	
	void setEllipsePoint(Point a,Point b){
		super.setRectangle(a, b);
	}
	
	void orderPoints(){// order the points
		

	}
	
	boolean contains(Point e) {
		
		
		int bigX,bigY,smallX,smallY;
		bigX = Math.max(data.pointX[0], Math.max(data.pointX[1],data.pointX[2]));
		bigY = Math.max(data.pointY[0], Math.max(data.pointY[1],data.pointY[2]));
		smallX = Math.min(data.pointX[0], Math.min(data.pointX[1],data.pointX[2]));
		smallY = Math.min(data.pointY[0], Math.min(data.pointY[1],data.pointY[2]));
		
		
		double y,h,k,a,b;
		a = Math.abs(bigX-smallX)/2;
		b = Math.abs(bigY-smallY)/2;
		h = smallX+a;
		k = smallY+b;
		
		y = b*Math.sqrt((1-Math.pow((e.x-h)/a, 2)))+k;
		if(!data.filled){
			if(Math.abs(y-e.y) <= data.stroke.getLineWidth())
				return true;
			if(Math.abs(2*k-y-e.y) <= data.stroke.getLineWidth())
				return true;
		}
		else if(e.y <= y && e.y >= 2*k-y)
			return true;
		
		return false;
	}
//////////////////////////////////////////////////////////////////////////////////////////

}
