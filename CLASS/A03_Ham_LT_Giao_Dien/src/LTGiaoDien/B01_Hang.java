package LTGiaoDien;

public class B01_Hang {
	private String tenhang;
	private long gia;
	
	public B01_Hang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public B01_Hang(String tenhang, long gia) {
		super();
		this.tenhang = tenhang;
		this.gia = gia;
	}
	

	@Override
	public String toString() {
		return "Tên hàng: "+  tenhang + "; Giá: " + gia;
	}

	public String getTenhang() {
		return tenhang;
	}
	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	
}
