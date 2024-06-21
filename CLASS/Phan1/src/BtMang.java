import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

public class BtMang {
	// Hàm trả về 1 ngày ngẫu nhiên từ ngay1 đến ngay2:
	public String TaoNgay(String ngay1, String ngay2) {
		try {
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			Date n1 = f.parse(ngay1); //Đổi chuỗi ra ngày
			Date n2 = f.parse(ngay2);
			Random r = new Random(); // Kich hoat
			while(true) {
				Long t = r.nextLong(); // Dung Random
				// n1.getTime(): doi ngay ra so
				if(t >= n1.getTime() && t <= n2.getTime()) {
					Date n = new Date(t); // Doi so ra ngay
					return f.format(n); // Tra ve chuoi ngay thang nam
				}
			}	
			
		} catch (Exception e) {
			System.out.println("Loi: " + e.getMessage());
			return null;
		}
	}
	
	public String TaoHoTen(){
		String[] ho = {"Tran", "Le", "Nguyen"};
		String[] chulot = {"Thanh", "Hoang","Trung", "Van","My"};
		String[] ten = {"Hung", "Nga","Tien","Tam", "Ton", "Giang","Sy"};
		Random r = new Random();
		//ho.length: tra ve do dai của mang họ ->3
		String h = ho[r.nextInt(ho.length)];
		String cl = chulot[r.nextInt(chulot.length)];
		String t = ten[r.nextInt(ten.length)];
		return h + " " + cl + " " + t;
	}
	
	public String gioiTinh() {
		String[] gt = {"Nam", "Nu"};
		Random r = new Random();
		String gtinh = gt[r.nextInt(gt.length)];
		return gtinh;
	}
	
	
	public void HienThi(int n){
		Random r = new Random();
		for(int i=1; i<=n; i++){
			double dtb = r.nextDouble()*10;
			System.out.printf("%20s %20s %20f\n", TaoHoTen (),TaoNgay ("01/01/1960","01/01/2022"), dtb);
	//		System.out.println(TaoHoTen ()+"; " + TaoNgay ("01/01/1960","01/01/2000")+"; "+dtb);
		}
	}
	
	public void HienThiFull(int n) {
		Random r = new Random();
		for(int i=1; i<=n; i++){
			double dtb = r.nextDouble()*10;
			System.out.printf("%20s %20s %20f %20s %20s\n", TaoHoTen (),TaoNgay ("01/01/1960","01/01/2022"), dtb, Ketqua(dtb), XepLoai(dtb));
			//System.out.println(TaoHoTen() + "; " + TaoNgay("01/01/1960","01/01/2000") + "; " + dtb + "; " + Ketqua(dtb) + "; "+ XepLoai(dtb));
		}
	}
	
	public String Ketqua(double dtb) {
		if(dtb >= 5) {
			return "Dau";
		}
		else return "Rot";
	}
	
	public String XepLoai(double dtb) {
		if(dtb >= 8.0) {
			return "Gioi";
		}
		else if(dtb >= 6.5 && dtb <= 7.9) {
			return "Kha";
		}
		else if(dtb >=5 && dtb <= 6.4) {
			return "Trung binh";
		}
		else if(dtb >= 3.1 && dtb <= 4.9) {
			return "Yeu";
		}
		else return "Kem";
	}
		
}
