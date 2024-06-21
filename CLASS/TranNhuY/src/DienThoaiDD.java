
public class DienThoaiDD extends DienThoai {
	private String timeBaohanh;

	public DienThoaiDD() {
		super();
	}

	public DienThoaiDD(String maDt, String tenDt, String hangSx, long gia, String timeBaohanh) {
		super(maDt, tenDt, hangSx, gia);
		this.timeBaohanh = timeBaohanh;
	}

	public String getTimeBaohanh() {
		return timeBaohanh;
	}

	public void setTimeBaohanh(String timeBaohanh) {
		this.timeBaohanh = timeBaohanh;
	}

	@Override
	public String toString() {
		return "DienThoaiDD [maDt = " + maDt + ", tenDt =" + tenDt + ", hangSx = " + hangSx + ", gia = " + gia + ", timeBaohanh = " + timeBaohanh + "]";
	}
	
}
