package test;

import java.awt.*;
import javax.swing.*;

public class demo extends JPanel {

    private JTextArea textArea;
    private JButton bSaveAs, bOk, bExit;
    private JTextField fileField;
    private GridBagConstraints c;

    public demo() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEtchedBorder());

        textArea = new JTextArea(12, 40); // 12 rows, 40 cols
        bSaveAs = new JButton("Save As");
        fileField = new JTextField("C:\\Document.txt");
        bOk = new JButton("OK");
        bExit = new JButton("Exit");

        c = new GridBagConstraints();

        // Text Area.
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(2, 2, 2, 2); // t,l,b,r
        add(textArea, c);

        // Save As Button.
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.VERTICAL;
        add(bSaveAs, c);

        // Filename Input (Textfield).
        c.gridx = 1;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.BOTH;
        add(fileField, c);

        // OK Button.
        c.gridx = 2;
        c.gridy++;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.NONE;
        add(bOk, c);

        // Exit Button.
        c.gridx = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.NONE;
        add(bExit, c);

        // Filler so Column 1 has nonzero width.
        Component filler = Box.createRigidArea(new Dimension(1, 1));
        c.gridx = 1;
        c.weightx = 1.0;
        add(filler, c);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Lưu ý: Lớp WindowUtilities cần được định nghĩa riêng hoặc thay bằng code LookAndFeel chuẩn nếu bị báo lỗi.
                //WindowUtilities.setNativeLookAndFeel();
                JFrame frame = new JFrame("GridBagLayout Test");
                frame.setContentPane(new demo());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}