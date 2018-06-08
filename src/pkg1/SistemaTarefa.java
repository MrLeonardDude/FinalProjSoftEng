package pkg1;

import java.util.ArrayList;

public class SistemaTarefa {

	private ArrayList<Tarefa> tarefasPendents;
	private ArrayList<Tarefa> tarefas;
	
	public SistemaTarefa() {
		tarefas = new ArrayList<Tarefa>();
		tarefasPendents = new ArrayList<Tarefa>();
	}

	public ArrayList<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(ArrayList<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	public void addTarefa(Tarefa newTarefa) {
		this.tarefas.add(newTarefa);
	}

    public ArrayList<Tarefa> getTarefasPendents() {
        return tarefasPendents;
    }

    public void setTarefasPendente(ArrayList<Tarefa> tarefas) {
        this.tarefasPendents = tarefas;
    }

    public void addTarefaPendente(Tarefa newTarefa) {
        this.tarefasPendents.add(newTarefa);
    }

}
