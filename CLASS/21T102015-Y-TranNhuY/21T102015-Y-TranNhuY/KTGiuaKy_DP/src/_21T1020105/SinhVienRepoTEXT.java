package _21T1020105;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SinhVienRepoTEXT implements SinhVienRepo {
	public SinhVienRepoTEXT() {
		super();
	}
	
	@Override
	public ArrayList<SinhVien> selectAll() {
		ArrayList<SinhVien> lstSV = new ArrayList<SinhVien>();
		try{
		     FileReader f = new FileReader("sinhvien.txt");
		     BufferedReader b = new BufferedReader(f);
		     while(true){
		          String st = b.readLine();
		          if(st == null || st == "") break;
		          String[] tt = st.split("[,]");
		          Date ns = new SimpleDateFormat("dd/MM/yyyy").parse(tt[3]);
		          lstSV.add(new SinhVien(tt[0], tt[1], Boolean.parseBoolean(tt[2]), ns));
		     }
		     b.close();
		} catch(Exception e) {
		     e.printStackTrace();
		}
		return lstSV;
	}


    @Override
    public void insertStudent(SinhVien x) {
        try {
        	FileWriter w = new FileWriter("sinhvien.txt", true); //mở file vs chế độ append
        	PrintWriter ghi = new PrintWriter(w);
            ghi.println(x.getMaSinhVien() + "," + x.getHoTen() + "," + x.isGioiTinhNam() + "," + new SimpleDateFormat("dd/MM/yyyy").format(x.getNgaySinh()));
            ghi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(String maSV) {
        try {
        	FileReader f = new FileReader("sinhvien.txt");
		    BufferedReader b = new BufferedReader(f);
            ArrayList<String> listTmp = new ArrayList<String>();
            String line;
            while ((line = b.readLine()) != null) {
                String[] info = line.split(",");
                if (!info[0].equals(maSV)) {
                    listTmp.add(line);
                }
            }
            b.close();

            FileWriter w = new FileWriter("sinhvien.txt");
        	PrintWriter ghi = new PrintWriter(w);
            for (String l : listTmp) {
                ghi.println(l);
            }
            ghi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
