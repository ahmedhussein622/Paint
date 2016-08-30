import java.awt.BasicStroke;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JSONRead 
{
	PaintGUI parent;
	public JSONRead(PaintGUI p) 
	{
		JSONParser parser = new JSONParser();
		parent = p;
		parent.shapes.clear();
		
		Class shapeClass = null;
		Constructor constructor = null;
		PShape loadedShape;
		ClassLoader loader  = ClassLoader.getSystemClassLoader();
		try 
		{
		    FileReader jsonFile = new FileReader(MenuBar.file.getAbsolutePath());   
		    
		    BufferedReader in = new BufferedReader(jsonFile);
		    String s;
		    ArrayList<String> file = new ArrayList<String>();

		    while((s = in.readLine()) != null)
		    {

		        String[] var = s.split("}");
		        int j=0;
		        try{while(var[j]!=null)
		        {
		        	file.add(var[j]);
		        	j++;
		        }}catch(Exception ex){}
		        
		    }
		    for(int i =0;i<file.size() ;i++)
		    {
		    	String line = file.get(i);
		    	JSONObject o = (JSONObject)parser.parse(line+"}");
		    	
		    	int id = Integer.parseInt((String) o.get("id"));
		    	
		    	String name = (String) o.get("name");
		    	
		    	String color = (String) o.get("Color");
		    	String stroke = (String) o.get("Stroke");
		    	int st =(int) Float.parseFloat(stroke);
		    	
		    	int locationX0 = Integer.parseInt((String) o.get("locationX0"));
		    	
		    	int locationY0 = Integer.parseInt((String) o.get("locationY0"));
		    	
		    	int locationX1 = Integer.parseInt((String) o.get("locationX1"));
		    	
		    	int locationY1 =Integer.parseInt((String) o.get("locationY1"));
		    	
		    	int locationX2=0, locationY2=0, locationX3=0, locationY3=0;
		    	String f;
		    	boolean filled =false;
		    	if(id!= 0)
		    	{
		    		locationX2 = Integer.parseInt((String) o.get("locationX2"));
			    
			    	locationY2 = Integer.parseInt((String) o.get("locationY2"));
			    	
			    	if(id!= 5)
			    	{
			    		locationX3 = Integer.parseInt((String) o.get("locationX3"));
				
				    	locationY3 = Integer.parseInt((String) o.get("locationY3"));
				
			    	}
			    	
			    	f = (String) o.get("filled");
			    	if(f.equals("true"))filled =true;
			    		
			    	
		    	}
		    	
		    	String colors = color.substring(17);
		    	String colors1=colors.replaceAll("g=", "");
		    	String colors2=colors1.replaceAll("b=", "");
		    	String colors3=colors2.replaceAll("]", "");
		    	String [] z = colors3.split(",");
		    	int[] colorsArray = new int[3];
		    	for(int j=0;j<z.length;j++)colorsArray[j] = Integer.parseInt(z[j]);
		    	Color u = new Color(colorsArray[0], colorsArray[1], colorsArray[2]);
		    	
		    	if(id == 0)
		    	{	
		    		
		    		try{

		    		shapeClass = loader.loadClass("PLine");
		    		constructor = shapeClass.getConstructor(JPanel.class);
		    		loadedShape = (PShape)constructor.newInstance(parent.drawingSurface); 		
		    		loadedShape.data.pointX[0] = locationX0;
		    		loadedShape.data.pointY[0] = locationY0;
		    		loadedShape.data.pointX[1] = locationX1;
		    		loadedShape.data.pointY[1] = locationY1;
		    		loadedShape.setColor(u);
		    		loadedShape.setStroke(new BasicStroke(st));
					PaintGUI.shapes.add(loadedShape);
		    		}catch(Exception e){}
					
		    	}
		    	else if(id ==1)
		    	{
		    		try{shapeClass = loader.loadClass("PRectangle");
		    		constructor = shapeClass.getConstructor(JPanel.class);
		    		loadedShape = (PShape)constructor.newInstance(parent.drawingSurface); 		
		    		loadedShape.data.pointX[0] = locationX0;
		    		loadedShape.data.pointY[0] = locationY0;
		    		loadedShape.data.pointX[1] = locationX1;
		    		loadedShape.data.pointY[1] = locationY1;
		    		loadedShape.data.pointX[2] = locationX2;
		    		loadedShape.data.pointY[2] = locationY2;
		    		loadedShape.data.pointX[3] = locationX3;
		    		loadedShape.data.pointY[3] = locationY3;
		    		loadedShape.setColor(u);
		    		loadedShape.setStroke(new BasicStroke(st));
		    		loadedShape.setFilled(filled);
					PaintGUI.shapes.add(loadedShape);
		    		}catch(Exception ex){}
					
		    	}
		    	else if(id ==2)
		    	{
		    		try{shapeClass = loader.loadClass("PRectangle");
		    		constructor = shapeClass.getConstructor(JPanel.class);
		    		loadedShape = (PShape)constructor.newInstance(parent.drawingSurface); 		
		    		loadedShape.data.pointX[0] = locationX0;
		    		loadedShape.data.pointY[0] = locationY0;
		    		loadedShape.data.pointX[1] = locationX1;
		    		loadedShape.data.pointY[1] = locationY1;
		    		loadedShape.data.pointX[2] = locationX2;
		    		loadedShape.data.pointY[2] = locationY2;
		    		loadedShape.data.pointX[3] = locationX3;
		    		loadedShape.data.pointY[3] = locationY3;
		    		loadedShape.setColor(u);
		    		loadedShape.setStroke(new BasicStroke(st));
		    		loadedShape.setFilled(filled);
					PaintGUI.shapes.add(loadedShape);
		    		}catch(Exception ex){}
		    		
		    	}
		    	else if(id ==3)
		    	{
		    		try{shapeClass = loader.loadClass("PEllipse");
		    		constructor = shapeClass.getConstructor(JPanel.class);
		    		loadedShape = (PShape)constructor.newInstance(parent.drawingSurface); 		
		    		loadedShape.data.pointX[0] = locationX0;
		    		loadedShape.data.pointY[0] = locationY0;
		    		loadedShape.data.pointX[1] = locationX1;
		    		loadedShape.data.pointY[1] = locationY1;
		    		loadedShape.data.pointX[2] = locationX2;
		    		loadedShape.data.pointY[2] = locationY2;
		    		loadedShape.data.pointX[3] = locationX3;
		    		loadedShape.data.pointY[3] = locationY3;
		    		loadedShape.setColor(u);
		    		loadedShape.setStroke(new BasicStroke(st));
		    		loadedShape.setFilled(filled);
					PaintGUI.shapes.add(loadedShape);
		    		}catch(Exception ex){}
		    		
					
		    	}
		    	else if(id == 4)
		    	{
		    		try{shapeClass = loader.loadClass("PEllipse");
		    		constructor = shapeClass.getConstructor(JPanel.class);
		    		loadedShape = (PShape)constructor.newInstance(parent.drawingSurface); 		
		    		loadedShape.data.pointX[0] = locationX0;
		    		loadedShape.data.pointY[0] = locationY0;
		    		loadedShape.data.pointX[1] = locationX1;
		    		loadedShape.data.pointY[1] = locationY1;
		    		loadedShape.data.pointX[2] = locationX2;
		    		loadedShape.data.pointY[2] = locationY2;
		    		loadedShape.data.pointX[3] = locationX3;
		    		loadedShape.data.pointY[3] = locationY3;
		    		loadedShape.setColor(u);
		    		loadedShape.setStroke(new BasicStroke(st));
		    		loadedShape.setFilled(filled);
					PaintGUI.shapes.add(loadedShape);
		    		}catch(Exception ex){}
		    		
		    	}
		    	else if(id == 5)
		    	{
		    		try{shapeClass = loader.loadClass("PTriangle");
		    		constructor = shapeClass.getConstructor(JPanel.class);
		    		loadedShape = (PShape)constructor.newInstance(parent.drawingSurface); 		
		    		loadedShape.data.pointX[0] = locationX0;
		    		loadedShape.data.pointY[0] = locationY0;
		    		loadedShape.data.pointX[1] = locationX1;
		    		loadedShape.data.pointY[1] = locationY1;
		    		loadedShape.data.pointX[2] = locationX2;
		    		loadedShape.data.pointY[2] = locationY2;
		    		loadedShape.setColor(u);
		    		loadedShape.setStroke(new BasicStroke(st));
		    		loadedShape.setFilled(filled);
					PaintGUI.shapes.add(loadedShape);
		    		}catch(Exception ex){}
		    		
		    				
		    	}
		    }
		    
		    parent.drawingSurface.repaint();
		}
		catch (FileNotFoundException e) {}
		catch (IOException e) {}
		catch (org.json.simple.parser.ParseException e){}
		
	}
}
