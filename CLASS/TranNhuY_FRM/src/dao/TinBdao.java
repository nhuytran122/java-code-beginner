package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import bean.TinBbean;

public class TinBdao {
	public ArrayList<TinBbean> getTinB() throws Exception{
		ArrayList<TinBbean> dsB = new ArrayList<TinBbean>();
		Scanner sc = new Scanner(System.in);
		try {
			// Mo File de doc:
			FileReader f = new FileReader("ds.txt");
			BufferedReader b = new BufferedReader(f);
			// Duyet file:
			while (true) {
				// Doc ra 1 dong
				String st = b.readLine();
				if (st == null || st == "")
					break;
				String[] tt = st.split("[;]");
				if(tt.length == 5) {
					Double diemExcel = Double.parseDouble(tt[2]);
					Double diemPp = Double.parseDouble(tt[3]);
					Double diemWeb = Double.parseDouble(tt[4]);
					dsB.add(new TinBbean(tt[0], tt[1], diemExcel, diemPp, diemWeb));
				}
			}
			b.close();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsB;
	}
}
