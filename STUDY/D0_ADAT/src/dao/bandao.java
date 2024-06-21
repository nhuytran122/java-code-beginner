package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.banbean;
import dao.Test1;

public class bandao {

	public ArrayList<banbean> getban() throws Exception	{
		ArrayList<banbean> ds = new ArrayList<banbean>();
		ResultSet rs = Test1.getBang("tbl_BAN");
		while(rs.next())		{
			String MaBan = rs.getString("MaBan");
			String TenBan = rs.getString("TenBan");
			Boolean TrangThai = rs.getBoolean("TrangThai");
			String ViTriBan = rs.getString("ViTriBan");
			banbean ban = new banbean(MaBan, TenBan, TrangThai, ViTriBan);
			ds.add(ban);
		}
		rs.close();
		return ds;
	}
//	public int Xoa(BanBean ban) throws Exception
//	{
//		String sql="delete from Ban where IdBan = ?";
//		PreparedStatement cmd = Test1.cn.prepareStatement(sql);
//		cmd.setString(1,ban.getIdBan());
//		return cmd.executeUpdate();```
//	}
}