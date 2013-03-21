package br.ufabc.edu.so.projetoFinal.model;

import java.util.Map;

/**
 * Classe responsavel por guardar o resultado de cada algoritimo
 * 
 * @author davidson
 * 
 */
public class ResultItem {

	private float tempoMedioEspera;

	private float tempoMedioRetorno;

	private int numeroTrocas;

	// Este mapa é para guardar a informação de qual processo esta sendo
	// executado a cada instante
	// Exemplo: instante 0 - Processo 1 | instante 3 - Processo 2 | instante 5 -
	// Processo 1
	private Map<String, Processo> diagramaTempExex;

	public ResultItem(float tempoMedioEspera, float tempoMedioRetorno, int numeroTrocas, Map<String, Processo> diagramaTempExex) {
		this.tempoMedioEspera = tempoMedioEspera;
		this.tempoMedioRetorno = tempoMedioRetorno;
		this.numeroTrocas = numeroTrocas;
		this.diagramaTempExex = diagramaTempExex;
	}

	// so para teste, mas tb serve para caso o arquivo venha vazio
	public ResultItem() {
		this.tempoMedioEspera = 0;
		this.tempoMedioRetorno = 0;
		this.numeroTrocas = 0;
	}

	/**
	 * 
	 * @return tempo medio de espera do escalonamento
	 */
	public float getTempoMedioEspera() {
		return tempoMedioEspera;
	}

	/**
	 * 
	 * @param tempoMedioEspera o tempo medio de espera do algoritimo
	 */
	public void setTempoMedioEspera(int tempoMedioEspera) {
		this.tempoMedioEspera = tempoMedioEspera;
	}

	/**
	 * 
	 * @return tempo medio de retorno do escalonamento
	 */
	public float getTempoMedioRetorno() {
		return tempoMedioRetorno;
	}

	/**
	 * 
	 * @param tempoMedioRetorno o tempo medio de retorno do processo
	 */
	public void setTempoMedioRetorno(int tempoMedioRetorno) {
		this.tempoMedioRetorno = tempoMedioRetorno;
	}

	/**
	 * 
	 * @return numero de trocas de contexto do escalonamento
	 */
	public int getNumeroTrocas() {
		return numeroTrocas;
	}

	/**
	 * 
	 * @param numeroTrocas o numero de trocas de contexto
	 */
	public void setNumeroTrocas(int numeroTrocas) {
		this.numeroTrocas = numeroTrocas;
	}

	/**
	 * 
	 * @return diagrama de tempo de execução
	 */
	public Map<String, Processo> getDiagramaTempExex() {
		return diagramaTempExex;
	}

	/**
	 * 
	 * @param diagramaTempExex
	 *            recebe um mapa com a estrutura instante-processo.
	 */
	public void setDiagramaTempExex(Map<String, Processo> diagramaTempExex) {
		this.diagramaTempExex = diagramaTempExex;
	}

}
