package bo;

import java.util.ArrayList;

import bean.Xebean;
import dao.XeDao;

public class XeBo {
	XeDao dvd = new XeDao();
	public void Luu(ArrayList<Xebean> ds){
		dvd.Luu(ds);
	}
	
}
