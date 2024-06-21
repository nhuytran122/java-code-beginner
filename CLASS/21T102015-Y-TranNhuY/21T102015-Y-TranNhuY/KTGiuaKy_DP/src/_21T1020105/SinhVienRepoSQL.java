package _21T1020105;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SinhVienRepoSQL implements SinhVienRepo {
	@Override
	public ArrayList<SinhVien> selectAll() {
		ArrayList<SinhVien> lstSV = new ArrayList<SinhVien>();
	    try {
	    	Connection con = DbHelper.getInstance().getConnection();
	    	String sql = "SELECT * FROM SinhVien";
	        PreparedStatement stm = con.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();
	        while (rs.next()) {
	        	String masv = rs.getString("MaSinhVien");
				String hoten = rs.getString("HoTen");
				Date ngaysinh = rs.getDate("NgaySinh");
				Boolean gioitinhnam = rs.getBoolean("GioiTinhNam");
				lstSV.add(new SinhVien(masv, hoten, gioitinhnam, ngaysinh));
	        }
	        rs.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return lstSV;
}

	@Override
	public void insertStudent(SinhVien x) {
	    try {
	    	Connection con = DbHelper.getInstance().getConnection();
	    	String sql = "INSERT INTO SinhVien (MaSinhVien, HoTen, GioiTinhNam, NgaySinh) VALUES (?, ?, ?, ?)";
	        PreparedStatement stm = con.prepareStatement(sql);
	        stm.setString(1, x.getMaSinhVien());
	        stm.setString(2, x.getHoTen());
	        stm.setBoolean(3, x.isGioiTinhNam());
	        stm.setDate(4, new java.sql.Date(x.getNgaySinh().getTime()));
	        stm.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void deleteStudent(String maSV) {
	    try {
	    	Connection con = DbHelper.getInstance().getConnection();
	    	String sql = "DELETE FROM SinhVien WHERE MaSinhVien = ?";
	        PreparedStatement stm = con.prepareStatement(sql);
	        stm.setString(1, maSV);
	        stm.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
