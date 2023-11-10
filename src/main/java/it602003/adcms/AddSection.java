package it602003.adcms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import it602003.objects.*;
import it602003.process.*;

public class AddSection extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Section s = new Section();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSection frame = new AddSection(s);
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
	public AddSection(Section s) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1133, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm chuyên mục mới vào hệ thống");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(308, 23, 501, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Tên chuyên mục");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(229, 110, 164, 39);
		contentPane.add(lblName);
		
		JLabel lbNotes = new JLabel("Mô tả chi tiết");
		lbNotes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbNotes.setBounds(229, 234, 164, 39);
		contentPane.add(lbNotes);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setBounds(229, 172, 659, 39);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JTextArea txtNotes = new JTextArea();
		txtNotes.setWrapStyleWord(true);
		txtNotes.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtNotes.setLineWrap(true);
		txtNotes.setRows(12);
		txtNotes.setBounds(229, 296, 659, 295);
		contentPane.add(txtNotes);
		
		JButton btnSave = new JButton("Thêm mới");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lấy thông tin
				String name = txtName.getText();
				String notes = txtNotes.getText();
				
				//kiểm tra hợp lệ
				if(!"".equalsIgnoreCase(name) && !"".equalsIgnoreCase(notes)) {	
					//Tạo đối tượng lưu trữ thông tin
					SectionObject item = new SectionObject();
					item.setSection_name(name);
					item.setSection_notes(notes);
					item.setSection_created_date("03/11/23");
					item.setSection_created_author_id(20);
					item.setSection_name_en(name);
					
					if(!s.addSection(item)) {
//						JOptionPane.showMessageDialog(null, "Tên và mô tả không được để trống");
						System.out.println("----KHÔNG THÀNH CÔNG----");
					}
					else {
						txtName.setText("");
						txtNotes.setText("");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Tên và mô tả không được để trống");
				}
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(476, 614, 164, 34);
		contentPane.add(btnSave);
	}
}
