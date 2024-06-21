package LTGiaoDien;
import java.util.ArrayList;

public class B02_Test_Hang {

	public static void main(String[] args) {
		ArrayList<B01_Hang> ds = new ArrayList<B01_Hang>();
		
		B01_Hang h1 = new B01_Hang();
		h1.setTenhang("Xang");
		h1.setGia(1000);
		ds.add(h1);
		
		System.out.println(h1.toString());
		B01_Hang h2 = new B01_Hang("Dau", 100);
		ds.add(h2);
		System.out.println("In hang tu mang: ");
		for(B01_Hang h:ds)
			System.out.println(h.toString());
	}

}
