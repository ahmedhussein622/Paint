import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.lang.reflect.Constructor;

import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLRead 
{
	PaintGUI parent;
	public XMLRead(PaintGUI p)
	{
		parent = p;
		parent.shapes.clear();
		Class shapeClass = null;
		Constructor constructor = null;
		PShape loadedShape;
		ClassLoader loader  = ClassLoader.getSystemClassLoader();
		try
		{		 
		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.parse(MenuBar.file);
		    
		  
		    NodeList nList = doc.getElementsByTagName("Line");
		    if(nList.getLength()>0){
		    for (int temp = 0; temp < nList.getLength(); temp++) 
		    {	 
				Node nNode = nList.item(temp);
					
				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element eElement = (Element) nNode;
					int x0 = Integer.parseInt(eElement.getElementsByTagName("LocationX0").item(0).getTextContent());
					int y0 = Integer.parseInt(eElement.getElementsByTagName("LocationY0").item(0).getTextContent());
					int x1 = Integer.parseInt(eElement.getElementsByTagName("LocationX1").item(0).getTextContent());
					int y1 = Integer.parseInt(eElement.getElementsByTagName("LocationY1").item(0).getTextContent());
					String stroke = eElement.getElementsByTagName("Stroke").item(0).getTextContent();
					int st = (int) Float.parseFloat(stroke);
					String color = eElement.getElementsByTagName("Color").item(0).getTextContent();
					
					String colors = color.substring(17);
			    	String colors1=colors.replaceAll("g=", "");
			    	String colors2=colors1.replaceAll("b=", "");
			    	String colors3=colors2.replaceAll("]", "");
			    	String [] z = colors3.split(",");
			    	int[] colorsArray = new int[3];
			    	for(int j=0;j<z.length;j++)colorsArray[j] = Integer.parseInt(z[j]);
			    	Color u = new Color(colorsArray[0], colorsArray[1], colorsArray[2]);					
					
			    	try{shapeClass = loader.loadClass("PLine");
		    		constructor = shapeClass.getConstructor(JPanel.class);
		    		loadedShape = (PShape)constructor.newInstance(parent.drawingSurface); 		
		    		loadedShape.data.pointX[0] = x0;
		    		loadedShape.data.pointY[0] = y0;
		    		loadedShape.data.pointX[1] = x1;
		    		loadedShape.data.pointY[1] = y1;
		    		
		    		loadedShape.setColor(u);
		    		loadedShape.setStroke(new BasicStroke(st));
					PaintGUI.shapes.add(loadedShape);
		    		}catch(Exception ex){}			
	
				}
			}}
		    
		    NodeList rList = doc.getElementsByTagName("Rectangle");
		    if(rList.getLength()>0){
		    for (int temp = 0; temp < rList.getLength(); temp++) 
		    {	 
				Node nNode = rList.item(temp);	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element eElement = (Element) nNode;
					int x0 = Integer.parseInt(eElement.getElementsByTagName("LocationX0").item(0).getTextContent());
					int y0 = Integer.parseInt(eElement.getElementsByTagName("LocationY0").item(0).getTextContent());
					int x1 = Integer.parseInt(eElement.getElementsByTagName("LocationX1").item(0).getTextContent());
					int y1 = Integer.parseInt(eElement.getElementsByTagName("LocationY1").item(0).getTextContent());
					int x2 = Integer.parseInt(eElement.getElementsByTagName("LocationX2").item(0).getTextContent());
					int y2 = Integer.parseInt(eElement.getElementsByTagName("LocationY2").item(0).getTextContent());
					int x3 = Integer.parseInt(eElement.getElementsByTagName("LocationX3").item(0).getTextContent());
					int y3 = Integer.parseInt(eElement.getElementsByTagName("LocationY3").item(0).getTextContent());
					String stroke = eElement.getElementsByTagName("Stroke").item(0).getTextContent();
					int st = (int) Float.parseFloat(stroke);
					String color = eElement.getElementsByTagName("Color").item(0).getTextContent();
					boolean filled = Boolean.parseBoolean(eElement.getElementsByTagName("filled").item(0).getTextContent());
					
					String colors = color.substring(17);
			    	String colors1=colors.replaceAll("g=", "");
			    	String colors2=colors1.replaceAll("b=", "");
			    	String colors3=colors2.replaceAll("]", "");
			    	String [] z = colors3.split(",");
			    	int[] colorsArray = new int[3];
			    	for(int j=0;j<z.length;j++)colorsArray[j] = Integer.parseInt(z[j]);
			    	Color u = new Color(colorsArray[0], colorsArray[1], colorsArray[2]);
					
			    	try{shapeClass = loader.loadClass("PRectangle");
		    		constructor = shapeClass.getConstructor(JPanel.class);
		    		loadedShape = (PShape)constructor.newInstance(parent.drawingSurface); 		
		    		loadedShape.data.pointX[0] = x0;
		    		loadedShape.data.pointY[0] = y0;
		    		loadedShape.data.pointX[1] = x1;
		    		loadedShape.data.pointY[1] = y1;
		    		loadedShape.data.pointX[2] = x2;
		    		loadedShape.data.pointY[2] = y2;
		    		loadedShape.data.pointX[3] = x3;
		    		loadedShape.data.pointY[3] = y3;
		    		loadedShape.setColor(u);
		    		loadedShape.setStroke(new BasicStroke(st));
		    		loadedShape.setFilled(filled);
					PaintGUI.shapes.add(loadedShape);
		    		}catch(Exception ex){}			
					
								
				}
			}}
		    
		    NodeList sList = doc.getElementsByTagName("Square");
		    if(sList.getLength()>0){
		    for (int temp = 0; temp < sList.getLength(); temp++) 
		    {	 
				Node nNode = sList.item(temp);	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element eElement = (Element) nNode;
					int x0 = Integer.parseInt(eElement.getElementsByTagName("LocationX0").item(0).getTextContent());
					int y0 = Integer.parseInt(eElement.getElementsByTagName("LocationY0").item(0).getTextContent());
					int x1 = Integer.parseInt(eElement.getElementsByTagName("LocationX1").item(0).getTextContent());
					int y1 = Integer.parseInt(eElement.getElementsByTagName("LocationY1").item(0).getTextContent());
					int x2 = Integer.parseInt(eElement.getElementsByTagName("LocationX2").item(0).getTextContent());
					int y2 = Integer.parseInt(eElement.getElementsByTagName("LocationY2").item(0).getTextContent());
					int x3 = Integer.parseInt(eElement.getElementsByTagName("LocationX3").item(0).getTextContent());
					int y3 = Integer.parseInt(eElement.getElementsByTagName("LocationY3").item(0).getTextContent());
					String stroke = eElement.getElementsByTagName("Stroke").item(0).getTextContent();
					int st = (int) Float.parseFloat(stroke);
					String color = eElement.getElementsByTagName("Color").item(0).getTextContent();
					boolean filled = Boolean.parseBoolean(eElement.getElementsByTagName("filled").item(0).getTextContent());
					
					String colors = color.substring(17);
			    	String colors1=colors.replaceAll("g=", "");
			    	String colors2=colors1.replaceAll("b=", "");
			    	String colors3=colors2.replaceAll("]", "");
			    	String [] z = colors3.split(",");
			    	int[] colorsArray = new int[3];
			    	for(int j=0;j<z.length;j++)colorsArray[j] = Integer.parseInt(z[j]);
			    	Color u = new Color(colorsArray[0], colorsArray[1], colorsArray[2]);
					
			    	try{shapeClass = loader.loadClass("PRectangle");
		    		constructor = shapeClass.getConstructor(JPanel.class);
		    		loadedShape = (PShape)constructor.newInstance(parent.drawingSurface); 		
		    		loadedShape.data.pointX[0] = x0;
		    		loadedShape.data.pointY[0] = y0;
		    		loadedShape.data.pointX[1] = x1;
		    		loadedShape.data.pointY[1] = y1;
		    		loadedShape.data.pointX[2] = x2;
		    		loadedShape.data.pointY[2] = y2;
		    		loadedShape.data.pointX[3] = x3;
		    		loadedShape.data.pointY[3] = y3;
		    		loadedShape.setColor(u);
		    		loadedShape.setStroke(new BasicStroke(st));
		    		loadedShape.setFilled(filled);
					PaintGUI.shapes.add(loadedShape);
		    		}catch(Exception ex){}			
								
				}
			}}
		    
		    NodeList eList = doc.getElementsByTagName("Ellipse");
		    if(eList.getLength()>0){
		    for (int temp = 0; temp < eList.getLength(); temp++) 
		    {	 
				Node nNode = eList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element eElement = (Element) nNode;
					int x0 = Integer.parseInt(eElement.getElementsByTagName("LocationX0").item(0).getTextContent());
					int y0 = Integer.parseInt(eElement.getElementsByTagName("LocationY0").item(0).getTextContent());
					int x1 = Integer.parseInt(eElement.getElementsByTagName("LocationX1").item(0).getTextContent());
					int y1 = Integer.parseInt(eElement.getElementsByTagName("LocationY1").item(0).getTextContent());
					int x2 = Integer.parseInt(eElement.getElementsByTagName("LocationX2").item(0).getTextContent());
					int y2 = Integer.parseInt(eElement.getElementsByTagName("LocationY2").item(0).getTextContent());
					int x3 = Integer.parseInt(eElement.getElementsByTagName("LocationX3").item(0).getTextContent());
					int y3 = Integer.parseInt(eElement.getElementsByTagName("LocationY3").item(0).getTextContent());
					String stroke = eElement.getElementsByTagName("Stroke").item(0).getTextContent();
					int st = (int) Float.parseFloat(stroke);
					String color = eElement.getElementsByTagName("Color").item(0).getTextContent();
					boolean filled = Boolean.parseBoolean(eElement.getElementsByTagName("filled").item(0).getTextContent());
					
					String colors = color.substring(17);
			    	String colors1=colors.replaceAll("g=", "");
			    	String colors2=colors1.replaceAll("b=", "");
			    	String colors3=colors2.replaceAll("]", "");
			    	String [] z = colors3.split(",");
			    	int[] colorsArray = new int[3];
			    	for(int j=0;j<z.length;j++)colorsArray[j] = Integer.parseInt(z[j]);
			    	Color u = new Color(colorsArray[0], colorsArray[1], colorsArray[2]);
					
			    	try{shapeClass = loader.loadClass("PEllipse");
		    		constructor = shapeClass.getConstructor(JPanel.class);
		    		loadedShape = (PShape)constructor.newInstance(parent.drawingSurface); 		
		    		loadedShape.data.pointX[0] = x0;
		    		loadedShape.data.pointY[0] = y0;
		    		loadedShape.data.pointX[1] = x1;
		    		loadedShape.data.pointY[1] = y1;
		    		loadedShape.data.pointX[2] = x2;
		    		loadedShape.data.pointY[2] = y2;
		    		loadedShape.data.pointX[3] = x3;
		    		loadedShape.data.pointY[3] = y3;
		    		loadedShape.setColor(u);
		    		loadedShape.setStroke(new BasicStroke(st));
		    		loadedShape.setFilled(filled);
					PaintGUI.shapes.add(loadedShape);
		    		}catch(Exception ex){}			
					
									
				}
			}}
		    
		    NodeList cList = doc.getElementsByTagName("Circle");
		    if(cList.getLength()>0){
		    for (int temp = 0; temp < cList.getLength(); temp++) 
		    {	 
				Node nNode = cList.item(temp);	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element eElement = (Element) nNode;
					int x0 = Integer.parseInt(eElement.getElementsByTagName("LocationX0").item(0).getTextContent());
					int y0 = Integer.parseInt(eElement.getElementsByTagName("LocationY0").item(0).getTextContent());
					int x1 = Integer.parseInt(eElement.getElementsByTagName("LocationX1").item(0).getTextContent());
					int y1 = Integer.parseInt(eElement.getElementsByTagName("LocationY1").item(0).getTextContent());
					int x2 = Integer.parseInt(eElement.getElementsByTagName("LocationX2").item(0).getTextContent());
					int y2 = Integer.parseInt(eElement.getElementsByTagName("LocationY2").item(0).getTextContent());
					int x3 = Integer.parseInt(eElement.getElementsByTagName("LocationX3").item(0).getTextContent());
					int y3 = Integer.parseInt(eElement.getElementsByTagName("LocationY3").item(0).getTextContent());
					String stroke = eElement.getElementsByTagName("Stroke").item(0).getTextContent();
					int st = (int) Float.parseFloat(stroke);
					String color = eElement.getElementsByTagName("Color").item(0).getTextContent();
					boolean filled = Boolean.parseBoolean(eElement.getElementsByTagName("filled").item(0).getTextContent()); 
					
					String colors = color.substring(17);
			    	String colors1=colors.replaceAll("g=", "");
			    	String colors2=colors1.replaceAll("b=", "");
			    	String colors3=colors2.replaceAll("]", "");
			    	String [] z = colors3.split(",");
			    	int[] colorsArray = new int[3];
			    	for(int j=0;j<z.length;j++)colorsArray[j] = Integer.parseInt(z[j]);
			    	Color u = new Color(colorsArray[0], colorsArray[1], colorsArray[2]);
					
			    	try{shapeClass = loader.loadClass("PEllipse");
		    		constructor = shapeClass.getConstructor(JPanel.class);
		    		loadedShape = (PShape)constructor.newInstance(parent.drawingSurface); 		
		    		loadedShape.data.pointX[0] = x0;
		    		loadedShape.data.pointY[0] = y0;
		    		loadedShape.data.pointX[1] = x1;
		    		loadedShape.data.pointY[1] = y1;
		    		loadedShape.data.pointX[2] = x2;
		    		loadedShape.data.pointY[2] = y2;
		    		loadedShape.data.pointX[3] = x3;
		    		loadedShape.data.pointY[3] = y3;
		    		loadedShape.setColor(u);
		    		loadedShape.setStroke(new BasicStroke(st));
		    		loadedShape.setFilled(filled);
					PaintGUI.shapes.add(loadedShape);
		    		}catch(Exception ex){}			
								
				}
			}}
		    
		    NodeList tList = doc.getElementsByTagName("Triangle");
		    if(tList.getLength()>0){
		    for (int temp = 0; temp < tList.getLength(); temp++) 
		    {	 
				Node nNode = tList.item(temp);	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element eElement = (Element) nNode;
					int x0 = Integer.parseInt(eElement.getElementsByTagName("LocationX0").item(0).getTextContent());
					int y0 = Integer.parseInt(eElement.getElementsByTagName("LocationY0").item(0).getTextContent());
					int x1 = Integer.parseInt(eElement.getElementsByTagName("LocationX1").item(0).getTextContent());
					int y1 = Integer.parseInt(eElement.getElementsByTagName("LocationY1").item(0).getTextContent());
					int x2 = Integer.parseInt(eElement.getElementsByTagName("LocationX2").item(0).getTextContent());
					int y2 = Integer.parseInt(eElement.getElementsByTagName("LocationY2").item(0).getTextContent());
					String stroke = eElement.getElementsByTagName("Stroke").item(0).getTextContent();
					int st = (int) Float.parseFloat(stroke);
					String color = eElement.getElementsByTagName("Color").item(0).getTextContent();
					boolean filled = Boolean.parseBoolean(eElement.getElementsByTagName("filled").item(0).getTextContent());
					
					String colors = color.substring(17);
			    	String colors1=colors.replaceAll("g=", "");
			    	String colors2=colors1.replaceAll("b=", "");
			    	String colors3=colors2.replaceAll("]", "");
			    	String [] z = colors3.split(",");
			    	int[] colorsArray = new int[3];
			    	for(int j=0;j<z.length;j++)colorsArray[j] = Integer.parseInt(z[j]);
			    	Color u = new Color(colorsArray[0], colorsArray[1], colorsArray[2]);
					
			    	try{shapeClass = loader.loadClass("PTriangle");
		    		constructor = shapeClass.getConstructor(JPanel.class);
		    		loadedShape = (PShape)constructor.newInstance(parent.drawingSurface); 		
		    		loadedShape.data.pointX[0] = x0;
		    		loadedShape.data.pointY[0] = y0;
		    		loadedShape.data.pointX[1] = x1;
		    		loadedShape.data.pointY[1] = y1;
		    		loadedShape.data.pointX[2] = x2;
		    		loadedShape.data.pointY[2] = y2;
		    		loadedShape.setColor(u);
		    		loadedShape.setStroke(new BasicStroke(st));
		    		loadedShape.setFilled(filled);
					PaintGUI.shapes.add(loadedShape);
		    		}catch(Exception ex){}					
								
				}
				
			}
		    	parent.drawingSurface.repaint();
		    }// end of try
		    
		}catch (Exception e) {}
	}
}
