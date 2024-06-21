import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Xuly {
	public ArrayList<String> ds = new ArrayList<String>();
	
	public boolean KtSdt(String sdt) {
		String mau = "[0][\\d]{9,10}";
	    return Pattern.matches(mau, sdt);
	}
	
	public boolean KtEmail(String email) {
		String mau = "[\\w]+@[\\w]+\\.[\\w]+(\\.[\\w]+){0,}";
		return Pattern.matches(mau, email);
	}
	
	public boolean KtBirth(String ns) {
		//d: viet tat cua [0-9]
		//w: viet tat cua [0-9A-Za-z]
		try {
			SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy");
			dd.setLenient(false);
			dd.parse(ns);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean KtHsLuong(String hsluong) {
		try {
			Float checkHsluong = Float.parseFloat(hsluong);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean KtMa(String ma) {
		String mauMacb = "[A-Za-z][\\w]+";
		return Pattern.matches(mauMacb, ma);
	}
	
	public boolean KtTenDn(String tendn) {
		String mauTendn = "[A-Za-z][\\w]+";
		return Pattern.matches(mauTendn, tendn);
	}
	
	public void GhiFile(ArrayList<String> ds) {
		try {
			FileWriter w = new FileWriter("loi.txt");
			PrintWriter ghi = new PrintWriter(w);
			int i = 1;
			for(String tt : ds) {
				String[] t = tt.split("[;]");
				String macb = t[0], email = t[2], sdt = t[3], ns = t[4], hsluong = t[5], tendn = t[6];
				boolean ch = KtMa(macb) & KtEmail(email) & KtSdt(sdt) & KtBirth(ns) & KtHsLuong(hsluong) & KtTenDn(tendn);
				if(ch == false) {
					if(i == 1)
						ghi.print(i);
					else
						ghi.print("\n" + i);
				}
				if(!KtMa(macb))
					ghi.print("; sai MaCB");
				if(!KtEmail(email))
					ghi.print("; sai Email");
				if(!KtSdt(sdt))
					ghi.print("; sai SĐT");
				if(!KtBirth(ns))
					ghi.print("; sai ngày sinh");
				if(!KtHsLuong(hsluong))
					ghi.print("; sai hệ số lương");
				if(!KtTenDn(tendn))
					ghi.print("; sai tên đăng nhập");
				i++;
			}
			ghi.close();
			System.out.println("Đã ghi xong!");
		}
		 catch (Exception e) {
			System.err.println("Lỗi ghi file");
		}
	}
	
}
