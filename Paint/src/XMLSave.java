import java.io.File;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
public class XMLSave {
 
	public XMLSave() {
 
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Shapes");
		doc.appendChild(rootElement);
		if(PaintGUI.shapes.size()>0){
		for(int i =0 ;i<PaintGUI.shapes.size();i++)
		{
			if(PaintGUI.shapes.get(i).data.type == 0)
			{
				Element shape = doc.createElement("Line");
				rootElement.appendChild(shape);
				
				Attr attr = doc.createAttribute("id");
				attr.setValue("0");
				shape.setAttributeNode(attr);
				
				String c =(PaintGUI.shapes.get(i).data.color).toString();
				
				Element color= doc.createElement("Color");
				color.appendChild(doc.createTextNode(c));
				shape.appendChild(color);
				
				Element locationX0 = doc.createElement("LocationX0");
				locationX0.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[0])));
				shape.appendChild(locationX0);
				
				
				Element locationX1 = doc.createElement("LocationX1");
				locationX1.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[1])));
				shape.appendChild(locationX1);
				
				
				Element locationY0 = doc.createElement("LocationY0");
				locationY0.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[0])));
				shape.appendChild(locationY0);
				
				Element locationY1 = doc.createElement("LocationY1");
				locationY1.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[1])));
				shape.appendChild(locationY1);
				
				String s =Float.toString((PaintGUI.shapes.get(i).data.stroke.getLineWidth()));
				Element stroke =doc.createElement("Stroke");
				stroke.appendChild(doc.createTextNode(s));
				shape.appendChild(stroke);
				
				
			}
			else if(PaintGUI.shapes.get(i).data.type == 1)
			{
				Element shape = doc.createElement("Rectangle");
				rootElement.appendChild(shape);
				
				Attr attr = doc.createAttribute("id");
				attr.setValue("1");
				shape.setAttributeNode(attr);
				
				String c =(PaintGUI.shapes.get(i).data.color).toString();
				Element color= doc.createElement("Color");
				color.appendChild(doc.createTextNode(c));
				shape.appendChild(color);
				
				Element locationX0 = doc.createElement("LocationX0");
				locationX0.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[0])));
				shape.appendChild(locationX0);
				
				Element locationX1 = doc.createElement("LocationX1");
				locationX1.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[1])));
				shape.appendChild(locationX1);
				
				Element locationX2 = doc.createElement("LocationX2");
				locationX2.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[2])));
				shape.appendChild(locationX2);
				
				Element locationX3 = doc.createElement("LocationX3");
				locationX3.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[3])));
				shape.appendChild(locationX3);
			
				Element locationY0 = doc.createElement("LocationY0");
				locationY0.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[0])));
				shape.appendChild(locationY0);
				
				Element locationY1 = doc.createElement("LocationY1");
				locationY1.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[1])));
				shape.appendChild(locationY1);
			
				Element locationY2 = doc.createElement("LocationY2");
				locationY2.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[2])));
				shape.appendChild(locationY2);
			
				Element locationY3 = doc.createElement("LocationY3");
				locationY3.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[3])));
				shape.appendChild(locationY3);
			
				String s =Float.toString((PaintGUI.shapes.get(i).data.stroke.getLineWidth()));
				Element stroke =doc.createElement("Stroke");
				stroke.appendChild(doc.createTextNode(s));
				shape.appendChild(stroke);
				
				boolean f = PaintGUI.shapes.get(i).data.filled;
				if(f)
				{
					Element filled =doc.createElement("filled");
					filled.appendChild(doc.createTextNode("true"));
					shape.appendChild(filled);
				}
				else
				{
					Element filled =doc.createElement("filled");
					filled.appendChild(doc.createTextNode("false"));
					shape.appendChild(filled);
				}
			}
			else if(PaintGUI.shapes.get(i).data.type == 2)
			{
				Element shape = doc.createElement("Square");
				rootElement.appendChild(shape);
				
				Attr attr = doc.createAttribute("id");
				attr.setValue("2");
				shape.setAttributeNode(attr);
				
				String c =(PaintGUI.shapes.get(i).data.color).toString();
				Element color= doc.createElement("Color");
				color.appendChild(doc.createTextNode(c));
				shape.appendChild(color);
				
				Element locationX0 = doc.createElement("LocationX0");
				locationX0.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[0])));
				shape.appendChild(locationX0);
				
				Element locationX1 = doc.createElement("LocationX1");
				locationX1.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[1])));
				shape.appendChild(locationX1);
				
				Element locationX2 = doc.createElement("LocationX2");
				locationX2.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[2])));
				shape.appendChild(locationX2);
				
				Element locationX3 = doc.createElement("LocationX3");
				locationX3.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[3])));
				shape.appendChild(locationX3);
			
				Element locationY0 = doc.createElement("LocationY0");
				locationY0.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[0])));
				shape.appendChild(locationY0);
				
				Element locationY1 = doc.createElement("LocationY1");
				locationY1.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[1])));
				shape.appendChild(locationY1);
			
				Element locationY2 = doc.createElement("LocationY2");
				locationY2.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[2])));
				shape.appendChild(locationY2);
			
				Element locationY3 = doc.createElement("LocationY3");
				locationY3.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[3])));
				shape.appendChild(locationY3);
			
				String s =Float.toString((PaintGUI.shapes.get(i).data.stroke.getLineWidth()));
				Element stroke =doc.createElement("Stroke");
				stroke.appendChild(doc.createTextNode(s));
				shape.appendChild(stroke);
				
				boolean f = PaintGUI.shapes.get(i).data.filled;
				if(f)
				{
					Element filled =doc.createElement("filled");
					filled.appendChild(doc.createTextNode("true"));
					shape.appendChild(filled);
				}
				else
				{
					Element filled =doc.createElement("filled");
					filled.appendChild(doc.createTextNode("false"));
					shape.appendChild(filled);
				}
			}
			else if(PaintGUI.shapes.get(i).data.type == 4)
			{
				Element shape = doc.createElement("Circle");
				rootElement.appendChild(shape);
				
				Attr attr = doc.createAttribute("id");
				attr.setValue("4");
				shape.setAttributeNode(attr);
				
				String c =(PaintGUI.shapes.get(i).data.color).toString();
				Element color= doc.createElement("Color");
				color.appendChild(doc.createTextNode(c));
				shape.appendChild(color);
				
				Element locationX0 = doc.createElement("LocationX0");
				locationX0.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[0])));
				shape.appendChild(locationX0);
				
				Element locationX1 = doc.createElement("LocationX1");
				locationX1.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[1])));
				shape.appendChild(locationX1);
				
				Element locationX2 = doc.createElement("LocationX2");
				locationX2.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[2])));
				shape.appendChild(locationX2);
				
				Element locationX3 = doc.createElement("LocationX3");
				locationX3.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[3])));
				shape.appendChild(locationX3);
			
				Element locationY0 = doc.createElement("LocationY0");
				locationY0.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[0])));
				shape.appendChild(locationY0);
				
				Element locationY1 = doc.createElement("LocationY1");
				locationY1.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[1])));
				shape.appendChild(locationY1);
			
				Element locationY2 = doc.createElement("LocationY2");
				locationY2.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[2])));
				shape.appendChild(locationY2);
			
				Element locationY3 = doc.createElement("LocationY3");
				locationY3.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[3])));
				shape.appendChild(locationY3);
			
				String s =Float.toString((PaintGUI.shapes.get(i).data.stroke.getLineWidth()));
				Element stroke =doc.createElement("Stroke");
				stroke.appendChild(doc.createTextNode(s));
				shape.appendChild(stroke);
				
				boolean f = PaintGUI.shapes.get(i).data.filled;
				if(f)
				{
					Element filled =doc.createElement("filled");
					filled.appendChild(doc.createTextNode("true"));
					shape.appendChild(filled);
				}
				else
				{
					Element filled =doc.createElement("filled");
					filled.appendChild(doc.createTextNode("false"));
					shape.appendChild(filled);
				}
			}
			else if(PaintGUI.shapes.get(i).data.type == 3)
			{
				Element shape = doc.createElement("Ellipse");
				
				rootElement.appendChild(shape);
				
				Attr attr = doc.createAttribute("id");
				attr.setValue("3");
				shape.setAttributeNode(attr);
				
				String c =(PaintGUI.shapes.get(i).data.color).toString();
				Element color= doc.createElement("Color");
				color.appendChild(doc.createTextNode(c));
				shape.appendChild(color);
				
				Element locationX0 = doc.createElement("LocationX0");
				locationX0.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[0])));
				shape.appendChild(locationX0);
				
				Element locationX1 = doc.createElement("LocationX1");
				locationX1.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[1])));
				shape.appendChild(locationX1);
				
				Element locationX2 = doc.createElement("LocationX2");
				locationX2.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[2])));
				shape.appendChild(locationX2);
				
				Element locationX3 = doc.createElement("LocationX3");
				locationX3.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[3])));
				shape.appendChild(locationX3);
			
				Element locationY0 = doc.createElement("LocationY0");
				locationY0.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[0])));
				shape.appendChild(locationY0);
				
				Element locationY1 = doc.createElement("LocationY1");
				locationY1.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[1])));
				shape.appendChild(locationY1);
			
				Element locationY2 = doc.createElement("LocationY2");
				locationY2.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[2])));
				shape.appendChild(locationY2);
			
				Element locationY3 = doc.createElement("LocationY3");
				locationY3.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[3])));
				shape.appendChild(locationY3);
			
				String s =Float.toString((PaintGUI.shapes.get(i).data.stroke.getLineWidth()));
				Element stroke =doc.createElement("Stroke");
				stroke.appendChild(doc.createTextNode(s));
				shape.appendChild(stroke);
				
				boolean f = PaintGUI.shapes.get(i).data.filled;
				if(f)
				{
					Element filled =doc.createElement("filled");
					filled.appendChild(doc.createTextNode("true"));
					shape.appendChild(filled);
				}
				else
				{
					Element filled =doc.createElement("filled");
					filled.appendChild(doc.createTextNode("false"));
					shape.appendChild(filled);
				}
			}
			else if(PaintGUI.shapes.get(i).data.type == 5)
			{
				Element shape = doc.createElement("Triangle");
				rootElement.appendChild(shape);
				
				Attr attr = doc.createAttribute("id");
				attr.setValue("5");
				shape.setAttributeNode(attr);
				
				String c =(PaintGUI.shapes.get(i).data.color).toString();
				Element color= doc.createElement("Color");
				color.appendChild(doc.createTextNode(c));
				shape.appendChild(color);
				
				Element locationX0 = doc.createElement("LocationX0");
				locationX0.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[0])));
				shape.appendChild(locationX0);
				
				Element locationX1 = doc.createElement("LocationX1");
				locationX1.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[1])));
				shape.appendChild(locationX1);
				
				Element locationX2 = doc.createElement("LocationX2");
				locationX2.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointX[2])));
				shape.appendChild(locationX2);
				
				Element locationY0 = doc.createElement("LocationY0");
				locationY0.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[0])));
				shape.appendChild(locationY0);
				
				Element locationY1 = doc.createElement("LocationY1");
				locationY1.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[1])));
				shape.appendChild(locationY1);
			
				Element locationY2 = doc.createElement("LocationY2");
				locationY2.appendChild(doc.createTextNode(Integer.toString(PaintGUI.shapes.get(i).data.pointY[2])));
				shape.appendChild(locationY2);
			
				String s =Float.toString((PaintGUI.shapes.get(i).data.stroke.getLineWidth()));
				Element stroke =doc.createElement("Stroke");
				stroke.appendChild(doc.createTextNode(s));
				shape.appendChild(stroke);
				
				boolean f = PaintGUI.shapes.get(i).data.filled;
				if(f)
				{
					Element filled =doc.createElement("filled");
					filled.appendChild(doc.createTextNode("true"));
					shape.appendChild(filled);
				}
				else
				{
					Element filled =doc.createElement("filled");
					filled.appendChild(doc.createTextNode("false"));
					shape.appendChild(filled);
				}
			}
			
		}}
		
		 

		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		java.util.Properties properties = System.getProperties();
	    String home = properties.get("user.home").toString();
	    String separator = properties.get("file.separator").toString();
	    String directoryName = "PaintBrush";
	    String name =JOptionPane.showInputDialog(null, "Please Enter File's name", "paint");
	    if(name==null)return;
	    String fileName = name+".xml";
	    File dir = new File(home+separator+directoryName);
	    dir.mkdir();    
		StreamResult result = new StreamResult(new File(dir,fileName));
		transformer.transform(source, result);
		JOptionPane.showMessageDialog(null, "File is Successfully Saved");
 
		
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}