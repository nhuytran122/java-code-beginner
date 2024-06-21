import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BT_test {

	public static void main(String[] args) {
		Xuly a = new Xuly();
		ArrayList<String> ds = new ArrayList<String>();
		try {
			FileReader f = new FileReader("cb.txt");
			BufferedReader b = new BufferedReader(f);
				while(true) {
					String st = b.readLine();
					if(st == "" || st == null) break;
					ds.add(st);
				}
				b.close();
			} catch (Exception e) {
				System.err.println("Lỗi đọc File");
			}
		
//		for(String tt : ds)
//			System.out.println(tt);
		
		a.GhiFile(ds);
		
	}

}
