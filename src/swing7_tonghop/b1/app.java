package swing7_tonghop.b1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class app {
	
	JFrame frame = new JFrame("app tinh toan tao lao");
	JPanel mainPanel = new JPanel();
	
	JLabel num1Label = new JLabel("Number 1");
	JLabel num2Label = new JLabel("Number 2");
	JLabel operatorLabel = new JLabel("Operator");
	JLabel resLabel = new JLabel("Result");
	
	JTextField num1Field = new JTextField(12);
	JTextField num2Field = new JTextField(12);
	
	String[] operators = {"+", "-", "*", "/"};
	JComboBox<String> operatorBox = new JComboBox<String>(operators);
	
	JTextField resDisplay = new JTextField();
	
	JButton computeBtt = new JButton("Compute");
	JButton cancelBtt = new JButton("Canel");
	
	JMenuBar menu = new JMenuBar();
	JMenu toolsMenu = new JMenu("Tools");
	JMenu helpMenu = new JMenu("Help");
	JMenuItem computeItem = new JMenuItem("Compute");
	JMenuItem exitItem = new JMenuItem("Exit");
	JMenuItem aboutItem = new JMenuItem("About");
	
	
	public app() {
		
		mainPanel.setLayout(new GridBagLayout()); //3 cot, 5 hang
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 8, 8, 8);
		
		
		/*Line 0*/		
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.weightx = 0;
		mainPanel.add(num1Label,gbc);
		num1Field.setHorizontalAlignment(JTextField.RIGHT);
		num1Field.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isDigit(c) && c!='.') {
		            e.consume();  // Hủy sự kiện
		        }
		    }
		});
		gbc.gridx = 1;
		gbc.weightx = 1;
		mainPanel.add(num1Field, gbc);
		
		
		/*Line 1*/
		gbc.gridx = 0; gbc.gridy = 1;
		gbc.weightx = 0;
		mainPanel.add(num2Label,gbc);
		num2Field.setHorizontalAlignment(JTextField.RIGHT);
		num2Field.addKeyListener(new KeyAdapter() {
		    @Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c) && c!='.') {
					e.consume();
				}
			}
		});
		gbc.gridx = 1;
		gbc.weightx = 1;
		mainPanel.add(num2Field, gbc);
		
		
		/*Line 2*/
		gbc.gridx = 0; gbc.gridy = 2;
		mainPanel.add(operatorLabel,gbc);
		gbc.gridx = 1; gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		mainPanel.add(operatorBox, gbc);
		
		
		/*Line 3*/
		gbc.gridx = 0; gbc.gridy = 3;
		mainPanel.add(resLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 3;
		resDisplay.setHorizontalAlignment(JTextField.LEFT);
		resDisplay.setEditable(false);
		mainPanel.add(resDisplay,gbc);
		
		
		/*Line 4*/
		JPanel grButton = new JPanel(new FlowLayout());
		
		computeBtt.addActionListener(e -> {
			double ans = calculating();
			resDisplay.setText(Double.toString(ans));
		});
		
		cancelBtt.addActionListener(e -> {
			System.exit(0);
		});
		
		grButton.add(computeBtt);grButton.add(cancelBtt);
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		mainPanel.add(grButton, gbc);	
		
		
		/*Menu*/
		
		computeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		computeItem.addActionListener(e -> {
			double ans = calculating();
			resDisplay.setText(Double.toString(ans));
		});
		
		exitItem.addActionListener(e -> {
			System.exit(0);
		});
		
		toolsMenu.add(computeItem);
		toolsMenu.add(exitItem);
		
		menu.add(toolsMenu);
		
		
		aboutItem.addActionListener(e -> {
			runHelpFrame();
		});
		helpMenu.add(aboutItem);
		menu.add(helpMenu);
		
		
		
		frame.setJMenuBar(menu);
		frame.getContentPane().add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack(); frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	private void runHelpFrame() {
	    // Tạo icon
	    ImageIcon icon = null;
	    try {
	        java.net.URL imgUrl = getClass().getResource("/about.png");
	        if (imgUrl != null) {
	            icon = new ImageIcon(imgUrl);
	        }
	    } catch (Exception e) {}
	    
	    // Hiển thị hộp thoại
	    JOptionPane.showMessageDialog(
	        frame,
	        "Ứng dụng tính toán đơn giản\nPhiên bản 1.0\n© 2024 Your Name",
	        "About",
	        JOptionPane.INFORMATION_MESSAGE,
	        icon
	    );
	}


	public double calculating() {
		double ans=0;
		try {			
			double n1 = Double.parseDouble(num1Field.getText());
			double n2 = Double.parseDouble(num2Field.getText());
			String operator = operatorBox.getSelectedItem().toString();
			
			if(n2 == 0.0 && operator == "/") {
				JOptionPane.showMessageDialog(frame, "khong dc chia cho 0 tk nguuuuu");
				return 0;
			}
			
			switch (operator) {
			case "+": {ans = n1 + n2;break;}
			case "-": {ans = n1 - n2;break;}
			case "*": {ans = n1 * n2;break;}
			case "/": {ans = n1 / n2;break;}
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "vui long nhap so tk ngu");
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new app());
	}

}
