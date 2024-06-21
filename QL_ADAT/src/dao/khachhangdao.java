//làm việc trực tiếp với CSDL, Nó chỉ biết sự tồn tại của java bean.
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.khachhangbean;

public class khachhangdao {
	khachhangbean khb = new khachhangbean();
	public ArrayList<khachhangbean> getKH() throws Exception{
		try {
			ArrayList<khachhangbean> listkhbean = new ArrayList<khachhangbean>();
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "select * from tbl_KHACHHANG";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()){
				String MaKH = rs.getString("MaKH");
				String TenKH = rs.getString("TenKH");
				Date NgaySinh = rs.getDate("NgaySinh");
				String DiaChi = rs.getString("DiaChi");
				String SDT = rs.getString("SDT");
				Double DiemTichLuy = rs.getDouble("DiemTichLuy");
				String HangThanhVien = rs.getString("HangThanhVien");
				listkhbean.add(new khachhangbean(MaKH, TenKH, NgaySinh, DiaChi, SDT, DiemTichLuy, HangThanhVien));
			}
			rs.close();
			kn.cn.close();
			return listkhbean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int ThemKH(String maKH, String tenKH, Date ngaySinh, String diaChi, String sDT) throws Exception{
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "insert into tbl_KHACHHANG(MaKH, TenKH, NgaySinh, DiaChi, SDT, DiemTichLuy, HangThanhVien) values(?,?,?,?,?,?,?)";
			//B3: Tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, maKH);
			cmd.setString(2, tenKH);
			cmd.setDate(3, new java.sql.Date(ngaySinh.getTime()));
			cmd.setString(4, diaChi);
			cmd.setString(5, sDT);
			cmd.setDouble(6, 0.0);
			cmd.setString(7, "");
			//B4: Thuc hien cau lenh
			int kq = cmd.executeUpdate();
			//B5: Duyet qua rs
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int SuaKH(String maKH, String tenKH, Date ngaySinh, String diaChi, String sDT) throws Exception {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "UPDATE tbl_KHACHHANG set TenKH = ?, NgaySinh = ?, DiaChi = ?, SDT = ? where MaKH = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tenKH);
			cmd.setDate(2, new java.sql.Date(ngaySinh.getTime()));
			cmd.setString(3, diaChi);
			cmd.setString(4, sDT);
			cmd.setString(5, maKH);
			int kq = cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int xoaKH(String makh) throws Exception{
		try {
			KetNoi kn= new KetNoi();
			kn.ketnoi();
			String sql = "delete from tbl_KHACHHANG from tbl_HOADON where tbl_KHACHHANG.MaKH = tbl_HOADON.MaKH and tbl_KHACHHANG.MaKH = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, makh);
			int kq = cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
