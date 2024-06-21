import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		ArrayList<hocvien> ds = new ArrayList<hocvien>();
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
				//SV1;Lê Văn A;7;9;8
				if(tt.length == 4) {
					Double Win = Double.parseDouble(tt[2]);
					Double Word = Double.parseDouble(tt[3]);
					tinA ta = new tinA(tt[0], tt[1], Win, Word);
					ds.add(ta);
				}
				else {
					Double Excel = Double.parseDouble(tt[2]);
					Double Pp = Double.parseDouble(tt[3]);
					Double Web = Double.parseDouble(tt[4]);
					tinB tb = new tinB(tt[0], tt[1], Excel, Pp, Web);
					ds.add(tb);
				}
			}
			b.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("3:");
		System.out.println("Toàn bộ SV: ");
		for(hocvien hv: ds)
			System.out.println(hv);
		
		System.out.println("\nSV Tin A:");
		for(hocvien sv:ds)
			if(sv instanceof tinA) 
				System.out.println(sv);
		System.out.println("\nSV Tin B:");
		for(hocvien sv:ds)
			if(sv instanceof tinB) 
				System.out.println(sv);
			
		
		System.out.println("\n4: \nNhap SV muon tim:");
		String key = sc.nextLine();
		int ch = 0;
		for(hocvien sv : ds) {
			if(sv.getHoten().toLowerCase().trim().contains(key.toLowerCase().trim())) {
				System.out.println(sv);
				ch = 1;
			}		
		}
		if(ch == 0)
			System.out.println("Không có SV tên " + key);
		
		System.out.println("\nCau 5:");
		try{
			FileWriter w1 = new FileWriter("f1.txt");
			PrintWriter ghi1 = new PrintWriter(w1);
			FileWriter w2 = new FileWriter("f2.txt");
			PrintWriter ghi2 = new PrintWriter(w2);
			for(hocvien sv:ds) {
				if(sv instanceof tinA) {
					tinA tA = (tinA) sv;
					ghi1.println(sv.getMsv() + ";" + sv.getHoten() + ";" + tA.getDiemWin() + ";" + tA.getDiemWord() + ";" + tA.DTB());
//					dsA.add(tA);
				}
				else {
					tinB tB = (tinB) sv;
					ghi2.println(sv.getMsv() + ";" + sv.getHoten() + ";" + tB.getDiemExcel() + ";" + tB.getDiemPp() + ";" + tB.getDiemWeb() + ";" + tB.DTB());
//					dsB.add(tB);
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
