package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.table.DefaultTableModel;

public class DungChung {
	public static Connection cn;

	public void KetNoi() throws Exception{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://PC-HFA1062\\SQLEXPRESS01:1433;databaseName=Food2;user=sa;password=trannhuy;encrypt=true;trustServerCertificate=true";
			cn = DriverManager.getConnection(url);
	}

	public ResultSet getbang(String tb) throws Exception {
		String sql = "select * from " + tb;
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		return rs;
	}

	public DefaultTableModel napbang(String tb) throws Exception {
		DefaultTableModel mh = new DefaultTableModel();
		//lay du lieu cua bang : tb
		ResultSet rs = getbang(tb);
		// lay ra metadata cua rs
		ResultSetMetaData mt = rs.getMetaData();
		//lay ra sos cot
		int socot = mt.getColumnCount();
		//lay ra ten cot
		for (int i = 1; i <= socot; i++)
			mh.addColumn(mt.getColumnName(i));
		//duyet rs de nap cac dong vao mo hinh
		while (rs.next()) {
			Object[] t = new Object[socot];
			for (int i = 1; i <= socot; i++)
				t[i - 1] = rs.getString(i);
			mh.addRow(t);
		}
		return mh;
	}
}