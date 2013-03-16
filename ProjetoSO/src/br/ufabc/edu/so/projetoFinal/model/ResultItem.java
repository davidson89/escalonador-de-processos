package br.ufabc.edu.so.projetoFinal.model;

import java.util.Map;

/**
 * Classe responsavel por guardar o resultado de cada algoritimo
 * 
 * @author davidson
 * 
 */
public class ResultItem {

	private int tempoMedioEspera;

	private int tempoMedioRetorno;

	private int numeroTrocas;

	//Este mapa é para guardar a informação de qual processo esta sendo executado a cada instante
	//Exemplo: instante 0 - Processo 1 | instante 3 - Processo 2 | instante 5 - Processo 1
	private Map<Integer, Processo> diagramaTempExex;

	public ResultItem(int tempoMedioEspera, int tempoMedioRetorno, int numeroTrocas, Map<Integer, Processo> diagramaTempExex) {
		this.tempoMedioEspera = tempoMedioEspera;
		this.tempoMedioRetorno = tempoMedioRetorno;
		this.numeroTrocas = numeroTrocas;
		this.diagramaTempExex = diagramaTempExex;
	}

	/**
	 * 
	 * @return tempo medio de espera do escalonamento
	 */
	public int getTempoMedioEspera() {
		return tempoMedioEspera;
	}

	public void setTempoMedioEspera(int tempoMedioEspera) {
		this.tempoMedioEspera = tempoMedioEspera;
	}

	/**
	 * 
	 * @return tempo medio de retorno do escalonamento
	 */
	public int getTempoMedioRetorno() {
		return tempoMedioRetorno;
	}

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

	public void setNumeroTrocas(int numeroTrocas) {
		this.numeroTrocas = numeroTrocas;
	}

	/**
	 * 
	 * @return diagrama de tempo de execução
	 */
	public Map<Integer, Processo> getDiagramaTempExex() {
		return diagramaTempExex;
	}

	/**
	 * 
	 * @param diagramaTempExex recebe um mapa com a estrutura instante-processo.
	 */
	public void setDiagramaTempExex(Map<Integer, Processo> diagramaTempExex) {
		this.diagramaTempExex = diagramaTempExex;
	}

}
