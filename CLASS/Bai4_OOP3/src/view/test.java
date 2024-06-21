package view;

import java.util.ArrayList;

import bean.Xebean;
import bo.XeBo;
import dao.XeDao;

public class test {
	public static void main(String[] args) {
		ArrayList<Xebean> dsv = new ArrayList<Xebean>();
		ArrayList<Xebean> dsr;
		ArrayList<Xebean> ds3 = new ArrayList<Xebean>();
		XeBo xbo = new XeBo();
		try {
			dsv = xbo.getXeVao();
			dsr = xbo.getXeRa();
			ds3 = xbo.getFullInf(dsv, dsr);
			
			xbo.Napdata_C4(dsv);
			System.out.println("LIST XE VAO");
			for(Xebean x: dsv) 
				System.out.println(x);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nDS3:");
		for(Xebean x:ds3) {
			System.out.println(x);
		}
		xbo.Luu(ds3);
	}
}
