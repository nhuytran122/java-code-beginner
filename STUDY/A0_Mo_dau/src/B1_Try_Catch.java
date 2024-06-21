import java.util.Scanner;

public class B1_Try_Catch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=0;
		try {
			System.out.println("Nhap vao so nguyen n: ");
			n = sc.nextInt();
			// cau lenh trong catch: neu khoi lenh trong try bi sai thi se dc thanh lap
		} catch (Exception e) {
			System.out.println("Nhập dữ liệu không đúng");
			// neu khoi lenh trong try bat ke dung sai thi khoi lenh trong finally deu duoc thuc hien
		} finally {
			System.out.println("Finally!");
		}
		System.out.println("Gia tri nhap la: "+n);
		System.out.println("Ket thuc chuong trinh");
	}
}
