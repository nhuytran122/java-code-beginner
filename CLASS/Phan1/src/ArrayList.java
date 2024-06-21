import java.util.Scanner;

public class ArrayList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BtArraylist a = new BtArraylist();
		a.TaoDanhSach();
		a.XuatDanhSach();
		
		System.out.println("\nNhap 1 tu khoa can tim: ");
		String name = sc.nextLine();
		a.Search(name);
		a.DauRot();
		
		System.out.println("\nTrung binh cong cua DTB: " + a.TBC());
	}

}
