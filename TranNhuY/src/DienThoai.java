
public class DienThoai {
	protected String maDt;
	protected String tenDt;
	protected String hangSx;
	protected long gia;
	public DienThoai() {
		super();
	}
	public DienThoai(String maDt, String tenDt, String hangSx, long gia) {
		super();
		this.maDt = maDt;
		this.tenDt = tenDt;
		this.hangSx = hangSx;
		this.gia = gia;
	}
	public String getMaDt() {
		return maDt;
	}
	public void setMaDt(String maDt) {
		this.maDt = maDt;
	}
	public String getTenDt() {
		return tenDt;
	}
	public void setTenDt(String tenDt) {
		this.tenDt = tenDt;
	}
	public String getHangSx() {
		return hangSx;
	}
	public void setHangSx(String hangSx) {
		this.hangSx = hangSx;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "DienThoai [maDt = " + maDt + ", tenDt = " + tenDt + ", hangSx = " + hangSx + ", gia = " + gia + "]";
	}
	
	
}
