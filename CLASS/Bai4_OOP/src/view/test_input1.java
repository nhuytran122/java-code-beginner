package view;

import java.util.ArrayList;

import bean.Xe4Banhbean;
import bean.XeDapbean;
import bean.XeMaybean;
import bean.Xebean;
import bo.Xe4BanhBo;
import bo.XeDapBo;
import bo.XeMayBo;

public class test_input1 {
	public ArrayList<Xebean> getXeVao(){
		XeDapBo xdb = new XeDapBo();
		XeMayBo xmb = new XeMayBo();
		Xe4BanhBo x4b = new Xe4BanhBo();
		ArrayList<Xebean> ds1 = new ArrayList<Xebean>();
		ArrayList<Xebean> ds2;
		
		ArrayList<XeDapbean> dsxdv;
		ArrayList<XeDapbean> dsxdr;
		ArrayList<XeMaybean> dsxmv;
		ArrayList<XeMaybean> dsxmr;
		ArrayList<Xe4Banhbean> dsx4v;
		ArrayList<Xe4Banhbean> dsx4r;
		
		try {
			dsxdv = xdb.getXeDapVao();
			for(XeDapbean xdbe : dsxdv) {
				Xebean xe = new XeDapbean();
				xe = xdbe;
				ds1.add(xe);
			}
			
			dsxmv = xmb.getXeMayVao();
			for(XeMaybean xmbe : dsxmv) {
				Xebean xe = new XeMaybean();
				xe = xmbe;
				ds1.add(xe);
			}
			
			dsx4v = x4b.getXe4BanhVao();
			for(Xe4Banhbean x4be : dsx4v) {
				Xebean xe = new Xe4Banhbean();
				xe = x4be;
				ds1.add(xe);
			}
//			System.out.println("Danh sách vào:");
//			for(Xebean xe : ds1) {
//				System.out.println(xe.toString());
//			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds1;
	}
	
	public static void main(String[] args) {
		XeDapBo xdb = new XeDapBo();
		XeMayBo xmb = new XeMayBo();
		Xe4BanhBo x4b = new Xe4BanhBo();
		ArrayList<Xebean> ds1 = new ArrayList<Xebean>();
		ArrayList<Xebean> ds2;
		
		ArrayList<XeDapbean> dsxdv;
		ArrayList<XeDapbean> dsxdr;
		ArrayList<XeMaybean> dsxmv;
		ArrayList<XeMaybean> dsxmr;
		ArrayList<Xe4Banhbean> dsx4v;
		ArrayList<Xe4Banhbean> dsx4r;
		
		try {
			dsxdv = xdb.getXeDapVao();
			for(XeDapbean xdbe : dsxdv) {
				Xebean xe = new XeDapbean();
				xe = xdbe;
				ds1.add(xe);
			}
			
			dsxmv = xmb.getXeMayVao();
			for(XeMaybean xmbe : dsxmv) {
				Xebean xe = new XeMaybean();
				xe = xmbe;
				ds1.add(xe);
			}
			
			dsx4v = x4b.getXe4BanhVao();
			for(Xe4Banhbean x4be : dsx4v) {
				Xebean xe = new Xe4Banhbean();
				xe = x4be;
				ds1.add(xe);
			}
			System.out.println("Danh sách vào:");
			for(Xebean xe : ds1) {
				System.out.println(xe.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
