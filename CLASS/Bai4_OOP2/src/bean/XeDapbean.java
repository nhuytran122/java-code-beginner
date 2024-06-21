package bean;

import java.util.Date;

public class XeDapbean extends Xebean {
	private String SoVeXe;

	public XeDapbean() {
		super();
	}

	public XeDapbean(String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao, Date timeRa, String soVeXe) {
		super(cmnd, hoten, gioitinh, mscanho, mauson, timeVao, timeRa);
		SoVeXe = soVeXe;
	}
	
	@Override
    public String tinhTien() {
		long dongia = 1000;
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
		return "Not Available";
	}

	@Override
	public String getTinhTrangRaBai() {
		return "Not Available";
	}

}
