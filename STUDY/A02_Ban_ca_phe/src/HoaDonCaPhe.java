public class HoaDonCaPhe {
	private String tenLoaiCaPhe;
	private double giaTien1Kg;
	private double khoiLuong;

	/**
	 * Kiểm tra khối lượng cà phê của túi đã bán có lớn hơn một con số được đưa vào phương thức hay không?
		Kiểm tra tổng tiền của hóa đơn có lớn hơn 500000đ hay không.
		Tính số tiền giảm giá, giảm x% cho các hóa đơn có giá trị lớn hơn 500000đ.
		Tính số tiền khách phải trả sau khi đã giảm giá.
	 **/
	public HoaDonCaPhe(String ten, double gia, double kl) {
		this.tenLoaiCaPhe = ten;
		this.giaTien1Kg = gia;
		this.khoiLuong = kl;
	}

	public double tinhTongTien() {
		return this.giaTien1Kg * this.khoiLuong;
	}

	public boolean kiemTraKhoiLuongLonHon(double kl) {
//		if (this.khoiLuong > kl) {
//			return true;
//		}else {
//			return false;
//		}

		return this.khoiLuong > kl;
	}

	public boolean kiemTraTongTienLonHon500K() {
		return this.tinhTongTien() > 500000;
	}

	public double giamGia(double x) {
		if (this.tinhTongTien() > 500000) {
			return (x / 100) * this.tinhTongTien();
		} else {
			return 0;
		}
	}
	
	public double giaSauKhiGiam(double x) {
		return this.tinhTongTien() - this.giamGia(x);
	}
}