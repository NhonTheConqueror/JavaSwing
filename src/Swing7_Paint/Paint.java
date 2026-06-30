package Swing7_Paint;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Paint {
	
	JFrame frame = new JFrame("Paint xam loz");
	
	JMenuBar menu = new JMenuBar();
	JMenu shapeMenu = new JMenu("Hình");
	JMenuItem lineShape, rectShape, ovalShape;
	JMenu inforMenu = new JMenu("Thong tin tac gia");
	JMenuItem inforItem = new JMenuItem("Thong tin");
	JMenuItem exit = new JMenuItem("Thoat");
	
	JPanel mainPanel = new JPanel();//use border
	
	JPanel drawPanel = new JPanel();//default
	ArrayList<>
	
	
	JPanel quickShapePanel = new JPanel();//box y.axis
	JButton lineButton = new JButton("Duong thang");
	JButton rectButton = new JButton("Hinh chu nhat");
	JButton ovalButton = new JButton("Hinh oval");
	
	JPanel propertyPanel = new JPanel(); //flow
	JCheckBox isFill = new JCheckBox("Hinh dac cau",false);
	Color[] colors = {Color.BLUE, Color.RED, Color.GREEN};
	JComboBox<Color> colorPick = new JComboBox<>(colors);
	
	JPanel inforPanel = new JPanel(new GridBagLayout());	
	
	
	public Paint() {
		
		/*Menu*/
		ImageIcon ic = new ImageIcon("src/bt7/adu1.jpg");
		
		lineShape = new JMenuItem("Duong thang", ic);
		rectShape = new JMenuItem("Hinh chu nhat", ic);
		ovalShape = new JMenuItem("Hinh oval", ic);
		shapeMenu.add(lineShape);
		shapeMenu.add(rectShape);
		shapeMenu.add(ovalShape);
		menu.add(shapeMenu);
		
		inforItem.addActionListener(e -> {
			
		});
		exit.addActionListener(e -> {
			System.exit(0);
		});
		inforMenu.add(inforItem);
		inforMenu.add(exit);
		menu.add(inforMenu);
		
		
		/*paint screen*/
		
		
		
		frame.setJMenuBar(menu);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,700);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	class Shape{
		
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Paint());
	}
}
