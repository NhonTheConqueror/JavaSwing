package bt7;
import javax.swing.*;
import java.awt.*;

public class app {
	JFrame frame = new JFrame("giao dien xam cu");
	JTextArea word = new JTextArea();{
		word.setFont(new Font("Arial", Font.ITALIC, 15));
		word.setBackground(Color.cyan);
	}
	JButton saveAsButton = new JButton("Save As");
	JButton okButton = new JButton("Ok");
	JButton exitButton = new JButton("Exit");{
		exitButton.addActionListener(e -> { 
			// exit app
		});
	}
	JTextField pathField = new JTextField("C:\\Document.txt");
	JPanel mainPanel = new JPanel();{
		mainPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 8, 8, 8);
		
		
			/*Setting text area*/
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER; //2;
		gbc.weightx = 1; gbc.weighty = 1;
		mainPanel.add(new JScrollPane(word),gbc); // gridx = 0 = gridy
		
        	/*Reset*/
        gbc.gridwidth = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
		
        	/*Setting save bar*/
        // Save As button
        gbc.weightx = 0;
        gbc.gridx = 0; gbc.gridy = 1;
        mainPanel.add(saveAsButton, gbc);
        // Path Field
        gbc.weightx =1;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(pathField, gbc);
		
        	/*Reset*/
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;
        
        	/*Setting funct bar*/
        JPanel functButtons = new JPanel();
        functButtons.setLayout(new FlowLayout(FlowLayout.RIGHT,8,0));
        functButtons.setOpaque(false);
        functButtons.add(okButton);
        functButtons.add(exitButton);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 1; gbc.gridy = 2;
        mainPanel.add(functButtons,gbc);
	}
	
	
	
	public app() {
		frame.getContentPane().add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		frame.setSize(500,500); frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] agrs) {
		new app();
	}
}

