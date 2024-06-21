public class DienThoaiCoDinh extends DienThoai {

	public DienThoaiCoDinh() {
		super();
	}

	public DienThoaiCoDinh(String maDt, String tenDt, String hangSx, long gia) {
		super(maDt, tenDt, hangSx, gia);
	}

	@Override
	public String toString() {
		return "DienThoaiCoDinh [maDt = " + maDt + ", tenDt = " + tenDt + ", hangSx = " + hangSx + ", gia = " + gia + "]";
	}
	

}
