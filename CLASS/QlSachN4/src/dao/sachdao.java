package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.sachbean;

public class sachdao {
	public ArrayList<sachbean> getSach(String maloai2) throws Exception{
		try {
			ArrayList<sachbean> ds = new ArrayList<sachbean>();
			// In:
			//B1: Ket noi vao CSDL
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh SQL
			String sql;
			PreparedStatement cmd;
			if(maloai2.equals("")) {
				//B3: Tao cau lenh
				 sql = "select * from sach";
				//B4: Thuc hien cau lenh
				 //cmd = kn.cn.prepareStatement(sql);
				cmd = KetNoi.cn.prepareStatement(sql);
			}
			else {
				sql = "select * from sach where maloai = ?";
				cmd = kn.cn.prepareStatement(sql);
				cmd.setString(1, maloai2);
			}
			
			ResultSet rs = cmd.executeQuery();
			//B5: Duyet qua rs
			while(rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String maloai = rs.getString("maloai");
				String sotap = rs.getString("sotap");
				String anh = rs.getString("anh");
				Date NgayNhap = rs.getDate("NgayNhap");
				String tacgia = rs.getString("tacgia");
				ds.add(new sachbean(masach, tensach, soluong, gia, maloai, sotap, anh, NgayNhap, tacgia));
			} 
			rs.close();
			KetNoi.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public int Sua(String masach, String tensach, Long soluong, Long gia, String tacgia) {
		try {
			//b1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql="update sach set tensach= ?, soluong = ?, gia = ?, tacgia  = ?  where masach = ?";
			//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, tensach);
			cmd.setLong(2, soluong);
			cmd.setLong(3, gia);
			cmd.setString(4, tacgia);			
			cmd.setString(5, masach);
			int kq = cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
	
	public int Ban(String masach, Long soluongban) {
		try {
			//b1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql = "update sach set soluong = soluong - ? where masach = ?";
			//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setLong(1, soluongban);
			cmd.setString(2, masach);			
			int kq = cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
	
	public int Xoa(String masach) {
		try {
			//b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql= "delete from sach where masach=?";
			//B3: tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			//b4: Thuc hien cau lenh
			int kq = cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
