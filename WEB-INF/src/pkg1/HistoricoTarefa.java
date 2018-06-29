package pkg1;

public class HistoricoTarefa {
	
	private int ID;
	private int progresso; 
	private String relatorio;
	private String data; //timestamp do BD
	private String membro; //username do membro
	private int tarefa; //id da tarefa
	
	public HistoricoTarefa(int iD, int progresso, String relatorio, String data, String membro, int tarefa) {
		ID = iD;
		this.progresso = progresso;
		this.relatorio = relatorio;
		this.data = data;
		this.membro = membro;
		this.tarefa = tarefa;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getProgresso() {
		return progresso;
	}

	public void setProgresso(int progresso) {
		this.progresso = progresso;
	}

	public String getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMembro() {
		return membro;
	}

	public void setMembro(String membro) {
		this.membro = membro;
	}

	public int getTarefa() {
		return tarefa;
	}

	public void setTarefa(int tarefa) {
		this.tarefa = tarefa;
	}
}
