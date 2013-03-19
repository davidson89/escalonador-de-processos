package br.ufabc.edu.so.projetoFinal.escalonadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufabc.edu.so.projetoFinal.model.Processo;
import br.ufabc.edu.so.projetoFinal.model.ResultItem;
import br.ufabc.edu.so.projetoFinal.util.ToolsUtils;

public class EscalonadorSJFNaoPreemptivo implements Escalonador {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultItem execute(List<Processo> processos) {
		int instante = 0;
		int numTrocas = 0;
		Map<Integer, Processo> diagrama = new HashMap<Integer, Processo>();
		Map<Processo, Integer> procTmpEspMap = new HashMap<Processo, Integer>();
		Map<Processo, Integer> procTmpRetMap = new HashMap<Processo, Integer>();

		// Variável de controle o número de processos executados
		int numProc = 0;

		// variável guarda o número de processos para ser usado no loop
		int loop = processos.size();

		// Enquanto não foram executados todos os processos
		while (numProc < loop) {
			int menorDuracao = 0, idProc = 0;

			/*
			 * Procura pelo processo de menor duração e com entrada no instante
			 * meor ou igual o atual e coloca na fila para ser executado
			 * primeiro
			 */
			for (int i = 0; i < processos.size(); i++) {
				if (processos.get(i).getHrCriacao() <= instante) {
					if (i == 0) {
						menorDuracao = processos.get(i).getDuracao();
						idProc = i;
					} else if (menorDuracao > processos.get(i).getDuracao()) {
						menorDuracao = processos.get(i).getDuracao();
						idProc = i;
					}
				}
			}

			diagrama.put(instante, processos.get(idProc));
			procTmpEspMap.put(processos.get(idProc), instante);
			// Aumenta o instante para o tempo de execução do processo
			instante += processos.get(idProc).getDuracao();
			procTmpRetMap.put(processos.get(idProc), instante);
			numTrocas++;
			processos.get(idProc).setFinished(true);
			processos.remove(idProc);
			numProc++;

		}

		float tmpMedioEsp = ToolsUtils.getTempoMedio(new ArrayList<Integer>(procTmpEspMap.values()));
		float tmpMediRetorno = ToolsUtils.getTempoMedio(new ArrayList<Integer>(procTmpRetMap.values()));
		return new ResultItem(tmpMedioEsp, tmpMediRetorno, numTrocas, diagrama);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "SJF não Preemptivo";
	}

}
