package _21T1020080;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	private Connection con = null;
	public Connection getConnection() {
		return this.con;
	}

	private static DbHelper instance = null;
	
	
	private DbHelper() {
		String url = CauHinh.getInstance().getChuoiKetNoi();
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DbHelper getInstance() throws SQLException {
		if (instance == null)
			instance = new DbHelper();
			
		return instance;
	}
}