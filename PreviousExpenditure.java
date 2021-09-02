import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JLabel;
import javax.swing.JPanel;

class PreviousExpenditure extends JPanel implements MouseListener {
	File fileName1 = new File("lastMonthData.txt");

	int food, transportation, leisure;
	int communication, medical, lifecost, saving;
	int extotal, income, currentMoney;

	public void paint(Graphics g) {
		try {
			ObjectInputStream thisInputStream = new ObjectInputStream(new FileInputStream(fileName1));
			InputMoney thisMonthOut = (InputMoney) thisInputStream.readObject();
			income = thisMonthOut.getIncome();
			extotal = thisMonthOut.getExpenditure();
			currentMoney = thisMonthOut.getcurrentAsset();
			food = thisMonthOut.getCategoryFood();
			transportation = thisMonthOut.getCategoryTransportation();
			leisure = thisMonthOut.getCategoryLeisure();
			communication = thisMonthOut.getCategoryCommunication();
			medical = thisMonthOut.getCategoryMedical();
			lifecost = thisMonthOut.getCategoryLifeCost();
			saving = thisMonthOut.getCategoryEtc();

			thisInputStream.close();
		} catch (IOException e) {
			System.out.println("Error opening the file ");
			e.printStackTrace();
			System.exit(0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawLine(50, 250, 450, 250);
		for (int cnt = 1; cnt < 11; cnt++) {
			g.drawString(cnt * 10000 + "", 5, 255 - 20 * cnt);
			g.drawLine(50, 250 - 20 * cnt, 450, 250 - 20 * cnt);
		}
		g.drawLine(50, 20, 50, 250);
		g.drawString("Food", 70, 270);
		g.drawString("Transport", 110, 270);
		g.drawString("Leisure", 170, 270);
		g.drawString("Communication ", 220, 270);
		g.drawString("Medical ", 310, 270);
		g.drawString("Lifecost ", 360, 270);
		g.drawString("saving", 410, 270);
		g.setColor(Color.RED);
		if (food > 0)
			g.fillRect(80, 250 - food * 2 / 1000, 10, food * 2 / 1000);
		if (transportation > 0)
			g.fillRect(130, 250 - transportation * 2 / 1000, 10, transportation * 2 / 1000);
		if (leisure > 0)
			g.fillRect(185, 250 - leisure * 2 / 1000, 10, leisure * 2 / 1000);
		if (communication > 0)
			g.fillRect(255, 250 - communication * 2 / 1000, 10, communication * 2 / 1000);
		if (medical > 0)
			g.fillRect(325, 250 - medical * 2 / 1000, 10, medical * 2 / 1000);
		if (lifecost > 0)
			g.fillRect(375, 250 - lifecost * 2 / 1000, 10, lifecost * 2 / 1000);
		if (saving > 0)
			g.fillRect(420, 250 - saving * 2 / 1000, 10, saving * 2 / 1000);

		g.drawString("수입 " + income, 60, 320);
		g.drawString("지출 " + extotal, 140, 320);
		g.drawString("잔액 " + currentMoney, 220, 320);
		Label currentMonth = new Label("이번 달 지출내역");
		currentMonth.setBackground(Color.yellow);
		currentMonth.setBounds(12, 5, 100, 20);
		add(currentMonth);
		currentMonth.addMouseListener((MouseListener) this);
	}

	public static void main(String args[]) {
		PreviousExpenditure gui = new PreviousExpenditure();
		gui.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		new Expense(); // 여기가 프레임 전환 역할
		this.setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}