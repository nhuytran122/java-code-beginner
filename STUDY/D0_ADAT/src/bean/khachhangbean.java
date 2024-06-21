package bean;

import java.util.Date;

public class khachhangbean {
	private String MaKH;
	private String TenKH;
	private Date NgaySinh;
	private String DiaChi;
	private String SDT;
	private Double DiemTichLuy;
	private String HangThanhVien;
	public khachhangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public khachhangbean(String maKH, String tenKH, Date ngaySinh, String diaChi, String sDT, Double diemTichLuy,
			String hangThanhVien) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		NgaySinh = ngaySinh;
		DiaChi = diaChi;
		SDT = sDT;
		DiemTichLuy = diemTichLuy;
		HangThanhVien = hangThanhVien;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public Double getDiemTichLuy() {
		return DiemTichLuy;
	}
	public void setDiemTichLuy(Double diemTichLuy) {
		DiemTichLuy = diemTichLuy;
	}
	public String getHangThanhVien() {
		return HangThanhVien;
	}
	public void setHangThanhVien(String hangThanhVien) {
		HangThanhVien = hangThanhVien;
	}
	@Override
	public String toString() {
		return "khachhangbean [MaKH=" + MaKH + ", TenKH=" + TenKH + ", NgaySinh=" + NgaySinh + ", DiaChi=" + DiaChi
				+ ", SDT=" + SDT + ", DiemTichLuy=" + DiemTichLuy + ", HangThanhVien=" + HangThanhVien + "]";
	}

	
	
	
	
}
