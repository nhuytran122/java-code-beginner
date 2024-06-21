package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import bean.TinAbean;

public class TinAdao {
	public ArrayList<TinAbean> getTinA() throws Exception{
		ArrayList<TinAbean> dsA = new ArrayList<TinAbean>();
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
				if(tt.length == 4) {
					Double diemWin = Double.parseDouble(tt[2]);
					Double diemWord = Double.parseDouble(tt[3]);
					dsA.add(new TinAbean(tt[0], tt[1], diemWin, diemWord));
				}
			}
			b.close();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsA;
	}
}
