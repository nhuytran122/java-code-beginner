import java.util.Scanner;

public class File {

	public static void main(String[] args) {
		// BT2: BT VE FILE
		Scanner sc = new Scanner(System.in);
		BTFile f = new BTFile();
		System.out.println("\nBT VE FILE: ");
		System.out.println("Nhap n: " );
		int n3 = sc.nextInt();
		f.TaoDanhSach(n3);
		f.XuatDanhSach();
		
		// ~ cin.ignore()
		sc.nextLine();
		System.out.println("\nNhap ten muon tim kiem: ");
		String ten = sc.nextLine();
		f.Search(ten);
		f.DauRot();

		System.out.println("\nTrung binh cong cua DTB: " + f.TBC());
		f.KhongHopLe();
	}

}
