import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class IdentificationGUI {
	User u = new User();
	Check c = new Check();
	JFrame f = new JFrame();
	
	BufferedImage img = null;
	JTextField nameTextField;
	JTextField IDField;
	JButton checkBtn;


	public static void main(String[] args) {
		new IdentificationGUI();
	}

	//Constructor
	public IdentificationGUI() {
		f.setTitle("Check user's Identification");
		f.setSize(1600, 900);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //x표시 누르면 종료

		//setting Layout
		f.setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1600, 900);
		layeredPane.setLayout(null);

		// Panel1
		// get image
		try {
			img = ImageIO.read(new File("identification.png"));
		} catch (IOException e) {
			System.out.println("Sorry, Fail to get image.");
			System.exit(0);
		}

		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 1600, 900);


		//name
		nameTextField = new JTextField(15);
		nameTextField.setBounds(600, 400, 500, 100);
		layeredPane.add(nameTextField);
		nameTextField.setOpaque(false);
		nameTextField.setFont(new Font("Arial",Font.BOLD,30));
		nameTextField.setForeground(Color.black);
		nameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		//rePW
		IDField = new JTextField(15);
		IDField.setBounds(600, 605, 500, 100);
		layeredPane.add(IDField);
		IDField.setOpaque(false);
		IDField.setFont(new Font("Arial",Font.BOLD,30));
		IDField.setForeground(Color.black);
		IDField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		

		// reset Button
		JButton checkBtn = new JButton("check");
		checkBtn.setFont(new Font("Arial",Font.PLAIN,30));
		checkBtn.setBounds(1200, 450, 200, 200);

		layeredPane.add(checkBtn);

		// 마지막 추가들
		layeredPane.add(panel);
		f.add(layeredPane);
		f.setVisible(true);

		//login button
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				u.initInfo();
				//u.writeInfo();
				String name = nameTextField.getText().trim();
				String ID = IDField.getText().trim();

				if(name.length()==0 || ID.length()==0) {
					JOptionPane.showMessageDialog(null, "Please enter Password", "Error!", JOptionPane.DEFAULT_OPTION);
					return;
				}

				if(name.equals(u.getName()) && Integer.parseInt(IDField.getText().trim()) == u.getID()) {
					JOptionPane.showMessageDialog(null, "correct!", "사용자 신원 확인", JOptionPane.DEFAULT_OPTION);
					f.setVisible(false);
					new ChangePWGUI();
				}
				else {
					JOptionPane.showMessageDialog(null, "Identification is wrong! Try again", "사용자 신원 확인", JOptionPane.DEFAULT_OPTION);
					nameTextField.setText("");
					IDField.setText("");
				}
			}
		});

	}

	class MyPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

}
