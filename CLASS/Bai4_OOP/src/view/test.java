package view;

import java.util.ArrayList;

import bean.Xebean;
import bo.XeBo;
import dao.XeDao;

public class test {
	public static void main(String[] args) {
		ArrayList<Xebean> ds1;
		ArrayList<Xebean> ds2;
		ArrayList<Xebean> ds3 = new ArrayList<Xebean>();
		XeBo xbo = new XeBo();
		test_input1 xevao = new test_input1();
		test_input2 xera = new test_input2();
		ds1 = xevao.getXeVao();
		ds2 = xera.getXeRa();
		XeDao xd = new XeDao();
		try {
			ds3 = xd.ADDFull(ds1, ds2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Xebean x:ds3) {
			System.out.println(x);
		}
		xbo.Luu(ds3);
		
		
/*		ArrayList<Xebean> ds1;
		ArrayList<Xebean> ds2;
		ArrayList<Xebean> ds3 = new ArrayList<Xebean>();
		
		test_input1 xevao = new test_input1();
		test_input2 xera = new test_input2();
		ds1 = xevao.getXeVao();
		ds2 = xera.getXeRa();
		
		XeBo xbo = new XeBo();
		SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		for(Xebean xer:ds2) {
			if(xer.getLoaiXe().equals("0")) {
				for(Xebean xev : ds1) 
					if(xer.getSoVeXe().equals(xev.getSoVeXe())) {
						Xebean tmp = new XeDapbean(null, null, null, null, null, xev.getTimeVao(), xer.getTimeRa(), xer.getSoVeXe());
						ds3.add(tmp);
					}
			}
			
			else if(xer.getLoaiXe().equals("2")) {
				for(Xebean xev : ds1) 
					if(xer.getBienSoXe().equals(xev.getBienSoXe())) {
						Xebean tmp = new XeMaybean(null, null, null, null, null, xev.getTimeVao(), xer.getTimeRa(), xer.getBienSoXe());
						ds3.add(tmp);
					}
			}
			else {
				for(Xebean xev : ds1) 
					if(xer.getBienSoXe().equals(xev.getBienSoXe())) {
						Xebean tmp = new Xe4Banhbean(null, null, null, null, null, xev.getTimeVao(),
								xer.getTimeRa(), xer.getBienSoXe(), xev.getTinhTrangVaoBai(), xer.getTinhTrangRaBai());
						ds3.add(tmp);
					}
			}
		}
		for(Xebean tmp:ds3) {
			System.out.println(tmp);
		}
		System.out.println("KET QUA: ");
		for(Xebean tmp:ds3) {
			System.out.println(tmp.getLoaiXe() + ";" + tmp.getBienSoXe() + ";" + tmp.getSoVeXe() + ";" + d.format(tmp.getTimeVao()) + ";" + d.format(tmp.getTimeRa()) + ";" + tmp.tinhTien());
		}
		try {
			xbo.Luu(ds3);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
*/		
		
		
	}
}
