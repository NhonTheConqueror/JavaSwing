package lab6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class bt3 {
    protected JFrame frame = new JFrame("Ghi xamloz");
    protected JTextArea area = new textArea();
    protected JPanel buttonL = new buttonLayout();
    protected JMenuBar menuBar = new menuSetup();


    public bt3(){

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(area ,BorderLayout.CENTER);
        frame.getContentPane().add(buttonL, BorderLayout.SOUTH);
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    class menuSetup extends JMenuBar{
        public menuSetup(){
            JMenu fileMenu = new JMenu("File");
            JMenu toolMenu = new JMenu("Tools");
            
            JMenuItem openI = new JMenuItem("open");
            JMenuItem saveI = new JMenuItem("save");
            JMenuItem saveAsI = new JMenuItem("save as");
            //
            fileMenu.add(openI);fileMenu.add(saveI);fileMenu.add(saveAsI);

            add(fileMenu);add(toolMenu);
        }
    }

    class textArea extends JTextArea{
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
                //the only line needed for JColorChooser dialog funct.
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
