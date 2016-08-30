import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;


public class JSONSave 
{
	public JSONSave()
	{
		try
		{	
			
			java.util.Properties properties = System.getProperties();
		    String home = properties.get("user.home").toString();
		    String separator = properties.get("file.separator").toString();
		    String directoryName = "PaintBrush";
		    
		    ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		    
		    if(PaintGUI.shapes.size()>0)
		    {
				for(int i =0 ;i<PaintGUI.shapes.size();i++)
				{
					JSONObject obj = new JSONObject();
					if(PaintGUI.shapes.get(i).data.type == 0)
					{
						obj.put("name", "Line");
						obj.put("id", "0");
						obj.put("locationX0", Integer.toString(PaintGUI.shapes.get(i).data.pointX[0]));
						obj.put("locationY0", Integer.toString(PaintGUI.shapes.get(i).data.pointY[0]));
						obj.put("locationX1", Integer.toString(PaintGUI.shapes.get(i).data.pointX[1]));
						obj.put("locationY1", Integer.toString(PaintGUI.shapes.get(i).data.pointY[1]));
						obj.put("Stroke", Float.toString((PaintGUI.shapes.get(i).data.stroke.getLineWidth())));
						obj.put("Color", (PaintGUI.shapes.get(i).data.color).toString());
					}
					else if(PaintGUI.shapes.get(i).data.type == 1)
					{
						obj.put("name", "Rectangle");
						obj.put("id", "1");
						obj.put("locationX0", Integer.toString(PaintGUI.shapes.get(i).data.pointX[0]));
						obj.put("locationY0", Integer.toString(PaintGUI.shapes.get(i).data.pointY[0]));
						obj.put("locationX1", Integer.toString(PaintGUI.shapes.get(i).data.pointX[1]));
						obj.put("locationY1", Integer.toString(PaintGUI.shapes.get(i).data.pointY[1]));
						obj.put("locationX2", Integer.toString(PaintGUI.shapes.get(i).data.pointX[2]));
						obj.put("locationY2", Integer.toString(PaintGUI.shapes.get(i).data.pointY[2]));
						obj.put("locationX3", Integer.toString(PaintGUI.shapes.get(i).data.pointX[3]));
						obj.put("locationY3", Integer.toString(PaintGUI.shapes.get(i).data.pointY[3]));
						obj.put("Stroke", Float.toString((PaintGUI.shapes.get(i).data.stroke.getLineWidth())));
						obj.put("Color", (PaintGUI.shapes.get(i).data.color).toString());
						boolean f = PaintGUI.shapes.get(i).data.filled;
						if(f)
						{
							obj.put("filled", "true");
						}
						else
						{
							obj.put("filled", "false");
						}
					}
					else if(PaintGUI.shapes.get(i).data.type == 2)
					{
						obj.put("name", "Square");
						obj.put("id", "2");
						obj.put("locationX0", Integer.toString(PaintGUI.shapes.get(i).data.pointX[0]));
						obj.put("locationY0", Integer.toString(PaintGUI.shapes.get(i).data.pointY[0]));
						obj.put("locationX1", Integer.toString(PaintGUI.shapes.get(i).data.pointX[1]));
						obj.put("locationY1", Integer.toString(PaintGUI.shapes.get(i).data.pointY[1]));
						obj.put("locationX2", Integer.toString(PaintGUI.shapes.get(i).data.pointX[2]));
						obj.put("locationY2", Integer.toString(PaintGUI.shapes.get(i).data.pointY[2]));
						obj.put("locationX3", Integer.toString(PaintGUI.shapes.get(i).data.pointX[3]));
						obj.put("locationY3", Integer.toString(PaintGUI.shapes.get(i).data.pointY[3]));
						obj.put("Stroke", Float.toString((PaintGUI.shapes.get(i).data.stroke.getLineWidth())));
						obj.put("Color", (PaintGUI.shapes.get(i).data.color).toString());
						boolean f = PaintGUI.shapes.get(i).data.filled;
						if(f)
						{
							obj.put("filled", "true");
						}
						else
						{
							obj.put("filled", "false");
						}
					}
					else if(PaintGUI.shapes.get(i).data.type == 3)
					{
						obj.put("name", "Ellipse");
						obj.put("id", "3");
						obj.put("locationX0", Integer.toString(PaintGUI.shapes.get(i).data.pointX[0]));
						obj.put("locationY0", Integer.toString(PaintGUI.shapes.get(i).data.pointY[0]));
						obj.put("locationX1", Integer.toString(PaintGUI.shapes.get(i).data.pointX[1]));
						obj.put("locationY1", Integer.toString(PaintGUI.shapes.get(i).data.pointY[1]));
						obj.put("locationX2", Integer.toString(PaintGUI.shapes.get(i).data.pointX[2]));
						obj.put("locationY2", Integer.toString(PaintGUI.shapes.get(i).data.pointY[2]));
						obj.put("locationX3", Integer.toString(PaintGUI.shapes.get(i).data.pointX[3]));
						obj.put("locationY3", Integer.toString(PaintGUI.shapes.get(i).data.pointY[3]));
						obj.put("Stroke", Float.toString((PaintGUI.shapes.get(i).data.stroke.getLineWidth())));
						obj.put("Color", (PaintGUI.shapes.get(i).data.color).toString());
						boolean f = PaintGUI.shapes.get(i).data.filled;
						if(f)
						{
							obj.put("filled", "true");
						}
						else
						{
							obj.put("filled", "false");
						}
					}
					else if(PaintGUI.shapes.get(i).data.type == 4)
					{
						obj.put("name", "Circle");
						obj.put("id", "4");
						obj.put("locationX0", Integer.toString(PaintGUI.shapes.get(i).data.pointX[0]));
						obj.put("locationY0", Integer.toString(PaintGUI.shapes.get(i).data.pointY[0]));
						obj.put("locationX1", Integer.toString(PaintGUI.shapes.get(i).data.pointX[1]));
						obj.put("locationY1", Integer.toString(PaintGUI.shapes.get(i).data.pointY[1]));
						obj.put("locationX2", Integer.toString(PaintGUI.shapes.get(i).data.pointX[2]));
						obj.put("locationY2", Integer.toString(PaintGUI.shapes.get(i).data.pointY[2]));
						obj.put("locationX3", Integer.toString(PaintGUI.shapes.get(i).data.pointX[3]));
						obj.put("locationY3", Integer.toString(PaintGUI.shapes.get(i).data.pointY[3]));
						obj.put("Stroke", Float.toString((PaintGUI.shapes.get(i).data.stroke.getLineWidth())));
						obj.put("Color", (PaintGUI.shapes.get(i).data.color).toString());
						boolean f = PaintGUI.shapes.get(i).data.filled;
						if(f)
						{
							obj.put("filled", "true");
						}
						else
						{
							obj.put("filled", "false");
						}
					}
					else if(PaintGUI.shapes.get(i).data.type == 5)
					{
						obj.put("name", "Triangle");
						obj.put("id", "5");
						obj.put("locationX0", Integer.toString(PaintGUI.shapes.get(i).data.pointX[0]));
						obj.put("locationY0", Integer.toString(PaintGUI.shapes.get(i).data.pointY[0]));
						obj.put("locationX1", Integer.toString(PaintGUI.shapes.get(i).data.pointX[1]));
						obj.put("locationY1", Integer.toString(PaintGUI.shapes.get(i).data.pointY[1]));
						obj.put("locationX2", Integer.toString(PaintGUI.shapes.get(i).data.pointX[2]));
						obj.put("locationY2", Integer.toString(PaintGUI.shapes.get(i).data.pointY[2]));
						obj.put("Stroke", Float.toString((PaintGUI.shapes.get(i).data.stroke.getLineWidth())));
						obj.put("Color", (PaintGUI.shapes.get(i).data.color).toString());
						boolean f = PaintGUI.shapes.get(i).data.filled;
						if(f)
						{
							obj.put("filled", "true");
						}
						else
						{
							obj.put("filled", "false");
						}
					}
					list.add(obj);
				}
		    }
			
			try {
				String name =JOptionPane.showInputDialog(null, "Please Enter File's name", "paint");
			    if(name==null)return;
			    String fileName = "/"+name+".json";
			    FileWriter file = new FileWriter(home+separator+directoryName+fileName);
				for(int i = 0;i<list.size();i++)
				{
					file.write(list.get(i).toJSONString());
				}
				file.flush();
				file.close();
				JOptionPane.showMessageDialog(null, "File is Successfully Saved");
		 
			} catch (IOException e) {
				e.printStackTrace();
			}
		 
			
		 
		}catch(Exception ex){}
	}
}
