import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		ArrayList<HocVien> ds = new ArrayList<HocVien>();
		ArrayList<TinA> dsA = new ArrayList<TinA>();
		ArrayList<TinB> dsB = new ArrayList<TinB>();
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
					Double diemWin = Double.parseDouble(tt[2]);
					Double diemWord = Double.parseDouble(tt[3]);
					ds.add(new TinA(tt[0], tt[1], diemWin, diemWord));
				}
				else {
					Double diemExcel = Double.parseDouble(tt[2]);
					Double diemPp = Double.parseDouble(tt[3]);
					Double diemWeb = Double.parseDouble(tt[4]);
					ds.add(new TinB(tt[0], tt[1], diemExcel, diemPp, diemWeb));
				}
			}
			b.close();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Cau 3:");
		for(HocVien hv: ds)
			System.out.println(hv);
		
		
		System.out.println("\nCau 4: \nNhap ho ten SV muon tim:");
		String key = sc.nextLine();
		int check = 0;
		for(HocVien sv : ds) {
			if(sv.getHoten().toLowerCase().trim().contains(key.toLowerCase().trim())) {
				System.out.println(sv);
				check = 1;
			}		
		}
		if(check == 0)
			System.out.println("Không tìm thấy!");
		
		System.out.println("\nCau 5:");
		try{
			FileWriter w1 = new FileWriter("f1.txt");
			PrintWriter ghi1 = new PrintWriter(w1);
			FileWriter w2 = new FileWriter("f2.txt");
			PrintWriter ghi2 = new PrintWriter(w2);
			for(HocVien sv:ds) {
				if(sv instanceof TinA) {
					TinA tA = (TinA) sv;
					ghi1.println(sv.getMsv() + ";" + sv.getHoten() + ";" + tA.getDiemWin() + ";" + tA.getDiemWord() + ";" + tA.DTB());
					dsA.add(tA);
				}
				else {
					TinB tB = (TinB) sv;
					ghi2.println(sv.getMsv() + ";" + sv.getHoten() + ";" + tB.getDiemExcel() + ";" + tB.getDiemPp() + ";" + tB.getDiemWeb() + ";" + tB.DTB());
					dsB.add(tB);
				}
			}
			ghi1.close();
			ghi2.close();
			System.out.println("Hoan thanh");
		} catch (Exception e) {
			System.err.println("Lỗi ghi file cau 5");
		}
		
		
	}
	

}
