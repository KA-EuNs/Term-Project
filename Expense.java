import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Expense extends JFrame
{
	
public Expense() {
	 JFrame frame = new JFrame("이번달 지출 확인하기");
	  frame.setLocation(500,400);
	  frame.setPreferredSize(new Dimension(500,400));
	  Container contentPane = frame.getContentPane();
	  
	  Expenditure drawingPanel = new Expenditure();
	  
	  contentPane.add(drawingPanel, BorderLayout.CENTER);
	  //그래프를 그릴 패널
	  
	//  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	  frame.pack();
	  frame.setVisible(true);
	 }

 public static void main(String args[])
 {
	 Expense expenses = new Expense();
	 
 }
}