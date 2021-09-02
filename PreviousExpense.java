import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PreviousExpense extends JFrame
{
	
public PreviousExpense() {
	 JFrame frame = new JFrame("이전달 지출 확인하기");
	  frame.setLocation(500,400);
	  frame.setPreferredSize(new Dimension(500,400));
	  Container contentPane = frame.getContentPane();
	  
	  PreviousExpenditure drawingPanel2 = new PreviousExpenditure();
	  
	  contentPane.add(drawingPanel2, BorderLayout.CENTER);
	  //그래프를 그릴 패널
	  
	//  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	  frame.pack();
	  frame.setVisible(true);
	 }

 public static void main(String args[])
 {
	 PreviousExpense expenses = new PreviousExpense();
	 
 }
}