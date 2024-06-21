//làm việc trực tiếp với CSDL, Nó chỉ biết sự tồn tại của java bean.
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.monbean;

public class mondao {
	monbean mb=new monbean();
	public ArrayList<monbean> getmon() throws Exception{
		ArrayList<monbean> listmb = new ArrayList<monbean>();
		ResultSet rs = connectDB.getBang("tbl_MON");
		while(rs.next()){
			String mamon = rs.getString("MaMon");
			String tenmon = rs.getString("TenMon");
			String gia = rs.getString("Gia");
			String loaimon = rs.getString("LoaiMon");
			listmb.add(new monbean(mamon,tenmon,gia,loaimon));
		}
		rs.close();
		return listmb;
	}

	public int Themmon(monbean mb) throws Exception{
		String sql = "insert into tbl_MON(MaMon,TenMon,Gia,LoaiMon) values(?,?,?,?)";
		PreparedStatement cmd=connectDB.cn.prepareStatement(sql);
		cmd.setString(1, mb.getMamon());
		cmd.setString(2, mb.getTenmon());
		cmd.setString(3, mb.getGia());
		cmd.setString(4, mb.getLoaimon());
		return cmd.executeUpdate();
	}
	
	public int Sua(String maMon, String tenMon, String gia, String loaiMon) throws Exception {
		String sql = "UPDATE tbl_MON set TenMon = ?, Gia = ?, LoaiMon = ? where MaMon = ?";
		PreparedStatement cmd = connectDB.cn.prepareStatement(sql);
		cmd.setString(1, tenMon);
		cmd.setString(2, gia);
		cmd.setString(3, loaiMon);
		cmd.setString(4, maMon);
		return cmd.executeUpdate();
	}
	
	public int xoaMon(monbean mon) throws Exception{
		String sql="delete from tbl_MON where MaMon = ?";
		PreparedStatement cmd = connectDB.cn.prepareStatement(sql);
		cmd.setString(1, mon.getMamon());
		return cmd.executeUpdate();
	}
}
