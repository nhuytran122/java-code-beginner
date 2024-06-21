import java.io.FileReader;
import java.io.BufferedReader;
public class A1_vdFile1 {

	public static void main(String[] args) {
		try {
			// Mo File de doc:
			FileReader f = new FileReader("data.txt");
			BufferedReader b = new BufferedReader(f);
			//Duyet file:
			//System.out.printf("%-16s%-12s%-12s%-12s%-12s\n", "Ho va ten", "Ten khoa", "Diem mon 1", "Diem mon 2", "DTB");
			while(true) {
				// Doc ra 1 dong
				String st = b.readLine();
				if(st == null || st == "") break;
				//System.out.println("\n" + st);
				
				//In ra ho ten, ten khoa, dm1, dm2 va dtb
				String[] tt2 = st.split("[|]");
				
//				System.out.println("Ho va ten: " + tt2[0]);
//				System.out.println("Ten khoa: " + tt2[2]);
				double dm1 = Double.parseDouble(tt2[4]);
				double dm2 = Double.parseDouble(tt2[5]);
				double dtb = (dm1 + dm2)/2;
//				System.out.println("Diem mon 1: " + dm1);
//				System.out.println("Diem mon 2: " + dm2);
//				System.out.println("DTB: " + dtb);
				System.out.printf("%16s %16s %16.2f %16.2f %16.2f\n", tt2[0], tt2[2], dm1, dm2, dtb);
			}
			
			//Dong file
			b.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
