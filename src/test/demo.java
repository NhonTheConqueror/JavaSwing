package test;


import java.awt.*;
import javax.swing.*;

public class demo extends JPanel {
	private JTextArea textArea;
	private JButton bSaveAs, bOk, bExit;
	private JTextField fileField;
	public demo() {
		setLayout(new BorderLayout(2, 2));
		setBorder(BorderFactory.createEtchedBorder());
		textArea = new JTextArea(12, 40); // 12 rows, 40 cols
		bSaveAs = new JButton("Save As");
		fileField = new JTextField("C:\\Document.txt");
		bOk = new JButton("OK");
		bExit = new JButton("Exit");
		
		add(textArea, BorderLayout.CENTER);
		// Set up buttons and textfield in bottom panel.
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(2, 1));
		JPanel subPanel1 = new JPanel();
		subPanel1.setLayout(new BorderLayout());
		subPanel1.add(bSaveAs, BorderLayout.WEST);
		subPanel1.add(fileField, BorderLayout.CENTER);
		JPanel subPanel2 = new JPanel();
		subPanel2.setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 2));
		subPanel2.add(bOk);
		subPanel2.add(bExit);
		bottomPanel.add(subPanel1);
		bottomPanel.add(subPanel2);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		//WindowUtilities.setNativeLookAndFeel();
		JFrame frame = new JFrame("Nested Containers");
		frame.setContentPane(new demo());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}