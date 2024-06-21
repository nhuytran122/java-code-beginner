package bean;

import java.util.Date;

public class NhanVienBean {
	private String manv;
	private String hoten;
	private Date ngaysinh;
	private Double hsl;
	private String madv; //microsoft sql server 2014 SP3
	
	public NhanVienBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVienBean(String maNV, String tenNV, Date ngaysinh, Double hsluong, String madv) {
		super();
		manv = maNV;
		this.hoten = tenNV;
		this.ngaysinh = ngaysinh;
		this.hsl = hsluong;
		this.madv = madv;
	}

	public String getMaNV() {
		return manv;
	}

	public void setMaNV(String maNV) {
		manv = maNV;
	}

	public String getTenNV() {
		return hoten;
	}

	public void setTenNV(String tenNV) {
		this.hoten = tenNV;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public Double getHsluong() {
		return hsl;
	}

	public void setHsluong(Double hsluong) {
		this.hsl = hsluong;
	}

	public String getMadv() {
		return madv;
	}

	public void setMadv(String madv) {
		this.madv = madv;
	}

	@Override
	public String toString() {
		return "NhanVienBean [MaNV=" + manv + ", tenNV=" + hoten + ", ngaysinh=" + ngaysinh + ", hsluong=" + hsl
				+ ", madv=" + madv + "]";
	}
	
	
	
	
}
