package lab6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class demo extends JPanel {
    private JTextArea txtArea;

    public demo() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        txtArea = new JTextArea();
        add(txtArea);

        JPanel panel = new JPanel();
        add(panel);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtArea.setText("");
            }
        });
        panel.add(btnClear);

        JButton btnColor = new JButton("Color");
        btnColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(demo.this,
                        "Choose color for Text", txtArea.getForeground());
                txtArea.setForeground(color);
            }
        });
        panel.add(btnColor);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Text Color Change Demo");
                frame.setContentPane(new demo());
                frame.setSize(300, 200);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
    }
}