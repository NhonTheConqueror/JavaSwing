package giaidethithu;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.concurrent.Flow;

public class App {
	JFrame frame = new JFrame("Phieu bau cu cac cap");
	JPanel mainPanel = new JPanel();
	
	JPanel titlePanel = new JPanel(); 
	
	JPanel bophieuPanel = new JPanel();
	JButton bophieuBtt = new JButton("Bo Phieu");
	JLabel titleLabel = new JLabel("PHIEU BAU CU CAC CAP", JLabel.CENTER);
	
	JPanel capPhuongPanel = new JPanel();
	JPanel capQuanPanel = new JPanel();
	JPanel capTpPanel = new JPanel();
	JLabel c1 = new JLabel("So nguoi da chon: 0");
	JLabel c2 = new JLabel("So nguoi da chon: 0");
	JLabel c3 = new JLabel("So nguoi da chon: 0");
	ArrayList<JCheckBox> uv1 = new ArrayList<JCheckBox>();
	ArrayList<JCheckBox> uv2 = new ArrayList<JCheckBox>();
	ArrayList<JCheckBox> uv3 = new ArrayList<JCheckBox>();
	
	public App() {
		mainPanel.setLayout(new GridLayout(1,3,0,5));
		
		
		/*Title*/
		titlePanel.setLayout(new GridBagLayout());
		
		GridBagConstraints g = new GridBagConstraints();
		g.fill = GridBagConstraints.HORIZONTAL;
		g.weightx = 1;
		titleLabel.setBorder(BorderFactory.createLineBorder(Color.pink));
		
		titlePanel.add(titleLabel, g);
		
		
		/*nut bo phieu*/
		bophieuPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bophieuBtt.addActionListener(e -> {
			Result();
		});
		bophieuPanel.add(bophieuBtt);
		
		/*cot 1*/
		capPhuongPanel.setLayout(new BoxLayout(capPhuongPanel, BoxLayout.Y_AXIS));
		capPhuongPanel.setBorder(BorderFactory.createTitledBorder("CAP PHUONG (Chon 3)"));
		addInset(capPhuongPanel);
		
		themUV("Nguyen Tuan Khoi", this.uv1, this.c1, capPhuongPanel);
		themUV("Nguyen Xi", this.uv1, this.c1, capPhuongPanel);
		themUV("Nguyen Xuan An", this.uv1, this.c1, capPhuongPanel);
		themUV("Ho Thanh Ha", this.uv1, this.c1, capPhuongPanel);
		
		capPhuongPanel.add(c1);
		
		mainPanel.add(capPhuongPanel);
		
		
		/*cot 2*/
		capQuanPanel.setLayout(new BoxLayout(capQuanPanel, BoxLayout.Y_AXIS));
		capQuanPanel.setBorder(BorderFactory.createTitledBorder("CAP QUAN (Chon 4)"));
		addInset(capQuanPanel);
		
		themUV("Vu Thai Hoa", this.uv2, this.c2, capQuanPanel);
		themUV("Do Thi Thanh Huong", this.uv2, this.c2, capQuanPanel);
		themUV("Lam Quoc Quan", this.uv2, this.c2, capQuanPanel);
		themUV("Ho Thi Lan", this.uv2, this.c2, capQuanPanel);
		themUV("Nguyen Van Kien", this.uv2, this.c2, capQuanPanel);
		themUV("Nguyen Tan Phat", this.uv2, this.c2, capQuanPanel);
		
		capQuanPanel.add(c2);
		
		mainPanel.add(capQuanPanel);
		
		
		/*cot 3*/
		capTpPanel.setLayout(new BoxLayout(capTpPanel, BoxLayout.Y_AXIS));
		capTpPanel.setBorder(BorderFactory.createTitledBorder("CAP THANH PHO (Chon 5)"));
		addInset(capTpPanel);
		
		themUV("Le Vu Chuong", uv3, c3, capTpPanel);
		themUV("Nguyen Huu Thinh", uv3, c3, capTpPanel);
		themUV("Huynh Thanh An", uv3, c3, capTpPanel);
		themUV("Pham Van Canh", uv3, c3, capTpPanel);
		themUV("Ta Thi Kim Chi", uv3, c3, capTpPanel);
		themUV("Dang Quoc Cuong", uv3, c3, capTpPanel);
		themUV("Tran Quoc Dao", uv3, c3, capTpPanel);
		
		capTpPanel.add(c3);
		
		mainPanel.add(capTpPanel);
		
		frame.getContentPane().add(titlePanel, BorderLayout.NORTH);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		frame.getContentPane().add(bophieuPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	

	private void themUV(String n, ArrayList<JCheckBox> list, JLabel label, JPanel panel) {
		JCheckBox uv = new JCheckBox(n, false);
		list.add(uv);
		panel.add(uv);
		addInset(panel);
		uv.addActionListener(e -> {
			updateCountUV(list,label);
		});
	}

	private void addInset(JPanel panel) {
		panel.add(Box.createHorizontalStrut(2));
	}

	private void updateCountUV(ArrayList<JCheckBox> list, JLabel label) {
		int count = 0;
		for(JCheckBox x: list) {
			if(x.isSelected()) {count++;}
		}
		label.setText("So nguoi da chon: " + count);
	}

	private void Result() { //bug white screen
		frame.getContentPane().removeAll();
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1,3,0,5));
		
		/*Title*/
		titleLabel.setText("KET QUA PHIEU BAU");
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		
		
		/*nut bo phieu*/
		bophieuPanel = new JPanel();
		JButton exitBtt = new JButton("Thoat");
		exitBtt.addActionListener(e -> {
			System.exit(0);
		});
		bophieuPanel.add(exitBtt,BorderLayout.CENTER);
		
		
		/*cot 1*/
		capPhuongPanel = new JPanel();
		capPhuongPanel.setBorder(BorderFactory.createTitledBorder("PHUONG"));
		JTextArea resPhuong = new JTextArea(); resPhuong.setEditable(false);
		resPhuong.setText(showRes(3,uv1)); 
		capPhuongPanel.add(resPhuong);
		mainPanel.add(capPhuongPanel);
		
		/*cot 2*/
		capQuanPanel = new JPanel();
		capQuanPanel.setBorder(BorderFactory.createTitledBorder("QUAN"));
		JTextArea resQuan = new JTextArea(); resQuan.setEditable(false);
		resQuan.setText(showRes(4,uv2)); 
		capQuanPanel.add(resQuan);
		mainPanel.add(capQuanPanel);
		
		/*cot 3*/
		capTpPanel = new JPanel();
		capTpPanel.setBorder(BorderFactory.createTitledBorder("THANH PHO"));
		JTextArea resTP = new JTextArea(); resTP.setEditable(false);
		resTP.setText(showRes(5,uv3)); 
		capTpPanel.add(resTP);
		mainPanel.add(capTpPanel);
		
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(mainPanel, BorderLayout.CENTER);
		frame.add(bophieuPanel, BorderLayout.SOUTH);
	    frame.revalidate();
	    frame.repaint();
	}
	
	
	
	private String showRes(int n, ArrayList<JCheckBox> list) {
		String ans = "";
		int count = 0;
		
		for(JCheckBox x: list) {
			if(x.isSelected()) {
				count++;
				ans += x.getText() + "\n";
			}
		}
		
		return (count==n) ? ans : "phieu khong hop le";
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new App());
	}
}
