package _21T1020080;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class XuLyData {
	public ArrayList<SinhVien> selectAll() {
		ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();
	    try {
	    	Connection con = DbHelper.getInstance().getConnection();
	    	String sql = "SELECT * FROM SinhVien";
	        PreparedStatement statement = con.prepareStatement(sql);
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	        	String masv = rs.getString("MaSinhVien");
				String hoten = rs.getString("HoTen");
				Date ngaysinh = rs.getDate("NgaySinh");
				Boolean gioitinhnam = rs.getBoolean("GioiTinhNam");
				listSV.add(new SinhVien(masv, hoten, gioitinhnam, ngaysinh));
	        }
	        rs.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listSV;
	}

	public void insertStudent(SinhVien x) {
	    try {
	    	Connection con = DbHelper.getInstance().getConnection();
	    	String sql = "INSERT INTO SinhVien (MaSinhVien, HoTen, GioiTinhNam, NgaySinh) VALUES (?, ?, ?, ?)";
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, x.getMaSinhVien());
	        statement.setString(2, x.getHoTen());
	        statement.setBoolean(3, x.isGioiTinhNam());
	        statement.setDate(4, new java.sql.Date(x.getNgaySinh().getTime()));
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}