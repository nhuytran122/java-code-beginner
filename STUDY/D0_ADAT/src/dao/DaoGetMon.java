package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.moninbanbean;

public class DaoGetMon {


	public ArrayList<moninbanbean> getmon(String Ban) throws Exception{
		ArrayList<moninbanbean> ds = new ArrayList<moninbanbean>();
		ResultSet rs = Test1.getMon(Ban);
		while(rs.next()){
			String TenMon = rs.getString("TenMon");
			int SoLuongMon = rs.getInt("SoLuongMon");
			moninbanbean mon = new moninbanbean(TenMon, SoLuongMon);
			ds.add(mon);
		}
		rs.close();
		return ds;
}
	public int DoiBan(String BanDich, String BanNguon) throws Exception	{
		String sql="UPDATE tbl_PHIEUDATMON SET MaBan = '" + BanNguon +"' WHERE MaBan= '" +BanDich +"'";
		PreparedStatement cmd= Test1.cn.prepareStatement(sql);
		cmd.executeUpdate();
		return cmd.executeUpdate();
	}
	public int CapNhatBanDich(String BanDich) throws Exception	{
		String sql="UPDATE tbl_BAN SET TrangThai='True' where MaBan ='"+BanDich+ "'";
		PreparedStatement cmd= Test1.cn.prepareStatement(sql);
		cmd.executeUpdate();
		return cmd.executeUpdate();
	}
	public int CapNhatBanNguon(String BanNguon) throws Exception {
		String sql="UPDATE tbl_BAN SET TrangThai='False' where MaBan ='"+ BanNguon + "'";
		PreparedStatement cmd= Test1.cn.prepareStatement(sql);
		cmd.executeUpdate();
		return cmd.executeUpdate();
	}
}
