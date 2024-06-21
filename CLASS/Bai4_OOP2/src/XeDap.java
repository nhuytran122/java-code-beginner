import java.util.Date;

public class XeDap extends Xe {
	private String SoVeXe;

	public XeDap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public XeDap(String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao, Date timeRa, String soVeXe) {
		super(cmnd, hoten, gioitinh, mscanho, mauson, timeVao, timeRa);
		// TODO Auto-generated constructor stub
		SoVeXe = soVeXe;
	}
	
	@Override
    public int tinhTien() {
        // Các xử lý tính tiền đỗ xe cho xe dap ở đây
        return 0;
    }



//	public int getSoVeXe() {
//		return SoVeXe;
//	}
	
	@Override
	public String getSoVeXe() {
		return SoVeXe;
	}

	public void setSoVeXe(String soVeXe) {
		SoVeXe = soVeXe;
	}

	@Override
	public String toString() {
		return "XeDap [SoVeXe=" + SoVeXe + "]";
	}
	
	@Override
	public String getBienSoXe() {
		return "Not Available";
	}

	@Override
	public String getLoaiXe() {
		// TODO Auto-generated method stub
		return "0";
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
