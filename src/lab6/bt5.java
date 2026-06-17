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
        String previous="";
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
        Stack<String> queue = new Stack<>();
        String temp = "";

        for(int i = 0; i<text.length(); i++){
            char c = text.charAt(i);
            if(Character.isDigit(text.charAt(i)) || text.charAt(i)=='.'){
                temp+=c;
                if(i==text.length()-1){queue.push(temp);}
            }
            else{
                queue.push(temp);
                temp = "";
                queue.push(Character.toString(c));
            }
        }
        Stack<String> nonDStack = new Stack<>();
        Stack<Double> DStack = new Stack<>();//digit stack
        //solve multiply and devide
        for(int i=0; i<queue.size();i++){
            String item = queue.get(i);
            if(item.equals("/") || item.equals("*")){
                double z = Double.parseDouble(queue.get(i+1));
                double a = DStack.pop();
                double res = ((item.equals("/")) ? a/z : a*z);
                DStack.push(res);
                i++;

            }
            else if(item.equals("+")||item.equals("-")){nonDStack.push(item);}
            else{DStack.push(Double.parseDouble(item));}
        }
        //solve plus and minus
        while(!nonDStack.isEmpty()){
                Double a = DStack.pop();
                Double b = DStack.pop();
                DStack.push( (nonDStack.pop().equals("+")) ? b+a : b-a );
        }
        String ans = DStack.pop().toString(); System.out.println(ans);
        return ans;
    }


    public static void main(String[] args){
        new bt5();
    }
}
