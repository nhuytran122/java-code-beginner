//là những class java thường được xây dựng mô phỏng lại 1 cấu trúc bản 
//dữ liệu trong csdl gồm các cấu trúc getter và setter.

//Java bean không cần biết sự tồn tại của bất kỳ lớp nào khác,
//nó chỉ đơn thuần là 1 class thuần java.
package bean;

public class monbean {
	private String mamon;
	private String tenmon;
	private String gia;
	private String loaimon;
	public monbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public monbean(String mamon, String tenmon, String gia, String loaimon) {
		super();
		this.mamon = mamon;
		this.tenmon = tenmon;
		this.gia = gia;
		this.loaimon = loaimon;
	}
	public String getMamon() {
		return mamon;
	}
	public void setMamon(String mamon) {
		this.mamon = mamon;
	}
	public String getTenmon() {
		return tenmon;
	}
	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	public String getLoaimon() {
		return loaimon;
	}
	public void setLoaimon(String loaimon) {
		this.loaimon = loaimon;
	}

}
