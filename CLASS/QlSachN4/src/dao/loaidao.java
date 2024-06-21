package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getLoai() throws Exception{
		try {
			ArrayList<loaibean> ds = new ArrayList<loaibean>();
			// In:
			//B1: Ket noi vao CSDL
//			KetNoi kn = new KetNoi();
//			kn.ketnoi();
			
			//B2: Tao cau lenh SQL
			String sql = "select * from loai";
			//B3: Tao cau lenh
			PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
			//B4: Thuc hien cau lenh
			ResultSet rs = cmd.executeQuery();
			//B5: Duyet qua rs
			while(rs.next()) {
				String maloai = rs.getString("maloai");
				String tenloai = rs.getString("tenloai");
				ds.add(new loaibean(maloai, tenloai));
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
	
	
	
}
