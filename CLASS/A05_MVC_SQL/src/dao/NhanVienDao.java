package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.NhanVienBean;

public class NhanVienDao {
	public ArrayList<NhanVienBean> getNV() throws Exception{
		try {
			ArrayList<NhanVienBean> ds = new ArrayList<NhanVienBean>();
			// In:
			//B1: Ket noi vao CSDL
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh SQL
			String sql = "select * from tbl_nhanvien";
			//B3: Tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//B4: Thuc hien cau lenh
			ResultSet rs = cmd.executeQuery();
			//B5: Duyet qua rs
			while(rs.next()) {
				//String manv, String tennv, Date ngaysinh, Double hsl, String madv
				String manv = rs.getString("manv");
				String hoten = rs.getString("hoten");
				Date ngaysinh = rs.getDate("ngaysinh");
				Double hsl = rs.getDouble("hsl");
				String madv = rs.getString("madv");
				//System.out.println(manv + " : " + hoten + " : " + hsl + " : " + ngaysinh);
				ds.add(new NhanVienBean(manv, hoten, ngaysinh, hsl, madv));
			} 
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public int ThemNV(String manv, String hoten, Date ngaysinh, Double hsl, String madv) throws Exception{
		try {
			//B1: Ket noi vao CSDL
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh SQL
			String sql = "insert into tbl_nhanvien(manv, hoten, ngaysinh, hsl, madv) values (?, ?, ?, ?, ?)";
			//B3: Tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, manv);
			cmd.setString(2, hoten);
			cmd.setDate(3, new java.sql.Date(ngaysinh.getDate()));
			cmd.setDouble(4, hsl);
			cmd.setString(5, madv);
			//B4: Thuc hien cau lenh
			int kq = cmd.executeUpdate();
			//B5: Duyet qua rs
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public int Xoa(String manv) {
		try {
			//b1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql= "delete from tbl_nhanvien where manv=?";
			//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, manv);
			//b4: Thuc hien cau lenh
			int kq= cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int Sua(String manv, String hoten, Date ngaysinh, Double hsl, String madv) {
		try {
			//b1: Ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql="update tbl_nhanvien set hoten = ?, ngaysinh = ?, hsl = ?, madv = ? where manv = ?";
			//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, hoten);
			cmd.setDate(2, new java.sql.Date(ngaysinh.getTime()));
			cmd.setDouble(3, hsl);
			cmd.setString(4, madv);
			cmd.setString(5, manv);
			int kq = cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

}
	
//	public void Luu(ArrayList<NhanVienBean> ds) throws Exception{
//		FileWriter f = new FileWriter("nhanvien.txt");
//		PrintWriter ghi = new PrintWriter(f);
//		
//		SimpleDateFormat f2 = new SimpleDateFormat("dd/MM/yyyy");
//		
//		for(NhanVienBean nv:ds) {
//			//doi ngay ra chuoi
//			String ns = f2.format(nv.getNgaysinh());
//			ghi.println(nv.getMaNV() + ";" + nv.getTenNV() + ";" + ns + ";" + nv.getHsluong() + ";" + nv.getMadv());
//		}
//		ghi.close();
//	}
}
