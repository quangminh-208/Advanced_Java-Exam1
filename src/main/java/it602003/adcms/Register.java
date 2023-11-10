package it602003.adcms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtYourName;
	private JTextField txtYourEmail;
	private JTextField textUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setResizable(false);
		setForeground(new Color(255, 128, 0));
		setTitle("Đăng ký tài khoản");
		setBackground(new Color(194, 249, 176));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 791);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Create an Account");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(0, 0, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitle.setBounds(241, 19, 287, 63);
		contentPane.add(lblTitle);
		
		JLabel lblSubtitle = new JLabel("Enter your personal details to create account");
		lblSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubtitle.setBounds(171, 101, 420, 63);
		contentPane.add(lblSubtitle);
		
		JLabel lblYourName = new JLabel("Your Name");
		lblYourName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYourName.setBounds(171, 183, 101, 30);
		contentPane.add(lblYourName);
		
		JLabel lblYourEmail = new JLabel("Your Email");
		lblYourEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYourEmail.setBounds(171, 288, 101, 30);
		contentPane.add(lblYourEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(171, 393, 101, 30);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(171, 498, 101, 30);
		contentPane.add(lblPassword);
		
		txtYourName = new JTextField();
		txtYourName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtYourName.setBounds(171, 232, 427, 37);
		contentPane.add(txtYourName);
		txtYourName.setColumns(10);
		
		txtYourEmail = new JTextField();
		txtYourEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtYourEmail.setColumns(10);
		txtYourEmail.setBounds(171, 337, 427, 37);
		contentPane.add(txtYourEmail);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsername.setColumns(10);
		textUsername.setBounds(171, 442, 427, 37);
		contentPane.add(textUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 547, 427, 37);
		contentPane.add(passwordField);
		
		JCheckBox chkAgreed = new JCheckBox("I agree and accept the terms and additions");
		chkAgreed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkAgreed.setBounds(171, 603, 427, 30);
		contentPane.add(chkAgreed);
		
		JButton btnRegister = new JButton("Create Account");
		btnRegister.setBorder(null);
		btnRegister.setForeground(new Color(255, 255, 0));
		btnRegister.setBackground(Color.RED);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegister.setBounds(171, 652, 427, 30);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel = new JLabel("Already have an account? Log in");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(171, 701, 427, 30);
		contentPane.add(lblNewLabel);
	}
}
