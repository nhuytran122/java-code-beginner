/**Xây dựng chương trình Java quản lý các bộ phim tại một Rạp 
 * chiếu phim. Một bộ phim bao gồm các thông tin: tên phim, năm 
 * sản xuất, hãng sản xuất, giá vé, ngày chiếu. Hãng sản xuất 
 * bao gồm tên hãng sản xuất, quốc gia. Ngày chiếu bao gồm thông 
 * tin ngày, tháng, năm.
Xây dựng lớp và hiện thực các phương thức sau:
a. Kiểm tra xem giá vé của một phim bất kỳ có rẽ hơn giá vé 
của một phim khác hay không?
b. Cho biết tên của hãng sản xuất phim.
c. Cho biết giá vé của phim khi có khuyến mãi (ví dụ như sau 
khi khuyến mãi 10%, 20%, ….), số tiền khuyến mãi đuợc giảm trừ theo % giá bán.**/

public class Quanly {
	public static void main(String[] args) {
		Ngay ngay1 = new Ngay(15, 05, 2022);
		Ngay ngay2 = new Ngay(31, 01, 2025);
		Ngay ngay3 = new Ngay(16, 02, 2030);
		
		HangSanXuat hangSanXuat1 = new HangSanXuat("Hãng A", "Việt Nam");
		HangSanXuat hangSanXuat2 = new HangSanXuat("Hãng B", "Mỹ");
		HangSanXuat hangSanXuat3 = new HangSanXuat("Hãng C", "Ba Lan");
		
		BoPhim boPhim1 = new BoPhim("Bố Già", 2020, hangSanXuat1, 65000, ngay1);
		BoPhim boPhim2 = new BoPhim("Running Man", 2021, hangSanXuat2, 100000, ngay2);
		BoPhim boPhim3 = new BoPhim("Khám phá Ba Lan", 2025, hangSanXuat3, 115000, ngay3);
	
		System.out.println("SS gia 1 re hon 2: "+ boPhim1.kiemTraGiaVeReHon(boPhim2));
		System.out.println("SS gia 3 re hon 2: "+ boPhim3.kiemTraGiaVeReHon(boPhim2));
	
		System.out.println("Tên hãng sản xuất BP 3: "+boPhim3.layTenHangSanXuat());
	
		System.out.println("BP1 giam 10%: "+ boPhim1.giaSauKhuyenMai(10));
		System.out.println("BP2 giam 20%: "+ boPhim2.giaSauKhuyenMai(20));
		System.out.println("BP3 giam 50%: "+ boPhim3.giaSauKhuyenMai(50));
	}
}
