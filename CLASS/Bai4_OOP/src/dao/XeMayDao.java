package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.XeMaybean;

public class XeMayDao {
	public ArrayList<XeMaybean> getXeMayVao() throws Exception{
		ArrayList<XeMaybean> dsbean = new ArrayList<XeMaybean>();
		//mo file
		FileReader f = new FileReader("input1.txt");
		BufferedReader b = new BufferedReader(f);
		//duyet file
		while(true) {
			String st = b.readLine();
			if(st == null || st == "") break;
			String[] t = st.split("[;]");
//			String loaixe = t[0];
			String bsx = t[1];
//			String sovexe = t[2];
			SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy");
			Date timevao = d.parse(t[3]);
//			String ttvao = t[4];
			if(t[0].equals("2"))
	//String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao, Date timeRa, String bSX
				dsbean.add(new XeMaybean(null, null, null, null, null, timevao, null, bsx));
		}
		b.close();
		return dsbean;
	}
	
	public ArrayList<XeMaybean> getXeMayRa() throws Exception{
		ArrayList<XeMaybean> dsbean = new ArrayList<XeMaybean>();
		//mo file
		FileReader f = new FileReader("input2.txt");
		BufferedReader b = new BufferedReader(f);
		//duyet file
		while(true) {
			String st = b.readLine();
			if(st == null || st == "") break;
			String[] t = st.split("[;]");
//			String loaixe = t[0];
			String bsx = t[1];
//			String sovexe = t[2];
			SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy");
			Date timera = d.parse(t[3]);
//			String ttra = t[4];
			if(t[0].equals("2"))
	//String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao, Date timeRa, String bSX
				dsbean.add(new XeMaybean(null, null, null, null, null, null, timera, bsx));
			}
		b.close();
		return dsbean;
	}

}
