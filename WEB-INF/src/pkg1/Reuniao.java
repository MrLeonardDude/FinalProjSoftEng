package pkg1;

public class Reuniao {
	private int ID;
	private String data; //timestamp do BD
	private String local;
	private String pauta;
	
	public Reuniao(int iD, String data, String local, String pauta) {
		ID = iD;
		this.data = data;
		this.local = local;
		this.pauta = pauta;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getPauta() {
		return pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}
}
