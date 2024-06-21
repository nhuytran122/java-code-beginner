package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class testSelect_where {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Nhap ho ten muon tim: ");
			Scanner nhap = new Scanner(System.in);
			String ht = nhap.nextLine();
			//B1: Ket noi vao CSDL
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh SQL
			String sql = "select * from tbl_nhanvien where hoten like ?";
			//B3: Tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//B4: Thuc hien cau lenh
			cmd.setString(1, "%" + ht + "%");
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
			nhap.close();
		
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
