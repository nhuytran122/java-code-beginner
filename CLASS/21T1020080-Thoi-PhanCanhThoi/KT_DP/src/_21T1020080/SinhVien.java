package _21T1020080;

import java.util.Date;

public class SinhVien {
	private String MSV;
	private String hoTen;
	private boolean gioiTinhNam;
	private Date ngaySinh;
	
	public SinhVien() {
		super();
	}
	
	@Override
	public String toString() {
		return "SinhVien [MaSinhVien=" + MSV + ", HoTen=" + hoTen + ", GioiTinhNam=" + gioiTinhNam
				+ ", NgaySinh=" + ngaySinh + "]";
	}

	public String getMaSinhVien() {
		return MSV;
	}
	public void setMaSinhVien(String MaSinhVien) {
		this.MSV = MaSinhVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public boolean isGioiTinhNam() {
		return gioiTinhNam;
	}
	public void setGioiTinhNam(boolean gioiTinhNam) {
		this.gioiTinhNam = gioiTinhNam;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public SinhVien(String maSinhVien, String hoTen, boolean gioiTinhNam, Date ngaySinh) {
		super();
		MSV = maSinhVien;
		this.hoTen = hoTen;
		this.gioiTinhNam = gioiTinhNam;
		this.ngaySinh = ngaySinh;
	}
}
