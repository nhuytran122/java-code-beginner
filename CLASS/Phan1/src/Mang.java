import java.util.Scanner;

public class Mang {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		BtMang m = new BtMang();
		System.out.println(m.TaoHoTen());
		String ngay1 = "01/02/1960";
		String ngay2 = "12/12/2022";
		System.out.println(m.TaoNgay(ngay1, ngay2));
//		System.out.println("Hiển thị ra 100 họ tên và ngày sinh một cách ngẫu nhiên:");
//		m.HienThi(100);
		System.out.println("Nhap n: ");
		int n = sc.nextInt();
		m.HienThi(n);
		
		System.out.println("\nThong tin cua 10 SV: ");
		m.HienThi(10);
		
		System.out.println("\nHien thi day du thong tin: ");
		System.out.println("Nhap n: ");
		int n2 = sc.nextInt();		
		System.out.println("\nThong tin cua " + n2 + " SV:");
		m.HienThiFull(n2);
		
	}


}
