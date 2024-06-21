package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testIn {
	public static void main(String[] args) {
		try {
			// In:
			//B1: Ket noi vao CSDL
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh SQL
			String sql = "select * from tbl_nhanvien";
			//B3: Tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
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
			} 
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
	

