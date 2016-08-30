import java.awt.Color;

import java.awt.Dimension;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JSeparator;

import javax.swing.JPanel;


public class ColorToolBar extends JPanel {
	

	private static final long serialVersionUID = 1L;
	private PaintGUI parent;
	private JButton [] colors;
	private JButton currenColor;
	
	public ColorToolBar(PaintGUI p) {
		ColorChange listener = new ColorChange();
		parent = p;
		currenColor = new JButton();
		colors = new JButton[252];
		float h = 0.004f;
		
		JPanel t = new JPanel();
		t.setLayout(new GridLayout(7,36));
		Dimension d = new Dimension(10,10);
		for(int i = 0; i < 252; i++){
			colors[i] = new JButton();
			colors[i].addActionListener(listener);
			colors[i].setBackground(Color.getHSBColor(h, 1, 1));
			h+= .004;
			colors[i].setPreferredSize(d);
			t.add(colors[i]);
		}
		
		currenColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color c = JColorChooser.showDialog(parent, "more colors", parent.drawingColor);
				if(c != null){
					parent.drawingColor = c;
					currenColor.setBackground(c);
					parent.setColor(c);
				}
			}
		});
		
		
		currenColor.setBackground(Color.black);
		currenColor.setPreferredSize(new Dimension(75,75));
		
		t.setPreferredSize(new Dimension(300,75));
		setPreferredSize(new Dimension(600,85));
		
		
		currenColor.setLocation(0, 0);
		
		add(currenColor);
		add(t);
		add(new JSeparator());
		
	}
	
	private class ColorChange implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton t = (JButton)e.getSource();
			parent.drawingColor = t.getBackground();
			currenColor.setBackground(t.getBackground());
			parent.setColor(t.getBackground());
		}
	}
	
}// end of colorToolBar
