package br.ufabc.edu.so.projetoFinal.escalonadores;

import java.util.List;

import br.ufabc.edu.so.projetoFinal.model.Processo;
import br.ufabc.edu.so.projetoFinal.model.ResultItem;

public class EscalonadorSJFNaoPreemptivo implements Escalonador {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultItem execute(List<Processo> processos) {
		return new ResultItem();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "SJF não Preemptivo";
	}

}
