package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.XeDapbean;

public class XeDapDao {
	public ArrayList<XeDapbean> getXeDapVao() throws Exception{
		//Tao 1 mang de luu all cac Don vi trong file donvi.txt
		ArrayList<XeDapbean> dsbean = new ArrayList<XeDapbean>();
		//mo file
		FileReader f = new FileReader("input1.txt");
		BufferedReader b = new BufferedReader(f);
		//duyet file
		while(true) {
			String st = b.readLine();
			if(st == null || st == "") break;
			String[] t = st.split("[;]");
//			String loaixe = t[0];
//			String bsx = t[1];
			String sovexe = t[2];
			SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy");
			Date timevao = d.parse(t[3]);
//			String ttvao = t[4];
			if(t[0].equals("0"))
	//(String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao, Date timeRa, String soVeXe)
				dsbean.add(new XeDapbean(null, null, null, null, null, timevao, null, sovexe));
		}
		b.close();
		return dsbean;
	}
	
	public ArrayList<XeDapbean> getXeDapRa() throws Exception{
		ArrayList<XeDapbean> dsbean = new ArrayList<XeDapbean>();
		//mo file
		FileReader f = new FileReader("input2.txt");
		BufferedReader b = new BufferedReader(f);
		//duyet file
		while(true) {
			String st = b.readLine();
			if(st == null || st == "") break;
			String[] t = st.split("[;]");
//			String loaixe = t[0];
//			String bsx = t[1];
			String sovexe = t[2];
			SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy");
			Date timera = d.parse(t[3]);
//			String ttra = t[4];
			if(t[0].equals("0"))
		//(String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao, Date timeRa, String soVeXe)
				dsbean.add(new XeDapbean(null, null, null, null, null, null, timera, sovexe));
		}
		b.close();
		return dsbean;
	}
//	public void Luu(ArrayList<XeDapbean> ds) throws Exception{
//		FileWriter f = new FileWriter("donvi.txt");
//		PrintWriter ghi = new PrintWriter(f);
//		for(XeDapbean h:ds)
//			ghi.println(h.getMadv() + ";" + h.getTendv());
//		ghi.close();
//	}
}
