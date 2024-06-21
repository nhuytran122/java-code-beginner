package bo;

import java.util.ArrayList;

import bean.hoadonbean;
import dao.hoadondao;

public class hoadonbo {
	hoadondao hd= new hoadondao();
	ArrayList<hoadonbean> list;
	public ArrayList<hoadonbean> getHoaDon() throws Exception{
		list = hd.getHoaDon();
		return list;
	}
	
	public int capnhatTongTien(String tongtien,String mahoadon) throws Exception{
		return hd.capnhatTongTien(tongtien,mahoadon);
	}
	
	public int xoaHoaDon(hoadonbean hd1) throws Exception{
		return hd.xoaHoaDon(hd1);
	}
}
