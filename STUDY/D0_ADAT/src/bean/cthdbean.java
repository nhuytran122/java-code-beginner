package bean;

import java.util.Date;

public class cthdbean {
	private String macthd;
	private String mahoadon;
	private String mamon;
	private int soluong;
	private String gia;
	private Date thoigianvao;
	private Date thoigianra;
	private Double khuyenmai;
	private String tamtinh;
	public cthdbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cthdbean(String macthd, String mahoadon, String mamon, int soluong, String gia, Date thoigianvao,
			Date thoigianra, Double khuyenmai, String tamtinh) {
		super();
		this.macthd = macthd;
		this.mahoadon = mahoadon;
		this.mamon = mamon;
		this.soluong = soluong;
		this.gia = gia;
		this.thoigianvao = thoigianvao;
		this.thoigianra = thoigianra;
		this.khuyenmai = khuyenmai;
		this.tamtinh = tamtinh;
	}
	public String getMacthd() {
		return macthd;
	}
	public void setMacthd(String macthd) {
		this.macthd = macthd;
	}
	public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getMamon() {
		return mamon;
	}
	public void setMamon(String mamon) {
		this.mamon = mamon;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	public Date getThoigianvao() {
		return thoigianvao;
	}
	public void setThoigianvao(Date thoigianvao) {
		this.thoigianvao = thoigianvao;
	}
	public Date getThoigianra() {
		return thoigianra;
	}
	public void setThoigianra(Date thoigianra) {
		this.thoigianra = thoigianra;
	}
	public Double getKhuyenmai() {
		return khuyenmai;
	}
	public void setKhuyenmai(Double khuyenmai) {
		this.khuyenmai = khuyenmai;
	}
	public String getTamtinh() {
		return tamtinh;
	}
	public void setTamtinh(String tamtinh) {
		this.tamtinh = tamtinh;
	}
	
}
