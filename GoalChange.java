import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.io.PrintWriter;
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class GoalChange extends JFrame implements ActionListener {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 400;

	private JTextField money;
	private JTextField deadLine;
	private String moneyCheck = "No MONEY.";
	private String dlCheck = "No DEAD LINE.";
	String fileName = "goalMoney.txt";
	PrintWriter outputStream = null;
	
	
	public GoalChange() {
		
		try // 
		{
			outputStream = new PrintWriter(fileName); /*�������� ��Ȳ
			�ǵ��Ѵ�� ���� �������� �ȵɶ��� ���� �� �ִ�
			*/ 
		}
		catch (FileNotFoundException e) /*������ ������ ������ �� �ȵǾ�����?*/
		{
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		
		setSize(WIDTH, HEIGHT);

		setTitle("Goal Change");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setLayout(new FlowLayout());
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		buttonPanel.add(saveButton);

		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		buttonPanel.add(clearButton);
		

		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridBagLayout());
		JLabel goalM = new JLabel("��ǥ�ݾ��� �Է��ϼ���");
		JLabel deadT = new JLabel("��ǥ������ �Է��ϼ���");
		money = new JTextField(20);
		deadLine = new JTextField(20);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(20, 20, 17, 0);

		textPanel.add(goalM);
		textPanel.add(money, gbc);
		textPanel.add(deadT);
		textPanel.add(deadLine, gbc);

		contentPane.add(textPanel, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Save")) {
			moneyCheck = money.getText();
			dlCheck = deadLine.getText();
			outputStream.println(moneyCheck);
			outputStream.println(dlCheck);
		} else if (actionCommand.equals("Clear")) {
			money.setText("");
			deadLine.setText("");
		} 

		else
			money.setText("Error in memo interface");
		outputStream.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoalChange guiMemo = new GoalChange();
		guiMemo.setVisible(true);
	}

}
