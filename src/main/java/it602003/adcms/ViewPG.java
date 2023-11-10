package it602003.adcms;

import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import it602003.objects.ProductGroupObject;
import it602003.process.ProductGroup;
import it602003.process.processImpl.ProductGroupImpl;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPG extends JFrame {

	private ProductGroupImpl pg;
	private ArrayList<ProductGroupObject> itemsArrayList;
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	private JPanel contentPane_Add;
	private JTable tblPG;
	private JLabel lblPGName;
	private JLabel lblPGPSID;
	private JLabel lblManagerID;
	private JLabel lblNotes;
	private JLabel lblEnName;
	private JLabel lblLanguage;
	private JTextField textPGName;
	private JTextField txtPGPSID;
	private JTextField textManagerID;
	private JTextArea textNotes;
	private JTextField textEnName;
	private JTextField textLanguage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		ProductGroupImpl pg = new ProductGroupImpl();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPG frame = new ViewPG(pg);
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
	public ViewPG(ProductGroupImpl pg) {
		setTitle("Product group");
		this.pg = pg;
		this.itemsArrayList = pg.getProductGroupObjects();

		initialize();
	}

//	Phương thức khỏi tạo
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Tạo tiêu đề bảng
		JLabel lblTitle = new JLabel("PRODUCT GROUP TABLE");
		lblTitle.setBounds(295, 10, 600, 62);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
		contentPane.add(lblTitle);

		// Tạo con lăn cho bảng
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(45, 82, 1100, 450);
		contentPane.add(scrollPane);

		// Tạo bảng
		tblPG = new JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false; // Ngăn chỉnh sửa bảng
			}
		};
		tblPG.setFont(new Font("Arial", Font.PLAIN, 12));
		tblPG.setUpdateSelectionOnSort(false);
		tblPG.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblPG.setColumnSelectionAllowed(true);
		tblPG.setCellSelectionEnabled(true);
		tblPG.setBackground(new Color(250, 250, 250));
		tblPG.setBounds(0, 0, 1100, 450);

		scrollPane.setViewportView(tblPG);

		// Tạo nút xóa hàng
		JButton btnDeleteRow = new JButton("Delete");
		btnDeleteRow.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnDeleteRow.setBackground(new Color(255, 255, 255));
		btnDeleteRow.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDeleteRow.setBounds(1010, 550, 110, 34);
		contentPane.add(btnDeleteRow);

		// Gán phương thức xóa vào nút xóa
		btnDeleteRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblPG.getSelectedColumn() != -1) {
					Object[] options = { "Yes", "No" };
					int id = -1;
					String PGName = tblPG.getValueAt(tblPG.getSelectedRow(), 1).toString();
					String temp = tblPG.getValueAt(tblPG.getSelectedRow(), 0).toString();
					id = Integer.valueOf(temp);
					int n = JOptionPane.showOptionDialog(frame,
							"<html>Product group '" + PGName + "' - ID " + temp + " will be deleted!!!</html>",
							"Comfirm delete", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							options, options[1]);
					if (n == 0) {
						if (id == -1) {
							JOptionPane.showMessageDialog(null, "Product group not exist!!!");
						}
						deletePG(id);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Select row first!!!");
				}
			}
		});

		// Tạo nút thêm hàng
		JButton btnAddRow = new JButton("Add");
		btnAddRow.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnAddRow.setBackground(new Color(255, 255, 255));
		btnAddRow.setFont(new Font("Arial", Font.PLAIN, 20));
		btnAddRow.setBounds(865, 550, 110, 34);
		contentPane.add(btnAddRow);

		// Gán phương thức thêm vào nút thêm
		btnAddRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Tạo khung cửa sổ
				frame = new JFrame("Add data row for Product Group Table");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setBounds(100, 100, 800, 700);
				frame.setBackground(new Color(245, 245, 245));
				frame.setVisible(true);

				// Tạo content
				contentPane_Add = new JPanel();
				contentPane_Add.setBackground(new Color(245, 245, 245));
				contentPane_Add.setBorder(new EmptyBorder(5, 5, 5, 5));
				frame.setContentPane(contentPane_Add);
				contentPane_Add.setLayout(null);

				JLabel lblTitle = new JLabel("Type information about new product group");
				lblTitle.setBounds(100, 10, 600, 62);
				lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
				contentPane_Add.add(lblTitle);

				lblPGName = new JLabel("Name");
				lblPGName.setFont(new Font("Arial", Font.PLAIN, 16));
				lblPGName.setBounds(30, 80, 100, 15);
				contentPane_Add.add(lblPGName);

				textPGName = new JTextField();
				textPGName.setBounds(30, 100, 300, 25);
				contentPane_Add.add(textPGName);
				textPGName.setColumns(10);

				lblPGPSID = new JLabel("PG_PS ID");
				lblPGPSID.setFont(new Font("Arial", Font.PLAIN, 16));
				lblPGPSID.setBounds(30, 125, 100, 15);
				contentPane_Add.add(lblPGPSID);

				txtPGPSID = new JTextField();
				txtPGPSID.setBounds(30, 145, 300, 25);
				contentPane_Add.add(txtPGPSID);
				txtPGPSID.setColumns(10);

				lblManagerID = new JLabel("Manager ID");
				lblManagerID.setFont(new Font("Arial", Font.PLAIN, 16));
				lblManagerID.setBounds(30, 170, 100, 15);
				contentPane_Add.add(lblManagerID);

				textManagerID = new JTextField();
				textManagerID.setBounds(30, 190, 300, 25);
				contentPane_Add.add(textManagerID);
				textManagerID.setColumns(10);

				lblNotes = new JLabel("Notes");
				lblNotes.setFont(new Font("Arial", Font.PLAIN, 16));
				lblNotes.setBounds(30, 215, 100, 15);
				contentPane_Add.add(lblNotes);

				textNotes = new JTextArea();
				textNotes.setBounds(30, 235, 300, 200);
				contentPane_Add.add(textNotes);
				textNotes.setColumns(10);

				lblEnName = new JLabel("English name");
				lblEnName.setFont(new Font("Arial", Font.PLAIN, 16));
				lblEnName.setBounds(30, 460, 100, 15);
				contentPane_Add.add(lblEnName);

				textEnName = new JTextField();
				textEnName.setBounds(30, 480, 300, 25);
				contentPane_Add.add(textEnName);
				textEnName.setColumns(10);

				lblLanguage = new JLabel("Language");
				lblLanguage.setFont(new Font("Arial", Font.PLAIN, 16));
				lblLanguage.setBounds(30, 505, 100, 15);
				contentPane_Add.add(lblLanguage);

				textLanguage = new JTextField();
				textLanguage.setBounds(30, 525, 300, 25);
				contentPane_Add.add(textLanguage);
				textLanguage.setColumns(10);
			}
		});

		// Tạo nút chỉnh sửa hàng
		JButton btnEditRow = new JButton("Edit");
		btnEditRow.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnEditRow.setBackground(new Color(255, 255, 255));
		btnEditRow.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEditRow.setBounds(720, 550, 110, 34);
		contentPane.add(btnEditRow);

		loadTable(this.itemsArrayList);

	}

