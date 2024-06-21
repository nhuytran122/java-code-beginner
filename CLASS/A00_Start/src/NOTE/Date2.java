package NOTE;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Date2 {
	public static void main(String[] args) {
		try {
			String ns = "12/2/2003";
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			//Doi String --> Date
			Date ngay = f.parse(ns);
			System.out.println("Date: " + ngay);
			
			//Chuyển date -> String
			String t = f.format(ngay); 
			System.out.println("String: " + t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
