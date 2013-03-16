package br.ufabc.edu.so.projetoFinal.escalonadores;

import java.util.List;

import br.ufabc.edu.so.projetoFinal.model.Processo;
import br.ufabc.edu.so.projetoFinal.model.ResultItem;

public interface Escalonador {
	
	/**
	 * 
	 * @param processos lista com os processos a serem escalonados
	 * @return ResultItem (estrutura que armazena o resultado do escalonamento)
	 */
	public ResultItem execute(List<Processo> processos);

}
