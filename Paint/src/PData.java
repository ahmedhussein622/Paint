import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.JPanel;


public class PData {
	
	public static final int Line = 0;
	public static final int Rectangle = 1;
	public static final int Square = 2;
	public static final int Ellipse = 3;
	public static final int Circle = 4;
	public static final int Triagle = 5;
	public static final int nothing = 10;
	int [] pointX,pointY;
	Color color;
	BasicStroke stroke;
	JPanel parent;
	boolean selected;
	boolean filled;
	int type;
	
	public PData getCopy(){
		
		PData result = new PData();
		result.color = color;
		result.selected = selected;
		result.filled = filled;
		result.parent = parent;
		result.stroke  = stroke;
		result.pointX = new int[pointX.length];
		result.pointY = new int[pointX.length];
		result.type = type;
		for(int i = 0; i< pointX.length; i++){
			result.pointX[i] = pointX[i];
			result.pointY[i] = pointY[i];
		}
		
		return result;
	}
}
