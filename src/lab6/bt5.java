package lab6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class bt5 {
    protected JFrame frame = new JFrame("may tinh loz");
    protected JTextField displayScreen = new JTextField();{
        displayScreen.setHorizontalAlignment(JTextField.CENTER);
        displayScreen.setFont(new Font("Arial", Font.BOLD, 24));
    }

    protected JPanel butonCal = new JPanel();{
        butonCal.setLayout(new GridLayout(4,4));
        butonCal.setBackground(Color.DARK_GRAY);

        String[] elements = {
            "9", "8", "7", "+",
            "4", "5", "6", "-",
            "3", "2", "1", "*",
            ".", "0", "/", "="
        };

        for(String i: elements){
            JButton button = new JButton(i);
            button.addActionListener(e->{
                if(i.equals("=")){
                    String ans = xCalculation(displayScreen.getText());
                    displayScreen.setText(ans);
                }
                else{displayScreen.setText(displayScreen.getText() + i);}
            });
            butonCal.add(button);
        }
    }

    public bt5(){

        frame.getContentPane().add(displayScreen, BorderLayout.NORTH);
        frame.getContentPane().add(butonCal, BorderLayout.CENTER);
        frame.setSize(300,300); frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    private String xCalculation(String text) {
        Stack<Double> numQueue = new Stack<>();
        Stack<Character> calQueue = new Stack<>();
        String temp = "";

        for(int i = 0; i<text.length(); i++){
            char c = text.charAt(i);
            if(Character.isDigit(text.charAt(i)) || text.charAt(i)=='.'){
                temp+=c; temp = "";
            }
            else{
                numQueue.push(Double.parseDouble(temp));
                if(c=='/' || c=='*'){
                    Double a = numQueue.pop();
                    Double b = numQueue.pop();
                    numQueue.push( (c=='/') ? a/b : a*b );
                }
                calQueue.push(c);
            }
        }

        while(!calQueue.isEmpty()){
                Double a = numQueue.pop();
                Double b = numQueue.pop();
                numQueue.push( (calQueue.pop()=='+') ? b+a : b-a );
        }
        String ans = numQueue.pop().toString(); System.out.println(ans);
        return ans;
    }


    public static void main(String[] args){
        new bt5();
    }
}
