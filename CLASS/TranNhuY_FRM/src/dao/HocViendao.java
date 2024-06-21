package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import bean.HocVienbean;
import bean.TinAbean;
import bean.TinBbean;

public class HocViendao {
	public ArrayList<HocVienbean> getSV() throws Exception{
		ArrayList<HocVienbean> ds = new ArrayList<HocVienbean>();
		ArrayList<TinAbean> dsA = new ArrayList<TinAbean>();
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
				if(tt.length == 4) {
					Double diemWin = Double.parseDouble(tt[2]);
					Double diemWord = Double.parseDouble(tt[3]);
					ds.add(new TinAbean(tt[0], tt[1], diemWin, diemWord));
				}
				else {
					Double diemExcel = Double.parseDouble(tt[2]);
					Double diemPp = Double.parseDouble(tt[3]);
					Double diemWeb = Double.parseDouble(tt[4]);
					ds.add(new TinBbean(tt[0], tt[1], diemExcel, diemPp, diemWeb));
				}
			}
			b.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public void Luu(ArrayList<HocVienbean> ds){
		try{
			FileWriter w1 = new FileWriter("f1.txt");
			PrintWriter ghi1 = new PrintWriter(w1);
			FileWriter w2 = new FileWriter("f2.txt");
			PrintWriter ghi2 = new PrintWriter(w2);
			for(HocVienbean sv:ds) {
				if(sv instanceof TinAbean) {
					TinAbean tA = (TinAbean) sv;
					ghi1.println(sv.getMsv() + ";" + sv.getHoten() + ";" + tA.getDiemWin() + ";" + tA.getDiemWord() + ";" + tA.DTB());
				}
				else {
					TinBbean tB = (TinBbean) sv;
					ghi2.println(sv.getMsv() + ";" + sv.getHoten() + ";" + tB.getDiemExcel() + ";" + tB.getDiemPp() + ";" + tB.getDiemWeb() + ";" + tB.DTB());
				}
			}
			ghi1.close();
			ghi2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
