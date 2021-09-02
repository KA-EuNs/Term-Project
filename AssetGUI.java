import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class AssetGUI extends JFrame implements ActionListener {

	public static final int WIDTH = 500;
	public static final int HEIGHT = 400;
	public static final int BUTTONWIDTH = 100;
	public static final int BUTTONHEIGHT = 100;
	private JButton enterButton;
	private JButton expenditureButton;
	private JButton goalButton;
	private JLabel currentAsset;
	private JLabel goalMoney;
	private JLabel remaindingMoney;
	private JLabel remainder;

	int remaindingAmount; // �Ŵ� ����ݾ�
	int currentTotal; // �����ڻ�
	int achievementRate; // ��ǥ�ݾ� �޼���
	int savingMoney; // ���� ����ݾ�

	String fileName = "goalMoney.txt"; // ��ǥ�ݾ� ���� ��������
	Scanner inputStream = null;

	File fileName1 = new File("InputMoneyData.txt");

	public AssetGUI() {
		// ���� ��������
		try {
			inputStream = new Scanner(new File(fileName));
			ObjectInputStream thisInputStream = new ObjectInputStream(new FileInputStream(fileName1));
			InputMoney thisMonthOut = (InputMoney) thisInputStream.readObject();
			currentTotal = thisMonthOut.getcurrentAsset();
			savingMoney = thisMonthOut.getCategoryEtc();

			thisInputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Error opening the file ");
			e.printStackTrace();
			System.exit(0);
		} catch (ClassNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
			System.exit(0);
		}

		setSize(WIDTH, HEIGHT);
		setTitle("main page");
		Container content = getContentPane();
		content.setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridBagLayout());
		topPanel.setPreferredSize(new Dimension(WIDTH, 100));
		topPanel.setBackground(Color.LIGHT_GRAY);
		currentAsset = new JLabel("���������� �����ڻ��� " + currentTotal + "���Դϴ�");
		currentAsset.setPreferredSize(new java.awt.Dimension(500, 500));
		topPanel.add(currentAsset);
		topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		String gMoney;
		String dead;
		int goal, deadLine;
		if (inputStream.hasNextLine() == true) {
			gMoney = inputStream.nextLine();
			dead = inputStream.nextLine();
			goal = Integer.parseInt(gMoney);
			deadLine = Integer.parseInt(dead);
			remaindingAmount = (goal - savingMoney) / deadLine;
		} else {
			gMoney = "100000";
			dead = "5";
			goal = Integer.parseInt(gMoney);
			deadLine = Integer.parseInt(dead);
			remaindingAmount = (goal - savingMoney) / deadLine;
		}
		// �޼��� �׸����� �����ֱ�
		achievementRate = 100 * savingMoney / goal;
		System.out.println(achievementRate);
		JPanel starPanel = new JPanel();
		starPanel.setLayout(new BorderLayout());
		starPanel.setPreferredSize(new Dimension(161, HEIGHT));
		starPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		MyPanel starGraph = new MyPanel();
		starPanel.add(starGraph, BorderLayout.CENTER);
		starPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 10, 10));
		starGraph.setBackground(Color.YELLOW);
		JLabel achiverRate = new JLabel("�޼���: " + achievementRate + "%");
		starPanel.add(achiverRate, BorderLayout.SOUTH);
		achiverRate.setHorizontalAlignment(JLabel.CENTER);
		JPanel goalPanel = new JPanel();
		goalPanel.setLayout(new GridBagLayout());

		goalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		// ��ǥ�ڻ�� �Ŵ� ����ݾ� �����ֱ�

		JLabel goalAsset = new JLabel(
				"<html>��ǥ�ڻ��� " + goal + "���Դϴ�<br>" + "�Ŵ� ����ݾ��� " + remaindingAmount + "���Դϴ� </html>");
		goalPanel.add(goalAsset);
		goalPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// ��ư ����
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 3, 0, 0));
		buttonPanel.setPreferredSize(new Dimension(WIDTH, 70));
		enterButton = new JButton("����/���� �Է�");
		enterButton.addActionListener(this);
		expenditureButton = new JButton("�Һ񳻿� Ȯ��");
		expenditureButton.addActionListener(this);
		goalButton = new JButton("��ǥ�ݾ� ����");
		goalButton.addActionListener(this);
		enterButton.setBounds(100, 100, 100, 100);
		buttonPanel.add(enterButton);
		buttonPanel.add(expenditureButton);
		buttonPanel.add(goalButton);

		content.add(starPanel, BorderLayout.WEST);
		content.add(topPanel, BorderLayout.NORTH);
		content.add(goalPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("����/���� �Է�")) {
			GUI input = new GUI();
			input.setVisible(true);
		} else if (e.getActionCommand().equals("�Һ񳻿� Ȯ��")) {
			new Expense(); // ���Ⱑ ������ ��ȯ ����
			this.setVisible(true);
		} else if (e.getActionCommand().equals("��ǥ�ݾ� ����")) {
			System.out.println("��ǥ�ݾ� ����");
			GoalChange guiMemo2 = new GoalChange();
			guiMemo2.setVisible(true);
		} else
			System.out.println("Error in button interface.");
	}

//�� �׸���
	class MyPanel extends JPanel {
		protected void paintComponent(Graphics g) {
			Color c1 = new Color(255, 255, 0); // yellow
			Color c2 = new Color(0, 0, 0); // black
			int x2[] = { 70, 58, 20, 50, 36, 70, 103, 90, 120, 82, 70 };
			int y2[] = { 20, 53, 53, 75, 113, 90, 113, 75, 53, 53, 20 };

			g.setColor(c2);
			g.drawPolygon(x2, y2, 10);
			g.setColor(c1);

			if (achievementRate == 0)
				g.fillPolygon(x2, y2, 0);
			else if (achievementRate > 0 && achievementRate < 40)
				g.fillPolygon(x2, y2, 4);
			else if (achievementRate >= 40 && achievementRate < 60)
				g.fillPolygon(x2, y2, 6);
			else if (achievementRate >= 60 && achievementRate < 100)
				g.fillPolygon(x2, y2, 8);
			else if (achievementRate == 100)
				g.fillPolygon(x2, y2, 10);

			// 4 6 8 10
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AssetGUI gui = new AssetGUI();
		gui.setVisible(true);

	}

}