package view;

import java.util.ArrayList;

import bean.Xebean;
import bo.XeBo;

public class test_input1 {
	public static void main(String[] args) {
		XeBo xb = new XeBo();
		ArrayList<Xebean> dsv = new ArrayList<Xebean>();
		try {
			dsv = xb.getXeVao();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("DANH SACH VAO");
		for(Xebean x:dsv)
			System.out.println(x);
	}
}
