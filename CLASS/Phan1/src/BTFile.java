import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.Date;

public class BTFile {
	public void TaoDanhSach(int n) {
		try {
			// Tao File sv.txt luu o thu muc Phan1
//			FileOutputStream f = new FileOutputStream("sv.txt");
//			OutputStreamWriter o = new OutputStreamWriter(f);
//			PrintWriter w = new PrintWriter(o);
			
			FileWriter w = new FileWriter("sv.txt");
			//FileWriter w = new FileWriter("sv.txt", true); : ghi bo sung
			PrintWriter ghi = new PrintWriter(w);
			
			Random r = new Random();
			//tao lop BtMang de su dung cac ham ben trong lop nay
			BtMang m = new BtMang();
			for(int i = 1; i <= n; i++) {
				double dtb = r.nextDouble()*10;
				//Ghi vao file msv, ho ten, ngay sinh, dtb
				ghi.println("SV" + i + "; " + m.TaoHoTen() + "; " + m.TaoNgay("01/01/1960", "01/01/2022") + "; " + dtb);
				
				//ghi.write("SV" + i + "; " + m.TaoHoTen() + "; " + m.TaoNgay("01/01/1960", "01/01/2022") + "; " + dtb + "\n");
			}
			//w.close();
			ghi.close();
			System.out.println("Da tao xong");
		} catch (Exception e) {
			System.out.println("Loi o ham TaoDanhSach" + e.getMessage());
		}
	}
	
	public void XuatDanhSach() {
		try {
			// Mo file sv.txt luu o thu muc Phan1
			FileReader f = new FileReader("sv.txt");
			BufferedReader b = new BufferedReader(f);
			while(true) {
				String st = b.readLine();
				if(st == "" || st == null) break; // Neu het file: hoac st = "" or st = null
				String[] ds = st.split("[;]"); //Tach cac thong tin tu st
				System.out.println(ds[0] + "\n" + ds[1] + "\n" + ds[2] + "\n" + ds[3] + "\n\n");
			}
			b.close();
		} catch (Exception e) {
			System.out.println("Loi o ham XuatDanhSach" + e.getMessage());
		}
	}
	
	public void Search(String name) {
		try {
			int ch = 0;
			FileReader f = new FileReader("sv.txt");
			BufferedReader b = new BufferedReader(f);
			while(true) {
				String tmp = b.readLine();
				if(tmp == null || tmp == "") break;
				String[] ds = tmp.split("[;]");
				if(ds[1].toLowerCase().trim().contains(name.toLowerCase().trim())) {
					ch++;
					System.out.println(tmp);
				}
			}
			b.close();
			if(ch == 0)
				System.out.println("Khong co SV nao ten co chu " + name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void DauRot() {
		try {
			FileReader f = new FileReader("sv.txt");
			BufferedReader b = new BufferedReader(f);
			int dau = 0, rot = 0;
			while(true) {
				String tmp = b.readLine();
				if(tmp == null || tmp == "") break;
				String[] ds = tmp.split("[;]");
				double dtb = Double.parseDouble(ds[3]);
				if(dtb >= 5) dau++;
				else rot++;
			}
			b.close();
			System.out.println("Co " + dau + " SV dau & co " + rot + " SV rot");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public double TBC() {
		int cnt = 0;
		double s = 0;
		try {
			FileReader f = new FileReader("sv.txt");
			BufferedReader b = new BufferedReader(f);
			while(true) {
				String tmp = b.readLine();
				cnt++;
				if(tmp == null || tmp == "") break;
				String[] ds = tmp.split("[;]");
				double dtb = Double.parseDouble(ds[3]);
				s += dtb;
			}
			b.close();
		} catch (Exception e) {
				e.printStackTrace();
		}
		return s/cnt;
	}
	
	public void KhongHopLe(){
		try{
			FileReader f = new FileReader("sv.txt");
			BufferedReader b = new BufferedReader(f);
			System.out.println("\nCac dong khong hop le: ");
			int ch = 0;
			while (true){
				String tmp = b.readLine();
				if(tmp == "" || tmp == null) break;
				String[] ds= tmp.split("[;]");
				Double dtb = Double.parseDouble(ds[3]);
				String ns = ds[2];
				/*SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
			    Date d1 = d.parse(ds[2]);
		    
				if (dtb < 0 || dtb > 10 || ds[2].compareTo(d.format(d1))!=0 || ds[2].length() != 10){
					System.out.println(ds[0] + " | " + ds[1] + " | " + ds[2] + " | " + ds[3]);
					ch++;
				}*/
				
				Pattern patternBirth = Pattern.compile("^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/[0-9]{4}$");
				if(ns.length() == 10 && patternBirth.matcher(ns).find() && dtb >=0 && dtb <=10) { 
					System.out.println(ds[0] + " | " + ds[1] + " | " + ds[2] + " | " + ds[3]);
					ch++;
				}
				
			}
			if (ch == 0)
				System.out.println("Khong co dong khong hop le");
			b.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
		
}
