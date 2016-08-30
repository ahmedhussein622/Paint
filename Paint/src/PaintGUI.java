import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class PaintGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<PShape> shapes,deleteList;
	public Stack< ChangeAction > undoStack,redoStack;
	
	public static DrawingSurface drawingSurface;
	private ColorToolBar colors;
	public ShapesToolBar tools;
	private JPanel container;
	private MenuBar bar;
	
	int drawingStroke;
	Color drawingColor;
	boolean drawingfill;
	
	public PaintGUI() {
		shapes = new ArrayList<PShape>();
		deleteList = new ArrayList<PShape>();
		
		drawingSurface = new DrawingSurface(shapes);
		colors = new ColorToolBar(this);
		container = new JPanel();
		bar = new MenuBar(this);
		tools = new ShapesToolBar(this);
		
		undoStack = new Stack< ChangeAction >();
		redoStack = new Stack< ChangeAction >();
		
		container.setLayout(new BorderLayout());
		container.add(drawingSurface,BorderLayout.CENTER);
		
		container.add(colors,BorderLayout.SOUTH);
		container.add(tools,BorderLayout.EAST);
		add(container);
		
		drawingStroke = 3;
		drawingColor = Color.black;
		drawingfill = false;
		/////////////////////////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
	}
	
////////////////////////////////////////////////////////////////////////////////
	// changes
	
	public void delelteShpaes(){
	
		int i = 0;
		boolean s = false;
		while (i < shapes.size()) {
			if(shapes.get(i).isSelected()){
				s = true;
				undoStack.add(new ChangeAction(shapes.get(i),ChangeAction.deleted));
				shapes.get(i).setSelected(false);
				deleteList.add(shapes.get(i));
			}
			i++;
		}
		
		if(s){
			drawingSurface.repaint();
			return;
		}
	
		for(i = 0;i  < deleteList.size();i++){
			shapes.remove(deleteList.get(i));
		}
		deleteList.clear();
		drawingSurface.repaint();
	}
	
	
	
	public void setColor(Color c){
			for(int i = 0; i < shapes.size(); i++){
				if(shapes.get(i).isSelected() && shapes.get(i).getColor()!= c){
					undoStack.add(new ChangeAction(shapes.get(i),ChangeAction.changeColor));
					shapes.get(i).setColor(c);
					redoStack.clear();
				}
			}
			drawingSurface.repaint();
	}
	
	public void setFilled(boolean f){
		for(int i = 0; i < shapes.size(); i++){
			if(shapes.get(i).isSelected() && shapes.get(i).isFilled()!= f){
				undoStack.add(new ChangeAction(shapes.get(i),ChangeAction.Changefilled));
				shapes.get(i).setFilled(f);
				redoStack.clear();
			}
		}
		drawingSurface.repaint();
	}
	
	public void setStroke(int x){
		for(int i = 0; i < shapes.size(); i++){
			if(shapes.get(i).isSelected() && shapes.get(i).getStroke().getLineWidth()!= x){
				undoStack.add(new ChangeAction(shapes.get(i),ChangeAction.ChangeStroke));
				shapes.get(i).setStroke(new BasicStroke(x));
				redoStack.clear();
			}
		}
		drawingSurface.repaint();
	}
	
	public void redo(){
		if(redoStack.isEmpty())
			return;
		ChangeAction top = redoStack.peek();
		undoStack.add(new ChangeAction(top.getSource(),top.getActionPerformed()));
		
		if(top.getActionPerformed() == ChangeAction.created){
			shapes.add(top.getSource());
		}
		else if(top.getActionPerformed() == ChangeAction.deleted){
			shapes.remove(top.getSource());
		}
		else
			top.reset();
		drawingSurface.repaint();
		redoStack.pop();
	}
	public void undo(){
		if(undoStack.isEmpty())
			return;
		
		boolean s = false;
		for(int i = 0 ; i < shapes.size();i++ ){
			if(shapes.get(i).isSelected()){
				s = true;
				shapes.get(i).setSelected(false);
			}
			
		}
		if(s){
			drawingSurface.repaint();
			return;
		}
		
		ChangeAction top = undoStack.peek();
		
		redoStack.add(new ChangeAction(top.getSource(),top.getActionPerformed()));
		
		PShape t = top.getSource();
		if(top.actionPerformed == ChangeAction.created){
			shapes.remove(t);
		}
		else if(top.actionPerformed == ChangeAction.deleted){
			shapes.add(top.getSource());
		}
		else
			top.reset();
		
		
		drawingSurface.repaint();
		undoStack.pop();
	}
	
///////////////////////////////////////////////////////////////////////////
	
	
}
