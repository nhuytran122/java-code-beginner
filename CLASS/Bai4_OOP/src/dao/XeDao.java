package dao;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.Xe4Banhbean;
import bean.XeDapbean;
import bean.XeMaybean;
import bean.Xebean;
import view.test_input1;
import view.test_input2;


public class XeDao {
	public void Luu(ArrayList<Xebean> ds3){
		SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		try {
			FileWriter f = new FileWriter("output.txt");
			PrintWriter ghi = new PrintWriter(f);
			for(Xebean tmp:ds3)
				ghi.println(tmp.getLoaiXe() + ";" + tmp.getBienSoXe() + ";" + tmp.getSoVeXe() + ";" + d.format(tmp.getTimeVao()) + ";" + d.format(tmp.getTimeRa()) + ";" + tmp.tinhTien());
			ghi.close();
			System.out.println("DONE");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Xebean> ADDFull(ArrayList<Xebean> dsvao, ArrayList<Xebean> dsra) throws Exception{
		ArrayList<Xebean> ds3 = new ArrayList<Xebean>();
		
		test_input1 xevao = new test_input1();
		test_input2 xera = new test_input2();
		dsvao = xevao.getXeVao();
		dsra = xera.getXeRa();
		
//		SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		for(Xebean xer:dsra) {
			if(xer.getLoaiXe().equals("0")) {
				for(Xebean xev : dsvao) 
					if(xer.getSoVeXe().equals(xev.getSoVeXe())) {
						Xebean tmp = new XeDapbean(null, null, null, null, null, xev.getTimeVao(), xer.getTimeRa(), xer.getSoVeXe());
						ds3.add(tmp);
					}
			}
			else if(xer.getLoaiXe().equals("2")) {
				for(Xebean xev : dsvao) 
					if(xer.getBienSoXe().equals(xev.getBienSoXe())) {
						Xebean tmp = new XeMaybean(null, null, null, null, null, xev.getTimeVao(), xer.getTimeRa(), xer.getBienSoXe());
						ds3.add(tmp);
					}
			}
			else {
				for(Xebean xev : dsvao) 
					if(xer.getBienSoXe().equals(xev.getBienSoXe())) {
						Xebean tmp = new Xe4Banhbean(null, null, null, null, null, xev.getTimeVao(),
								xer.getTimeRa(), xer.getBienSoXe(), xev.getTinhTrangVaoBai(), xer.getTinhTrangRaBai());
						ds3.add(tmp);
					}
			}
		}
//		for(Xebean tmp:ds3) {
//			System.out.println(tmp);
//		}
//		System.out.println("KET QUA: ");
//		for(Xebean tmp:ds3) {
//			System.out.println(tmp.getLoaiXe() + ";" + tmp.getBienSoXe() + ";" + tmp.getSoVeXe() + ";" + d.format(tmp.getTimeVao()) + ";" + d.format(tmp.getTimeRa()) + ";" + tmp.tinhTien());
//		}
		return ds3;
	}
}
