package _21T1020105;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SinhVien {
	private String MaSinhVien;
	private String HoTen;
	private boolean GioiTinhNam;
	private Date NgaySinh;
	
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		return "SinhVien [MaSinhVien=" + MaSinhVien + ", HoTen=" + HoTen + ", GioiTinhNam=" + GioiTinhNam
				+ ", NgaySinh=" + d.format(NgaySinh) + "]";
	}

	public String getMaSinhVien() {
		return MaSinhVien;
	}
	public void setMaSinhVien(String MaSinhVien) {
		this.MaSinhVien = MaSinhVien;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public boolean isGioiTinhNam() {
		return GioiTinhNam;
	}
	public void setGioiTinhNam(boolean gioiTinhNam) {
		GioiTinhNam = gioiTinhNam;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public SinhVien(String maSinhVien, String hoTen, boolean gioiTinhNam, Date ngaySinh) {
		super();
		MaSinhVien = maSinhVien;
		HoTen = hoTen;
		GioiTinhNam = gioiTinhNam;
		NgaySinh = ngaySinh;
	}
}
