import java.util.Scanner;

public class A1_vdString1 {

	public static void main(String[] args) {
		System.out.println("Nhap 1 ho ten: ");
		Scanner sc = new Scanner(System.in);
		String ht = sc.nextLine();
		int vt1 = ht.indexOf(" ");
		int vt2 = ht.lastIndexOf(" ");
//		System.out.println("Vt1: " + vt1);
//		System.out.println("Vt2: " + vt2);
		if(vt1 != -1) {
			System.out.println("Ho: " + ht.substring(0, vt1));
			System.out.println("Ten: " + ht.substring(vt2+1));
			if(vt1 < vt2) {
				System.out.println("Chu lot: " + ht.substring(vt1+1, vt2));
			}
		}
		else System.out.println("Ten: " + ht);
		sc.close();
	}

}
