import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
public class A3_vd_ArrayList_File {

	public static void main(String[] args) {
		ArrayList<String> ds = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		try {
			// Mo File de doc:
			FileReader f = new FileReader("data.txt");
			BufferedReader b = new BufferedReader(f);
			//Duyet file:
			while(true) {
				// Doc ra 1 dong
				String st = b.readLine();
				if(st == null || st == "") break;
//				
//				//In ra ho ten, ten khoa, dm1, dm2 va dtb
//				String[] tt2 = st.split("[|]");
//				
//				System.out.println("Ho va ten: " + tt2[0]);
//				System.out.println("Ten khoa: " + tt2[2]);
//				double dm1 = Double.parseDouble(tt2[4]);
//				double dm2 = Double.parseDouble(tt2[5]);
//				double dtb = (dm1 + dm2)/2;
//				System.out.println("Diem mon 1: " + dm1);
//				System.out.println("Diem mon 2: " + dm2);
//				System.out.println("DTB: " + dtb);
//				System.out.printf("%16s %16s %16.2f %16.2f %16.2f\n", tt2[0], tt2[2], dm1, dm2, dtb);
				
				ds.add(st);
			}
			
			//Dong file
			b.close();
			
			for(String tt : ds) {
				System.out.println(tt);
			}
			
			// Nhập vào 1 họ hoặc tên hoặc chữ lót -> 
			// In ra các thông tin của SV đó
			System.out.println("\nNhap 1 key: ");
			String key = sc.nextLine();
			for(String sv : ds) {
				String[] t = sv.split("[|]");
				// trim(): bỏ khoảng trắng dư thừa đầu và cuối chuỗi
				// toLowerCase(): in thường chuỗi
				if(t[0].toLowerCase().trim().contains(key.toLowerCase().trim()))
					System.out.println(sv);
			}
			
			// Nhập vào 1 tên khoa, hiển thị thông tin các SV của Khoa đó
			System.out.println("\nNhap 1 ten khoa: ");
			String khoa = sc.nextLine();
			for(String sv : ds) {
				String[] t = sv.split("[|]");
				if(t[2].toLowerCase().trim().equals(khoa.toLowerCase().trim()))
					System.out.println(sv);
			}
			
			//BTVN
			// Nhập vào 1 họ tên -> In ra DTB của SV này
			System.out.println("\nNhap 1 ho ten: ");
			String ten = sc.nextLine();
			int tmp = 0;
			double s = 0;
			for(String sv : ds) {
				String[] t = sv.split("[|]");
				double dm1 = Double.parseDouble(t[4]);
				double dm2 = Double.parseDouble(t[5]);
				double dtb = (dm1 + dm2)/2;
				
				tmp++;
				s += dtb;
				
				if(t[0].toLowerCase().trim().equals(ten.toLowerCase().trim()))
					System.out.println("DTB cua " + ten + ": " + dtb);
			}
			
			//In ra TBC của DTB (cua all SV)
			System.out.println("\nTBC của DTB (cua tat ca SV): " + s/tmp);
			
			// Xóa các SV có DTB < 5 ra khỏi mảng
			for(int i=0; i < ds.size(); i++) {
				String[] t = ds.get(i).split("[|]");
				double dm1 = Double.parseDouble(t[4]);
				double dm2 = Double.parseDouble(t[5]);
				double dtb = (dm1 + dm2)/2;
				if(dtb < 5) 
					ds.remove(i);
			}
			
			System.out.println("\nArrayList sau khi xoa: ");
			for(String tt : ds) {
				System.out.println(tt);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
// BTVN: Nhập vào 1 họ tên -> In ra DTB của SV này
// In ra TBC của DTB
// Xóa các SV có DTB < 5 ra khỏi mảng