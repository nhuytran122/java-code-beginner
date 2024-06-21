package bean;

import java.util.Date;

public class XeMaybean extends Xebean {
	private String BSX;

	public XeMaybean() {
		super();
	}

	public XeMaybean(String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao, Date timeRa, String bSX) {
		super(cmnd, hoten, gioitinh, mscanho, mauson, timeVao, timeRa);
		BSX = bSX;
	}
	@Override
    public String tinhTien() {
		long dongia = 3000;
		String thanhtien;
		long timeThue = this.getTimeRa().getTime() - this.getTimeVao().getTime();
		//long songayThue = timeThue/(1000*60*60*24); //làm tròn đến 1 ngày
		int thoigian = (int) (timeThue);
		if(thoigian%(1000*60*60*24) != 0)
			thoigian = thoigian/(1000*60*60*24) + 1;
		else 
			thoigian = thoigian/(1000*60*60*24);
		thanhtien = String.format("%d", thoigian * dongia);
		return thanhtien;
    }

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
		return "Not Available";
	}

	@Override
	public String getLoaiXe() {
		return "2";
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
