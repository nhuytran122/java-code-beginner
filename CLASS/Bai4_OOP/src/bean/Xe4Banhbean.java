package bean;

import java.util.Date;

public class Xe4Banhbean extends Xebean {
	private String BSX;
	private String ttVao;
	private String ttRa;
	public Xe4Banhbean() {
		super();
	}
	public Xe4Banhbean(String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao,
			Date timeRa, String bSX, String ttVao, String ttRa) {
		super(cmnd, hoten, gioitinh, mscanho, mauson, timeVao, timeRa);
		BSX = bSX;
		this.ttVao = ttVao;
		this.ttRa = ttRa;
	}
	
	@Override
    public String tinhTien() {
		long dongia = 5000;
		String thanhtien;
        // Các xử lý tính tiền đỗ xe cho xe ở đây
		if(!this.getTinhTrangRaBai().equals("Binh thuong"))
			thanhtien = "Chua xac dinh - dang xu ly boi thuong";
		else {
			long hieu = this.getTimeRa().getTime() - this.getTimeVao().getTime();
			int thoigian = (int) (hieu);
			if(thoigian%(1000*60*30) != 0)
				thoigian = thoigian/(1000*60*30) + 1;
			else 
				thoigian = thoigian/(1000*60*30);
			thanhtien = String.format("%d", thoigian * dongia);
		}
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
	public String getTinhTrangVaoBai() {
		// TODO Auto-generated method stub
		return ttVao;
	}
	public void setTtVao(String ttVao) {
		this.ttVao = ttVao;
	}
	
	@Override
	public String getTinhTrangRaBai() {
		return ttRa;
	}
	
	public void setTtRa(String ttRa) {
		this.ttRa = ttRa;
	}
	@Override
	public String toString() {
		return "Xe4Banh [BSX=" + BSX + ", ttVao=" + ttVao + ", ttRa=" + ttRa + "]";
	}
	
	@Override
	public String getSoVeXe() {
		return "Not Available";
	}
	
	@Override
	public String getLoaiXe() {
		return "4";
	}
}

