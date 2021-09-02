import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class LoginFrameGUI {
	User u = new User();
	Check c = new Check();
	JFrame f = new JFrame();
	
	BufferedImage img = null;
	BufferedImage img2 = null;
	JTextField IDTextField;
	JPasswordField passwordField;
	JButton loginBtn;


	public static void main(String[] args) {
		new LoginFrameGUI();
	}

	//Constructor
	public LoginFrameGUI() {
		f.setTitle("Login");
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
			img = ImageIO.read(new File("loginPage.png"));
		} catch (IOException e) {
			System.out.println("Sorry, Fail to get image.");
			System.exit(0);
		}

		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 1600, 900);


		// 로그인 필드
		IDTextField = new JTextField(15);
		IDTextField.setBounds(500, 500, 500, 100);
		layeredPane.add(IDTextField);
		IDTextField.setOpaque(false);
		IDTextField.setFont(new Font("Arial",Font.BOLD,30));
		//loginTextField.setForeground(Color.black);
		IDTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		// 패스워드
		passwordField = new JPasswordField(15);
		passwordField.setBounds(500, 670, 500, 100);
		passwordField.setOpaque(false);
		passwordField.setFont(new Font("Arial",Font.BOLD,30));
		//passwordField.setForeground(Color.black);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(passwordField);

		// 로그인버튼 추가
		JButton loginBtn = new JButton("Login");
		loginBtn.setFont(new Font("Arial",Font.PLAIN,30));
		loginBtn.setBounds(1100, 550, 200, 200);

		layeredPane.add(loginBtn);

		// 마지막 추가들
		layeredPane.add(panel);
		f.add(layeredPane);
		f.setVisible(true);

		//login button
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u.initInfo();
				u.writeInfo();
				String id = IDTextField.getText().trim();
				String pw = passwordField.getText().trim();

				if(id.length()==0 || pw.length()==0) {
					JOptionPane.showMessageDialog(null, "Please enter ID & Password", "Error!", JOptionPane.DEFAULT_OPTION);
					return;
				}

				if(Integer.parseInt(IDTextField.getText().trim()) == u.getID() && Integer.parseInt(passwordField.getText().trim()) == u.PW) {
					JOptionPane.showMessageDialog(null, "Success to Login!", "로그인 상태", JOptionPane.DEFAULT_OPTION);
					f.setVisible(false);
					
					AssetGUI asset = new AssetGUI(u.name);
					asset.setVisible(true);
					return;
				}
				
				else {
					c.plusCount();
					JOptionPane.showMessageDialog(null, "Fail to Login! Try again(" + c.getCount() + "/5)", "로그인 상태", JOptionPane.DEFAULT_OPTION);
					
					IDTextField.setText("");
					passwordField.setText("");
					
					if(c.getCount()==5) {
						f.setVisible(false);
						new IdentificationGUI();
					}
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