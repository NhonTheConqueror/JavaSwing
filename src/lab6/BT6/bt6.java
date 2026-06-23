package lab6.BT6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
        functPanel.setPreferredSize(new Dimension(500,50));
    }


    public bt6(){
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.getContentPane().add(functPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500); frame.setResizable(false);
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
            comboType.getSelectedItem().toString(), comboStyle.getSelectedItem().toString(), comboAuthor.getSelectedItem().toString()));
            fieldArtName.setText(""); fieldDateYear.setText("");
            comboType.setSelectedItem(listType.get(0));
            comboStyle.setSelectedItem(listStyle.get(0));
            comboAuthor.setSelectedItem(listAuthor.get(0));
        });
        

        functPanel.add(addButton); functPanel.add(sortButton);
    }

    public static void main(String[] args) {
        new bt6();
    }
}
