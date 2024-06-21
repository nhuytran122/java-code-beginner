//làm việc trực tiếp với CSDL, Nó chỉ biết sự tồn tại của java bean.
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.khachhangbean;
import bean.monbean;

public class khachhangdao {
	khachhangbean khb = new khachhangbean();
	public ArrayList<khachhangbean> getKH() throws Exception{
		ArrayList<khachhangbean> listkhbean = new ArrayList<khachhangbean>();
		ResultSet rs = connectDB.getBang("tbl_KHACHHANG");
		while(rs.next()){
			String makh = rs.getString("MaKH");
			String tenkh = rs.getString("TenKH");
			Date ngaysinh = rs.getDate("NgaySinh");
			String diachi = rs.getString("DiaChi");
			String sdt = rs.getString("SDT");
			khachhangbean kh = new khachhangbean(makh,tenkh,ngaysinh,diachi,sdt);
			listkhbean.add(kh);
		}
		rs.close();
		return listkhbean;
	}

	public int ThemKH(khachhangbean mb) throws Exception{
		String sql = "insert into tbl_KHACHHANG(MaKH,TenKH,NgaySinh,DiaChi,SDT) values(?,?,?,?,?)";
		PreparedStatement cmd=connectDB.cn.prepareStatement(sql);
		cmd.setString(1, khb.getMaKH());
		cmd.setString(2, khb.getTenKH());
		cmd.setDate(3, (java.sql.Date) khb.getNgaysinh());
		cmd.setString(4, khb.getDiachi());
		cmd.setString(5, khb.getSdt());
		return cmd.executeUpdate();
	}
	
	public int SuaKH(String makh, String tenkh, Date ngaysinh, String diachi, String sdt) throws Exception {
		String sql = "UPDATE tbl_KHACHHANG set MaKH = ?, TenKH = ?, DiaChi = ?, SDT = ? where MaKH = ?";
		PreparedStatement cmd = connectDB.cn.prepareStatement(sql);
		cmd.setString(1, makh);
		cmd.setString(2, tenkh);
		cmd.setDate(3, (java.sql.Date) ngaysinh);
		cmd.setString(4, diachi);
		cmd.setString(5, sdt);
		return cmd.executeUpdate();
	}
	
	public int xoaKH(khachhangbean kh) throws Exception{
		String sql="delete from tbl_KHACHHANG where MaKH = ?";
		PreparedStatement cmd = connectDB.cn.prepareStatement(sql);
		cmd.setString(1, kh.getMaKH());
		return cmd.executeUpdate();
	}
}
