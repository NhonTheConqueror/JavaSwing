package lab6.BT6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

public class bt6 {
    JFrame frame = new JFrame("Art man nay ment");
    private ArrayList<Art> listArts = new ArrayList<>();
    private ArrayList<String> listType = new ArrayList<>();{
        listType.add("Son dau");
        listType.add("Sap");
    }
    private ArrayList<String> listStyle = new ArrayList<>();{
        listStyle.add("Phuc hung");
        listStyle.add("Hien dai");
    }
    private ArrayList<String> listAuthor = new ArrayList<>();{
        listAuthor.add("Dang Hoai Nhon");
        listAuthor.add("Dang Thi Tuyet Ha");
    }


        JTextField fieldArtName = new JTextField();
        JTextField fieldDateYear = new JTextField();

        JComboBox<String> comboType = new JComboBox<>(listType.toArray(new String[0]));
        JComboBox<String> comboStyle = new JComboBox<>(listStyle.toArray(new String[0]));
        JComboBox<String> comboAuthor = new JComboBox<>(listAuthor.toArray(new String[0]));
    JPanel mainPanel = new JPanel();{
        mainPanel.setBorder(new EmptyBorder(50,25,50,100));
        mainPanel.setLayout(new GridLayout(5,2,0,50));
        getContentMainPanel();
    }

    JPanel functPanel = new JPanel();{
        functPanel.setLayout(new FlowLayout());
        getContentFunctPanel();
        functPanel.setBackground(Color.GRAY);
    }

    JTextArea showArea = new JTextArea(10, 15);
    JPanel displayArtPanel = new JPanel();{
    		displayArtPanel.setLayout(new BoxLayout(displayArtPanel, BoxLayout.Y_AXIS));
    		displayArtPanel.setBorder(BorderFactory.createTitledBorder("Thong tin ve tac pham hoi hoa"));
    		displayArtPanel.add(new JScrollPane(showArea)); showArea.setEditable(false);
    		showArea.setFont(new Font("Arial", Font.ITALIC, 17));
    		
    }

    public bt6(){
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        JPanel connect2Bottom = new JPanel(new BorderLayout());
        connect2Bottom.add(functPanel, BorderLayout.NORTH);
        connect2Bottom.add(displayArtPanel, BorderLayout.CENTER);
        frame.getContentPane().add(connect2Bottom, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(500,500);
        frame.pack(); frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void getContentMainPanel(){
        JLabel nameLabel = new JLabel("Ten tac pham:", JLabel.RIGHT);
        JLabel yearLabel = new JLabel("Nam sang tac:", JLabel.RIGHT); 
        JLabel typeLabel = new JLabel("Loai tranh:", JLabel.RIGHT); 
        JLabel styleLabel = new JLabel("Phong cach:", JLabel.RIGHT); 
        JLabel authorLabel = new JLabel("Tac gia:", JLabel.RIGHT); 


        mainPanel.add(nameLabel);mainPanel.add(fieldArtName);
        mainPanel.add(yearLabel);mainPanel.add(fieldDateYear);
        mainPanel.add(typeLabel);mainPanel.add(comboType);
        mainPanel.add(styleLabel);mainPanel.add(comboStyle);
        mainPanel.add(authorLabel);mainPanel.add(comboAuthor);  
        
    }

    public void getContentFunctPanel(){
        JButton addButton = new JButton("Them");
        JButton sortButton = new JButton("Sap xep");

        addButton.addActionListener(e->{
        	
            listArts.add(new Art(fieldArtName.getText(), Integer.parseInt(fieldDateYear.getText()),
                    comboType.getSelectedItem().toString(), comboStyle.getSelectedItem().toString(),
                     		 comboAuthor.getSelectedItem().toString()));
            
            fieldArtName.setText(""); fieldDateYear.setText("");
            comboType.setSelectedItem(listType.get(0));
            comboStyle.setSelectedItem(listStyle.get(0));
            comboAuthor.setSelectedItem(listAuthor.get(0));
            JOptionPane.showMessageDialog(frame, "Them thanh cong!");
            show();
        });
        
        sortButton.addActionListener(e -> {
        		listArts = Art.sortByName(listArts);
        		show();
        });

        functPanel.add(addButton); functPanel.add(sortButton);
    }

    private void show() {
    		String ans = "";
    		for(Art x: listArts) {
    			ans += x.getName() + " | " + x.getAu() + "\n";
    		}
    		showArea.setText(ans);    		
	}

	public static void main(String[] args) {
        new bt6();
    }
}