//	Phương thức load dữ liệu bảng
	public void loadTable(ArrayList<ProductGroupObject> itemsArrayList) {
		String[] headerColName = { "ID", "Name", "PG_PS ID", "Manager ID", "Notes", "English name", "Created author ID",
				"Language" };
		DefaultTableModel tableData = new DefaultTableModel();
		tableData.setColumnIdentifiers(headerColName);
		// Chuyển đổi product group object sang object
		for (int i = 0; i < itemsArrayList.size(); i++) {
			Object[] obj = new Object[] { itemsArrayList.get(i).getPg_id(), itemsArrayList.get(i).getPg_name(),
					itemsArrayList.get(i).getPg_ps_id(), itemsArrayList.get(i).getPg_manager_id(),
					itemsArrayList.get(i).getPg_notes(), itemsArrayList.get(i).getPg_name_en(),
					itemsArrayList.get(i).getPg_created_author_id(), itemsArrayList.get(i).getPg_language() };
			tableData.addRow(obj);
		}
		tblPG.setModel(tableData);
	}

//	Phương thức xóa hàng
	private void deletePG(int id) {
		if (!pg.deleteProductGroup(id)) {
			JOptionPane.showMessageDialog(null, "Can not delete product group!!!");
			return;
		}
		this.itemsArrayList = pg.getProductGroupObjects();
		loadTable(this.itemsArrayList);
	}
}
