package it602003;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
	//xin kết nối để làm việc
	public Connection getConnection(String objectName) throws SQLException;
	
	//yêu cầu trả về kết nối
	public void releaseConnection(Connection con, String objectName) throws SQLException;
}
