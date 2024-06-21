package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DungChung {
	public static Connection cn;
	public static void KetNoi() throws Exception {
		//B1: Xac dinh SQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		//B2: ket noi vao csdl;
		String url = "jdbc:sqlserver://PC-HFA1062\\SQLEXPRESS01:1433;databaseName=Food2;user=sa;password=trannhuy;encrypt=true;trustServerCertificate=true";		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
	public static ResultSet getBang(String tb) throws Exception {
		String sql="select *from "+tb;
		PreparedStatement cmd=DungChung.cn.prepareStatement(sql);
		return cmd.executeQuery();
	}
}
