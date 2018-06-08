package pkg1;

import java.util.ArrayList;

public class Tarefa {

	private int ID;
	private String definicao;
	private String descricao;
	private int progressoTotal;
	private String estado;
	private ArrayList<Tarefa> dependencias;
	private ArrayList<Membro> membros;
	private ArrayList<HistoricoTarefa> historico;
	
	public Tarefa(int iD, String definicao, String descricao, int progressoTotal, String estado,
			ArrayList<Tarefa> dependencias, ArrayList<Membro> membros) {
		ID = iD;
		this.definicao = definicao;
		this.descricao = descricao;
		this.progressoTotal = progressoTotal;
		this.estado = estado;
		this.dependencias = dependencias;
		this.membros = membros;
		this.historico = new ArrayList<HistoricoTarefa>();
	}

	public Tarefa(String definicao) {
		this.definicao = definicao;
	}
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDefinicao() {
		return definicao;
	}

	public void setDefinicao(String definicao) {
		this.definicao = definicao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getProgressoTotal() {
		return progressoTotal;
	}

	public void setProgressoTotal(int progressoTotal) {
		this.progressoTotal = progressoTotal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArrayList<Tarefa> getDependencias() {
		return dependencias;
	}

	public void setDependencias(ArrayList<Tarefa> dependencias) {
		this.dependencias = dependencias;
	}

	public ArrayList<Membro> getMembros() {
		return membros;
	}

	public void setMembros(ArrayList<Membro> membros) {
		this.membros = membros;
	}

	public ArrayList<HistoricoTarefa> getHistorico() {
		return historico;
	}

	public void setHistorico(ArrayList<HistoricoTarefa> historico) {
		this.historico = historico;
	}
	
	public void addHistorico(HistoricoTarefa newHistorico) {
		historico.add(newHistorico);
	}
}
