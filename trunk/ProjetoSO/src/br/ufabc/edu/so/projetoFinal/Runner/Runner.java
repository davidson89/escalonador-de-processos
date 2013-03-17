package br.ufabc.edu.so.projetoFinal.Runner;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map.Entry;

import br.ufabc.edu.so.projetoFinal.escalonadores.EscalonadorFCFS;
import br.ufabc.edu.so.projetoFinal.model.Processo;
import br.ufabc.edu.so.projetoFinal.model.ResultItem;
import br.ufabc.edu.so.projetoFinal.util.ToolsUtils;

public class Runner {

	public Runner() {
		try {
			List<Processo> processos = ToolsUtils.getListaProcessos(System.getProperty("user.dir")+ "/src/br/ufabc/edu/so/projetoFinal/Runner/processos.txt");
			EscalonadorFCFS fcfs = new EscalonadorFCFS();
			ResultItem result = fcfs.execute(processos);
			this.printResult(result);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void printResult(ResultItem result) {
		System.out.println("Tempo médio de espera: " + result.getTempoMedioEspera());
		System.out.println("Tempo médio de retorno: " + result.getTempoMedioRetorno());
		System.out.println("Numero de trocas de contexto: " + result.getNumeroTrocas());
		System.out.println("Instante   -   Processo");
		for(Entry<Integer, Processo> entry : result.getDiagramaTempExex().entrySet()) {
			System.out.println("   " + entry.getKey() + "              P" + entry.getValue().getId());
		}
	}
		

	public static void main(String[] args) {
		new Runner();
	}

}
