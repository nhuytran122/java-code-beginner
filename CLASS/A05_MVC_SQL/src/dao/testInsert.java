package dao;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testInsert {
	public static void main(String[] args) {
		try {
			//B1: Ket noi vao CSDL
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh SQL
			String sql2 = "insert into tbl_nhanvien(manv, hoten, gioitinh, ngaysinh, hsl, madv) values (?, ?, ?, ?, ?, ?)";
			//B3: Tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql2);
			cmd.setString(2, "Lê Văn A");
			cmd.setString(1, "KFSDLFDB");
			cmd.setBoolean(3, false);
			String ns = "2000-09-19";
			//Doi chuoi sang util
			SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
			Date ngay = d.parse(ns);
			
			//Doi ngay util sang ngay sql
			cmd.setDate(4, new java.sql.Date(ngay.getTime()));
			cmd.setDouble(5, 4.0);
			cmd.setString(6, "DV3");
			cmd.executeUpdate();
			System.out.println("Hoan thanh");


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
