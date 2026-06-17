package lab6.BT6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class bt6 {
    JFrame frame = new JFrame("Art man nay ment");
    private Art itemArt;

    JPanel mainPanel = new JPanel();{
        mainPanel.setLayout(new GridLayout(5,5));
        
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
        JLabel nameLabel = new JLabel("Ten tac pham:");
        JLabel yearLabel = new JLabel("Nam sang tac:");
        JLabel typeLabel = new JLabel("Loai tranh:");
        JLabel styleLabel = new JLabel("Phong cach:");
        JLabel authorLabel = new JLabel("Tac gia:");
        
    }

    public void getContentFunctPanel(){
        JButton addButton = new JButton("Them");
        JButton sortButton = new JButton("Sap xep");

        

        functPanel.add(addButton); functPanel.add(sortButton);
    }

    public static void main(String[] args) {
        new bt6();
    }
}
