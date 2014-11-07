package ca.centennial.practice;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
public class TestSwingCommonFeatures extends JFrame
{
//constructor
	public TestSwingCommonFeatures()
	{
		//create a panel to group three buttons, Flowlayout left
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT,2,2));
		p1.setBorder(new TitledBorder("Three Buttons"));
		p1.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		
		JButton jbtLeft = new JButton("Left");
		JButton jbtCenter = new JButton("Center");
		JButton jbtRight = new JButton("Right");
		
		jbtLeft.setBackground(Color.WHITE);
		jbtCenter.setBackground(Color.YELLOW);
		jbtRight.setToolTipText("This is the right button");
		p1.add(jbtLeft);
		p1.add(jbtCenter);
		p1.add(jbtRight);
		
		
		//create a font and a line border
		Font largeFont = new Font("TimesRoman", Font.BOLD, 20);
		LineBorder lineBorder = new LineBorder(Color.BLACK,2);
		
		//create a panel to group 2 labels
		JPanel p2 = new JPanel(new GridLayout(1,2,5,5));
		JLabel jblRed = new JLabel("Red");
		JLabel jblOrange = new JLabel("Orange");
		jblRed.setForeground(Color.RED);
		jblOrange.setForeground(Color.ORANGE);
		jblRed.setBorder(lineBorder);
		jblOrange.setBorder(lineBorder);
		jblRed.setFont(largeFont);
		jblOrange.setFont(largeFont);
		
		//add labels to p2
		p2.add(jblRed);
		p2.add(jblOrange);
		p2.setBorder(new TitledBorder("Two Labels:"));
		
		//set layout for the frame and add p1 and p2 to frame
		setLayout(new GridLayout(2,1,5,5));
		add(p1);
		add(p2);
		
	}
	
	
	public static void main(String[] args)
	{
		JFrame frame = new TestSwingCommonFeatures();
		frame.setSize(300,150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("More GUI Practice");
		frame.setVisible(true);
	}

}
