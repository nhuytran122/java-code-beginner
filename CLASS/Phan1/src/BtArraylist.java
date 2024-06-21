import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BtArraylist {
	public ArrayList<String> DsHoten = new ArrayList<String>();
	public ArrayList<Double> DsDtb = new ArrayList<Double>();
	
	public void TaoDanhSach() {
		try {
			FileReader f = new FileReader("sv.txt");
			BufferedReader b = new BufferedReader(f);
			while(true) {
				String st = b.readLine();
				if(st == "" || st == null) break; // Neu het file: hoac st = "" or st = null
				String[] ds = st.split("[;]"); //Tach cac thong tin tu st
				DsHoten.add(ds[1]);
				DsDtb.add(Double.parseDouble(ds[3]));
			}
			b.close();
				
		} catch (Exception e) {
			System.out.println("Loi o ham TaoDanhSach" + e.getMessage());
		}
	}
	
	public void XuatDanhSach() {
		int ss = DsHoten.size();
		for(int i=0; i<ss; i++) {
			System.out.println(DsHoten.get(i) + ": " + DsDtb.get(i));
		}
	}
	
	public void Search(String name) {
		int ch = 0;
		for(String sv : DsHoten) {
			String[] t = sv.split("[;]");
			if(t[0].toLowerCase().trim().contains(name.toLowerCase().trim())) {
				System.out.println(sv);
				ch++;
			}				
		}
		if(ch == 0) System.out.println("Khong tim thay!");
	}
	
	public void DauRot() {
		int dau = 0, rot = 0;
		for(double diem : DsDtb) {
			if(diem >= 5) dau++;
			else rot++;
		}
		System.out.println("\nCo " + dau + " SV dau & co " + rot + " SV rot");
	}
	
	public Double TBC() {
		int cnt = 0;
		double s = 0;
		for(double diem : DsDtb) {
			cnt++;
			s += diem;
		}
		return s/cnt;
	}

}
