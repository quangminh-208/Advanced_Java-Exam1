package it602003.process.processImpl;

import java.sql.*;
import java.util.*;
import it602003.objects.*;
import it602003.process.ProductGroup;
import it602003.*;

public class ProductGroupImpl {
	// kết nối để làm việc với csdl
	private Connection con;

	// bộ quản lý kết nối riêng section
	private ConnectionPool cp;

	public ProductGroupImpl() {
		// Xác định bộ quản lý kết nối
		this.cp = new ConnectionPoolImpl();

		// Xin kết nối để làm việc
		try {
			this.con = this.cp.getConnection("ProductGroup");

			// Kiểm tra chế độ thực thi của kết nối
			if (this.con.getAutoCommit()) {
				// Hủy chế độ thực thi tự động
				this.con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<ProductGroupObject> getProductGroupObjects() {
		ArrayList<ProductGroupObject> items = new ArrayList<>();
		ProductGroupObject item;

		String sql = "SELECT * FROM tblpg ";
		sql += "WHERE Pg_delete = 0 or Pg_delete is NULL ";
		sql += "ORDER BY pg_name ASC ";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery(); // Lấy về tập kết quả
			if (rs != null) {
				while (rs.next()) {
					item = new ProductGroupObject();
					item.setPg_id(rs.getShort("Pg_id"));
					item.setPg_name(rs.getString("Pg_name"));
					item.setPg_ps_id(rs.getShort("Pg_ps_id"));
					item.setPg_manager_id(rs.getInt("Pg_manager_id"));
					item.setPg_notes(rs.getString("Pg_notes"));
					item.setPg_delete(rs.getBoolean("Pg_delete"));
					item.setPg_deleted_date(rs.getString("Pg_deleted_date"));
					item.setPg_deleted_author(rs.getString("Pg_deleted_author"));
					item.setPg_modified_date(rs.getString("Pg_modified_date"));
					item.setPg_created_date(rs.getString("Pg_created_date"));
					item.setPg_enable(rs.getString("Pg_enable"));
					item.setPg_name_en(rs.getString("Pg_name_en"));
					item.setPg_created_author_id(rs.getInt("Pg_created_author_id"));
					item.setPg_language(rs.getByte("Pg_language"));

					items.add(item);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// trở về trạng thái an toàn của kết nối
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return items;
	}

	public ArrayList<ProductGroupObject> getProductGroupObjects(byte total) {

		ArrayList<ProductGroupObject> items = new ArrayList<>();
		ProductGroupObject item;

		String sql = "SELECT * FROM tblpg ";
		sql += "WHERE Pg_delete = 0  or Pg_delete is NULL ";
		sql += "ORDER BY pg_name ASC ";
		sql += "LIMIT ?";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			// Truyền giá trị cho tham số
			pre.setByte(1, total);

			ResultSet rs = pre.executeQuery(); // Lấy về tập kết quả
			if (rs != null) {
				while (rs.next()) {
					item = new ProductGroupObject();
					item.setPg_id(rs.getShort("Pg_id"));
					item.setPg_name(rs.getString("Pg_name"));
					item.setPg_ps_id(rs.getShort("Pg_ps_id"));
					item.setPg_manager_id(rs.getInt("Pg_manager_id"));
					item.setPg_notes(rs.getString("Pg_notes"));
					item.setPg_delete(rs.getBoolean("Pg_delete"));
					item.setPg_deleted_date(rs.getString("Pg_deleted_date"));
					item.setPg_deleted_author(rs.getString("Pg_deleted_author"));
					item.setPg_modified_date(rs.getString("Pg_modified_date"));
					item.setPg_created_date(rs.getString("Pg_created_date"));
					item.setPg_enable(rs.getString("Pg_enable"));
					item.setPg_name_en(rs.getString("Pg_name_en"));
					item.setPg_created_author_id(rs.getInt("Pg_created_author_id"));
					item.setPg_language(rs.getByte("Pg_language"));
					items.add(item);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// trở về trạng thái an toàn của kết nối
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return items;
	}

	public ProductGroupObject getProductGroupObjectById(int id) {
		ProductGroupObject item = new ProductGroupObject();
		String sql = "SELECT * FROM tblpg WHERE pg_id = ? ";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setShort(1, (short) id);

			ResultSet rs = pre.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					item = new ProductGroupObject();
					item.setPg_id(rs.getShort("Pg_id"));
					item.setPg_name(rs.getString("Pg_name"));
					item.setPg_ps_id(rs.getShort("Pg_ps_id"));
					item.setPg_manager_id(rs.getInt("Pg_manager_id"));
					item.setPg_notes(rs.getString("Pg_notes"));
					item.setPg_delete(rs.getBoolean("Pg_delete"));
					item.setPg_deleted_date(rs.getString("Pg_deleted_date"));
					item.setPg_deleted_author(rs.getString("Pg_deleted_author"));
					item.setPg_modified_date(rs.getString("Pg_modified_date"));
					item.setPg_created_date(rs.getString("Pg_created_date"));
					item.setPg_enable(rs.getString("Pg_enable"));
					item.setPg_name_en(rs.getString("Pg_name_en"));
					item.setPg_created_author_id(rs.getInt("Pg_created_author_id"));
					item.setPg_language(rs.getByte("Pg_language"));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return item;
	}

	public ArrayList<ProductGroupObject> getProductGroupObjectByName(String name) {

		ArrayList<ProductGroupObject> items = new ArrayList<>();
		ProductGroupObject item;

		String sql = "SELECT * FROM tblpg ";
		sql += "WHERE pg_name LIKE ? and (Pg_delete = 0 or Pg_delete is NULL) ";
		sql += "ORDER BY pg_name ASC";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			// Truyền giá trị cho tham số
			pre.setString(1, "%" + name + "%");
			ResultSet rs = pre.executeQuery(); // Lấy về tập kết quả
			if (rs != null) {
				while (rs.next()) {
					item = new ProductGroupObject();
					item.setPg_id(rs.getShort("Pg_id"));
					item.setPg_name(rs.getString("Pg_name"));
					item.setPg_ps_id(rs.getShort("Pg_ps_id"));
					item.setPg_manager_id(rs.getInt("Pg_manager_id"));
					item.setPg_notes(rs.getString("Pg_notes"));
					item.setPg_delete(rs.getBoolean("Pg_delete"));
					item.setPg_deleted_date(rs.getString("Pg_deleted_date"));
					item.setPg_deleted_author(rs.getString("Pg_deleted_author"));
					item.setPg_modified_date(rs.getString("Pg_modified_date"));
					item.setPg_created_date(rs.getString("Pg_created_date"));
					item.setPg_enable(rs.getString("Pg_enable"));
					item.setPg_name_en(rs.getString("Pg_name_en"));
					item.setPg_created_author_id(rs.getInt("Pg_created_author_id"));
					item.setPg_language(rs.getByte("Pg_language"));
					items.add(item);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// trở về trạng thái an toàn của kết nối
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return items;
	}

	public boolean addProductGroup(ProductGroupObject item) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tblpg(");
		sql.append("pg_name, pg_ps_id, ");
		sql.append("pg_manager_id, pg_notes, pg_delete, ");
		sql.append("pg_deleted_date, pg_deleted_author, pg_modified_date, ");
		sql.append("pg_created_date, pg_enable, pg_name_en, ");
		sql.append("pg_created_author_id, pg_language) ");
		sql.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getPg_name());
			pre.setShort(2, item.getPg_ps_id());
			pre.setInt(3, item.getPg_manager_id());
			pre.setString(4, item.getPg_notes());
			pre.setBoolean(5, item.isPg_delete());
			pre.setString(6, item.getPg_deleted_date());
			pre.setString(7, item.getPg_deleted_author());
			pre.setString(8, item.getPg_modified_date());
			pre.setString(9, item.getPg_created_date());
			pre.setString(10, item.getPg_enable());
			pre.setString(11, item.getPg_name_en());
			pre.setInt(12, item.getPg_created_author_id());
			pre.setByte(13, item.getPg_language());
			// thực thi
			int result = pre.executeUpdate();
			if (result == 0) {
				this.con.rollback();
				return false;
			}

			// Ghi nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateProductGroupObject(ProductGroupObject item) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblpg SET ");
		sql.append("pg_name = ?, pg_ps_id = ?, ");
		sql.append("pg_manager_id = ?, pg_notes = ?, pg_delete = ?, ");
		sql.append("pg_deleted_date = ?, pg_deleted_author = ?, pg_modified_date = ?, ");
		sql.append("pg_created_date = ?, pg_enable = ?, pg_name_en = ?, ");
		sql.append("pg_created_author_id = ?, pg_language = ?) ");
		sql.append("WHERE pg_id = ?;");
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getPg_name());
			pre.setShort(2, item.getPg_ps_id());
			pre.setInt(3, item.getPg_manager_id());
			pre.setString(4, item.getPg_notes());
			pre.setBoolean(5, item.isPg_delete());
			pre.setString(6, item.getPg_deleted_date());
			pre.setString(7, item.getPg_deleted_author());
			pre.setString(8, item.getPg_modified_date());
			pre.setString(9, item.getPg_created_date());
			pre.setString(10, item.getPg_enable());
			pre.setString(11, item.getPg_name_en());
			pre.setInt(12, item.getPg_created_author_id());
			pre.setByte(13, item.getPg_language());
			pre.setShort(14, item.getPg_id());
			// thực thi
			int result = pre.executeUpdate();
			if (result == 0) {
				this.con.rollback();
				return false;
			}

			// Ghi nhận thực thi sau cùng
			this.con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteProductGroup(int id) {
		StringBuilder sql = new StringBuilder();
//		sql.append("DELETE FROM tblpg WHERE pg_id = ?;");
		sql.append("UPDATE tblpg SET Pg_delete = 1 WHERE pg_id = ?;");
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setShort(1, (short) id);
			int result = pre.executeUpdate();
			if (result == 0) {
				this.con.rollback();
				return false;
			}
			this.con.commit();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}