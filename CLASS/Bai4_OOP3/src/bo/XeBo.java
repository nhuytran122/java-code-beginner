package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.Xebean;
import dao.XeDao;

public class XeBo {
	
	XeDao xd = new XeDao();
	ArrayList<Xebean> dsbean;
	public ArrayList<Xebean> getXeVao() throws Exception{
		dsbean = xd.getXeVao();
		return dsbean;
	}
	
	public ArrayList<Xebean> getXeRa() throws Exception{
		dsbean = xd.getXeRa();
		return dsbean;
	}
	public ArrayList<Xebean> getFullInf(ArrayList<Xebean> dsvao, ArrayList<Xebean> dsra) throws Exception{
		dsbean = xd.ADDFull(dsvao, dsra);
		return dsbean;
	}
	
	public void Luu(ArrayList<Xebean> ds){
		xd.XuatOutput(ds);
	}
	
	public void Napdata_C4(ArrayList<Xebean> ds) throws Exception{
		System.out.println("Napdata_C4");
		
		for(Xebean xb:ds) {
			String loaixe = xb.getLoaiXe();
			String bsx = xb.getBienSoXe();
			String svx = xb.getSoVeXe();
			if(loaixe.equals("0")) {
				if(!bsx.equals(null)) {
					System.err.println("0");
					return;
				}
			}
			else if(loaixe.equals("2")) {
				if(!svx.equals(null) || !xb.getTinhTrangVaoBai().equals(null)) {
					System.err.println("2");
					return;
					
				}
					}
			else 
				if(!svx.equals(null)) {
					System.err.println("4");
					return;
				}
					
			xd.Napdata(loaixe, svx, bsx, xb.getTimeVao(), xb.getTinhTrangVaoBai());
		}
		
		//them vao csdl
		
		
	}
	
}
