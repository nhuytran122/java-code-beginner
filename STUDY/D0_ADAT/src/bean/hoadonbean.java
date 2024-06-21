package bean;

import java.util.Date;

public class hoadonbean {
	private String mahoadon;
	private String maban;
	private String maphieu;
	private String manhanvien;
	private String tongtien;
	private Date ngaylap;
	public hoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hoadonbean(String mahoadon, String maban, String maphieu, String manhanvien, String tongtien, Date ngaylap) {
		super();
		this.mahoadon = mahoadon;
		this.maban = maban;
		this.maphieu = maphieu;
		this.manhanvien = manhanvien;
		this.tongtien = tongtien;
		this.ngaylap = ngaylap;
	}
	public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getMaban() {
		return maban;
	}
	public void setMaban(String maban) {
		this.maban = maban;
	}
	public String getMaphieu() {
		return maphieu;
	}
	public void setMaphieu(String maphieu) {
		this.maphieu = maphieu;
	}
	public String getManhanvien() {
		return manhanvien;
	}
	public void setManhanvien(String manhanvien) {
		this.manhanvien = manhanvien;
	}
	public String getTongtien() {
		return tongtien;
	}
	
	public void setTongtien(String tongtien) {
		this.tongtien = tongtien;
	}
	public Date getNgaylap() {
		return ngaylap;
	}
	public void setNgaylap(Date ngaylap) {
		this.ngaylap = ngaylap;
	}
}
