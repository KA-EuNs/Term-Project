import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class ChangePWGUI {
	User u = new User();
	Check c = new Check();
	JFrame f = new JFrame();
	
	BufferedImage img = null;
	JTextField PWTextField;
	JPasswordField checkPWField;
	JButton changeBtn;


	public static void main(String[] args) {
		User u = new User();
		System.out.println("HI "+u.PW);
		new ChangePWGUI();
		
	}

	//Constructor
	public ChangePWGUI() {
		f.setTitle("Reset Password");
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
			img = ImageIO.read(new File("changePW.png"));
		} catch (IOException e) {
			System.out.println("Sorry, Fail to get image.");
			System.exit(0);
		}

		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 1600, 900);


		//pw
		PWTextField = new JTextField(15);
		PWTextField.setBounds(600, 400, 500, 100);
		layeredPane.add(PWTextField);
		PWTextField.setOpaque(false);
		PWTextField.setFont(new Font("Arial",Font.BOLD,30));
		PWTextField.setForeground(Color.black);
		PWTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		//rePW
		checkPWField = new JPasswordField(15);
		checkPWField.setBounds(600, 605, 500, 100);
		checkPWField.setOpaque(false);
		checkPWField.setFont(new Font("Arial",Font.BOLD,30));
		checkPWField.setForeground(Color.black);
		checkPWField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(checkPWField);

		// reset Button
		JButton changeBtn = new JButton("change");
		changeBtn.setFont(new Font("Arial",Font.PLAIN,30));
		changeBtn.setBounds(1280, 450, 200, 200);

		layeredPane.add(changeBtn);

		// 마지막 추가들
		layeredPane.add(panel);
		f.add(layeredPane);
		f.setVisible(true);

		//login button
		changeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				u.initInfo();
				//u.writeInfo();
				String pw = PWTextField.getText().trim();
				String rePW = checkPWField.getText().trim();

				if(pw.length()==0 || rePW.length()==0) {
					JOptionPane.showMessageDialog(null, "Please enter Password", "Error!", JOptionPane.DEFAULT_OPTION);
					return;
				}

				if(Integer.parseInt(PWTextField.getText().trim()) == Integer.parseInt(checkPWField.getText().trim())) {
					
					//u.setPW(Integer.parseInt(checkPWField.getText().trim()));
					u.PW =  Integer.parseInt(checkPWField.getText().trim());
					System.out.println("change PW : " + u.PW);
					JOptionPane.showMessageDialog(null, "Success to change PW!", "비밀번호 변경", JOptionPane.DEFAULT_OPTION);
					f.setVisible(false);
					new LoginFrameGUI();
				}
				else {
					JOptionPane.showMessageDialog(null, "Password is not same! Try again", "비밀번호 변경", JOptionPane.DEFAULT_OPTION);
					PWTextField.setText("");
					checkPWField.setText("");
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