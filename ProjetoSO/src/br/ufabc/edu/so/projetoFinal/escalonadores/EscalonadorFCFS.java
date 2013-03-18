package br.ufabc.edu.so.projetoFinal.escalonadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufabc.edu.so.projetoFinal.model.Processo;
import br.ufabc.edu.so.projetoFinal.model.ResultItem;
import br.ufabc.edu.so.projetoFinal.util.ToolsUtils;

public class EscalonadorFCFS implements Escalonador {

	@Override
	public ResultItem execute(List<Processo> processos) {
		int instante = 0;
		int numeroTrocas = 0;
		Map<Integer, Processo> diagrama = new HashMap<Integer, Processo>();
		Map<Processo, Integer> procTmpEspMap = new HashMap<Processo, Integer>();
		Map<Processo, Integer> procTmpRetMap = new HashMap<Processo, Integer>();
		for (Processo processo : processos) {
			diagrama.put(instante, processo);
			procTmpEspMap.put(processo, instante);
			instante += processo.getDuracao();
			procTmpRetMap.put(processo, instante);
			numeroTrocas++;
			processo.setFinished(true);
		}
		float tmpMedioEsp = ToolsUtils.getTempoMedio(new ArrayList(procTmpEspMap.values()));
		float tmpMediRetorno = ToolsUtils.getTempoMedio(new ArrayList(procTmpRetMap.values()));
		return new ResultItem(tmpMedioEsp, tmpMediRetorno, numeroTrocas, diagrama);
	}

	@Override
	public String getName() {
		return "FCFS";
	}
	

	
	
}
