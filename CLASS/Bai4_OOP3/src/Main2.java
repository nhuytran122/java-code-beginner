import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Xe> ds = new ArrayList<Xe>();
		ArrayList<Xe4Banh> ds4 = new ArrayList<Xe4Banh>();
		ArrayList<XeMay> ds2 = new ArrayList<XeMay>();
		ArrayList<XeDap> ds0 = new ArrayList<XeDap>();
		try {
			FileReader f = new FileReader("input1.txt");
			BufferedReader b = new BufferedReader(f);
			//Duyet file:
			while(true) {
				// Doc ra 1 dong
				String st = b.readLine();
				if(st == null || st == "") break;
				String[] tt = st.split("[;]");
				String loaixe;
				if(tt[0].equals("4")) loaixe = "Xe 4 banh";
				else if(tt[0].equals("2")) loaixe = "Xe gan may";
				else loaixe = "Xe dap";
				String bsx = tt[1], sovexe = tt[2];
				SimpleDateFormat dd = new SimpleDateFormat("HH:mm dd/MM/yyyy");
				Date timevao = dd.parse(tt[3]);
				String ttvao = tt[4];
				System.out.println("\nLoai xe: " + loaixe);
			    System.out.println("Bien so xe: " + bsx);
			    System.out.println("So ve xe: " + sovexe);
			    System.out.println("Thoi gian vao bai: " + tt[3]);
			    System.out.println("Tinh trang xe luc vao bai: " + ttvao);
			}
			b.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			FileReader f = new FileReader("input2.txt");
			BufferedReader b = new BufferedReader(f);
			//Duyet file:
			while(true) {
				// Doc ra 1 dong
				String st = b.readLine();
				if(st == null || st == "") break;
				String[] tt = st.split("[;]");
				String loaixe;
				if(tt[0].equals("4")) loaixe = "Xe 4 banh";
				else if(tt[0].equals("2")) loaixe = "Xe gan may";
				else loaixe = "Xe dap";
				String bsx = tt[1], sovexe = tt[2];
				SimpleDateFormat dd = new SimpleDateFormat("HH:mm dd/MM/yyyy");
				Date timera = dd.parse(tt[3]);
				String ttra = tt[4];
				System.out.println("\nLoai xe: " + loaixe);
			    System.out.println("Bien so xe: " + bsx);
			    System.out.println("So ve xe: " + sovexe);
			    System.out.println("Thoi gian ra bai: " + tt[3]);
			    System.out.println("Tinh trang xe luc ra bai: " + ttra);
			}
			b.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
