import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame extends JFrame {

	 MyFrame(String title) {

	 super(title);

	 setSize(500,500);

	 setDefaultCloseOperation(EXIT_ON_CLOSE);

	 makeUI();

	 setVisible(true);

	 }

	 private void makeUI() {

	 MyPanel p = new MyPanel();

	 add(p, BorderLayout.CENTER);

	 }

	}
class MyPanel extends JPanel {

	 protected void paintComponent(Graphics g) {




	int x2[] = { 210,175,60,150,110,210,310,270,360,245,210 };
	int y2[] = { 60,160,160,225,340,270,340,225,160,160,60 };
	g.drawPolygon( x2, y2, 10 );     //  별그리기

	 }

	}