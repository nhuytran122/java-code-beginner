package Cau2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class cau2 {
	public void InDsTuFile() {
		try {
			FileReader f = new FileReader("ds.txt");
			BufferedReader b = new BufferedReader(f);
			while (true) {
				String st = b.readLine();
				if (st == null || st == "")
					break;
				System.out.println(st);
			}
			b.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean KtMa(String ma) {
		String mau = "CD[\\d]{3}";
		String mau2 = "DD[\\d]{3}";
	    return Pattern.matches(mau, ma) || Pattern.matches(mau2, ma);
	}
	public void KtHople() {
		try {
			FileReader f = new FileReader("ds.txt");
			BufferedReader b = new BufferedReader(f);
			
			FileWriter w = new FileWriter("ketqua.txt");
			PrintWriter ghi = new PrintWriter(w);
			while (true) {
				String st = b.readLine();
				if (st == null || st == "")
					break;
				String[] tt2 = st.split("[;]");
				if (tt2[0].startsWith("CD")) {
					if (tt2.length == 4 && KtMa(tt2[0])) {
						System.out.println(st);
						ghi.println(st);
					}
				}
				else if (tt2[0].startsWith("DD")) {
					if (tt2.length == 5 && KtMa(tt2[0])) {
						System.out.println(st);
						ghi.println(st);
					}
				}
			}
			ghi.close();
			b.close();
			System.out.println("Đã ghi xong các dòng hợp lệ từ file ds.txt vào file ketqua.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		cau2 tmp = new cau2();
		System.out.println("\tCác dòng được đọc từ file ds.txt");
		tmp.InDsTuFile();
		System.out.println("\n\tCác dòng hợp lệ trong file ds.txt");
		tmp.KtHople();
	}
}
