package lab6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class bt3 {
    protected JFrame frame = new JFrame("Ghi xamloz");
    protected textArea area = new textArea();
    protected buttonLayout buttonL = new buttonLayout();



    public bt3(){

        frame.getContentPane().add(area ,BorderLayout.CENTER);
        frame.getContentPane().add(buttonL, BorderLayout.SOUTH);
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    class textArea extends JTextField{
        public textArea(){
            setBackground(Color.LIGHT_GRAY);
            setForeground(Color.BLACK);

        }
    }

    class buttonLayout extends JPanel{
        public buttonLayout(){
            JButton clearButton = new JButton("Clear");
            JButton colorButton = new JButton("Color");

            clearButton.addActionListener(e->{
                area.setText("");
            });
            colorButton.addActionListener(e->{
                Color color = JColorChooser.showDialog(null, "Chon nhanh cmm len", area.getForeground());
                area.setForeground(color);
            });

            setLayout(new FlowLayout());
            setBackground(Color.BLACK);
            add(clearButton); add(colorButton);
            
        }
    }

    public static void main(String[] agrs){
        new bt3();
    }
}
