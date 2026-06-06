package lab6;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class bt1{

    protected JFrame frame = new JFrame("App xamloz");
    protected JPanel mainPanel = new JPanel();
    
    public bt1(){
        
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY);

        JButton redColor = new JButton("Red");
        JButton greenColor = new JButton("Green");
        JButton blueColor = new JButton("Blue");
        //
        redColor.addActionListener(e->{
            mainPanel.setBackground(Color.RED);
        });
        greenColor.addActionListener(e->{
            mainPanel.setBackground(Color.GREEN);
        });
        blueColor.addActionListener(e->{
            mainPanel.setBackground(Color.BLUE);
        });
        mainPanel.add(redColor); mainPanel.add(greenColor); mainPanel.add(blueColor);

        frame.add(mainPanel);
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



    public static void main(String[] args){
        new bt1();
    }

}
