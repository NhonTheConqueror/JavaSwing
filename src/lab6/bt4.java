package lab6;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.time.LocalTime;

public class bt4 {
    protected JFrame frame = new JFrame("app dong ho");
    protected JPanel clockPanelLayout = new JPanel();
    private JLabel timeLabel = new JLabel();

    public bt4(){
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        clockPanelLayout.setLayout(new GridBagLayout());
        clockPanelLayout.add(timeLabel);
        frame.add(clockPanelLayout, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);; frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        try {
            addLabelClock();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private void addLabelClock() throws InterruptedException {
        LocalTime time = LocalTime.now();
        //update by 1000ms (1s)
        try {
            while(true){
                time = LocalTime.now();
                String hour = (String.valueOf(time.getHour()).length() == 1) ? 
                    ("0"+String.valueOf(time.getHour())) : (String.valueOf(time.getHour()));
                String minute = (String.valueOf(time.getMinute()).length() == 1) ? 
                    ("0"+String.valueOf(time.getMinute())) : (String.valueOf(time.getMinute()));
                String second = (String.valueOf(time.getSecond()).length() == 1) ? 
                    ("0"+String.valueOf(time.getSecond())) : (String.valueOf(time.getSecond()));

                timeLabel.setText(hour + ":" + minute + ":" + second);

                //delay time (ms)
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args){
        new bt4();
    }
}
