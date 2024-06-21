package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DonViBean;

public class DonViDao {
	public ArrayList<DonViBean> getDV() throws Exception{
		try {
			ArrayList<DonViBean> ds = new ArrayList<DonViBean>();
			// In:
			//B1: Ket noi vao CSDL
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh SQL
			String sql = "select * from tbl_donvi";
			//B3: Tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//B4: Thuc hien cau lenh
			ResultSet rs = cmd.executeQuery();
			//B5: Duyet qua rs
			while(rs.next()) {
				String madv = rs.getString("madv");
				String tendv = rs.getString("tendv");
				//System.out.println(manv + " : " + hoten + " : " + hsl + " : " + ngaysinh);
				ds.add(new DonViBean(madv, tendv));
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
	
	public int ThemDV(String madv, String tendv) throws Exception{
		try {
			//B1: Ket noi vao CSDL
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh SQL
			String sql = "insert into tbl_donvi(madv, tendv) values(?, ?)";
			//B3: Tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, madv);
			cmd.setString(2, tendv);
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
	
	public int Xoa(String madv) {
		try {
			//b1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql= "delete from tbl_donvi where madv=?";
			//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, madv);
			//b4: Thuc hien cau lenh
			int kq= cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int Sua(String madv, String tendvmoi) {
		try {
			//b1: Ket noi vao csdl
			KetNoi kn= new KetNoi();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql="update tbl_donvi set tendv=? where madv=?";
			//B3: tao cau lenh
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, tendvmoi);
			cmd.setString(2, madv);
			//b4: Thuc hien cau lenh
			int kq= cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

}

//	public ArrayList<DonViBean> getDV() throws Exception{
//		//Tao 1 mang de luu all cac Don vi trong file donvi.txt
//		ArrayList<DonViBean> dsbean = new ArrayList<DonViBean>();
//		//mo file
//		FileReader f = new FileReader("donvi.txt");
//		BufferedReader b = new BufferedReader(f);
//		//duyet file
//		while(true) {
//			String st = b.readLine();
//			if(st == null || st == "") break;
//			String[] t = st.split("[;]");
//			String madv = t[0];
//			String tendv = t[1];
//			dsbean.add(new DonViBean(madv, tendv));
//		}
//		b.close();
//		return dsbean;
//	}
	
//	public void NapFile() throws Exception{
//		FileReader f = new FileReader("donvi.txt");
//		BufferedReader b = new BufferedReader(f);
//		while(true) {
//			String st=b.readLine();
//			if(st==null||st=="") break;
//			String[] t=st.split("[;]");
//			ThemDV(t[0], t[1]);//Them vao csdl
//		}
//		b.close();
//
//	}

	public void Luu(ArrayList<DonViBean> ds) throws Exception{
		FileWriter f = new FileWriter("donvi.txt");
		PrintWriter ghi = new PrintWriter(f);
		for(DonViBean h:ds)
			ghi.println(h.getMadv() + ";" + h.getTendv());
		ghi.close();
	}
}
