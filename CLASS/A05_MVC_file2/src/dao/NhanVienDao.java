package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.NhanVienBean;

public class NhanVienDao {
	public ArrayList<NhanVienBean> getNV() throws Exception{
		//Tao 1 mang de luu all cac Don vi trong file donvi.txt
		ArrayList<NhanVienBean> ds = new ArrayList<NhanVienBean>();
		//mo file
		FileReader f = new FileReader("nhanvien.txt");
		BufferedReader b = new BufferedReader(f);
		//duyet file
		while(true) {
			String st = b.readLine();
			if(st == null || st == "") break;
			String[] t = st.split("[;]");
			String MaNV = t[0];
			String tenNV = t[1];
			SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy");
			Date ngaysinh = dd.parse(t[2]);
			Double hsluong = Double.parseDouble(t[3]);
			String madv = t[4];
			ds.add(new NhanVienBean(MaNV, tenNV, ngaysinh, hsluong, madv));
		}
		b.close();
		return ds;
	}
	
	public void Luu(ArrayList<NhanVienBean> ds) throws Exception{
		FileWriter f = new FileWriter("nhanvien.txt");
		PrintWriter ghi = new PrintWriter(f);
		
		SimpleDateFormat f2 = new SimpleDateFormat("dd/MM/yyyy");
		
		for(NhanVienBean nv:ds) {
			//doi ngay ra chuoi
			String ns = f2.format(nv.getNgaysinh());
			ghi.println(nv.getMaNV() + ";" + nv.getTenNV() + ";" + ns + ";" + nv.getHsluong() + ";" + nv.getMadv());
		}
		ghi.close();
	}
}
