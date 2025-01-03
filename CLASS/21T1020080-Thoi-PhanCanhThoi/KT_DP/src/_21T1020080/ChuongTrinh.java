package _21T1020080;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ChuongTrinh {
    public static void main(String[] args) throws Exception {
        XuLyData tmp = new XuLyData();
        ArrayList<SinhVien> lstSV = tmp.selectAll();
        System.out.println("Test selectAll:");
        for(SinhVien sv: lstSV)
         	System.out.println(sv);
            
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        SinhVien newSV = new SinhVien("21T1020308", "Nguyen Minh Quang", true, d.parse("28/12/2003"));
        tmp.insertStudent(newSV);
        System.out.println("\nTest Insert: ");
        for(SinhVien sv: tmp.selectAll())
            System.out.println(sv);
    }
}