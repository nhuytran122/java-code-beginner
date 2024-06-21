/**Xây dựng một chương trình Java hỗ trợ quản lý thông tin máy tính của một 
 * cửa hàng điện máy. Máy tính có những thông tin như: Hãng sản xuất, ngày 
 * sản xuất, giá bán, thời gian bảo hành tính theo tháng. 
 * Ngày sản xuất bao gồm thông tin ngày, tháng , năm mà máy tính được lắp ráp. 
 * Hãng sản xuất bao gồm thông tin tên hãng và quốc gia. 
 * Quốc gia bao gồm các thông tin mã quốc gia và tên của quốc gia.

Xây dựng lớp và hiện thực các phương thức sau:
Viết phương thức kiểm tra xem một máy tính có giá bán thấp hơn một máy 
tính khác hay không.
Viết phương thức cho biết tên quốc gia sản xuất máy tính. (GETTER LỒNG)
 * **/
public class QuanLy {
	public static void main(String[] args) {
		Ngay ngay1 = new Ngay(15, 8, 2025);
		Ngay ngay2 = new Ngay(1, 3, 2025);
		Ngay ngay3 = new Ngay(6, 9, 2025);
		
		QuocGia quocGia1 = new QuocGia("VN", "Việt Nam");
		QuocGia quocGia2 = new QuocGia("USA", "Hoa Kỳ");
		QuocGia quocGia3 = new QuocGia("TW", "Đài Loan");
		
		HangSanXuat hangSanXuat1 = new HangSanXuat("VNLaptop", quocGia1);
		HangSanXuat hangSanXuat2 = new HangSanXuat("Macbook", quocGia2);
		HangSanXuat hangSanXuat3 = new HangSanXuat("Asus", quocGia3);
		
		MayTinh mayTinh1 = new MayTinh(hangSanXuat1, ngay1, 1500, 12);
		MayTinh mayTinh2 = new MayTinh(hangSanXuat2, ngay2, 2000, 24);
		MayTinh mayTinh3 = new MayTinh(hangSanXuat3, ngay3, 1000, 12);
		
		System.out.println("So sanh gia thấp hơn: ");
		System.out.println("M1 < M2: "+ mayTinh1.kiemTraGiaThapHon(mayTinh2));
		System.out.println("M1 < M3: "+ mayTinh1.kiemTraGiaThapHon(mayTinh3));
		
		
		System.out.println("Tên quốc gia: ");
		System.out.println("M1: "+ mayTinh1.layTenQuocGia());
		System.out.println("M2: "+ mayTinh2.layTenQuocGia());
		System.out.println("M3: "+ mayTinh3.layTenQuocGia());
	}
}
