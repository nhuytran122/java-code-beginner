package _21T1020105;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CauHinh {
	private String loaiNguon;
	private String chuoiKetNoi;
	
	private static CauHinh _instance = null;

	private CauHinh() {
        try {
        	BufferedReader br = new BufferedReader(new FileReader("config.txt"));
            loaiNguon = br.readLine();
            chuoiKetNoi = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    
    public String getLoaiNguon() {
		return loaiNguon;
	}

	public void setLoaiNguon(String loaiNguon) {
		this.loaiNguon = loaiNguon;
	}

	public String getChuoiKetNoi() {
		return chuoiKetNoi;
	}

	public void setChuoiKetNoi(String chuoiKetNoi) {
		this.chuoiKetNoi = chuoiKetNoi;
	}

	public static CauHinh getInstance() {
        if (_instance == null) {
            _instance = new CauHinh();
        }
        return _instance;
    }
	
}
