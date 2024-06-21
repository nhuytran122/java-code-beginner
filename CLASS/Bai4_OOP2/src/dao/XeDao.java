package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.Xe4Banhbean;
import bean.XeDapbean;
import bean.XeMaybean;
import bean.Xebean;
import bo.XeBo;

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
		XeBo xb = new XeBo();
		dsvao = xb.getXeVao();
		dsra = xb.getXeRa();
		
//		SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		for(Xebean xer:dsra) {
			if(xer.getLoaiXe().equals("0")) {
				for(Xebean xev : dsvao) 
					if(xer.getSoVeXe().equals(xev.getSoVeXe())) {
						ds3.add(new XeDapbean(null, null, null, null, null, xev.getTimeVao(), xer.getTimeRa(), xer.getSoVeXe()));
					}
			}
			else if(xer.getLoaiXe().equals("2")) {
				for(Xebean xev : dsvao) 
					if(xer.getBienSoXe().equals(xev.getBienSoXe())) {
						ds3.add(new XeMaybean(null, null, null, null, null, xev.getTimeVao(), xer.getTimeRa(), xer.getBienSoXe()));
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
		return ds3;
	}
		
	public ArrayList<Xebean> getXeVao() throws Exception{
		ArrayList<Xebean> dsbean = new ArrayList<Xebean>();
			//mo file
		FileReader f = new FileReader("input1.txt");
		BufferedReader b = new BufferedReader(f);
			//duyet file
		while(true) {
			String st = b.readLine();
			if(st == null || st == "") break;
			String[] t = st.split("[;]");
			String loaixe = t[0];
			String bsx = t[1];	
			String sovexe = t[2];
			SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy");
			Date timevao = d.parse(t[3]);
			String ttvao = t[4];
			if(t[0].equals("0"))
		//(String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao, Date timeRa, String soVeXe)
				dsbean.add(new XeDapbean(null, null, null, null, null, timevao, null, sovexe));
			else if(t[0].equals("2"))
				dsbean.add(new XeMaybean(null, null, null, null, null, timevao, null, bsx));
			else
				dsbean.add(new Xe4Banhbean(null, null, null, null, null, timevao, null, bsx, ttvao, null));
		}
		b.close();
		return dsbean;
	}
		
	public ArrayList<Xebean> getXeRa() throws Exception{
		ArrayList<Xebean> dsbean = new ArrayList<Xebean>();
		//mo file
		FileReader f = new FileReader("input2.txt");
		BufferedReader b = new BufferedReader(f);
		//duyet file
		while(true) {
			String st = b.readLine();
			if(st == null || st == "") break;
			String[] t = st.split("[;]");
			String loaixe = t[0];
			String bsx = t[1];
			String sovexe = t[2];
			SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy");
			Date timera = d.parse(t[3]);
			String ttra = t[4];
			if(t[0].equals("0"))
			//(String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao, Date timeRa, String soVeXe)
				dsbean.add(new XeDapbean(null, null, null, null, null, null, timera, sovexe));
			else if(t[0].equals("2"))
				dsbean.add(new XeMaybean(null, null, null, null, null, null, timera, bsx));
			else
				dsbean.add(new Xe4Banhbean(null, null, null, null, null, null, timera, bsx, null, ttra));
		}
		b.close();
		return dsbean;
	}
	
}
