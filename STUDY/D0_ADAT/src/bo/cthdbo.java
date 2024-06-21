package bo;

import java.util.ArrayList;

import bean.cthdbean;
import dao.cthddao;

public class cthdbo {
	cthddao ct = new cthddao();
	ArrayList<cthdbean> list;
	public ArrayList<cthdbean> getCTHD() throws Exception{
		list = ct.getcthd();
		return list;
	}
	
	public int suaCTHD(cthdbean ct1) throws Exception{
		return ct.suaCTHD(ct1);
	}
	
	public int xoaMonTrongCTHD(cthdbean ct1) throws Exception{
		return ct.xoaMonTrongCTHD(ct1);
	}
	
	public ArrayList<cthdbean> Find(String mahoadon) throws Exception{
		ArrayList<cthdbean> tam = new ArrayList<cthdbean>();
		for(cthdbean cthd:getCTHD()){
			if(cthd.getMahoadon().contains(mahoadon)){
				tam.add(cthd);
			}
		}
		return tam;
	}
	
	public int capnhatTamtinh(cthdbean ct1) throws Exception{
		return ct.capNhatTamTinh(ct1);
	}
}
