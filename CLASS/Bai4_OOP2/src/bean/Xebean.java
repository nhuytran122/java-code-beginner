package bean;

import java.util.Date;

public abstract class Xebean {
	protected String cmnd;
	protected String hoten;
	protected String gioitinh;
	protected String mscanho;
	protected String mauson;
	protected Date timeVao;
	protected Date timeRa;
	public Xebean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Xebean(String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao, Date timeRa) {
		super();
		this.cmnd = cmnd;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.mscanho = mscanho;
		this.mauson = mauson;
		this.timeVao = timeVao;
		this.timeRa = timeRa;
	}
	
	public abstract String tinhTien();{ // Hàm để tính tiền đỗ xe (sẽ được override trong các lớp con)
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getMscanho() {
		return mscanho;
	}
	public void setMscanho(String mscanho) {
		this.mscanho = mscanho;
	}
	public String getMauson() {
		return mauson;
	}
	public void setMauson(String mauson) {
		this.mauson = mauson;
	}
	public Date getTimeVao() {
		return timeVao;
	}
	public void setTimeVao(Date timeVao) {
		this.timeVao = timeVao;
	}
	public Date getTimeRa() {
		return timeRa;
	}
	public void setTimeRa(Date timeRa) {
		this.timeRa = timeRa;
	}
	@Override
	public String toString() {
		return "Xe [cmnd=" + cmnd + ", hoten=" + hoten + ", gioitinh=" + gioitinh + ", mscanho=" + mscanho + ", mauson="
				+ mauson + ", timeVao=" + timeVao + ", timeRa=" + timeRa + "]";
	}
	
	public abstract String getBienSoXe();
	public abstract String getSoVeXe();
	public abstract String getLoaiXe();
	public abstract String getTinhTrangVaoBai();
	public abstract String getTinhTrangRaBai();
	
}

