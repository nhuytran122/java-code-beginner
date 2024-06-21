package bean;

public class monbean {
	private String MaMon;
	private String TenMon;
	private Double Gia;
	private String LoaiMon;
	public monbean() {
		super();
	}
	
	public monbean(String mamon, String tenmon, Double gia, String loaimon) {
		super();
		this.MaMon = mamon;
		this.TenMon = tenmon;
		this.Gia = gia;
		this.LoaiMon = loaimon;
	}
	public String getMamon() {
		return MaMon;
	}
	public void setMamon(String mamon) {
		this.MaMon = mamon;
	}
	public String getTenmon() {
		return TenMon;
	}
	public void setTenmon(String tenmon) {
		this.TenMon = tenmon;
	}
	public Double getGia() {
		return Gia;
	}
	public void setGia(Double gia) {
		this.Gia = gia;
	}
	public String getLoaimon() {
		return LoaiMon;
	}
	public void setLoaimon(String loaimon) {
		this.LoaiMon = loaimon;
	}
}
