package bo;

import java.util.ArrayList;

import bean.sachbean;
import dao.sachdao;

public class sachbo {
	sachdao sdao = new sachdao();
	ArrayList<sachbean> dsbean;
	public ArrayList<sachbean> getSach(String maloai) throws Exception{
		dsbean = sdao.getSach(maloai);
		return dsbean;
	}
	
	public ArrayList<sachbean> Sua(String masach, String tensach, Long soluong, Long gia, String tacgia) throws Exception{
		int n = dsbean.size();
		for(int i=0;i<n;i++)
			if(dsbean.get(i).getMasach().equals(masach)) {
				sachbean sb=dsbean.get(i);
				sb.setTensach(tensach);
				sb.setSoluong(soluong);
				sb.setGia(gia);
				sb.setTacgia(tacgia);
				dsbean.set(i, sb);//Sua trong bo nho
				sdao.Sua(masach, tensach, soluong, gia, tacgia);//Sua trong csdl
				break;
		  }
		  return dsbean;
	}
	
	public ArrayList<sachbean> Xoa(String masach) throws Exception{
		for(sachbean sbe:dsbean) {
			if(sbe.getMaloai().equals(masach)) {
				dsbean.remove(sbe); //xoa trong bo nho
				sdao.Xoa(masach); // xoa trong csdl
				break;
			}
			//xoa neu het sach
			if(sbe.getSoluong() == 0) {
				dsbean.remove(sbe); //xoa trong bo nho
				sdao.Xoa(masach); // xoa trong csdl
				break;
			}
		}
			
		return dsbean;
	}

	public ArrayList<sachbean> Ban(String masach, long soluongban) throws Exception{
		int n = dsbean.size();
		for(int i=0;i<n;i++)
			if(dsbean.get(i).getMasach().equals(masach)) {
				sachbean sb=dsbean.get(i);
				sb.setSoluong(sb.getSoluong() - soluongban);
				dsbean.set(i, sb);//Sua trong bo nho
				sdao.Ban(masach, soluongban);//Sua trong csdl
				break;
		  }
		  return dsbean;
	}
	
	public ArrayList<sachbean> Tim(String key) throws Exception{
		ArrayList<sachbean> dstmp = sdao.getSach("");
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for(sachbean sach : dstmp){
			if(sach.getMasach().toLowerCase().trim().contains(key.toLowerCase().trim()) || sach.getMasach().toLowerCase().trim().contains(key.toLowerCase().trim()))
				tam.add(sach);
		}
		return tam;
	}
	
	public sachbean Tim2(String key) throws Exception{
		ArrayList<sachbean> dstmp = sdao.getSach("");
		sachbean tam = new sachbean();
		for(sachbean sach : dstmp){
			if(sach.getMasach().equals(key.toLowerCase().trim()) || sach.getMasach().toLowerCase().trim().equals(key.toLowerCase().trim()))
				tam = sach;
		}
		return tam;
	}
	
}
