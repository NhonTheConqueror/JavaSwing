package lab6;

import java.awt.Color;
import java.util.HashMap;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class bt2 extends bt1{

    public bt2(){
        super();
        HashMap<String, Color> colorMap = new HashMap<>();{
            colorMap.put("white",Color.white);
            colorMap.put("black",Color.black);
            
        }
        JTextField textF = new JTextField("type your color here!",11);
        textF.addActionListener(e->{
            //change color as user input string
            String input = textF.getText().toLowerCase().trim(); // if text wrong, background come white
            mainPanel.setBackground(colorMap.get(input));
        });

        mainPanel.add(textF);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new bt2());
    }
}
