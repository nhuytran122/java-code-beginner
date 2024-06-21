package _21T1020080;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CauHinh {
	private String chuoiKetNoi;
	
	private static CauHinh _instance = null;

	private CauHinh() {
        try {
        	BufferedReader br = new BufferedReader(new FileReader("config.ini"));
            chuoiKetNoi = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
