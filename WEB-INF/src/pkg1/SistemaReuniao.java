package pkg1;

import java.util.ArrayList;

public class SistemaReuniao {

	private ArrayList<Reuniao> reunioes;
	
	public SistemaReuniao() {
		reunioes = new ArrayList<Reuniao>();
	}

	public ArrayList<Reuniao> getReunioes() {
		return reunioes;
	}

	public void setReunioes(ArrayList<Reuniao> reunioes) {
		this.reunioes = reunioes;
	}
	
	public void addReuniao(Reuniao newReuniao) {
		reunioes.add(newReuniao);
	}
}
