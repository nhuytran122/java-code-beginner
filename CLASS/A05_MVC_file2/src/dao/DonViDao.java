package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import bean.DonViBean;

public class DonViDao {
	public ArrayList<DonViBean> getDV() throws Exception{
		//Tao 1 mang de luu all cac Don vi trong file donvi.txt
		ArrayList<DonViBean> dsbean = new ArrayList<DonViBean>();
		//mo file
		FileReader f = new FileReader("donvi.txt");
		BufferedReader b = new BufferedReader(f);
		//duyet file
		while(true) {
			String st = b.readLine();
			if(st == null || st == "") break;
			String[] t = st.split("[;]");
			String madv = t[0];
			String tendv = t[1];
			dsbean.add(new DonViBean(madv, tendv));
		}
		b.close();
		return dsbean;
	}
	
	public void Luu(ArrayList<DonViBean> ds) throws Exception{
		FileWriter f = new FileWriter("donvi.txt");
		PrintWriter ghi = new PrintWriter(f);
		for(DonViBean h:ds)
			ghi.println(h.getMadv() + ";" + h.getTendv());
		ghi.close();
	}
}
