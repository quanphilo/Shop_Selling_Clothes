 package DAL;

import java.sql.*;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection con = null;
		try {
			String url = "jdbc:mysql://localhost:3306/javashop";
			String usr = "root";
			String password = "root";
			con = DriverManager.getConnection(url, usr, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}