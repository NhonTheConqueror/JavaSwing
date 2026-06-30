package lab6.BT6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RemakeArtManagement {
	
    JFrame frame = new JFrame("Art man nay ment");
    private ArrayList<Art> listArts = new ArrayList<>();
    private ArrayList<String> listType = new ArrayList<>();{
        listType.add("Son dau");
        listType.add("Sap");
    }
    private ArrayList<String> listStyle = new ArrayList<>();{
        listStyle.add("Phuc hung");
        listStyle.add("Hien dai");
    }
    private ArrayList<String> listAuthor = new ArrayList<>();{
        listAuthor.add("Dang Hoai Nhon");
        listAuthor.add("Dang Thi Tuyet Ha");
    }


        JTextField fieldArtName = new JTextField();
        JTextField fieldDateYear = new JTextField();

        JComboBox<String> comboType = new JComboBox<>(listType.toArray(new String[0]));
        JComboBox<String> comboStyle = new JComboBox<>(listStyle.toArray(new String[0]));
        JComboBox<String> comboAuthor = new JComboBox<>(listAuthor.toArray(new String[0]));
    JPanel mainPanel = new JPanel();{
        

        mainPanel.setBorder(new EmptyBorder(50,25,50,100));
        mainPanel.setLayout(new GridLayout(5,2,0,50));
        getContentMainPanel();
    }

    JPanel functPanel = new JPanel();{
        functPanel.setLayout(new FlowLayout());
        getContentFunctPanel();
        functPanel.setBackground(Color.GRAY);
        functPanel.setPreferredSize(new Dimension(500,50));
    }

	
	public static void main(String[] args) {
		
	}
}
