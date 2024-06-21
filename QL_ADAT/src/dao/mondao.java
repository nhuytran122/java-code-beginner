package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.monbean;

public class mondao {
	monbean mbe = new monbean();
	public ArrayList<monbean> getMon() throws Exception{
		try {
			ArrayList<monbean> ds = new ArrayList<monbean>();
			//B1: Ket noi vao CSDL
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh SQL
			String sql = "select * from tbl_MON";
			//B3: Tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//B4: Thuc hien cau lenh
			ResultSet rs = cmd.executeQuery();
			//B5: Duyet qua rs
			while(rs.next()) {
				String MaMon = rs.getString("MaMon");
				String TenMon = rs.getString("TenMon");
				Double Gia = rs.getDouble("Gia");
				String LoaiMon = rs.getString("LoaiMon");
				ds.add(new monbean(MaMon, TenMon, Gia, LoaiMon));
			} 
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int ThemMon(String mamon, String tenmon, Double gia, String loaimon) throws Exception{
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "insert into tbl_MON(MaMon, TenMon, Gia, LoaiMon) values(?,?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, mamon);
			cmd.setString(2, tenmon);
			cmd.setDouble(3, gia);
			cmd.setString(4, loaimon);
			int kq = cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int SuaMon(String mamon, String tenmon, Double gia, String loaimon) throws Exception {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "UPDATE tbl_MON set TenMon = ?, Gia = ?, LoaiMon = ? where MaMon = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tenmon);
			cmd.setDouble(2, gia);
			cmd.setString(3, loaimon);
			cmd.setString(4, mamon);
			int kq = cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int XoaMon(String MaMon) throws Exception{
		try {
			KetNoi kn= new KetNoi();
			kn.ketnoi();
			String sql = "delete from tbl_MON where MaMon = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, MaMon);
			int kq = cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
