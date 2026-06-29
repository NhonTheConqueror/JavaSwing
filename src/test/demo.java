package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class demo extends JFrame {
    private JPanel mainPanel;
    private ArrayList<JCheckBox> checkboxes = new ArrayList<>();
    private JButton countButton;
    private JLabel resultLabel;
    
    public demo() {
        setTitle("Đếm số mục đã chọn");
        setLayout(new BorderLayout());
        
        // Panel chứa các checkbox
        mainPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Thêm các checkbox
        addCheckbox("Java");
        addCheckbox("Python");
        addCheckbox("C++");
        addCheckbox("JavaScript");
        addCheckbox("Ruby");
        
        // Panel chứa nút và label
        JPanel bottomPanel = new JPanel(new FlowLayout());
        countButton = new JButton("Đếm số mục đã chọn");
        resultLabel = new JLabel("Số mục đã chọn: 0");
        
        countButton.addActionListener(e -> countSelected());
        
        bottomPanel.add(countButton);
        bottomPanel.add(resultLabel);
        
        // Thêm vào frame
        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void addCheckbox(String text) {
        JCheckBox cb = new JCheckBox(text);
        checkboxes.add(cb);
        mainPanel.add(cb);
        
        // Tự động cập nhật khi checkbox thay đổi
        cb.addActionListener(e -> updateCount());
    }
    
    private void updateCount() {
        int count = countSelected();
        resultLabel.setText("Số mục đã chọn: " + count);
    }
    
    private int countSelected() {
        int count = 0;
        for (JCheckBox cb : checkboxes) {
            if (cb.isSelected()) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        new demo();
    }
}