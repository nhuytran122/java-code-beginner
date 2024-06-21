package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KetNoi {
	public static Connection cn;
	public void ketnoi() throws Exception{
		//B1: Xac dinh HQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		//B2: Ket Noi
		String url = "jdbc:sqlserver://PC-HFA1062\\SQLEXPRESS01:1433; databaseName=QLNV; user=sa; password=trannhuy; encrypt=true; trustServerCertificate=true";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
	public static void main(String[] args) {
		try {
			//B1: Ket noi vao CSDL
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh SQL
			String sql = "select * from tbl_nhanvien";
			//B3: Tao cau lenh
			PreparedStatement cmd = cn.prepareStatement(sql);
			//B4: Thuc hien cau lenh
			ResultSet rs = cmd.executeQuery();
			//B5: Duyet qua rs
			while(rs.next()) {
				String manv = rs.getString("manv");
				String hoten = rs.getString("hoten");
				Double hsl = rs.getDouble("hsl");
				Date ns = rs.getDate("ngaysinh");
				SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
				String ngaysinh = d.format(ns);
				System.out.println(manv + " : " + hoten + " : " + hsl + " : " + ngaysinh);
			} rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
