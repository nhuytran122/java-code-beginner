package bo;

import dao.KetNoi;

public class ketnoibo {
	KetNoi kn = new KetNoi();
	public void ketnoi(String server, String database, String username, String pass) {
		kn.ketnoi(server, database, username, pass);
	}

}
