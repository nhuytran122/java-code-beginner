import java.util.Date;

public class XeMay extends Xe {
	private String BSX;

	public XeMay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public XeMay(String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao, Date timeRa, String bSX) {
		super(cmnd, hoten, gioitinh, mscanho, mauson, timeVao, timeRa);
		// TODO Auto-generated constructor stub
		BSX = bSX;
	}
	@Override
    public int tinhTien() {
        // Các xử lý tính tiền đỗ xe cho xe dap ở đây
        return 0;
    }

//	public String getBSX() {
//		return BSX;
//	}
	
	@Override
	public String getBienSoXe() {
		return BSX;
	}

	public void setBSX(String bSX) {
		BSX = bSX;
	}

	@Override
	public String toString() {
		return "XeMay [BSX=" + BSX + "]";
	}
	
	@Override
	public String getSoVeXe() {
		// TODO Auto-generated method stub
		return "Not Available";
	}

	@Override
	public String getLoaiXe() {
		// TODO Auto-generated method stub
		return "2";
	}

	@Override
	public String getTinhTrangVaoBai() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTinhTrangRaBai() {
		// TODO Auto-generated method stub
		return null;
	}
}
