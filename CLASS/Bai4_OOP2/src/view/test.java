package view;

import java.util.ArrayList;

import bean.Xebean;
import bo.XeBo;
import dao.XeDao;

public class test {
	public static void main(String[] args) {
		ArrayList<Xebean> dsv;
		ArrayList<Xebean> dsr;
		ArrayList<Xebean> ds3 = new ArrayList<Xebean>();
		XeBo xbo = new XeBo();
		XeDao xd = new XeDao();
		try {
			dsv = xbo.getXeVao();
			dsr = xbo.getXeRa();
			ds3 = xbo.getFullInf(dsv, dsr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		for(Xebean x:ds3) {
			System.out.println(x);
		}
		
		xbo.Luu(ds3);
	}
}
