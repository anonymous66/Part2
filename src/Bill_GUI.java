import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Bill_GUI extends JFrame implements ActionListener{
	
	private HashSet<Dish> menu;
	private HashMap<Integer,HashSet<Order>> orders;

	// -----------------------------------------------//
	// Adding main Attributes
	private String[] Tables = { "--- Select Table ---", " Table 1", " Table 2", " Table 3", " Table 4",
			" Table 5", " Table 6", " Table 7", " Table 8", " Table 9", " Table 10" };
	private JPanel mainPanel, northPanel, centerPanel;
	private JComboBox<String> dropdownBox;
	private JTextArea resultWindow;

	// -----------------------------------------------//
	// Starting my Main Window
	public Bill_GUI(HashSet<Dish> menu,HashMap<Integer,HashSet<Order>> orders) {

		this.menu=menu;
		this.orders=orders;
		
		//
		mainPanel = new JPanel();
		northPanel = new JPanel();
		centerPanel = new JPanel();
		resultWindow = new JTextArea(30, 20);
		resultWindow.setEditable(false);
		JScrollPane scrollList = new JScrollPane(resultWindow);
		dropdownBox = new JComboBox<String>();

		// instering and configuring Panels
		mainPanel = new JPanel(new GridLayout(2, 1));
		mainPanel.setVisible(true);
		northPanel = new JPanel(new GridLayout(5, 1));
		northPanel.setVisible(true);
		centerPanel = new JPanel(new GridLayout(1, 1));
		centerPanel.setVisible(true);
		// populating JComboBox
		for (int i = 0; i < 11; i++) {
			dropdownBox.addItem(Tables[i]);
		}

		// Main Panel
		mainPanel.add(northPanel);
		mainPanel.add(centerPanel);
		// North Panel
		northPanel.add(dropdownBox);
		northPanel.add(new JLabel(""));
		dropdownBox.setBorder(BorderFactory.createTitledBorder("Vacation Resort"));
		northPanel.add(new JLabel(""));
		northPanel.add(new JLabel(""));
		northPanel.add(new JLabel(""));
		// Center Panel
		centerPanel.add(scrollList);
		
		ChoiceComboListener listener = new ChoiceComboListener();
		dropdownBox.addActionListener(listener);
		// Stage 4. Set Content

		this.setContentPane(mainPanel);
		this.setVisible(true);
		this.setSize(600, 800);
		this.setTitle("Bill");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// Create ComboBox Listener
		public class ChoiceComboListener implements ActionListener {
			public void actionPerformed(ActionEvent ev) {
				JComboBox<?> cb = (JComboBox<?>) ev.getSource();
				String currentComboSelection = (String) cb.getSelectedItem();
				Bill bill = new Bill(menu,orders);
				if (currentComboSelection.equals(Tables[0])) {
					resultWindow.setText("");
				} else if (currentComboSelection.equals(Tables[1])) {
					resultWindow.setText(bill.StringOPrintedBill(1));
				} else if (currentComboSelection.equals(Tables[2])) {
					resultWindow.setText(bill.StringOPrintedBill(2));
				} else if (currentComboSelection.equals(Tables[3])) {
					resultWindow.setText(bill.StringOPrintedBill(3));
				}else if (currentComboSelection.equals(Tables[4])) {
					resultWindow.setText(bill.StringOPrintedBill(4));
				}else if (currentComboSelection.equals(Tables[5])) {
					resultWindow.setText(bill.StringOPrintedBill(5));
				}else if (currentComboSelection.equals(Tables[6])) {
					resultWindow.setText(bill.StringOPrintedBill(6));
				}else if (currentComboSelection.equals(Tables[7])) {
					resultWindow.setText(bill.StringOPrintedBill(7));
				}else if (currentComboSelection.equals(Tables[8])) {
					resultWindow.setText(bill.StringOPrintedBill(8));
				}else if (currentComboSelection.equals(Tables[9])) {
					resultWindow.setText(bill.StringOPrintedBill(9));
				}else if (currentComboSelection.equals(Tables[10])) {
					resultWindow.setText(bill.StringOPrintedBill(10));
				}
			}
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

		// -------------------------------------------------------------------//

}
