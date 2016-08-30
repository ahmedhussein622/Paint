
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;



public class MenuBar extends JMenuBar {
	
	private static final long serialVersionUID = 1L;
	private PaintGUI parent;
	private JButton redo,undo,delete,classLoad;
	private JFileChooser classChooser,imageChooser;
	URLClassLoader loader;
	Method addNewURL;
	private JButton save, load;
	private JButton saveJSON, loadJSON;
	private JRadioButton JSON, XML;
	private ButtonGroup choices;
	private JFileChooser chooser;
	public static File file;
	
	public MenuBar(PaintGUI p) {
		parent = p;
		
		redo = new JButton(new ImageIcon("image/redo.png"));
		undo = new JButton(new ImageIcon("image/undo.png"));
		delete = new JButton(new ImageIcon("image/delete.png"));
		save = new JButton(new ImageIcon("image/save.png"));
		load = new JButton(new ImageIcon("image/load.png"));
		JSON = new JRadioButton("JSON", true);
		XML = new JRadioButton("XML", false);
		chooser = new JFileChooser();
		choices = new ButtonGroup();
		choices.add(JSON);
		choices.add(XML);
		
		
		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.redo();
			}
		});
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.undo();
			}
		});
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.delelteShpaes();
			}
		});

		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(JSON.isSelected())new JSONSave();
				else new XMLSave();
			}
		});
		
		load.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				  int returnVal = chooser.showOpenDialog(parent);
			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			            file = chooser.getSelectedFile();
			            String name =file.getName();
			            if(name.contains("json"))
			            {
			            	new JSONRead(parent);
			            }
			            else if(name.contains("xml"))
			            {
			            	new XMLRead(parent);
			            }
			            else 
			            {
			            	System.out.println("Worng");
			            }
			        } 
			}
		});
		///////////////////////////////////////////////////////////////////
		// modifying system classloader
		
		loader = (URLClassLoader)ClassLoader.getSystemClassLoader();
		addNewURL = null;
		try {
			addNewURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
			addNewURL.setAccessible(true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		/////////////////////////////////////////////////////
		classChooser = new JFileChooser();
		imageChooser = new JFileChooser();
		
		classLoad = new JButton(new ImageIcon("image/search.png"));
		classLoad.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				classChooser.showOpenDialog(parent);
/// dynamic class loading is in here////////////////////////////////////				
				try {
					
					URL u = classChooser.getSelectedFile().toURL();
					String g = u.toString();
					g = g.substring(0, g.lastIndexOf("/")+1);// get the path
					u = new URL(g);// the final URL to load class from
					String className =classChooser.getSelectedFile().toString();
					className = className.substring(className.lastIndexOf("/")+1,className.lastIndexOf("."));
					
					
					
					addNewURL.invoke(loader, u);
					Class m = loader.loadClass(className);
					
					parent.tools.addNewShape(m, null);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}// end of actionPerformed
		});
		
		JButton credit = new JButton();
		credit.setIcon(new ImageIcon("image/copyRight.png"));
		credit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = "Paint Brush\nCreated by students:\n* Ahmed Mohamed Hussein\n* " +
						"Mohammed Abd Elrhman Elfeki\n\n Alexandria University Faculty of Engineering" +
						"\n Computer and Systems Engineering Dept\n second year , first semester." +
						"\n 2016 graduate";
				JOptionPane.showMessageDialog(parent,a,"credit",JOptionPane.PLAIN_MESSAGE);
			}
		});
		add(undo);
		add(redo);
		add(load);
		add(save);
		add(JSON);
		add(XML);
		add(Box.createHorizontalStrut(5));
		add(delete);
		add(Box.createHorizontalGlue());
		add(classLoad);
		add(Box.createHorizontalStrut(5));
		add(credit);
		parent.setJMenuBar(this);
	}
}
