package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.hoadonbean;

public class hoadondao {
	public ArrayList<hoadonbean> getHoaDon() throws Exception{
		ArrayList<hoadonbean> list = new ArrayList<hoadonbean>();
		ResultSet rs = connectDB.getBang("tbl_HOADON");
		while(rs.next()){
			String mahoadon = rs.getString("MaHD");
			String maban = rs.getString("MaBan");
			String maphieu = rs.getString("MaPhieu");
			String manhanvien = rs.getString("MaNV");
			Date ngaylap = rs.getDate("NgayLap");
			String tongtien = rs.getString("TongTien");
			hoadonbean hoadon = new hoadonbean(mahoadon,maban,maphieu,manhanvien,tongtien,ngaylap);
			list.add(hoadon);
		}
		rs.close();
		return list;
	}
	
	public int capnhatTongTien(String TongTien,String mahoadon) throws Exception{
		String sql = "update tbl_HOADON set TongTien = ? where MaHD = ?";
		PreparedStatement cmd = connectDB.cn.prepareStatement(sql);
		cmd.setString(1,TongTien);
		cmd.setString(2, mahoadon);
		return cmd.executeUpdate();
	}
	
	public int xoaHoaDon(hoadonbean hd) throws Exception{
		String sql="delete from tbl_HOADON where MaHD = ?";
		PreparedStatement cmd = connectDB.cn.prepareStatement(sql);
		cmd.setString(1, hd.getMahoadon());
		return cmd.executeUpdate();
	}
}
