import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class TestCau3 {
	public ArrayList<DienThoai> Napds() {
		try {
			ArrayList<DienThoai> ds = new ArrayList<DienThoai>();
			FileReader f = new FileReader("ketqua.txt");
			BufferedReader b = new BufferedReader(f);
			while(true) {
				String st = b.readLine();
				if(st == null || st == "") break;
				String[] tt = st.split("[;]");
				if(tt[0].startsWith("CD")) {
					ds.add(new DienThoaiCoDinh(tt[0], tt[1], tt[2], Long.parseLong(tt[3])));
				}
				else ds.add(new DienThoaiDD(tt[0], tt[1], tt[2], Long.parseLong(tt[3]), tt[4]));
			}
			b.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		TestCau3 tmp = new TestCau3();
		ArrayList<DienThoai> ds = tmp.Napds();
		System.out.println("Câu 3: \n\tĐiện thoại cố định:");
		for(DienThoai dt : ds)
			if(dt instanceof DienThoaiCoDinh) 
				System.out.println(dt);
		System.out.println("\n\tĐiện thoại di động:");
		for(DienThoai dt : ds)
			if(dt instanceof DienThoaiDD) 
				System.out.println(dt);
	}

}
