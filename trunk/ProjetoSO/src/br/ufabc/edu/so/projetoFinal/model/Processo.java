package br.ufabc.edu.so.projetoFinal.model;

/**
 * 
 * @author davidson
 * Estrutura para armazenamento dos dados de um processo
 *
 */
public class Processo {

	private int id;
	private int hrCriacao;
	private int duracao;
	private int prioridade;
	private int processado;

	private boolean finished;

	public Processo(int id, int hrCriacao, int duracao, int prioridade, boolean finished) {
		this.id = id;
		this.hrCriacao = hrCriacao;
		this.duracao = duracao;
		this.prioridade = prioridade;
		this.finished = finished;
		this.processado = duracao;
	}

	public Processo(int id, int hrCriacao, int duracao, int prioridade) {
		this.id = id;
		this.hrCriacao = hrCriacao;
		this.duracao = duracao;
		this.prioridade = prioridade;
		this.processado = duracao;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the hrCriacao
	 */
	public int getHrCriacao() {
		return hrCriacao;
	}

	/**
	 * @param hrCriacao the hrCriacao to set
	 */
	public void setHrCriacao(int hrCriacao) {
		this.hrCriacao = hrCriacao;
	}

	/**
	 * @return o tempo de duração do processo
	 */
	public int getDuracao() {
		return duracao;
	}

	/**
	 * @param seta o tempo de duração do  processo
	 */
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	/**
	 * @return a prioridade do processo
	 */
	public int getPrioridade() {
		return prioridade;
	}

	/**
	 * @param seta a prioridade do processo
	 */
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	/**
	 * @return informa se o processo ja foi finalizado
	 */
	public boolean isFinished() {
		return finished;
	}

	/**
	 * @param seta o status do processo <code>true</code> se o processo ainda não terminou e <code>false</code> caso contrario.
	 */
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	/**
	 * @return the processado
	 */
	public int getProcessado() {
		return processado;
	}

	public void setProcessado(int Processado) {
		if (Processado < 0)
			this.processado = 0;
		else
			this.processado = Processado;
	}
}
