package Cau2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cau2_6 {
	public static Connection cn;
	public void ketnoi() throws Exception{
		//B1: Xac dinh HQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		//B2: Ket Noi
		String url = "jdbc:sqlserver://PC-HFA1062\\SQLEXPRESS01:1433; databaseName=QLTrungThuong; user=sa; password=trannhuy; encrypt=true; trustServerCertificate=true";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
	public static void main(String[] args) {
		try {
			//B1: Ket noi vao CSDL
			Cau2_6 kn = new Cau2_6();
			kn.ketnoi();
			//B2: Tao cau lenh SQL
			String sql = "insert into tbl_NguoiMua(Hoten, Diachi, SDT) values (?, ?, ?)";
			//B3: Tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, manv);
			cmd.setString(2, hoten);
			cmd.setDate(3, new java.sql.Date(ngaysinh.getDate()));
			cmd.setDouble(4, hsl);
			cmd.setString(5, madv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
