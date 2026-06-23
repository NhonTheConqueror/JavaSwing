package DeadLineOn24.bt2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.*;

public class App {
    private JFrame frame = new JFrame("Art Management");
    private Painting[] dataPaintings = new Painting[0]; 
    private String[] typeData = {"sơn dầu", "sơn mài", "gốm", "đơn sắc", "men", "thủy mặc"};
    private String[] styleData = {"Khong ro", "Hien dai", "Sieu thuc", "Vo van"};
    private String[] artistData = {"Dang Hoai Nhon", "Dang Thi Tuyet Ha"};
    private JPanel mainPanel = new JPanel(); {
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        
        JLabel underTitle = new JLabel("QUAN LY TAC PHAM NGHE THUAT", SwingConstants.CENTER);
        underTitle.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        mainPanel.add(underTitle, gbc);

        
        String[] labels = {"Ten tac pham: ", "Nam sang tac: ", "Loai tranh: ", "Phong cach: ", "Ten nghe si: "};
        JTextField nameField = new JTextField();
        // nameField.addKeyListener(new KeyAdapter() {
        //     @Override
        //     public void keyReleased(java.awt.event.KeyEvent e) {
        //         String text = nameField.getText();
        //         nameField.setText(text);
        //     }
        // });
        JTextField dateField = new JTextField();
        JComboBox<String> typeField = new JComboBox<>(typeData);
        JComboBox<String> styleField = new JComboBox<>(styleData);
        JComboBox<String> artistField = new JComboBox<>(artistData);
        JComponent[] fields = {nameField, dateField, typeField, styleField, artistField};
        gbc.gridwidth = 1;
        for (int i=0; i<labels.length; i++) {
            gbc.gridx = 0; gbc.gridy = i + 1; gbc.weightx = 0.3;
            mainPanel.add(new JLabel(labels[i]), gbc);

            gbc.gridx = 1; gbc.weightx = 0.7;
            mainPanel.add(fields[i], gbc);
        }

        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 21, 0));
        buttonPanel.setBackground(Color.lightGray);
        JButton addButton = new JButton("Them");
        JButton sortButton = new JButton("Sap xep");
        addButton.addActionListener(e -> {
            String title = nameField.getText().trim();
            int year = 0;
            try {
                year = Integer.parseInt(dateField.getText().trim());
            } catch (Exception er) {
                JOptionPane.showMessageDialog(frame, "nam sang tac phai la so nguyen chu tk ngoo!"); return;
            }
            String paintType = typeField.getSelectedItem().toString();
            String style = styleField.getSelectedItem().toString();
            String artist = artistField.getSelectedItem().toString();
            
            Painting painting = new Painting(artist, year, title, "", paintType, style);
            dataPaintings = addPainting(dataPaintings, painting);
            
            nameField.setText(""); dateField.setText("");
            typeField.setSelectedIndex(0); styleField.setSelectedIndex(0); artistField.setSelectedIndex(0);
            updateDisplayList();
        });
        sortButton.addActionListener(e -> {
            Painting.sortPaintingsByTitle(dataPaintings, true);
            updateDisplayList();
        });
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 8, 8, 8);
        buttonPanel.add(addButton); 
        buttonPanel.add(sortButton);
        mainPanel.add(buttonPanel, gbc);
    }
    JTextArea displayArea = new JTextArea(19, 30);
    JScrollPane paintInforPanel = new JScrollPane(displayArea);{
        //paintInforPanel.setBackground(Color.LIGHT_GRAY);

        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        displayArea.setEditable(false);

        paintInforPanel.setBorder(BorderFactory.createTitledBorder("Th0ng tin ve tac pham hoi hoa"));
    }

    private void updateDisplayList() {
        String text = "";
        for (int i = 0; i < dataPaintings.length; i++) {
            Painting p = dataPaintings[i];
            if (p != null) {
                
                text += (i + 1) +" -- "+ p.getTitle() +"\t\t\t"+ p.getArtist() +"\n\n";
            }
        }
        displayArea.setText(text);
    }

    private Painting[] addPainting(Painting[] old, Painting painting) {
        Painting[] newL = Arrays.copyOf(old, old.length + 1);
        newL[old.length] = painting;
        return newL;
    }

    public App() {
        frame.add(mainPanel, BorderLayout.NORTH);
        frame.add(paintInforPanel, BorderLayout.SOUTH);
        frame.setSize(420, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}