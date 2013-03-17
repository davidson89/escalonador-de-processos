package br.ufabc.edu.so.projetoFinal.model;

public class Processo {

	private int id;
	
	private int hrCriacao;
	
	private int duracao;
	
	private int prioridade;
	
	private boolean finished;

	public Processo(int id, int hrCriacao, int duracao, int prioridade, boolean finished) {
		this.id = id;
		this.hrCriacao = hrCriacao;
		this.duracao = duracao;
		this.prioridade = prioridade;
		this.finished = finished;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHrCriacao() {
		return hrCriacao;
	}

	public void setHrCriacao(int hrCriacao) {
		this.hrCriacao = hrCriacao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	public boolean isFinished() {
		return finished;
	}
	
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
}