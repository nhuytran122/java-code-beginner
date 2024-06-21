/**Xây dựng chương trình Java hỗ trợ quản lý thông tin Sinh viên.
 *  Sinh viên bao gồm mã số sinh viên, họ và tên, ngày tháng năm
 *   sinh, điểm trung bình, lớp. Ngày sinh bao gồm ngày, tháng, 
 *   năm. Lớp bao gồm tên lớp và tên khoa.

Xây dựng lớp và hiện thực các phương thức sau:

Cho biết tên khoa mà sinh viên đang theo học.
Cho biết học sinh có đậu hay không (điểm trung bình >=5.0)
Kiểm tra sinh viên có ngày sinh giống với ngày sinh của một 
sinh viên khác hay không.**/
public class QuanLy {
	public static void main(String[] args) {
		Ngay ngay1 = new Ngay(19, 7, 2002);
		Ngay ngay2 = new Ngay(17, 2, 2001);
		Ngay ngay3 = new Ngay(19, 7, 2002);
		
		
		Lop lop1 = new Lop("DH01", "Khoa Công nghệ Thông tin");
		Lop lop2 = new Lop("DH02", "Khoa Khoa học Máy tính");
		Lop lop3 = new Lop("DH03", "Khoa An ninh mạng");
		
		SinhVien sv1 = new SinhVien("0001", "Tùng ITV", ngay1, 9.0, lop1);
		SinhVien sv2 = new SinhVien("0002", "Peter Le", ngay2, 4.0, lop2);
		SinhVien sv3 = new SinhVien("0003", "Lê Tùng", ngay3, 6.0, lop3);
		
		System.out.println("Tên khoa: ");
		System.out.println("SV1: "+ sv1.layTenKhoa());
		System.out.println("SV2: "+ sv2.layTenKhoa());
		System.out.println("SV3: "+ sv3.layTenKhoa());
		System.out.println("Kiểm tra thi đạt: ");
		System.out.println("SV1: "+ sv1.kiemTraThiDat());
		System.out.println("SV2: "+ sv2.kiemTraThiDat());
		System.out.println("SV3: "+ sv3.kiemTraThiDat());
		System.out.println("Kiểm tra cùng ngày sinh:");
		System.out.println("sv1 và sv2: "+ sv1.kiemTraCungNgaySinh(sv2));
		System.out.println("sv1 và sv3: "+ sv1.kiemTraCungNgaySinh(sv3));
		
	}
}
