import java.util.Scanner;

public class A1_Nhap_Xuat {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap ho ten: ");
		String ten = sc.nextLine();
		System.out.println("Nhap ma sinh vien:");
		long msv = sc.nextLong();
		
		System.out.println("Nhap diem thi: ");
		float diemThi = sc.nextFloat();
		
		System.out.println("Ho ten: " + ten);
		System.out.println("MSV: " + msv);
		System.out.println("Diem thi: " + diemThi);
		
		// Ep kieu ngam dinh
		int b = 6;
		float c = b;
		System.out.println("Ep kieu: c = " + c);
		
		//Ep kieu tuong minh
		float d = 6.8f;
		int e = (int)d;
		System.out.println("Ep kieu d = " + e);
		
		//Ep kieu giua bien nguyen thuy va doi tuong
		int x = new Integer(32);
		System.out.println("x = " + x);
	}
}

/*nextBoolean(): đọc giá trị Boolean từ bàn phím
 * nextByte(): byte
 * nextDouble()
 * nextFloat()
 * nextInt()
 * nextLine(): đọc String
 * nextLong()
 * nextShort()
 * */
