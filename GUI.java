import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;

	private JTextField income,expenditure,category;
	private JButton Button;

	public GUI() {
		
	setTitle("InputMoneyData");
	setSize(WIDTH,HEIGHT);
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container content = getContentPane();
	content.setLayout(new GridLayout(5,1));
	
	JPanel titlePanel = new JPanel(); 
	titlePanel.setLayout(null);
	JLabel titleLabel = new JLabel("Income & expenditure management"); //Ÿ��Ʋ �κ�//
	titlePanel.setBackground(Color.WHITE);
	Font f = new Font(null, Font.BOLD, 15);
	titleLabel.setFont(f);
	titleLabel.setBounds(55,19,300,20);
	titlePanel.add(titleLabel);
	content.add(titlePanel);
	
	JPanel IncomePanel = new JPanel(); 
	IncomePanel.setLayout(null);
	JLabel incomeLabel = new JLabel("additional income :"); //���� �κ�//
	incomeLabel.setBounds(50,20,300,20);
	income = new JTextField(25);
	income.setBounds(220,20,80,20);
	IncomePanel.add(income);
	IncomePanel.add(incomeLabel);
	content.add(IncomePanel);
	
	JPanel expenditurePanel = new JPanel(); 
	expenditurePanel.setLayout(null);
	JLabel expenditureLabel = new JLabel("additional expenditure : "); //���� �κ�//
	expenditureLabel.setBounds(50,10,300,20);
	expenditure = new JTextField(25);
	expenditure.setBounds(220,10,80,20);
	expenditurePanel.add(expenditure);
	expenditurePanel.add(expenditureLabel);
	content.add(expenditurePanel);
	
	JPanel categoryPanel = new JPanel(); 
	categoryPanel.setLayout(null);
	JLabel categoryLabel = new JLabel("kind of expenditure : "); //ī�װ��� �κ�//
	categoryLabel.setBounds(50,5,300,20);
	category = new JTextField(25);
	category.setBounds(220,5,80,20);	
	categoryPanel.add(category);
	categoryPanel.add(categoryLabel);	
	content.add(categoryPanel);
	
	JPanel buttonPanel = new JPanel(); //�����ư �κ�//
	categoryPanel.setLayout(null);
	Button = new JButton("Save");
	Button.setBounds(150,20,60,20);
	buttonPanel.add(Button);
	content.add(buttonPanel);
	
	Button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			InputMoney money = new InputMoney();
			
			if(Integer.parseInt(income.getText().trim()) > 0 && Integer.parseInt(expenditure.getText().trim()) > 0) {
				money.resetCurrentAssetIncome(income.getText().trim());
				money.calEachCategoryTotal(expenditure.getText().trim(),category.getText().trim());
				AssetGUI asset = new AssetGUI(); // ���Ⱑ ������ ��ȯ ����
				
				asset.setVisible(true);
			}
			
			// �����ڻ� ǥ���ϴ� GUI�� �Ѿ��
			
			else {
				JOptionPane.showMessageDialog(null, "Entered a Negative value.", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	});
}
	
	public static void main(String[] args) {
		
		GUI w = new GUI();
		w.setVisible(true);

	}

}