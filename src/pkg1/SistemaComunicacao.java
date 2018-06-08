package pkg1;

import java.util.ArrayList;

public class SistemaComunicacao {
	
	private ArrayList<Membro> membrosOnline;
	private ArrayList<Membro> membrosOffline;
	
	public SistemaComunicacao() {
		membrosOnline = new ArrayList<Membro>();
		membrosOffline = new ArrayList<Membro>();
		
	}

	public ArrayList<Membro> getMembrosOnline() {
		return membrosOnline;
	}

	public void setMembrosOnline(ArrayList<Membro> membrosOnline) {
		this.membrosOnline = membrosOnline;
	}

	public ArrayList<Membro> getMembrosOffline() {
		return membrosOffline;
	}

	public void setMembrosOffline(ArrayList<Membro> membrosOffline) {
		this.membrosOffline = membrosOffline;
	}
	
	public void addMembroOnline(Membro newMembro) {
		membrosOnline.add(newMembro);
	}
	
	public void addMembroOffline(Membro newMembro) {
		membrosOffline.add(newMembro);
	}
}
