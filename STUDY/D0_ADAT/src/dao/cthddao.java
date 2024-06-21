package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.cthdbean;
import bean.hoadonbean;

public class cthddao {
	
	public ArrayList<cthdbean> getcthd() throws Exception
	{
		ArrayList<cthdbean> list = new ArrayList<cthdbean>();
		ResultSet rs = connectDB.getBang("tbl_CTHD");
		while(rs.next())
		{
			String macthd = rs.getString("MaCTHD");
			String mahoadon = rs.getString("MaHD");
			String mamon = rs.getString("MaMon");
			int soluong = rs.getInt("SoLuong");
			String gia = rs.getString("Gia");
			Date thoigianvao = rs.getDate("ThoiGianVao");
			Date thoigianra = rs.getDate("ThoiGianRa");
			Double khuyenmai = rs.getDouble("KhuyenMai");
			String tamtinh = rs.getString("TamTinh");
			cthdbean ct = new cthdbean(macthd,mahoadon,mamon,soluong,gia,thoigianvao,thoigianra,khuyenmai,tamtinh);
			list.add(ct);
		}
		rs.close();
		return list;
	}
	public int suaCTHD(cthdbean ct) throws Exception
	{
		String sql = "update tbl_CTHD set SoLuong = ?, KhuyenMai = ? where MaCTHD = ?";
		PreparedStatement cmd = connectDB.cn.prepareStatement(sql);
		cmd.setString(3, ct.getMacthd());
		cmd.setInt(1, ct.getSoluong());
		cmd.setDouble(2,ct.getKhuyenmai());
		return cmd.executeUpdate();
	}
	public int xoaMonTrongCTHD(cthdbean ct) throws Exception
	{
		String sql="delete from tbl_CTHD where MaCTHD = ?";
		PreparedStatement cmd = connectDB.cn.prepareStatement(sql);
		cmd.setString(1, ct.getMacthd());
		return cmd.executeUpdate();
	}
	public int capNhatTamTinh(cthdbean ct) throws Exception
	{
		String sql = "update tbl_CTHD set TamTinh = ? where MaCTHD = ?";
		PreparedStatement cmd = connectDB.cn.prepareStatement(sql);
		cmd.setString(2, ct.getMacthd());
		cmd.setString(1, ct.getTamtinh());
		return cmd.executeUpdate();
	}
}
