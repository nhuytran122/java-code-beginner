package view;

import java.util.ArrayList;

import bean.Xe4Banhbean;
import bean.XeDapbean;
import bean.XeMaybean;
import bean.Xebean;
import bo.Xe4BanhBo;
import bo.XeDapBo;
import bo.XeMayBo;

public class test_input2 {
	public ArrayList<Xebean> getXeRa(){
		XeDapBo xdb = new XeDapBo();
		XeMayBo xmb = new XeMayBo();
		Xe4BanhBo x4b = new Xe4BanhBo();
		ArrayList<Xebean> ds2 = new ArrayList<Xebean>();
		
		ArrayList<XeDapbean> dsxdr;
		ArrayList<XeMaybean> dsxmr;
		ArrayList<Xe4Banhbean> dsx4r;
		
		try {
			dsxdr = xdb.getXeDapRa();
			for(XeDapbean xdbe : dsxdr) {
				Xebean xe = new XeDapbean();
				xe = xdbe;
				ds2.add(xe);
			}
			dsxmr = xmb.getXeMayRa();
			for(XeMaybean xmbe : dsxmr) {
				Xebean xe = new XeMaybean();
				xe = xmbe;
				ds2.add(xe);
			}
			
			dsx4r = x4b.getXe4BanhRa();
			for(Xe4Banhbean x4be : dsx4r) {
				Xebean xe = new Xe4Banhbean();
				xe = x4be;
				ds2.add(xe);
			}
//			System.out.println("Danh sách ra:");
//			for(Xebean xe : ds2) {
//				System.out.println(xe.toString());
//			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds2;
	}
	public static void main(String[] args) {
		XeDapBo xdb = new XeDapBo();
		XeMayBo xmb = new XeMayBo();
		Xe4BanhBo x4b = new Xe4BanhBo();
		ArrayList<Xebean> ds2 = new ArrayList<Xebean>();
		
		ArrayList<XeDapbean> dsxdr;
		ArrayList<XeMaybean> dsxmr;
		ArrayList<Xe4Banhbean> dsx4r;
		
		try {
			dsxdr = xdb.getXeDapRa();
			for(XeDapbean xdbe : dsxdr) {
				Xebean xe = new XeDapbean();
				xe = xdbe;
				ds2.add(xe);
			}
			dsxmr = xmb.getXeMayRa();
			for(XeMaybean xmbe : dsxmr) {
				Xebean xe = new XeMaybean();
				xe = xmbe;
				ds2.add(xe);
			}
			
			dsx4r = x4b.getXe4BanhRa();
			for(Xe4Banhbean x4be : dsx4r) {
				Xebean xe = new Xe4Banhbean();
				xe = x4be;
				ds2.add(xe);
			}
			System.out.println("Danh sách ra:");
			for(Xebean xe : ds2) {
				System.out.println(xe.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
