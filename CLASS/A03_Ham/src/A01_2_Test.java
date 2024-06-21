import java.util.Date;

public class A01_2_Test {

	public static void main(String[] args) {
		try {
			A01_Tinh t = new A01_Tinh();
			System.out.println(t.DTB(6, 7, 9));
			System.out.println(t.DTB(8, 9, 7, 10, 6));
			t.Xuat(6*8, "haha", new Date(), t.DTB(9, 6, 10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
