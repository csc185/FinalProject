package pointOfSale;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import utils.ObjWriter;

public class ProcessPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L; // Added to satisfy the
														// compiler
	private static final Color DARK_CHAMPAGNE = new Color(194, 178, 128);
	private static final String RECEIPT_PATH = "Files/Receipt";
	private static final String RECEIPT_LIST = RECEIPT_PATH + "/ReceiptList";

	private JPanel upperPanel = new JPanel(new GridLayout(3, 1));
	private JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
	private static DefaultListModel<String> listModel = new DefaultListModel<String>();
	private static JList<String> receiptList = new JList<String>(listModel);
	private JLabel titleLabel = new JLabel("Process Receipt",
			SwingConstants.CENTER);
	private JLabel listLabel = new JLabel("Select Receipt from list below",
			SwingConstants.LEFT);

	private static boolean isAdmin;

	public ProcessPanel(boolean isAdmin__) {
		isAdmin = isAdmin__;
		setLayout(new GridLayout(2, 1));
		setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,
				DARK_CHAMPAGNE));

		readReceipts();
		receiptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		receiptList.setSelectionBackground(new Color(132, 250, 53));
		receiptList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getClickCount() >= 2)
				{
					if (receiptList.getSelectedIndex() > -1) {
						CardPanel.setLoaded(true);
						CardPanel.reset();
						CardPanel.DisplayFocus(true);
						ReceiptPanel.loadReceipt(receiptList.getSelectedValue());
						CardPanel.loadReciept(new File(RECEIPT_PATH + "/"
								+ receiptList.getSelectedValue()));

					}
					if(!receiptList.isFocusOwner()){
						receiptList.clearSelection();
						//receiptList.setSelectionBackground(Color.white);
						System.out.print(receiptList.getSelectedIndex());
					}
				} 
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		titleLabel.setVerticalAlignment(SwingConstants.TOP);
		titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 24));
		listLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		listLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 18));

		buttonPanel.setBackground(DARK_CHAMPAGNE);
		buttonPanel.add(new MenuButton("Load", "Load", this));
		// if(isAdmin)
		// buttonPanel.add(new MenuButton("Void", "Void", this));
		// else
		Tools.addBlankSpace(buttonPanel, 1);
		// buttonPanel.add(new MenuButton("Delete", "Delete", this));
		// buttonPanel.add(new MenuButton("Card", "Card", this));
		buttonPanel.add(new MenuButton("Gift Card", "Gift Card", this));
		buttonPanel.add(new MenuButton("Debit", "Debit", this));
		buttonPanel.add(new MenuButton("Cash", "Cash", this));
		buttonPanel.add(new MenuButton("Back", "Back", this));

		upperPanel.setBackground(DARK_CHAMPAGNE);
		upperPanel.add(titleLabel);
		upperPanel.add(buttonPanel);
		upperPanel.add(listLabel);

		add(upperPanel);
		add(new JScrollPane(receiptList,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
	}
   //Tanes makes changed on 5-24-2014 to support binary file reading the receipt
	private void readReceipts() {
		listModel.removeAllElements();
		Scanner inputStream = null;
		Scanner reader = null;
		try {
			inputStream = new Scanner(new File(RECEIPT_LIST));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine().trim();
			System.out.println(RECEIPT_PATH + "/" + line);
			try {
				reader = new Scanner(new File(RECEIPT_PATH + "/" + line));
			} catch (FileNotFoundException e) {
				System.out.println("Reciept file not found");
				continue;
			}

			if (line.equals(""))
				;
			else {
				String read = reader.nextLine().trim();
				// System.out.println(read.matches("OPEN"));
				if (read.equalsIgnoreCase("OPEN")
						|| read.equalsIgnoreCase("PROGRESS")) {
					listModel.addElement(line);
				}
			}
		}
		if (reader != null)
			reader.close();
		inputStream.close();
	}
	
	/*private void readReceipts() {
		listModel.removeAllElements();
		Scanner inputStream = null;
		Scanner reader = null;
		try {
			inputStream = new Scanner(new File(RECEIPT_LIST));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine().trim();
			System.out.println(RECEIPT_PATH + "/" + line);
			try {
				reader = new Scanner(new File(RECEIPT_PATH + "/" + line));
			} catch (FileNotFoundException e) {
				System.out.println("Reciept file not found");
				continue;
			}

			if (line.equals(""))
				;
			else {
				String read = reader.nextLine().trim();
				// System.out.println(read.matches("OPEN"));
				if (read.equalsIgnoreCase("OPEN")
						|| read.equalsIgnoreCase("PROGRESS")) {
					listModel.addElement(line);
				}
			}
		}
		if (reader != null)
			reader.close();
		inputStream.close();
	}*/

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getActionCommand().equals("Load")
				&& receiptList.getSelectedIndex() > -1) {
			CardPanel.setLoaded(true);
			CardPanel.reset();
			CardPanel.DisplayFocus(true);
			ReceiptPanel.loadReceipt(receiptList.getSelectedValue());
			CardPanel.loadReciept(new File(RECEIPT_PATH + "/"
					+ receiptList.getSelectedValue()));

		}
		if (event.getActionCommand().equals("Delete")
				&& receiptList.getSelectedIndex() > -1)
			deleteReceipt();
		if (event.getActionCommand().equals("Cash")
				&& receiptList.getSelectedIndex() > -1) {
			closeReceipt("CASH");
			SystemInit.setTransactionScreen();
		}
		if (event.getActionCommand().equals("Card")
				&& receiptList.getSelectedIndex() > -1)
			closeReceipt("CARD");
		if (event.getActionCommand().equals("Back")) {
			SystemInit.setTransactionScreen();
			if (!receiptList.isSelectedIndex(-1))
				ReceiptPanel.loadReceipt(receiptList.getSelectedValue());
			CardPanel.clearDisplay();
			CardPanel.setLoaded(false);
			CardPanel.timerCheck();
		}
		// Jung needs to program giftcard at this point
		if (event.getActionCommand().equals("Gift Card")
				&& receiptList.getSelectedIndex() > -1) {

		}

		// Jung needs to program giftcard at this point
		if (event.getActionCommand().equals("Debit")
				&& receiptList.getSelectedIndex() > -1) {

		}

	}

	private void deleteReceipt() {
		File file = new File(RECEIPT_PATH + "/"
				+ receiptList.getSelectedValue());
		file.delete();

		listModel.removeElementAt(receiptList.getSelectedIndex());

		saveReceiptList();
		ReceiptPanel.clearReceipt();
	}

	private void saveReceiptList() {
		PrintWriter listWriter = null;
		try {
			listWriter = new PrintWriter(RECEIPT_LIST);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		for (int count = 0; count < listModel.getSize(); count++)
			listWriter.println(listModel.getElementAt(count));
		listWriter.close();
	}

	public static void closeReceipt(String title) {
		closeReceipt(title,
				new File(RECEIPT_PATH + "/" + receiptList.getSelectedValue()));
		SystemInit.setProcessScreen(isAdmin);
	}

	public static void closeReceipt(String title, File file) {
		// File file = new File(RECEIPT_PATH + "/"
		// + receiptList.getSelectedValue());
		Scanner reader = null;
		PrintWriter printer = null;
		String toPrint = "";
		try {
			reader = new Scanner(file);
			if (!title.equalsIgnoreCase("OPEN")) {
				reader.nextLine();
			}
			toPrint += title;
			while (reader.hasNextLine()) {
				toPrint += "\n" + reader.nextLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error reading");
			return;
		}
		try {
			printer = new PrintWriter(file);
			printer.println(toPrint);
			printer.flush();
			printer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error printing");
		}

	}

	public static void closeReceipt(String title, String approve) {
		closeReceipt(title,
				new File(RECEIPT_PATH + "/" + receiptList.getSelectedValue()),
				approve);
		SystemInit.setProcessScreen(isAdmin);
	}

	public static void closeReceipt(String title, File file, String approve) {
		// File file = new File(RECEIPT_PATH + "/"
		// + receiptList.getSelectedValue());
		Scanner reader = null;
		PrintWriter printer = null;
		String toPrint = "";
		try {
			reader = new Scanner(file);
			if (!title.equalsIgnoreCase("OPEN")) {
				reader.nextLine();
			}
			toPrint += title;
			while (reader.hasNextLine()) {
				toPrint += "\n" + reader.nextLine();

			}
			if (approve != null && !approve.equals("")) {
				toPrint += "\n" + Tools.toMoney(approve)
						+ ReceiptPanel.manualTab(Tools.toMoney(approve))
						+ "Approved";
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error reading");
			return;
		}
		try {
			printer = new PrintWriter(file);
			printer.println(toPrint);
			printer.flush();
			printer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error printing");
		}

	}

	public static void toggleSelection() {
		if (receiptList.getSelectionBackground()
				.equals(new Color(132, 250, 53))) {
			receiptList.setSelectionBackground(new Color(252, 28, 35));
		} else {
			receiptList.setSelectionBackground(new Color(132, 250, 53));
		}
	}

}
