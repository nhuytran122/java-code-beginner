import java.util.Date;
import java.text.SimpleDateFormat;

public class VD_Kc_2Date {
	public static void main(String[] args) {
		String ngay1 = "16:43 29/01/2023";
		String ngay2 = "16:45 29/01/2023";
		try {
			SimpleDateFormat f = new SimpleDateFormat("HH:mm dd/MM/yyyy");
			Date d1 = f.parse(ngay1); //Đổi chuỗi ra ngày

			Date d2 = f.parse(ngay2);
			long hieu = d2.getTime() - d1.getTime();
			//getTime ra ms => can phai doi qua giay
			long soGiay = hieu / 1000;
			System.out.println("Ngay 1: " + f.format(d1) + "\nNgay 2: " + f.format(d2) + "\nCach nhau: " + soGiay + "s");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
