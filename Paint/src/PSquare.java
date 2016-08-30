import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;


public class PSquare extends PRectangle {
	
	int centerX,centerY;
	public PSquare(JPanel p) {
		super(p);
		data.type = PData.Square;
	}
	
	
	public void checkSquare(){
		int maxLlength = Math.max(Math.abs(data.pointX[0]-data.pointX[2]), 
				Math.abs(data.pointY[0]-data.pointY[2]));
	
		int minlength = Math.min(Math.abs(data.pointX[0]-data.pointX[2]), 
				Math.abs(data.pointY[0]-data.pointY[2]));
		
		int average = (maxLlength+minlength)/4;
		data.pointX[0] = centerX- average;
		data.pointY[0] = centerY- average;
		
		data.pointX[1] = centerX+ average;
		data.pointY[1] = centerY- average;
		
		data.pointX[2] = centerX+ average;
		data.pointY[2] = centerY+ average;
		
		data.pointX[3] = centerX- average;
		data.pointY[3] = centerY+ average;
	}
	
	public void moving(){
		
		int i;
		centerX += move.displacementX;
		centerY+= move.displacementY;
		for(i = 0; i < 4; i++){
			data.pointX[i] += move.displacementX;
			data.pointY[i] += move.displacementY;
		}
		data.parent.repaint();
		
	}
	
	@Override
	public void paintComponent(Graphics2D g) {
		checkSquare();
		super.paintComponent(g);
	}
	
//////////////////////////////////////////////////////////////////////////////////////
	
	public boolean drawByUser(int clicksNumber, boolean moving, int clickX,
			int clickY) {
		
		if(clicksNumber == 0)
			return false;
		setSelected(true);
		if(clicksNumber == 2){
			return true;
		}
				
		if(clicksNumber == 1 && !moving){
			
			centerX = clickX;
			centerY = clickY;
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