package bean;

import java.util.Date;

public class XeMaybean extends Xebean {
	private String BSX;

	public XeMaybean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public XeMaybean(String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao, Date timeRa, String bSX) {
		super(cmnd, hoten, gioitinh, mscanho, mauson, timeVao, timeRa);
		// TODO Auto-generated constructor stub
		BSX = bSX;
	}
	@Override
    public String tinhTien() {
        // Các xử lý tính tiền đỗ xe cho xe dap ở đây
		long dongia = 3000;
		String thanhtien;
        // Các xử lý tính tiền đỗ xe cho xe dap ở đây
		long hieu = this.getTimeRa().getTime() - this.getTimeVao().getTime();
		int thoigian = (int) (hieu);
		if(thoigian%(1000*60*60*24) != 0)
			thoigian = thoigian/(1000*60*60*24) + 1;
		else 
			thoigian = thoigian/(1000*60*60*24);
		thanhtien = String.format("%d", thoigian * dongia);
		return thanhtien;
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
