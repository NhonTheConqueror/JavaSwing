package bt7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class otherApp {
	
	JFrame frame = new JFrame("menu vo van");
	private JMenuBar menuBar = new JMenuBar();
	
	public otherApp() {
		
		JMenu aMenu = new JMenu("A Menu");
		aMenu.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem menuItem1 = new JMenuItem("A text only menu item");
		menuItem1.setMnemonic(KeyEvent.VK_T);
		menuItem1.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.ALT_MASK));
		menuItem1.addActionListener(e -> {
			JOptionPane.showMessageDialog(frame, "adu1");
		});
		
		
		Image img1 = new ImageIcon("src/bt7/adu1.jpg")
				.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		ImageIcon icon1 = new ImageIcon(img1);
		JMenuItem menuItem2 = new JMenuItem("Both text and icon", icon1);
		
		JMenuItem menuItem3 = new JMenuItem(icon1);
		
		JRadioButtonMenuItem rb1 = new JRadioButtonMenuItem("A radio button menu item");
		JRadioButtonMenuItem rb2 = new JRadioButtonMenuItem("Another one");
		ButtonGroup rbGroup3 = new ButtonGroup();
		rbGroup3.add(rb1); rbGroup3.add(rb2);
		
		JCheckBoxMenuItem cb1 = new JCheckBoxMenuItem("A check box menu item");
		JCheckBoxMenuItem cb2 = new JCheckBoxMenuItem("Another one");
		
		
		aMenu.add(menuItem1);		aMenu.addSeparator();
		aMenu.add(menuItem2);		aMenu.addSeparator();
		aMenu.add(menuItem3); 		aMenu.addSeparator();
		aMenu.add(rb1); aMenu.add(rb2);		aMenu.addSeparator();
		aMenu.add(cb1); aMenu.add(cb2);
		
		menuBar.add(aMenu);
		
		

		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500); frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> new otherApp());
	}
}
