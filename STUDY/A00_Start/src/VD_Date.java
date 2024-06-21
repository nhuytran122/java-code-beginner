import java.util.Date;
import java.text.SimpleDateFormat;

public class VD_Date {
	public static void main(String[] args) {
		try {
			SimpleDateFormat f = new SimpleDateFormat("HH:mm \ndd/MM/yyyy");
			Date d = new Date(); //Lấy ngày hiện tại
			System.out.println(f.format(d));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
