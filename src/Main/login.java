package Main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import Class.*;
import Connect.*;
public class login extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail;
	private JPanel panel_1;
	private JTextField tfPass;
	private Connect connect = new Connect();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 485);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(188, 97, 436, 63);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("SF UI Display", Font.BOLD, 14));
		tfEmail.setBorder(null);
		tfEmail.setBackground(SystemColor.control);
		tfEmail.setBounds(10, 11, 416, 41);
		panel.add(tfEmail);
		tfEmail.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(188, 185, 436, 63);
		contentPane.add(panel_1);
		
		tfPass = new JTextField();
		tfPass.setFont(new Font("SF UI Display", Font.BOLD, 14));
		tfPass.setColumns(10);
		tfPass.setBorder(null);
		tfPass.setBackground(SystemColor.menu);
		tfPass.setBounds(10, 11, 416, 41);
		panel_1.add(tfPass);
		
		JButton btLogin = new JButton("\u0110\u0103ng Nh\u1EADp");
		
		btLogin.setFont(new Font("SF UI Display", Font.BOLD, 16));
		btLogin.setBorderPainted(false);
		btLogin.setBackground(new Color(154, 205, 50));
		btLogin.setForeground(new Color(0, 0, 0));
		btLogin.setBounds(188, 262, 436, 54);
		contentPane.add(btLogin);
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//l???y d??? li???u t??? tf Email
				String email = tfEmail.getText();
				//l???y d??? li???u t??? tf Pass
				String pass = tfPass.getText();
				////Kh???i t???o m???t Object User m???i 
				User user = new User();
				/////g???i h??m l???y t??i kho???n t??? Database
				user = connect.getUserByEmail(email);
				///ki???m tra email c?? t???n t???i tron database hay kh??ng
				if(user.getId() != null) {
					//ki???m tra pass
					if(user.getPass().equals(pass) == true) {
						JOptionPane.showMessageDialog(contentPane, "????ng nh???p th??nh c??ng");
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Sai m???t kh???u");
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Kh??ng c?? t??i kho???n n??y");
				}
				
			}
		});
	}
}
