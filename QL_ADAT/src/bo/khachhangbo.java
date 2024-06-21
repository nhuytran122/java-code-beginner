package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {
	khachhangdao khd = new khachhangdao();
	khachhangbean khb = new khachhangbean();
	ArrayList<khachhangbean> dskh;
	public ArrayList<khachhangbean> getKH() throws Exception{
		dskh = khd.getKH();
		return dskh;
	}
	
	public ArrayList<khachhangbean> ThemKH(String maKH, String tenKH, Date ngaySinh, String diaChi, String sDT) throws Exception{
		for(khachhangbean k1:dskh)
			if(k1.getMaKH().toLowerCase().trim().equals((maKH).toLowerCase().trim()) || k1.getSDT().equals(sDT))
				return null;
			
		dskh.add(new khachhangbean(maKH, tenKH, ngaySinh, diaChi, sDT, 0.0, ""));
		khd.ThemKH(maKH, tenKH, ngaySinh, diaChi, sDT);
		return dskh;
	}
	
	public ArrayList<khachhangbean> SuaKH(String maKH, String tenKH, Date ngaySinh, String diaChi, String sDT) throws Exception{
		int n = dskh.size();
		for(int i = 0; i < n; i++)
			if(dskh.get(i).getMaKH().equals(maKH)) {
				khachhangbean khbe = dskh.get(i);
				khbe.setTenKH(tenKH);
				khbe.setNgaySinh(ngaySinh);
				khbe.setDiaChi(diaChi);
				khbe.setSDT(sDT);
				dskh.set(i, khbe);//Sua trong bo nho
				khd.SuaKH(maKH, tenKH, ngaySinh, diaChi, sDT);//Sua trong csdl
				break;
		  }
		  return dskh;
	}
	
	public ArrayList<khachhangbean> Xoa(String makh) throws Exception{
		for(khachhangbean khbe:dskh)
			if(khbe.getMaKH().equals(makh)) {
				dskh.remove(khbe); //xoa trong bo nho
				khd.xoaKH(makh); // xoa trong csdl
				break;
			}
		return dskh;
	}
	
	public ArrayList<khachhangbean> TimKH(String key) throws Exception{
		ArrayList<khachhangbean> tmp = new ArrayList<khachhangbean>();
		for(khachhangbean khbe:dskh){
			if(khbe.getMaKH().toLowerCase().trim().contains(key.toLowerCase().trim()) || khbe.getTenKH().toLowerCase().trim().contains(key.toLowerCase().trim()))
				tmp.add(khbe);
		}
		return tmp;
	}
	
}
