import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class A5_Xuly {
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
}
